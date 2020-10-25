import java.math.BigDecimal;
import java.lang.Math;

public class Manager implements Employee {

    private double oklad = 30000;
    private double monthSalary = 0;

    public double getMonthSalary() {
        return monthSalary;
    }

    @Override
    public double setMonthSalary() {
        double income = (115000 + (Math.random() * 25000));
        /*company.setIncoming(company.getIncoming() + income);*/
        this.monthSalary = income * 0.05 + getOklad();
        return monthSalary;
    }

    @Override
    public double getOklad() {
        return oklad;
    }
}
