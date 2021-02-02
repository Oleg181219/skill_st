import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;


public class DBConnection {
    private static Connection connection;

    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "Vadim30052011";
    private static StringBuilder insertQuery = new StringBuilder();
    private static long time;
    private static int j;


    public static long getInsertQueryLenth() {
        return insertQuery.length();
    }

    public static String getInsertQuery() {
        String insertString = insertQuery.toString();
        return insertString;
    }

    public static Connection getConnection() {

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + dbName + "?user=" + dbUser + "&password=" + dbPass + "&useSSL=false&serverTimezone=UTC");
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name TINYTEXT NOT NULL, " +
                        "birthDay DATE NOT NULL, " +
                        "num_station INT NOT NULL, " +
                        "time DATETIME NOT NULL," +
                        "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return connection;
    }

    public static void executeMultiInsert(String string) throws Exception {

        String sql = "INSERT INTO voter_count(name, birthDay, num_station, time) "
                + "VALUES" + string;

//        if (sql.length() < 70) {
//            try {
//                j = j +1;
//                BufferedWriter writer = new BufferedWriter(new FileWriter("notes" + j + ".txt", false));
//                writer.write(sql);
//                writer.close();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        /**
         * поставил условие что бы откинуть запросы с отсутствующими VALUES
         */
//        if (sql.length() > 70) {
        try {
            DBConnection.getConnection().createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            insertQuery = new StringBuilder();
//        }


    }

    public static void countVoter(String name, String birthDay, String numStation, String time) throws Exception {
        birthDay = birthDay.replace('.', '-');
        insertQuery.append((insertQuery.length() == 0 ? "" : ",")
                + "('" + name + "', '" + birthDay + "', '" + numStation + "', '" + time + "')");

    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, `count` FROM voter_count WHERE `count` > 1";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                    rs.getString("birthDate") + ") - " + rs.getInt("count"));
        }
    }
}
