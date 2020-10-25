
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Company company = new Company();
        //Company manager = new Company();
        int numberOfManagers = 80;
        int numberOfOperator = 180;
        int numberOfTopManagers = 10;
        ArrayList<Employee> operators = new ArrayList<>();
        ArrayList<Employee> topManagers = new ArrayList<>();
        ArrayList<Employee> managers = new ArrayList<>();
//============================================

        for (int j = 0; j < numberOfManagers; j++) {
            Employee manager = new Manager();
            manager.setMonthSalary();
            managers.add(manager);

        }
      /*  for (int k = 0; k < numberOfTopManagers; k++) {

            company.topManagers;
        }
        for (int l = 0; l < numberOfOperator; l++) {

            company.operators;
        }*/
// ===========================================
        for (int m = 0; m < numberOfManagers; m++) {
            System.out.println("managers.get(" + m + ").MonthSalary() -" + managers.get(m).getMonthSalary());
        }

      /*  company.hireAll(company.companyMain, company.managers, company.topManagers, company.operators);
        company.hire(company.companyMain, company.operator);*/

// ===========================================
       //System.out.println(company.companyMain.size());
        System.out.println("Общий доход компании = " + company.getIncoming() + " тугриков ");



    }
}