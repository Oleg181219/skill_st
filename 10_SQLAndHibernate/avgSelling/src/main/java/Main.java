import java.sql.*;
import com.mysql.cj.jdbc.Driver;

public class Main {

    public static void main(String[] args) {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String password = "Vadim30052011";


            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name , " +
                    "COUNT(subscription_date)/ (MAX(MONTH(subscription_date))- MIN(MONTH(subscription_date))) as average\n" +
                    "FROM Subscriptions\n" +
                    "JOIN Courses ON Courses.id = Subscriptions.course_id \n" +
                    "GROUP BY course_id;");
            while (resultSet.next()){
                String name =  resultSet.getString("name");
                String average = resultSet.getString("average");
                System.out.println(name +" - "+ average);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
