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


    public int executeUpdate(String sql, Object... params) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeUpdate();
        }
    }

}