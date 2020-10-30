import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args) {
        ArrayList<Employee> staff = loadStaffFromFile();
// 1 метод. зп только выдает в порядке убыания :((( не нашел как исправить.
//       staff.sort(Comparator.comparing((Employee employee) -> employee.getSalary())
//               .thenComparing(Employee::getName));
// 2 метод
        staff.sort((a1, a2) -> {
            int result = (a2.getSalary() - a1.getSalary());
            if (result != 0) {
                return result;
            }
            return (a1.getName().compareTo(a2.getName()));
        });


        for (Employee s : staff) {
            System.out.println(s);
        }
    }


    private static ArrayList<Employee> loadStaffFromFile() {
        ArrayList<Employee> staff = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }


}