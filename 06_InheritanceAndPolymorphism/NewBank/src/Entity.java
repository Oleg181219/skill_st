import java.math.BigDecimal;

public class Entity extends Clients {
    private BigDecimal balance = new BigDecimal("0");
    private BigDecimal percent = new BigDecimal("0.01");

    public  void info(){
        System.out.println("Счет юридического лица" +
                "\nПополнение без коммисии \nСнятие 1% коммисии \nБаланс счета = " + getBalance());
    }

    public void deposit(BigDecimal amount) {
        this.balance = getBalance().add(amount);
    }

    public void withdraw(BigDecimal amount) {
        this.balance = getBalance().add(amount).subtract(amount.multiply(percent));
    }

    public void balance() {
        System.out.println("Текущий баланс счета (юр.лицо) = " + balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
