import java.sql.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    private static String url = "jdbc:mysql://localhost:3306/skillbox";
    private static String user = "root";
    private static String password = "Vadim30052011";

    public static void main(String[] args) {
        // averageSell(url,user,password); // 10.1
        //10.2
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, 40);
        System.out.println("Название курса: " + course.getName() +
                "\nКоличество студентов: " + course.getStudentsCount());
        sessionFactory.close();
    }

    private static void averageSell(String url, String user, String password) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name , " +
                    "COUNT(subscription_date)/ (MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date)) + 1) as average\n" +
                    "FROM Subscriptions\n" +
                    "JOIN Courses ON Courses.id = Subscriptions.course_id \n" +
                    "GROUP BY course_id;");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String average = resultSet.getString("average");
                System.out.println(name + " - " + average);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
