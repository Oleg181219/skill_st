import java.math.BigDecimal;
import java.util.ArrayList;

public class Company {
    ArrayList<Employee> companyMain = new ArrayList<>();
    BigDecimal incoming = new BigDecimal("666666");

    public BigDecimal getIncoming() {
        return incoming;
    }

    public void setIncoming(BigDecimal incoming) {
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

