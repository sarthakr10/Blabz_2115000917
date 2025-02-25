package Review;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
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
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return policyNumber.hashCode();
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

public class PolicyManagementSystem {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>();

    public void loadPolicies(String filePath) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            String policyNumber = parts[0];
            String policyholderName = parts[1];
            Date expiryDate = dateFormat.parse(parts[2]);
            String coverageType = parts[3];
            double premiumAmount = Double.parseDouble(parts[4]);

            Policy policy = new Policy(policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
            hashSet.add(policy);
            linkedHashSet.add(policy);
            treeSet.add(policy);
        }
        reader.close();
    }

    public Set<Policy> getAllUniqueP() {
        return hashSet;
    }

    public Set<Policy> getPoliciesExpiringSoon() {
        return treeSet;
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

        for (Policy policy : linkedHashSet) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        PolicyManagementSystem system = new PolicyManagementSystem();
        try {
            system.loadPolicies("input.txt");
            System.out.println("All Unique Policies: ");
            System.out.println(system.getAllUniqueP());
            System.out.println("----------------------------");
            System.out.println("Policies Expiring Soon: ");
            System.out.println(system.getPoliciesExpiringSoon());
            System.out.println("----------------------------");
            System.out.println("Policies by Coverage Type Health: ");
            System.out.println(system.getPoliciesByCoverageType("Health"));
            System.out.println("----------------------------");
            System.out.println("Duplicate Policies: ");
            System.out.println(system.getDuplicatePolicies());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}