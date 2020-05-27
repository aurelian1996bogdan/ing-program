package service;

import ch.qos.logback.core.net.server.Client;
import entity.AbstractAcount;
import entity.Bank;
import entity.Customer;

import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface BankService {

    public void addClient(Customer client,Bank bank);
    public void printMaximumAmountToWithdraw(Bank bank);
    public Set<Customer> getClients(Bank bank);
    public int getNumberOfAccounts(Bank bank);
    public SortedSet<AbstractAcount> getAccountsSortedBySum(Bank bank);
    public Map getCustomerAccounts(Bank bank);
}
