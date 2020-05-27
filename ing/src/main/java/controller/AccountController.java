package controller;

import entity.AbstractAcount;
import exception.NotEnoughFundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.AccountService;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public void deposit(double amount, AbstractAcount acount) {
        accountService.deposit(amount,acount);
    }

    @PostMapping
    public void withdraw(double amount,AbstractAcount account) throws NotEnoughFundsException {
        accountService.withdraw(amount,account);
    }

    @GetMapping
    public long decimalValue(AbstractAcount account) {
        return accountService.decimalValue(account);
    }


}
