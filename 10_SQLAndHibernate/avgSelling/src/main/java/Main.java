import java.sql.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/skillbox";
    private static final String user = "root";
    private static final String password = "Vadim30052011";
    private static Course course;
    private static int num = 10;

    public static void main(String[] args) {

        //10.1
        averageSell();

        //10.2
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
            SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            course = session.get(Course.class, num);


            System.out.println("Название курса: " + course.getName() +
                    "\nКоличество студентов: " + course.getStudentsCount());
            System.out.println(course.getTeacher().getName() + ", с зп:" + course.getTeacher().getSalary() + " руб.");
            List<Student> studentList = course.getStudents();

            for (Student stud : studentList) {
                System.out.println(stud.getName());
            }


            transaction.commit();
            sessionFactory.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    private static void averageSell() {
        try {
            Connection connection = DriverManager.getConnection(Main.url, Main.user, Main.password);
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
