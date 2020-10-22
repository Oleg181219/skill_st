import java.math.BigDecimal;
import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        Company company = new Company();
// задаем количество сотрудников
        company.setNumberOfManagers(80);
        company.setNumberOfOperator(180);
        company.setNumberOfTopManagers(10);
// ===========================================
        company.hireAll();
        System.out.println("Сотрудников в компании =" + company.company.size());
        System.out.println("Общий доход компании = " + company.getIncoming() + " тугриков ");


    }

}
