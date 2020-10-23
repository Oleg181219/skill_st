import java.math.BigDecimal;
import java.lang.Math;

public class Manager implements Employee {
    Company company = new Company();
    private BigDecimal oklad = new BigDecimal(30000);


    public BigDecimal getOklad() {
        return oklad;
    }

    @Override
    public BigDecimal getMonthSalary() {
       // зп менеджера
        double in = (115000 + (Math.random() * 25000));
        double inco = 0.05 * in;
        BigDecimal incom = new BigDecimal(inco);
        BigDecimal salary = oklad.add(incom).setScale(0, BigDecimal.ROUND_HALF_UP);
        // плюсуем общий доход
        BigDecimal incomingBD = new BigDecimal(in).setScale(0, BigDecimal.ROUND_HALF_UP);
        company.setIncoming(company.getIncoming().add(incomingBD));
        System.out.println("-----"+ company.getIncoming());
        return salary;
    }
}
