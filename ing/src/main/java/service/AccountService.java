package service;

import entity.AbstractAcount;
import exception.NotEnoughFundsException;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    public void deposit(double amount, AbstractAcount account);
    public void withdraw(double amount, AbstractAcount account) throws NotEnoughFundsException;
    public long decimalValue(AbstractAcount account);
    public double maximumAmountToWithdraw(AbstractAcount account);
    public double getBalance(AbstractAcount account);
}
