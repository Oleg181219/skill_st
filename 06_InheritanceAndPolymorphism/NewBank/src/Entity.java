import java.math.BigDecimal;

public class Entity extends Clients {
    private BigDecimal balance = new BigDecimal("0");
    private BigDecimal percent = new BigDecimal("0.01");

    void info() {
        System.out.println("Счет юридического лица" +
                "\nПополнение без коммисии \nСнятие 1% коммисии \nБаланс счета = " + getBalance());
    }

    void deposit(BigDecimal amount) {
        this.balance = getBalance().add(amount);
    }

    void withdraw(BigDecimal amount) {
        amount.add(amount.multiply(percent));
        if (amount.add(amount.multiply(percent)).compareTo(getBalance()) >= 0) {
            this.balance = getBalance().subtract(amount).subtract(amount.multiply(percent));
        }
    }

    void balance() {
        System.out.println("Текущий баланс счета (юр.лицо) = " + balance);
    }

    BigDecimal getBalance() {
        return balance;
    }

    void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
