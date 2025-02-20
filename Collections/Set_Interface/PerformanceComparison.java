package Set_Interface;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, String expiryDate, String coverageType, double premiumAmount) throws ParseException {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = new SimpleDateFormat("yyyy-MM-dd").parse(expiryDate);
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policy policy = (Policy) o;
        return Objects.equals(policyNumber, policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

public class PerformanceComparison {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void removePolicy(Policy policy) {
        hashSet.remove(policy);
        linkedHashSet.remove(policy);
        treeSet.remove(policy);
    }

    public boolean containsPolicy(Policy policy) {
        return hashSet.contains(policy) && linkedHashSet.contains(policy) && treeSet.contains(policy);
    }

    public Set<Policy> getAllPolicies() {
        return new HashSet<>(hashSet);
    }

    public Set<Policy> getPoliciesExpiringSoon() {
        Set<Policy> expiringSoon = new HashSet<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date dateIn30Days = calendar.getTime();

        for (Policy policy : treeSet) {
            if (policy.getExpiryDate().before(dateIn30Days)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public Set<Policy> getPoliciesByCoverageType(String coverageType) {
        Set<Policy> policiesByCoverageType = new HashSet<>();
        for (Policy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                policiesByCoverageType.add(policy);
            }
        }
        return policiesByCoverageType;
    }

    public Set<Policy> getDuplicatePolicies() {
        Set<Policy> duplicates = new HashSet<>();
        Set<String> policyNumbers = new HashSet<>();
        for (Policy policy : hashSet) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) throws ParseException {
        PerformanceComparison pc = new PerformanceComparison();

        Policy policy1 = new Policy("P001", "John Doe", "2023-12-01", "Health", 500.0);
        Policy policy2 = new Policy("P002", "Jane Smith", "2023-11-15", "Auto", 300.0);
        Policy policy3 = new Policy("P003", "Alice Johnson", "2023-10-20", "Home", 700.0);
        Policy policy4 = new Policy("P001", "John Doe", "2023-12-01", "Health", 500.0); // Duplicate

        pc.addPolicy(policy1);
        pc.addPolicy(policy2);
        pc.addPolicy(policy3);
        pc.addPolicy(policy4);

        System.out.println("All Policies: " + pc.getAllPolicies());
        System.out.println("Policies Expiring Soon: " + pc.getPoliciesExpiringSoon());
        System.out.println("Health Policies: " + pc.getPoliciesByCoverageType("Health"));
        System.out.println("Duplicate Policies: " + pc.getDuplicatePolicies());
    }
}