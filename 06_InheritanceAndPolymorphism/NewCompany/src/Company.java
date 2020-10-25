import java.util.ArrayList;

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
}

