import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;


public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Wrong format. \nCorrect format:  add Василий Петров " +
                    "vasily.petrov@gmail.com +79215637722");
        }

        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(components[2]);

        if (!m.find()) {
            throw new IllegalArgumentException("Wrong e-mail format. \nCorrect format: vasily.petrov@gmail.com ");
        }

        Pattern t = Pattern.compile("^\\+?[78][-\\(]?\\d{3}\\)?-?\\d{3}-?\\d{2}-?\\d{2}$");
        Matcher t1 = t.matcher(components[3]);
        if (!t1.find()) {
            throw new IllegalArgumentException("Wrong phone format. \nCorrect format: +79215637722 ");
        }

        String name = components[0] + " " + components[1];
        Double.parseDouble(components[3]);
        storage.put(name, new Customer(name, components[3], components[2]));

    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public int getCount() {
        return storage.size();
    }
}