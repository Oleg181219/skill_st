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
        Company.setIncoming(Company.getIncoming() + income);
        monthSalary = (int) (income * 0.05 + oklad);
        System.out.println(Company.getIncoming());
        return monthSalary;
    }
}
