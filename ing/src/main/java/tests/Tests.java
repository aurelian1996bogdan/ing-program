package tests;

import entity.*;
import exception.NotEnoughFundsException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.AccountService;
import service.AccountServiceImpl;
import service.BankService;
import service.BankServiceImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class Tests {

    private AccountService accountService;
    private BankService bankService;


    AbstractAcount savingAccount1;
    AbstractAcount savingAccount2;
    AbstractAcount checkingAccount1;
    AbstractAcount checkingAccount2;
    Bank bank;

    @Before
    public void initializeAccounts(){
        accountService = new AccountServiceImpl();
        bankService = new BankServiceImpl();
        savingAccount1 = new SavingAccount(1, 1140.25);
        savingAccount2 = new SavingAccount(1, 1140.25);

        checkingAccount1 = new CheckingAccount(2, 1120.75, 100.0);
        checkingAccount2 = new CheckingAccount(2, 1120.75, 100.0);

        AbstractAcount account = new AbstractAcount(1,34.2);
        AbstractAcount account1 = new AbstractAcount(2,35.1);
        AbstractAcount account2 = new AbstractAcount(3,45.2);
        AbstractAcount account3 = new AbstractAcount(4,23);

        Set<AbstractAcount> accountSet = new HashSet<>();
        accountSet.add(account);
        accountSet.add(account1);

        Set<AbstractAcount> accountSet2 = new HashSet<>();
        accountSet2.add(account2);
        accountSet2.add(account3);

        Customer customer = new Customer("Popescu", Gender.male, accountSet);
        Customer customer1 = new Customer("Ionescu", Gender.female, accountSet2);
        bank = new Bank();
        bank.addClient(customer);
        bank.addClient(customer1);

    }

    @Test(expected= NotEnoughFundsException.class)
    public void testSavingAccountThrowException() throws NotEnoughFundsException {
        AbstractAcount savingAccount = new SavingAccount(1, 1000.0);
        accountService.deposit(100.0,savingAccount);
        accountService.withdraw(2000.0,savingAccount);
    }

    @Test(expected=NotEnoughFundsException.class)
    public void testCheckingAccountThrowException() throws NotEnoughFundsException {
        AbstractAcount checkingAccount = new CheckingAccount(2, 1000.0, 100.0);
        accountService.deposit(100.0,checkingAccount);
        accountService.withdraw(2000.0,checkingAccount);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testWithdrawNegativeValue() throws NotEnoughFundsException {
        AbstractAcount checkingAccount = new CheckingAccount(2, 1000.0, 100.0);
        accountService.withdraw(-100.0,checkingAccount);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testCreateCheckingAccount() {
        new CheckingAccount(1, 1000.0, -100.0);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testDepositNegativeValue() {
        AbstractAcount savingAccount = new SavingAccount(1, 1000.0);
        accountService.deposit(-100.0,savingAccount);
    }

    @Test
    public void testAccountsToDecimal() throws NotEnoughFundsException {
        assertEquals(1140, accountService.decimalValue(savingAccount1));
        assertEquals(1121, accountService.decimalValue(checkingAccount1));
    }

    @Test
    public void testNumberOfAccounts() {
        assertEquals(4, bankService.getNumberOfAccounts(bank));
    }


}
