import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Сумма расходов: 398 563.39 руб.
 * Сумма доходов: 289 890.06 руб.
 * <p>
 * Суммы расходов по организациям:
 * RUSMOSKVA56  SHLOVE REPUBLIC        1 081.53 руб.
 * RUSMOSCOW42 SHCL ETOILE                     126.34 руб.
 * RUSPUSHKINO105ZOOMAGAZIN 4             217.65 руб.
 */
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
        System.out.println("Сумма прихода: " + BankAccount.getIncome());
        System.out.println("Сумма расхода: " + BankAccount.getOutcome());
    }
}