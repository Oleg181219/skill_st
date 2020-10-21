import java.math.BigDecimal;

class Entrepreneur extends Clients {
    private BigDecimal balance = new BigDecimal("0");
    private BigDecimal percentMax = new BigDecimal("0.01");
    private BigDecimal percentMin = new BigDecimal("0.005");
    private BigDecimal border = new BigDecimal("1000");

    protected void info() {
        System.out.println("Счет ИП" +
                "При пополнении меньше 1000 руб коммисия 1%" +
                "\nПри пополнении на равную или больше 1000 руб, коммисия 0,5% \nСнятие без коммисии \nБаланс счета = " + getBalance());
    }

    protected void deposit(BigDecimal amount) {
        if (amount.compareTo(border) < 0) {
            this.balance = getBalance().add(amount).subtract(amount.multiply(percentMax));
        }
        if (amount.compareTo(border) >= 0) {
            this.balance = getBalance().add(amount).subtract(amount.multiply(percentMin));
        }
    }

    protected void withdraw(BigDecimal amount) {
        if (getBalance().compareTo(amount) >= 0) {
            this.balance = getBalance().subtract(amount);
        }
    }

    protected void balance() {
        System.out.println("Текущий баланс счета (ИП) = " + balance);
    }

    protected BigDecimal getBalance() {
        return balance;
    }

    protected void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


}
