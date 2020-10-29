import java.util.ArrayList;
import java.util.List;


public class main {
    public static void main(String[] args) {
        int numberOfManagers = 80;
        int numberOfOperator = 180;
        int numberOfTop = 10;
        int topSalary = 10;
        int lowSalary = 10;
        ArrayList<Employee> managers = new ArrayList<>();
        ArrayList<Employee> operators = new ArrayList<>();
        ArrayList<Employee> topManagers = new ArrayList<>();
        Company company = new Company();

        for (int j = 0; j < numberOfManagers; j++) {
            Employee manager = new Manager();
            manager.setMonthSalary();
            managers.add(manager);
        }

        for (int j = 0; j < numberOfTop; j++) {
            Employee topManager = new TopManager();
            topManager.setMonthSalary();
            topManagers.add(topManager);
        }

        for (int j = 0; j < numberOfOperator; j++) {
            Employee operator = new Operator();
            operator.setMonthSalary();
            operators.add(operator);
        }

        System.out.println("Общий доход компании = " + Company.getIncoming() + " тугриков ");
        company.hireAll(managers);
        company.hireAll(topManagers);
        company.hireAll(operators);
        System.out.println(company.employeeList.size());

        System.out.println(company.getTopSalaryStaff(topSalary).size());


        for (int i = 0; i < company.employeeList.subList(0, topSalary).size(); i++) {
            System.out.println(i + "-Top =" + company.getTopSalaryStaff(topSalary).get(i).getMonthSalary());
        }
        System.out.println("--" + company.getLowestSalaryStaff(lowSalary).size());
        for (int i = 0; i < company.employeeList.subList(0, lowSalary).size(); i++) {
            System.out.println(i + "-Low =-" + company.getLowestSalaryStaff(lowSalary).get(i).getMonthSalary());
        }

        List<Employee> dissmissList = company.employeeList.subList(0,company.employeeList.size()/2 );
        int j = dissmissList.size();
        for (int i= 0; i< j; i++) {
            company.fire(company.employeeList.get(i));
        }

        System.out.println(""+ company.employeeList.size());
        for (int i = 0; i < company.employeeList.subList(0, topSalary).size(); i++) {
            System.out.println(i + "-Top  after =" + company.getTopSalaryStaff(topSalary).get(i).getMonthSalary());
        }
        for (int i = 0; i < company.employeeList.subList(0, lowSalary).size(); i++) {
            System.out.println(i + "-Lowest after =" + company.getLowestSalaryStaff(lowSalary).get(i).getMonthSalary());
        }

    }
}