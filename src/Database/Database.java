package Database;

import java.sql.*;

public class Database {

    private static Database instance = null;
    private static final String user = "admin";
    private static final String ip = "localhost";
    private static final String port = "5432";
    private static final String password = "admin";
    private static final String database = "batikitchen";
    public static Connection connection;


    private Database() {
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://" + ip + ":" + port + "/" + database, user, password);
                System.out.println("Connection successful.");
            } catch (SQLException e) {
                System.out.println("Connection failure.");
                e.printStackTrace();

            }
        }
        return instance;
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Query execution failure.");
            e.printStackTrace();
            throw e;
        }
    }


    public static int executeUpdate(String query) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Update execution failure.");
            e.printStackTrace();
            throw e;
        }
    }

}