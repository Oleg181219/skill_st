import java.math.BigDecimal;

public class main {

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("10000");
        BigDecimal subtraction = new BigDecimal("1000");

        Clients individual = new Individual();
        Clients entity = new Entity();
        Clients entrepreneur = new Entrepreneur();

        individual.deposit(amount);
        individual.withdraw(subtraction);
        individual.info();
        entity.deposit(amount);
        entity.info();
    }
}
