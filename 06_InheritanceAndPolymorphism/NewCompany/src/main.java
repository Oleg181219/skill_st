import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        int numberOfManagers = 80;
        ArrayList<Employee> managers = new ArrayList<>();

        for (int j = 0; j < numberOfManagers; j++) {
            Employee manager = new Manager();
            manager.setMonthSalary();
            managers.add(manager);
        }

        for (int m = 0; m < numberOfManagers; m++)
            System.out.println("managers.get(" + m + ").MonthSalary() -" + managers.get(m).getMonthSalary());

        System.out.println("Общий доход компании = " + Company.getIncoming() + " тугриков ");
    }
}