
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Company company = new Company();
        int numberOfManagers = 80;
        int numberOfOperator = 180;
        int numberOfTopManagers = 10;
        Employee operator = new Operator();
        Employee topManager = new TopManager();
        Employee manager = new Manager();
        ArrayList<Employee> managers = new ArrayList<>();
        ArrayList<Employee> operators = new ArrayList<>();
        ArrayList<Employee> topManagers = new ArrayList<>();
        ArrayList<Employee> companyMain = new ArrayList<>();
//============================================
        for (int j = 0; j < numberOfManagers; j++) {
            managers.add(manager);
        }
        for (int k = 0; k < numberOfTopManagers; k++) {
            topManagers.add(topManager);
        }
        for (int l = 0; l < numberOfOperator; l++) {
            operators.add(operator);
        }
// ===========================================
       /* for (int m = 0; m < numberOfManagers; m++) {
            System.out.println(managers.get(m).getMonthSalary());
        }*/
        company.hireAll(companyMain, managers, topManagers, operators);
        company.hire(companyMain, operator);
// ===========================================
        System.out.println(companyMain.size());
        System.out.println("Общий доход компании = " + company.getIncoming() + " тугриков ");

    }
}