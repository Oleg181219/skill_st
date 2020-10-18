import java.math.BigDecimal;

public class DepositAccount extends BankAccount {
    private static long blockTime = 0;
    private static final long MONTH_BLOCK = 2592000000L; // 30 суток в милисекундах.


    public static void inToDeposit(BigDecimal inMoney) {
        System.out.println("Прошло пополнение депозита в размере " + inMoney);
        blockTime = System.currentTimeMillis() + MONTH_BLOCK;
        BankAccount.setDepBalance(BankAccount.getDepBalance().add(inMoney));
    }

    public static void withdrawDeposit(BigDecimal outMoney) {
        if (System.currentTimeMillis() > blockTime) {
            System.out.println("Прошло снятие денежных средств с депозита в размере " + outMoney);
        }
        System.out.println("Вы не можете снять сейчас средства с депозита, приходите через месяц");
    }
}
