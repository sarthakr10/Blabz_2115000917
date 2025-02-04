
public class BankAccount{
    private static String bankName = "Global bank";
    private static int totalAccounts = 0;
    
    private String accountHolderName;
    private final String  accountNumber;

    public BankAccount(String accountHolderName , String accountNumber){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }
    public static int getTotalAccounts(){
        return totalAccounts;
    }
    public void display(){
        if (this instanceof BankAccount) {
            System.out.println("Bank name : "+ bankName);
            System.out.println("Account Holder name : "+accountHolderName);
            System.out.println("Account number : "+accountNumber);
        }
        else{
            System.out.println("Object is not an instance of BankAccount class");
        }
    }
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("Ayan", "123456789");
        BankAccount b2  = new BankAccount("SRK", "123412221");
        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
        b1.display();;
        b2.display();
    }
}