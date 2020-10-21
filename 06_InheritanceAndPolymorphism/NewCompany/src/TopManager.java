import java.math.BigDecimal;

public class TopManager implements Employee {
    private BigDecimal salary = new BigDecimal(13500);
    private BigDecimal salaryMax = new BigDecimal(33750);
    private BigDecimal limit = new BigDecimal(10000000);

    private BigDecimal prem = new BigDecimal(2.5);
    Company companyMain = new Company();

    @Override
    public BigDecimal getMonthSalary() {
        if (companyMain.getIncoming().compareTo(limit) < 0) {
            return salaryMax;
        }
        return salary;
    }

    @Override
    public BigDecimal getOklad() {
        return null;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
