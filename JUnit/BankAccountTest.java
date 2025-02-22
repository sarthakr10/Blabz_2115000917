import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount(100.0); // Starting balance of 100
    }

    @Test
    public void testDeposit() {
        bankAccount.deposit(50.0);
        assertEquals(150.0, bankAccount.getBalance(), "Balance should be 150 after depositing 50");
    }

    @Test
    public void testWithdraw() {
        bankAccount.withdraw(30.0);
        assertEquals(70.0, bankAccount.getBalance(), "Balance should be 70 after withdrawing 30");
    }

    @Test
    public void testWithdraw_InsufficientFunds() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(200.0);
        });
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    public void testDeposit_NegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.deposit(-10.0);
        });
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }

    @Test
    public void testWithdraw_NegativeAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bankAccount.withdraw(-20.0);
        });
        assertEquals("Withdrawal amount must be positive", exception.getMessage());
    }

    @Test
    public void testInitialNegativeBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new BankAccount(-50.0);
        });
        assertEquals("Initial balance cannot be negative", exception.getMessage());
    }
}
