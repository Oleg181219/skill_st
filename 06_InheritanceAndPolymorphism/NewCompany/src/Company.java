import java.math.BigDecimal;
import java.util.ArrayList;

public class Company {

    private BigDecimal incoming = new BigDecimal(0);
    ArrayList<Employee> company = new ArrayList<>();
    BigDecimal coefficient = new BigDecimal(20);
    Employee operator = new Operator();
    Employee topManager = new TopManager();
    Employee manager = new Manager();

    int numberOfManagers;
    int numberOfOperator;
    int numberOfTopManagers;

    // геттеры сеттеры для количества сотрудников
    public int getNumberOfOperator() {
        return numberOfOperator;
    }

    public void setNumberOfOperator(int numberOfOperator) {
        this.numberOfOperator = numberOfOperator;
    }

    public int getNumberOfTopManagers() {
        return numberOfTopManagers;
    }

    public void setNumberOfTopManagers(int numberOfTopManagers) {
        this.numberOfTopManagers = numberOfTopManagers;
    }

    public int getNumberOfManagers() {
        return numberOfManagers;
    }

    public void setNumberOfManagers(int numberOfManagers) {
        this.numberOfManagers = numberOfManagers;
    }


    void hire(Employee emp) {
        company.add(emp);
    }

    public void hireAll() {
        for (int j = 0; j < numberOfManagers; j++) {
            company.add(manager);
            System.out.println(company.get(j).getMonthSalary());

        }
        for (int i = 0; i < numberOfManagers; i++) {
            incoming = incoming.add(((company.get(i).getMonthSalary().subtract(manager.getOklad())).multiply(coefficient)));

        }
        for (int k = 0; k < numberOfTopManagers; k++) {
            company.add(topManager);
        }
        for (int l = 0; l < numberOfOperator; l++) {
            company.add(operator);
        }
    }


    void fire() {

    }


    void getTopSalaryStaff(int count) {

    }

    void getLowestSalaryStaff(int count) {

    }

    public BigDecimal getIncoming() {
        //System.out.println(incoming);
        return incoming;
    }

    public void setIncoming(BigDecimal incoming) {
        this.incoming = incoming;
    }
}

