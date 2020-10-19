import java.math.BigDecimal;
import java.util.Calendar;

public class DepositAccount extends BankAccount {
    private static Calendar blockDay;


    public  void inToDeposit(BigDecimal inMoney) {
        System.out.println("Прошло пополнение депозита в размере " + inMoney);
        blockDay = Calendar.getInstance();
        blockDay.add(Calendar.MONTH, 1);
        this.setBalance(this.getBalance().add(inMoney));
    }

    public  void withdrawDeposit(BigDecimal outMoney) {
        if (Calendar.getInstance().before(blockDay)) {
            System.out.println("Прошло снятие денежных средств с депозита в размере " + outMoney);
        }
        System.out.println("Вы не можете снять сейчас средства с депозита, приходите через месяц");
    }
    boolean send(BankAccount receiver, BigDecimal amount) {
        if (Calendar.getInstance().after(blockDay)) {
            this.setBalance(this.getBalance().subtract(amount));
            receiver.setBalance(receiver.getBalance().add(amount));
            return true;
        }
        return false;
    }

    }

