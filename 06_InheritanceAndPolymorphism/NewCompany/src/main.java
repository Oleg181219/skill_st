
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Company company = new Company();
        int numberOfManagers = 10;
        int numberOfOperator = 180;
        int numberOfTopManagers = 10;

//============================================

        for (int j = 0; j < numberOfManagers; j++) {
            System.out.println("1-" + company.manager.setMonthSalary());
            System.out.println("2-" + company.manager.getMonthSalary());
            company.managers.add(j, company.manager);

        }
      /*  for (int k = 0; k < numberOfTopManagers; k++) {

            company.topManagers;
        }
        for (int l = 0; l < numberOfOperator; l++) {

            company.operators;
        }*/
// ===========================================
        for (int m = 0; m < numberOfManagers; m++) {
            System.out.println("managers.get(" + m + ").MonthSalary() -" + company.managers.get(m).getMonthSalary());
        }

      /*  company.hireAll(company.companyMain, company.managers, company.topManagers, company.operators);
        company.hire(company.companyMain, company.operator);*/

// ===========================================
       /* System.out.println(company.companyMain.size());
        System.out.println("Общий доход компании = " + company.getIncoming() + " тугриков ");
        System.out.println("managers.get(1).getMonthSalary()=");*/


    }
}