package exception;

public class OverdraftLimitExceededException extends NotEnoughFundsException {

    private double overdraft;

    public OverdraftLimitExceededException(NotEnoughFundsException e, double overdraft) {
        super(e.getMessage());
        this.id = e.id;
        this.balance = e.balance;
        this.amount = Math.round(amount * 100) / 100d;
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }
}
