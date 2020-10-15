import java.math.BigDecimal;

public class cardAccount extends bankAccount {

    static BigDecimal percent = new BigDecimal("0.01");

    public static void withdraw(BigDecimal outMoney) {
        System.out.println("Прошло снятие денежных средств c карточки " + outMoney);
        System.out.println(" + Проценты за снятие " +outMoney.multiply(percent));
        bankAccount.accountBalance(deposit.subtract(outMoney).subtract(deposit).subtract(outMoney.multiply(percent)));
    }
}