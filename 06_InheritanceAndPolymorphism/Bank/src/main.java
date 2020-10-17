import java.math.BigDecimal;

public class main {


    public static void main(String[] args) {
        BigDecimal moneyToMain = new BigDecimal("20000");
        BigDecimal moneyToCard = new BigDecimal("30000");
        BigDecimal moneyToWithdraw = new BigDecimal("152.9");
        BigDecimal moneyToDeposit = new BigDecimal("5000");
        BigDecimal moneyToCardWithdraw = new BigDecimal("1000");

        bankAccount.deposit(moneyToMain);
        System.out.println("Баланс счета = " + bankAccount.getBalance());
        bankAccount.withdraw(moneyToWithdraw);
        System.out.println("Баланс счета = " + bankAccount.getBalance());


        cardAccount.setCardBalance(moneyToCard);
        System.out.println("Деньги на карте " + cardAccount.getCardBalance());
        cardAccount.withdraw(moneyToCardWithdraw);
        System.out.println("Баланс счета Card = " + bankAccount.getCardBalance());
        bankAccount.setCardBalance(bankAccount.getCardBalance().add(moneyToCard));
        System.out.println("Баланс счета Card = " + bankAccount.getCardBalance());
        System.out.println("Баланс счета = " + bankAccount.getBalance());

        depositAccount.inToDeposit(bankAccount.setDepBalance(moneyToDeposit));
        System.out.println(bankAccount.getDepBalance());
        depositAccount.withdrawDeposit(bankAccount.setDepBalance(moneyToCardWithdraw));

    }
}
