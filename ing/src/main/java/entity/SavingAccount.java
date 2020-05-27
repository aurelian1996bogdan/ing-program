package entity;

import java.util.Objects;

public class SavingAccount extends AbstractAcount {

    private Currency currency;

    public SavingAccount(int id, double balance) {
        super(id, balance);
    }

    public SavingAccount(int id, double balance, Currency currency) {
        super(id, balance);
        this.currency = currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SavingAccount that = (SavingAccount) o;
        return Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), currency);
    }
}
