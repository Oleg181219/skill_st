import java.math.BigDecimal;
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
        company.incoming(managers, numberOfManagers);
        for (int k = 0; k < numberOfTopManagers; k++) {
            topManagers.add(topManager);
        }
        for (int l = 0; l < numberOfOperator; l++) {
            operators.add(operator);
        }
// ===========================================
        company.hireAll(companyMain, managers, topManagers, operators);
// ===========================================
        System.out.println("Сотрудников в main компании =" + companyMain.size());
        System.out.println("Общий доход компании = " + company.getIncoming() + " тугриков ");

    }
}