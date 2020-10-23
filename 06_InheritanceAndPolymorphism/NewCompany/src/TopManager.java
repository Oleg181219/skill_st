import java.math.BigDecimal;

public class TopManager implements Employee {
    private BigDecimal salary = new BigDecimal(30000);
    private BigDecimal salaryMax = new BigDecimal(75000);
    private BigDecimal limit = new BigDecimal(10000000);

    @Override
    public BigDecimal getMonthSalary() {
        Company company = new Company();
        if (company.getIncoming().compareTo(limit) < 0) {
            return salaryMax;
        }
        return salary;
    }

    @Override
    public BigDecimal getOklad() {
        return null;
    }


}
