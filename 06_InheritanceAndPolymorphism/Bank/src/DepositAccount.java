import java.math.BigDecimal;
import java.util.Calendar;

public class DepositAccount extends BankAccount {
    private static Calendar blockDay;


    public static void inToDeposit(BigDecimal inMoney) {
        System.out.println("Прошло пополнение депозита в размере " + inMoney);
        Calendar.getInstance().add(Calendar.MONTH,1);
        BankAccount.setDepBalance(BankAccount.getDepBalance().add(inMoney));
    }

    public static void withdrawDeposit(BigDecimal outMoney) {
        if (Calendar.getInstance().after(blockDay)) {
            System.out.println("Прошло снятие денежных средств с депозита в размере " + outMoney);
        }
        System.out.println("Вы не можете снять сейчас средства с депозита, приходите через месяц");
    }
}
