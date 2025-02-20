import java.util.*;

class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();
    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, accounts.get(accountNumber) + amount);
            System.out.println("Deposited $" + amount + " to account " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
            System.out.println("Withdrawal request added for account " + accountNumber);
        } else {
            System.out.println("Account not found!");
        }
    }
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for account " + accountNumber);
        }
    }
    public void displayAccounts() {
        System.out.println("\nAll Accounts:");
        for (String account : accounts.keySet()) {
            System.out.println("Account: " + account + ", Balance: $" + accounts.get(account));
        }
    }

    public void displaySortedAccountsByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        TreeMap<Double, String> sortedAccounts = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }

        for (Map.Entry<Double, String> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + ", Balance: $" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("12345", 1000.0);
        bank.addAccount("67890", 500.0);
        bank.addAccount("54321", 1500.0);

        bank.deposit("12345", 200.0);
        bank.requestWithdrawal("67890");
        bank.requestWithdrawal("54321");

        bank.displayAccounts();
        bank.displaySortedAccountsByBalance();
        bank.processWithdrawals();
    }
}