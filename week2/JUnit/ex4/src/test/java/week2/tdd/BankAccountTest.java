package week2.tdd;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount(1000.0);
    }

    @After
    public void tearDown() {
        account = null;
    }

    @Test
    public void deposit_shouldIncreaseBalance() {
        account.deposit(250.0);
        assertEquals(1250.0, account.getBalance(), 0.001);
    }

    @Test
    public void withdraw_shouldDecreaseBalance() {
        account.withdraw(400.0);
        assertEquals(600.0, account.getBalance(), 0.001);
    }

    @Test
    public void depositAndWithdraw_shouldUpdateBalanceCorrectly() {
        account.deposit(500.0);
        account.withdraw(200.0);
        assertEquals(1300.0, account.getBalance(), 0.001);
    }
}
