import java.util.ArrayList;

public class Company {

    ArrayList<Employee> companyMain = new ArrayList<>();
    ArrayList<Employee> managers = new ArrayList<>();
    ArrayList<Employee> operators = new ArrayList<>();
    ArrayList<Employee> topManagers = new ArrayList<>();
    Employee operator = new Operator();
    Employee topManager = new TopManager();
    Employee manager = new Manager();
    double incoming =0;

    public double getIncoming() {
        return incoming;
    }


    public void setIncoming(double incoming) {
        this.incoming = incoming;
    }

    public ArrayList<Employee> hire(ArrayList<Employee> company, Employee emp) {
        company.add(emp);
        System.out.println(" by="+ incoming);
        return companyMain;
    }

    public ArrayList<Employee> hireAll(ArrayList<Employee> company, ArrayList<Employee> managers, ArrayList<Employee> topmanagers,
                                       ArrayList<Employee> operators) {
        company.addAll(managers);
        company.addAll(topmanagers);
        company.addAll(operators);
        System.out.println(" uiu="+ incoming);
        return companyMain;
    }


/*

    void fire() {

    }


    void getTopSalaryStaff(int count) {

    }

    void getLowestSalaryStaff(int count) {

    }
*/

}

