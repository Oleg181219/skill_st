import java.math.BigDecimal;

abstract class Clients {

    private BigDecimal balance = new BigDecimal("0");

    abstract void info();


    abstract void deposit(BigDecimal ammount);

    abstract void withdraw(BigDecimal ammount);

    abstract void balance();

    BigDecimal getBalance() {
        return balance;
    }

    void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
