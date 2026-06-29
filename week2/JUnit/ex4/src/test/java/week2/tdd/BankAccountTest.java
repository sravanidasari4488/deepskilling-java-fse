package week2.tdd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        // Test fixture: fresh account before each test
        account = new BankAccount(1000.0);
    }

    @After
    public void tearDown() {
        // Cleanup after each test
        account = null;
    }

    @Test
    public void deposit_shouldIncreaseBalance() {
        // Arrange
        double depositAmount = 250.0;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(1250.0, account.getBalance(), 0.001);
    }

    @Test
    public void withdraw_shouldDecreaseBalance() {
        // Arrange
        double withdrawalAmount = 400.0;

        // Act
        account.withdraw(withdrawalAmount);

        // Assert
        assertEquals(600.0, account.getBalance(), 0.001);
    }

    @Test
    public void depositAndWithdraw_shouldUpdateBalanceCorrectly() {
        // Arrange
        double depositAmount = 500.0;
        double withdrawalAmount = 200.0;

        // Act
        account.deposit(depositAmount);
        account.withdraw(withdrawalAmount);

        // Assert
        assertEquals(1300.0, account.getBalance(), 0.001);
    }
}
