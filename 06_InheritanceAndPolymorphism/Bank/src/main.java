import java.math.BigDecimal;

public class main {


    public static void main(String[] args) {
        BigDecimal moneyToDeposit = new BigDecimal("2000");
        BigDecimal moneyToWithdraw = new BigDecimal("152.9");
        BigDecimal moneyToDepositDeposit = new BigDecimal("5000");

        bankAccount.deposit(moneyToDeposit);
        bankAccount.deposit(moneyToDeposit);

        bankAccount.withdraw(moneyToWithdraw);
        bankAccount.withdraw(moneyToWithdraw);

        System.out.println("Баланс счета = " + bankAccount.balance);

        cardAccount.withdraw(moneyToWithdraw);// съем через карточку со счета, общего.
        System.out.println("Баланс счета = " + bankAccount.balance);
        System.out.println("Баланс DEPO счета = " + depositAccount.balanceDeposit);
        depositAccount.depositDeposit(moneyToDepositDeposit);
        System.out.println("Баланс DEPO счета = " + depositAccount.balanceDeposit);
        depositAccount.withdrawDeposit(moneyToWithdraw);
    }
}
