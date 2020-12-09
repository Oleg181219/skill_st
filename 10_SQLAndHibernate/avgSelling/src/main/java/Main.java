import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/skillbox";
    private static final String user = "root";
    private static final String password = "Vadim30052011";
    private static Course course;
    private static int num = 10;

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateActivation.getSessionFactory();
        Session session = sessionFactory.openSession();
        Course course = session.get(Course.class, 1);
        //10.1
        averageSell();


        //10.2
        String sql = "select * from Courses";
        Query query = session.createSQLQuery(sql).addEntity(Course.class);
        List<Course> courses = query.list();
        for (Course oneCourse : courses) {
            System.out.println(oneCourse.getName() + " (количество студентов - " + oneCourse.getStudentsCount() + ")");
        }

        sql = "select * from Purchaselist";
        query = session.createSQLQuery(sql).addEntity(PurchaseList.class);
        List<PurchaseList> purchaseLists = query.list();


        Transaction transaction = session.beginTransaction();
        for (PurchaseList purchaseList : purchaseLists) {
            session.save(new LinkedPurchaseList(purchaseList.getStudent(), purchaseList.getCourse()));
        }

        transaction.commit();
        sessionFactory.close();
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
