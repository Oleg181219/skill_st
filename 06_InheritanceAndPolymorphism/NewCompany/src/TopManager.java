import java.math.BigDecimal;

public class TopManager implements Employee {
    private double salary = 30000;
    private double salaryMax = 75000;
    private double limit = 10000000;
    private double monthSalary= 0;



    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

    @Override
    public double setMonthSalary() {
        Company company = new Company();
        if (company.getIncoming() > limit) {
            return salaryMax;
        }
        return salary;
    }

    @Override
    public double getOklad() {
        return 0;
    }


}
