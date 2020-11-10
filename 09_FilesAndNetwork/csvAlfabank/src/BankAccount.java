import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private static double income;
    private static double outcome;
    private static double out;
    //Company companyes;

    public static double getIncome() {
        return income;
    }

    public static void setIncome(double income) {
        BankAccount.income = income;
    }

    public static double getOutcome() {
        return outcome;
    }

    public static void setOutcome(double outcome) {
        BankAccount.outcome = outcome;
    }

    private  ArrayList<Company> companyes = new ArrayList<>();

    public  void countAccountMove(String[] fild) {

        setIncome(getIncome() + Double.parseDouble(fild[6]));
        out = getOutcome() + Double.parseDouble(fild[7].replace('"', ' ')
                .replace(',', '.').trim());
        setOutcome(out);
       /* String string = fild[5].substring(28, 60);
        if (string.matches("\\\\.+") || string.matches("\\s.+") || string.matches("\\w.+")) {
            String[] company = string.split("\\\\");

            if(companyes.getNameCompany().contains(company[company.length - 1].trim())){



            }
        }*/


    }


}
