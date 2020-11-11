import java.util.HashMap;

public class BankAccount {
    private static double income;
    private static double outcome;
    private double out;
    private double amountSpent;
    private static HashMap<String, Double> company = new HashMap<>();
    private String concan;

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
        amountSpent = Double.parseDouble(fild[7].replace('"', ' ')
                .replace(',', '.').trim());
        out = getOutcome() + amountSpent;
        setOutcome(out);


        String string = fild[5].substring(28, 60).trim();

        if (string.matches("\\\\.+") || string.matches("\\s.+") || string.matches("\\w.+")) {
            String[] companyList = string.split("\\\\");
            concan = "";

            for (int i = 0; i < companyList.length; i++) {
                concan = concan.concat(companyList[i]).concat(" ");
            }

            if (company.containsKey(concan)) {
                company.put(concan, company.get(concan) + amountSpent);

            } else if (!company.containsKey(concan)) {
                company.put(concan, amountSpent);
            }

        }
    }


}



