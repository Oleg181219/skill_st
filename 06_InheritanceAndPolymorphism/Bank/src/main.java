import java.math.BigDecimal;

public class main {


    public static void main(String[] args) {
        BigDecimal moneyToMain = new BigDecimal("20000");
        BigDecimal moneyToCard = new BigDecimal("30000");
        BigDecimal moneyToWithdraw = new BigDecimal("152.9");
        BigDecimal moneyToDeposit = new BigDecimal("5000");
        BigDecimal moneyToCardWithdraw = new BigDecimal("1000");

        BankAccount.deposit(moneyToMain);
        System.out.println("Баланс счета = " + BankAccount.getBalance());
        BankAccount.withdraw(moneyToWithdraw);
        System.out.println("Баланс счета = " + BankAccount.getBalance());


        CardAccount.setCardBalance(moneyToCard);
        System.out.println("Деньги на карте " + CardAccount.getCardBalance());
        CardAccount.withdraw(moneyToCardWithdraw);
        System.out.println("Баланс счета Card = " + BankAccount.getCardBalance());
        BankAccount.setCardBalance(BankAccount.getCardBalance().add(moneyToCard));
        System.out.println("Баланс счета Card = " + BankAccount.getCardBalance());

        DepositAccount.inToDeposit(moneyToDeposit);
        System.out.println(BankAccount.getDepBalance());
        DepositAccount.withdrawDeposit(moneyToWithdraw);
        System.out.println(BankAccount.getDepBalance());

    }
}
