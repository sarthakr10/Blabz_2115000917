import java.util.ArrayList;

abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public abstract double calculateInterest();
}


interface Loanable {
    void applyForLoan();
    double calculateLoanEligibility();
}


class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan() {
        System.out.println("Savings account holder applied for a loan.");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 2; 
    } // **Fixed: Added missing closing brace here**
}


class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan() {
        System.out.println("Current account holder applied for a loan.");
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3;
    }
}


public class BankingSystem {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();

        SavingsAccount savings = new SavingsAccount("SA123", "John Doe", 5000);
        CurrentAccount current = new CurrentAccount("CA456", "Jane Doe", 10000);

        accounts.add(savings);
        accounts.add(current);

        for (BankAccount account : accounts) {
            System.out.println("Account Holder: " + account.getHolderName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("Annual Interest: $" + account.calculateInterest());

            if (account instanceof Loanable) {
                Loanable loanable = (Loanable) account;
                loanable.applyForLoan();
                System.out.println("Loan Eligibility: $" + loanable.calculateLoanEligibility());
            }
            System.out.println("------------------------------");
        }
    }
}
