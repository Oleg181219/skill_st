import java.math.BigDecimal;
import java.lang.Math;

public class Manager implements Employee {

    private double salaryDouble;
    private BigDecimal oklad = new BigDecimal(15000);
    private double inco;

    public BigDecimal getOklad() {
        return oklad;
    }

    public void setOklad(BigDecimal oklad) {
        this.oklad = oklad;
    }

    @Override
    public BigDecimal getMonthSalary() {
        inco = 0.05 * (115000 + Math.random() * 35000);// вход денег от менеджеров в double
        BigDecimal incom =  new BigDecimal(inco);
        BigDecimal salary = oklad.add(incom).setScale(0, BigDecimal.ROUND_HALF_UP);
        return salary;
    }




}
