import java.math.BigDecimal;

public class BankAccount {


    private BigDecimal balance = new BigDecimal("0");
    private BigDecimal cardBalance = new BigDecimal("0");
    private BigDecimal depBalance = new BigDecimal("0");


    public void withdraw(BigDecimal outMoney) {
        System.out.println("Минус на главный " + outMoney);
        balance = balance.subtract(outMoney);
    }

    public BigDecimal deposit(BigDecimal inMoney) {
        System.out.println("Плюс на главный " + inMoney);
        balance = balance.add(inMoney);
        return balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(BigDecimal cardBalance) {
        this.cardBalance = cardBalance;
    }

    public BigDecimal getDepBalance() {
        return depBalance;
    }

    public void setDepBalance(BigDecimal depBalance) {
        this.depBalance = depBalance;
    }


}

