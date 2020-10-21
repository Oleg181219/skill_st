import java.math.BigDecimal;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        Employee operator = new Operator();
        Employee topManager = new TopManager();
        Employee manager = new Manager();
        ArrayList<BigDecimal> company = new ArrayList<>();

// создание  Manager
        for (int j = 0; j < 80; j++) {
            company.add(manager.getMonthSalary());
        }
// создание Operator
        for (int i = 0; i < 50; i++) {
            company.add(operator.getMonthSalary());
        }
// создание тор
        for (int i = 0; i < 10; i++) {
            company.add(topManager.getMonthSalary());
        }

        System.out.println(company.size());
        System.out.println(company);

       // System.out.println(company.);

    }

}
