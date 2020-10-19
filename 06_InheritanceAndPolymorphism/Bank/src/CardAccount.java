import java.math.BigDecimal;


public class CardAccount extends BankAccount {

    private BigDecimal percent = new BigDecimal("0.01");


    public void withdraw(BigDecimal outMoney) {
        System.out.println("Минус карточки " + outMoney);
        System.out.println(" + Проценты за снятие " + outMoney.multiply(percent));
        this.setBalance(this.getBalance().subtract(outMoney.add(outMoney.multiply(percent))));
        System.out.println("cardbalanse = " + getBalance());

    }

}