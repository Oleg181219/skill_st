import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvAlfa {
    private static final Path PATH = Paths.get("resurses/movementList.csv");


    public static void main(String[] args) {

        BankAccount bankAccount = new BankAccount();
        try {
            List<String> list = Files.readAllLines(PATH);
            list.remove(0);
            for (String line : list) {
                String[] filds = line.split("\\,", 8);
                bankAccount.countAccountMove(filds);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("============================================" + "\n" +
                "Сумма доходов: " + BankAccount.getIncome() + "руб.");
        System.out.println("Сумма расхода: " + BankAccount.getOutcome() + "руб." + "\n" +
                "Суммы расходов по организациям:" + "\n");
        printValues(BankAccount.getCompany());
    }

    public static void printValues(HashMap<String, Double> map) {

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            String name = pair.getKey();
            Double value = pair.getValue();
            System.out.print(name + "= ");
            String result = String.format("%.2f", value);
            System.out.println(result + "руб.");
        }

    }
}