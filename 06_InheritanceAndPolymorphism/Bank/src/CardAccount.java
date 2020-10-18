import java.math.BigDecimal;

public class CardAccount extends BankAccount {

    private static BigDecimal percent = new BigDecimal("0.01");


    public static void withdraw(BigDecimal outMoney) {
       System.out.println("Минус карточки " + outMoney);
        System.out.println(" + Проценты за снятие " + outMoney.multiply(percent));
        BankAccount.setCardBalance(BankAccount.getCardBalance().subtract(outMoney.add(outMoney.multiply(percent))));
        System.out.println("cardbalanse = " + getCardBalance());

    }


}