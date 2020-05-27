package service;

import ch.qos.logback.core.net.server.Client;
import dao.BankRepository;
import entity.AbstractAcount;
import entity.Bank;
import entity.CheckingAccount;
import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BankServiceImpl implements BankService {


    @Autowired
    AccountService accountService;
    @Autowired
    BankRepository bankRepository;

    @Override
    public void addClient(Customer client,Bank bank) {
       bank.addClient(client);
    }

    @Override
    public void printMaximumAmountToWithdraw(Bank bank) {
        System.out.format("%nPrint maximum amount to withdraw for all clients%n");

        StringBuilder result = new StringBuilder();
        for (Customer client: bank.getClients()) {
            result.append("Client: ")
                    .append(client)
                    .append("\n");
            int i = 1;
            for (AbstractAcount account: client.getAccounts()) {
                result.append("Account nr. ")
                        .append(i++)
                        .append(", maximum amount to withdraw: ")
                        .append(Math.round(accountService.maximumAmountToWithdraw(account) * 100) / 100d)
                        .append("\n");
            }
        }

        System.out.println(result.toString());
    }

    @Override
    public Set<Customer> getClients(Bank bank) {
        Set<Customer> customers = bank.getClients();
        return customers;
    }

    @Override
    public int getNumberOfAccounts(Bank bank) {
        Set accounts = new HashSet();
        for (Customer client : bank.getClients())
            accounts.addAll(client.getAccounts());
        return accounts.size();
    }

    @Override
    public SortedSet<AbstractAcount> getAccountsSortedBySum(Bank bank) {
        SortedSet<AbstractAcount> result = new TreeSet<>(new Comparator<AbstractAcount>() {
            @Override
            public int compare(AbstractAcount o1, AbstractAcount o2) {
                return (int) Math.round(o1.getBalance() - o2.getBalance());
            }
        });
        for (Customer client : bank.getClients())
            result.addAll(client.getAccounts());
        return result;
    }

    public List<Customer> getAccountsSortedBySumUsingStream(Bank bank) {
        List<Customer> accounts = bank.getClients().stream().sorted( (c1, c2) -> { return c1.getName().compareTo(c2.getName());}).collect(Collectors.toList());
        return accounts;
    }

    @Override
    public Map getCustomerAccounts(Bank bank) {
        Map result = new HashMap();
        for (Customer client : bank.getClients()) {
            result.put(client, client.getAccounts());
        }
        return result;
    }

    public double getBankCreditSum(Bank bank) {
        double result = 0.0;
        Set accounts = new HashSet();
        for (Customer client : bank.getClients())
            accounts.addAll(client.getAccounts());
        for (Object account : accounts)
            if (account instanceof CheckingAccount) {
                if (((AbstractAcount) account).getBalance() < 0) {
                    result -= ((AbstractAcount) account).getBalance();
                }
            }

        return Math.round(result * 100) / 100d;
    }

}
