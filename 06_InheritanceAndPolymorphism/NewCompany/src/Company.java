import java.math.BigDecimal;
import java.util.ArrayList;

public class Company {
    ArrayList<Employee> companyMain = new ArrayList<>();
    BigDecimal incoming = new BigDecimal("0");
    Employee operator = new Operator();
    Employee topManager = new TopManager();
    Employee manager = new Manager();
    BigDecimal coefficient = new BigDecimal(20);


    void incoming(ArrayList<Employee> arrayList, int num) {
        for (int i = 0; i < num; i++) {
            incoming = incoming.add(((arrayList.get(i).getMonthSalary().subtract(manager.getOklad())).multiply(coefficient)));
        }
    }

    public BigDecimal getIncoming() {
        return incoming;
    }

    public void setIncoming(BigDecimal incoming) {
        this.incoming = incoming;
    }

    /*void hire(Employee emp) {
        company.add(emp);
    }*/

    public ArrayList<Employee> hireAll(ArrayList<Employee> company, ArrayList<Employee> managers, ArrayList<Employee> topmanagers,
                                       ArrayList<Employee> operators) {
        company.addAll(managers);
        company.addAll(topmanagers);
        company.addAll(operators);
        return companyMain;
    }


    void fire() {

    }


    void getTopSalaryStaff(int count) {

    }

    void getLowestSalaryStaff(int count) {

    }

   /* public BigDecimal getIncoming() {
        //System.out.println(incoming);
        return incoming;
    }

    public void setIncoming(BigDecimal incoming) {
        this.incoming = incoming;
    }*/
}

