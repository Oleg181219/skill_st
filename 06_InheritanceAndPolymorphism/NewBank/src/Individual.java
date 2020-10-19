import java.math.BigDecimal;

public class Individual extends Clients {
    private BigDecimal balance = new BigDecimal("0");

    public void info() {
        System.out.println("Счет физического лица" +
                "\nПополнение без коммисии \nСнятие без коммисии \nБаланс счета = " + getBalance());
    }

    public void deposit(BigDecimal amount) {
        this.balance = getBalance().add(amount);
    }

    public void withdraw(BigDecimal amount) {
        this.balance = getBalance().subtract(amount);
    }

    public void balance() {
        System.out.println("Текущий баланс счета (физ. лицо) = " + balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
