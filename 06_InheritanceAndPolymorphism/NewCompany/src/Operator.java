import java.math.BigDecimal;

public class Operator implements Employee {
    private BigDecimal salary = new BigDecimal(33000);


    @Override
    public BigDecimal getMonthSalary() {
        return salary;
    }

    @Override
    public BigDecimal getOklad() {
        return null;
    }


}
