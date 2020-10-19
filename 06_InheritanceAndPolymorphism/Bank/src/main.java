import java.math.BigDecimal;

public class main {


    public static void main(String[] args) {
        BigDecimal moneyToMain = new BigDecimal("20000");
        BigDecimal moneyToCard = new BigDecimal("30000");
        BigDecimal moneyToWithdraw = new BigDecimal("152.9");
        BigDecimal moneyToDeposit = new BigDecimal("5000");
        BigDecimal moneyToCardWithdraw = new BigDecimal("1000");
        BigDecimal sent = new BigDecimal("10000");

        BankAccount bankAccount = new BankAccount();
        CardAccount cardAccount = new CardAccount();
        DepositAccount depositAccount = new DepositAccount();


        // действия с главным аккаунтом
        bankAccount.setBalance(moneyToMain);
        bankAccount.withdraw(moneyToWithdraw);
        bankAccount.deposit(moneyToMain);

        // действия с карточным аккаунтом
        cardAccount.setBalance(moneyToCard);
        cardAccount.withdraw(moneyToCardWithdraw);

        //действия с депозитным аккаунтом
        depositAccount.setBalance(moneyToDeposit);
        depositAccount.inToDeposit(moneyToDeposit);
        depositAccount.withdrawDeposit(moneyToCardWithdraw);

        bankAccount.send(cardAccount, sent);
        System.out.println("bankAccount=" + bankAccount.getBalance());
        System.out.println("cardAccount=" + cardAccount.getBalance());
        System.out.println("depositAccount=" + depositAccount.getBalance());
        System.out.println(depositAccount.send(cardAccount, sent));

        System.out.println(cardAccount.send(depositAccount, sent));

        System.out.println(bankAccount.send(cardAccount, sent));

    }


}
