import java.math.BigDecimal;

public class Manager implements Employee {
    //private BigDecimal salary = new BigDecimal(13500);
    private double salaryDouble;
    private double oklad = 15000;
    private double inco;
    private BigDecimal incoming = new BigDecimal(0);

    @Override
    public BigDecimal getMonthSalary() {
        Company company = new Company();
        inco = (115000 + Math.random() * 35000);
        // суммирование дохода от Manager
        BigDecimal incom = new BigDecimal(inco).setScale(0,BigDecimal.ROUND_HALF_UP);
        company.setIncoming(company.getIncoming().add(incom));
        // расчет зп Manager
        salaryDouble = oklad + inco * 0.05;
        BigDecimal salary = new BigDecimal(salaryDouble).setScale(0,BigDecimal.ROUND_HALF_UP);
        System.out.println(salary);
        return salary;
    }


}
