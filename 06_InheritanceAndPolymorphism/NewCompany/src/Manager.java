import java.math.BigDecimal;
import java.lang.Math;

public class Manager implements Employee {

    private BigDecimal oklad = new BigDecimal(30000);

    public BigDecimal getOklad() {
        return oklad;
    }

    public void setOklad(BigDecimal oklad) {
        this.oklad = oklad;
    }

    @Override
    public BigDecimal getMonthSalary() {
        double inco = 0.05 * (115000 + (Math.random() * 25000));
        BigDecimal incom = new BigDecimal(inco);
        BigDecimal salary = oklad.add(incom).setScale(0, BigDecimal.ROUND_HALF_UP);
        return salary;
    }


}
