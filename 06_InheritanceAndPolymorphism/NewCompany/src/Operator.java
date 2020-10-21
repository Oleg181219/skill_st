import java.math.BigDecimal;

public class Operator implements Employee{
    private BigDecimal salary = new BigDecimal(20000);


    @Override
     public BigDecimal getMonthSalary() {
        return salary;
    }





}
