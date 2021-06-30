package databases;
import org.testng.annotations.AfterSuite;

import java.sql.*;
import java.util.ArrayList;

public class ConnectDB {
    public static Connection connection = null;
    public static Statement statement = null;

    static {
        try {
            connection = getConnection("root", "Moto1996", "peopleandtech");
            statement = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection(String username, String password, String databaseName) throws SQLException {
        String url = Utilities.getPropertyFromConfig("dbUrl") + databaseName + "?serverTimezone=UTC";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }


    public static ArrayList connectToDbAndGetData(String query, String columnName) throws SQLException {

        Statement statement = ConnectDB.connection.createStatement();
        ResultSet table = statement.executeQuery(query);

        ArrayList dataList = new ArrayList();
        String data = "";
        while (table.next()) {

            data = table.getString(columnName);
            dataList.add(data);
        }

        return dataList;
    }

    @AfterSuite
    public static void cleanUpDatabase(Statement statement, Connection connection) {
        try {
            statement.close();
            connection.close();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}
