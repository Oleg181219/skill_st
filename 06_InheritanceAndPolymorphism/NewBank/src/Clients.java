import java.math.BigDecimal;

public abstract class Clients {

    private BigDecimal balance = new BigDecimal("0");


    public abstract void deposit(BigDecimal ammount);

    public abstract void withdraw(BigDecimal ammount);

    public abstract void balance();

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
