import java.math.BigDecimal;

public class Individual extends Clients {
    private BigDecimal balance = new BigDecimal("0");

    void info() {
        System.out.println("Счет физического лица" +
                "\nПополнение без коммисии \nСнятие без коммисии \nБаланс счета = " + getBalance());
    }

    void deposit(BigDecimal amount) {
        this.balance = getBalance().add(amount);
    }

    void withdraw(BigDecimal amount) {
        if (getBalance().compareTo(amount) >= 0 ) {
            this.balance = getBalance().subtract(amount);
        }
    }

    void balance() {
        System.out.println("Текущий баланс счета (физ. лицо) = " + balance);
    }

    BigDecimal getBalance() {
        return balance;
    }

    void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
