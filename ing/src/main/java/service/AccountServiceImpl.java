package service;

import entity.AbstractAcount;
import entity.CheckingAccount;
import exception.NotEnoughFundsException;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AccountServiceImpl implements AccountService {

    public static final int SAVING_ACCOUNT_TYPE = 1;
    public static final int CHECKING_ACCOUNT_TYPE = 2;
    Logger logger = Logger.getLogger(AccountServiceImpl.class.getName());

    @Override
    public void deposit(final double amount,AbstractAcount account) {
        logger.log(Level.WARNING, "“This class is a service for account!”");
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot deposit a negative amount");
        }
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void withdraw(final double amount, AbstractAcount account) throws NotEnoughFundsException {
        logger.log(Level.WARNING, "“This class is a service for account!”");
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot withdraw a negative amount");
        }

        if (amount > maximumAmountToWithdraw(account)) {
            throw new NotEnoughFundsException(account.getId(), account.getBalance(), amount, "Requested amount exceeds the maximum amount to withdraw");
        }

        account.setBalance(account.getBalance() - amount);
    }

    @Override
    public long decimalValue(AbstractAcount account) {
        logger.log(Level.WARNING, "“This class is a service for account!”");
        return Math.round(account.getBalance());
    }

    @Override
    public double maximumAmountToWithdraw(AbstractAcount account) {
        logger.log(Level.WARNING, "“This class is a service for account!”");
        switch (account.getType()) {
            case SAVING_ACCOUNT_TYPE:
                return account.getBalance();
            case CHECKING_ACCOUNT_TYPE:
                CheckingAccount checkingAccount = (CheckingAccount) account;
                return checkingAccount.getBalance() + checkingAccount.overdraft;
        }
        return 0;
    }

    @Override
    public double getBalance(AbstractAcount account) {

        logger.log(Level.WARNING, "“This class is a service for account!”");
        return account.getBalance();
    }


}
