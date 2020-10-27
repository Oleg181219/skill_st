import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Company {

    ArrayList<Employee> employeeList = new ArrayList<>();
    ArrayList<Employee> employeeListTop = new ArrayList<>();
    ArrayList<Employee> employeeListLow = new ArrayList<>();
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

    public void fire(int fire) {
        for (int i = 0; i < fire; i++) {
            employeeList.remove((int) (Math.random() * employeeList.size()));
        }

    }

    public static Comparator<Employee> comparatorMin = (s1, s2) -> (int) s1.getMonthSalary() - (int) s2.getMonthSalary();

    public static Comparator<Employee> comparatorMax = (s1, s2) -> (int) s2.getMonthSalary() - (int) s1.getMonthSalary();

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        employeeListTop.clear();

        if (count <= 0 | count > employeeList.size()) {
            System.out.println("неверный count. лист не изменился");
            return employeeListTop;
        }
        Collections.sort(employeeList, comparatorMax);
        for (int i = 0; i < count; i++) {
            employeeListTop.add(employeeList.get(i));
        }
        return employeeListTop;
    }


    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        employeeListLow.clear();

        if (count <= 0 & count > employeeList.size()) {
            System.out.println("неверный count. лист не изменился");
            return employeeListLow;
        }
        Collections.sort(employeeList, comparatorMin);
        for (int i = 0; i < count; i++) {
            employeeListLow.add(employeeList.get(i));
        }
        return employeeListLow;
    }
}

