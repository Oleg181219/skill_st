import java.math.BigDecimal;

public class main {


    public static void main(String[] args) {
        BigDecimal moneyToMain = new BigDecimal("20000");
        BigDecimal moneyToCard = new BigDecimal("30000");
        BigDecimal moneyToWithdraw = new BigDecimal("152.9");
        BigDecimal moneyToDeposit = new BigDecimal("5000");
        BigDecimal moneyToCardWithdraw = new BigDecimal("1000");


        DepositAccount depositAccount = new DepositAccount();
        depositAccount.setBalance(moneyToCard);
        depositAccount.inToDeposit(moneyToDeposit);
        depositAccount.withdrawDeposit(moneyToCardWithdraw);


    }
}
