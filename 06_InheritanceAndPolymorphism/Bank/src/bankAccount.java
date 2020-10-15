import java.math.BigDecimal;

public class bankAccount {

    static BigDecimal deposit = new BigDecimal("0");
    static BigDecimal balance = new BigDecimal("0");


    public static void withdraw(BigDecimal outMoney) {
        System.out.println("Прошло снятие денежных средств в размере " + outMoney);
        bankAccount.accountBalance(deposit.subtract(outMoney).subtract(deposit));
    }

    public static BigDecimal deposit(BigDecimal inMoney) {
        System.out.println("Прошло пополнение денежных средств в размере " + inMoney);
        bankAccount.accountBalance(inMoney);
        return deposit;
    }

    public static BigDecimal accountBalance(BigDecimal moneyMoving) {
        balance = balance.add(moneyMoving);
        return balance;
    }
}

