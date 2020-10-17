import java.math.BigDecimal;

public class bankAccount {

  //  private static BigDecimal deposit = new BigDecimal("0");
    private static BigDecimal balance = new BigDecimal("0");
    private static BigDecimal cardBalance = new BigDecimal("0");
    private static BigDecimal depBalance = new BigDecimal("0");


    public static void withdraw(BigDecimal outMoney) {
        System.out.println("Минус на главный " + outMoney);
       balance =  balance.subtract(outMoney);
    }

    public static BigDecimal deposit(BigDecimal inMoney) {
        System.out.println("Плюс на главный " + inMoney);
        balance= balance.add(inMoney);
        return balance;
    }

    public static BigDecimal getBalance() {
        return balance;
    }

    public static void setBalance(BigDecimal balance) {
        bankAccount.balance = balance;
    }

    public static BigDecimal getCardBalance() {
        return cardBalance;
    }

    public static void setCardBalance(BigDecimal cardBalance) {
        bankAccount.cardBalance = cardBalance;
    }

    public static BigDecimal getDepBalance() {
        return depBalance;
    }

    public static BigDecimal setDepBalance(BigDecimal depBalance) {
        bankAccount.depBalance = depBalance;
        return depBalance;
    }
}

