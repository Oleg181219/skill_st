import java.math.BigDecimal;

class BankAccount {

    private BigDecimal balance = new BigDecimal("0");

    void withdraw(BigDecimal outMoney) {
        System.out.println("Минус на главный " + outMoney);
        balance = balance.subtract(outMoney);
    }

    BigDecimal deposit(BigDecimal inMoney) {
        System.out.println("Плюс на главный " + inMoney);
        balance = balance.add(inMoney);
        return balance;
    }

    boolean send(BankAccount receiver, BigDecimal amount) {
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

