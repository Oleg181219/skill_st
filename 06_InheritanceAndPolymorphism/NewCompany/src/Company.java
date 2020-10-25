import java.util.ArrayList;

public class Company {
    //Employee manager = new Manager();
    ArrayList<Employee> companyMain = new ArrayList<>();


    double incoming;

    public double getIncoming() {
        return incoming;
    }


    public void setIncoming(double incoming) {
        this.incoming = incoming;
    }

    public ArrayList<Employee> hire(ArrayList<Employee> company, Employee emp) {
        company.add(emp);
        return companyMain;
    }

    public ArrayList<Employee> hireAll(ArrayList<Employee> company, ArrayList<Employee> managers, ArrayList<Employee> topmanagers,
                                       ArrayList<Employee> operators) {
        company.addAll(managers);
        company.addAll(topmanagers);
        company.addAll(operators);
        System.out.println(" uiu=" + incoming);
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

