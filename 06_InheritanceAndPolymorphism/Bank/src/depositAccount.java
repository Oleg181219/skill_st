import java.math.BigDecimal;

public class depositAccount extends bankAccount {
    private static long blockTime = 0;
    private static final long MONTH_BLOCK = 2592000000L;// 30 дней в миллисекундах
    static BigDecimal balanceDeposit = new BigDecimal("5000");


    public static void  depositDeposit(BigDecimal inMoney) {
        System.out.println("Прошло пополнение депозита в размере " + inMoney);
        blockTime = System.currentTimeMillis() + MONTH_BLOCK;
        depositAccount.depositBalance(inMoney);
    }

    public static void withdrawDeposit(BigDecimal outMoney) {
        if (System.currentTimeMillis() > blockTime) {
            System.out.println(System.currentTimeMillis());
            System.out.println(blockTime);
            System.out.println("Прошло снятие денежных средств с депозита в размере " + outMoney);
            depositAccount.depositBalance(balanceDeposit.subtract(outMoney).subtract(balanceDeposit));
        }
        System.out.println(System.currentTimeMillis());// печать текущего времени
        System.out.println(blockTime);// печать времени создания + 2592000000 мс ( ровно 30 дней)
        System.out.println("Вы не можете снять сейчас средства с депозита, приходите через месяц");
    }

    public static BigDecimal depositBalance(BigDecimal moneyMoving) {
        balanceDeposit = balanceDeposit.add(moneyMoving);
        return balanceDeposit;
    }

}
