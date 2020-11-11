import java.util.HashMap;

public class BankAccount {
    private static double income;
    private static double outcome;
    private static final HashMap<String, Double> company = new HashMap<>();

    public static HashMap<String, Double> getCompany() {
        return company;
    }

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


    public void countAccountMove(String[] fild) {

        setIncome(getIncome() + Double.parseDouble(fild[6]));
        double amountSpent = Double.parseDouble(fild[7].replace('"', ' ')
                .replace(',', '.').trim());
        double out = getOutcome() + amountSpent;
        setOutcome(out);


        String string = fild[5].substring(28, 60).trim();

        if (string.matches("\\\\.+") || string.matches("\\s.+") || string.matches("\\w.+")) {
            String[] companyList = string.split("\\\\");
            String concan = "";

            for (String s : companyList) {
                concan = concan.concat(s).concat(" ");
            }

            if (company.containsKey(concan)) {
                company.put(concan, company.get(concan) + amountSpent);

            } else if (!company.containsKey(concan)) {
                company.put(concan, amountSpent);
            }

        }
    }


}



