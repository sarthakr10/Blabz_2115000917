import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class Policy {
    String policyNumber;
    String policyholderName;
    Date expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "{PolicyNumber: " + policyNumber + ", Holder: " + policyholderName +
               ", Expiry: " + sdf.format(expiryDate) + ", Type: " + coverageType +
               ", Premium: " + premiumAmount + "}";
    }
}

public class InsurancePolicyManagement {
    Map<String, Policy> policyMap = new HashMap<>();
    Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    TreeMap<Date, Policy> sortedPolicyMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        sortedPolicyMap.put(policy.expiryDate, policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getExpiringPolicies(int days) {
        List<Policy> expiringPolicies = new ArrayList<>();
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        Date futureDate = calendar.getTime();

        for (Map.Entry<Date, Policy> entry : sortedPolicyMap.entrySet()) {
            if (entry.getKey().before(futureDate)) {
                expiringPolicies.add(entry.getValue());
            }
        }
        return expiringPolicies;
    }

    public List<Policy> getPoliciesByHolder(String policyholder) {
        List<Policy> holderPolicies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholder)) {
                holderPolicies.add(policy);
            }
        }
        return holderPolicies;
    }

    public void removeExpiredPolicies() {
        Date today = new Date();
        sortedPolicyMap.entrySet().removeIf(entry -> entry.getKey().before(today));
        policyMap.values().removeIf(policy -> policy.expiryDate.before(today));
        orderedPolicyMap.values().removeIf(policy -> policy.expiryDate.before(today));
    }

    public void displayPolicies(Map<String, Policy> map) {
        for (Policy policy : map.values()) {
            System.out.println(policy);
        }
    }

    public static void main(String[] args) throws Exception {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        manager.addPolicy(new Policy("P1001", "Alice", sdf.parse("2024-03-10"), "Health", 500.0));
        manager.addPolicy(new Policy("P1002", "Bob", sdf.parse("2024-04-15"), "Auto", 700.0));
        manager.addPolicy(new Policy("P1003", "Alice", sdf.parse("2024-02-25"), "Home", 600.0));

        System.out.println("All Policies:");
        manager.displayPolicies(manager.policyMap);

        System.out.println("\nPolicies Expiring in 30 Days:");
        System.out.println(manager.getExpiringPolicies(30));

        System.out.println("\nPolicies for Alice:");
        System.out.println(manager.getPoliciesByHolder("Alice"));

        manager.removeExpiredPolicies();
        System.out.println("\nPolicies after removing expired:");
        manager.displayPolicies(manager.policyMap);
    }
}