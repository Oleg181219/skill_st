import java.math.BigDecimal;

public class TopManager implements Employee {
    private BigDecimal salary = new BigDecimal(13500);
    private BigDecimal salaryMax = new BigDecimal(33750);
    private BigDecimal prem = new BigDecimal("2.5");
    private BigDecimal limit = new BigDecimal(10000000);

  //Company company = new Company();


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
