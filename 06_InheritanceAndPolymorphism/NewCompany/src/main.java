import java.util.ArrayList;


public class main {
    public static void main(String[] args) {
        int numberOfManagers = 80;
        int numberOfOperator = 180;
        int numberOfTop = 10;
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

        company.getTopSalaryStaff(15);
        for (int i = 0; i < company.employeeListTop.size(); i++) {
            System.out.println(i + "-max ДО- " + company.employeeListTop.get(i).getMonthSalary());
        }
        System.out.println(company.employeeListTop.size());

        company.getLowestSalaryStaff(30);
        for (int i = 0; i < company.employeeListLow.size(); i++) {
            System.out.println(i + "-min ДО- " + company.employeeListLow.get(i).getMonthSalary());
        }
        System.out.println(company.employeeListLow.size());

        company.fire(50);

        company.getTopSalaryStaff(15);
        for (int i = 0; i < company.employeeListTop.size(); i++) {
            System.out.println(i + "-max ПОСЛЕ- " + company.employeeListTop.get(i).getMonthSalary());
        }
        System.out.println(company.employeeListTop.size());

        company.getLowestSalaryStaff(30);
        for (int i = 0; i < company.employeeListLow.size(); i++) {
            System.out.println(i + "-min ПОСЛЕ- " + company.employeeListLow.get(i).getMonthSalary());
        }
        System.out.println(company.employeeListLow.size());

    }
}