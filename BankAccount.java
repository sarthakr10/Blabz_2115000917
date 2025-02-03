public class BankAccount {
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;

    private String accountHolderName;
    private final String accountNumber;

    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public static String getBankName() {
        return bankName;
    }

    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder Name: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
        }
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John Doe", "123456789");
        BankAccount account2 = new BankAccount("Jane Smith", "987654321");

        account1.displayAccountDetails();
        account2.displayAccountDetails();

        System.out.println("Total Accounts: " + BankAccount.getTotalAccounts());
    }
}