import java.math.BigDecimal;

public class BankAccount {

    private BigDecimal balance = new BigDecimal("0");

    public void withdraw(BigDecimal outMoney) {
        System.out.println("Минус на главный " + outMoney);
        balance = balance.subtract(outMoney);
    }

    public BigDecimal deposit(BigDecimal inMoney) {
        System.out.println("Плюс на главный " + inMoney);
        balance = balance.add(inMoney);
        return balance;
    }

    public boolean send(BankAccount receiver, BigDecimal amount) {
        this.setBalance(this.getBalance().subtract(amount));
        receiver.setBalance(receiver.getBalance().add(amount));
        return true;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

