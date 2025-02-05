import java.util.ArrayList;
import java.util.List;

class Bank {
    private String name;
    private List<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer) {
        customers.add(customer);
        System.out.println("Account opened for " + customer.getName() + " at " + this.name);
    }

    public String getName() {
        return name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public double viewBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}

class Account {
    private Bank bank;
    private double balance;

    public Account(Bank bank, double initialBalance) {
        this.bank = bank;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public Bank getBank() {
        return bank;
    }
}

public class BankApp {
    public static void main(String[] args) {
        Bank bank = new Bank("Global Bank");
        Customer customer = new Customer("John Doe");

        Account account1 = new Account(bank, 1000.0);
        Account account2 = new Account(bank, 2000.0);

        customer.addAccount(account1);
        customer.addAccount(account2);

        bank.openAccount(customer);

        System.out.println("Total balance for " + customer.getName() + " is: " + customer.viewBalance());
    }
}