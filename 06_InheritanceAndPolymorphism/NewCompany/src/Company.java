import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Company {

    ArrayList<Employee> employeeList = new ArrayList<>();

    private static double incoming;

    public static double getIncoming() {
        return incoming;
    }

    public static void setIncoming(double incoming) {
        Company.incoming = incoming;
    }

    public void hire(Employee emp) {
        employeeList.add(emp);
    }

    public void hireAll(ArrayList<Employee> empl) {
        employeeList.addAll(empl);
    }

    public void fire(Employee employee) {
        employeeList.remove(employee);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count > 0) {
            if (count < employeeList.size()) {
                employeeList.sort((s1, s2) -> (int) s2.getMonthSalary() - (int) s1.getMonthSalary());
                return employeeList.subList(0, count);
            }
        }
        return employeeList.subList(0, employeeList.size());
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count > 0) {
            if (count < employeeList.size()) {
                employeeList.sort(Comparator.comparingInt(s -> (int) s.getMonthSalary()));
                return employeeList.subList(0, count);
            }
        }
        return employeeList.subList(0, 0);
    }

}
