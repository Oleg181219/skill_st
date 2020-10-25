public class TopManager implements Employee {
    private final double salary = 30000;
    private final double salaryMax = 75000;
    private final double limit = 10000000;
    private final double monthSalary= 0;

    @Override
    public double getMonthSalary() {
        return monthSalary;
    }

    @Override
    public double setMonthSalary() {
        if (Company.getIncoming() > limit)
            return salaryMax;
        return salary;
    }
}
