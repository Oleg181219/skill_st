import java.math.BigDecimal;

public class TopManager implements Employee {
    private BigDecimal salary = new BigDecimal(13500);

    @Override
    public BigDecimal getMonthSalary() {
        return salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
