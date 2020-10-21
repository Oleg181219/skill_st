import java.math.BigDecimal;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        BigDecimal coefficient =new BigDecimal(20);
        Employee operator = new Operator();
        Employee topManager = new TopManager();
        Employee manager = new Manager();
        ArrayList<BigDecimal> company = new ArrayList<>();
        Company companyMain = new Company();
        companyMain.getIncoming();
// создание  Manager
        for (int j = 0; j < 80; j++) {
            company.add(manager.getMonthSalary());
        }
        for (int i = 0; i < company.size(); i++){
            companyMain.setIncoming(companyMain.getIncoming().add(company.get(i)
                    .subtract(manager.getOklad()).multiply(coefficient)));
        }
// создание топов
        for (int k = 0; k <10;k++){
           company.add(topManager.getMonthSalary());
        }
// создание operator
        for (int l = 0; l <180;l++){
            company.add(operator.getMonthSalary());
        }

        System.out.println("income = " + companyMain.getIncoming());
        System.out.println(company.size());
        System.out.println(company);
    }

}
