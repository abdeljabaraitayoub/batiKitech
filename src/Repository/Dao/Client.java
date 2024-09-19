package Repository.Dao;

import Database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Client extends Dao {

    public void create(Entitie.Client client) {
        String sql = "INSERT INTO clients (name, address, phone, isProfessional) VALUES (?, ?, ?, ?::boolean)";

        try {
            int rowsAffected = database.executeUpdate(sql,
                    client.getName(),
                    client.getaddress(),
                    client.getPhone(),
                    client.getIsProfessional() ? "true" : "false"
            );

            if (rowsAffected > 0) {
                System.out.println("Client created successfully.");

            } else {
                System.out.println("Failed to create client.");
            }
        } catch (SQLException e) {
            System.err.println("Error creating client: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void update(int id, Entitie.Client client) {
        String sql = "update clients set name = ?, address = ?, phone = ?, isProfessional = ? where id = ?";
        try {
            int rowsAffected = database.executeUpdate(
                    sql,
                    client.getName(),
                    client.getaddress(),
                    client.getPhone(),
                    client.getIsProfessional(),
                    id

            );
            if (rowsAffected > 0) {
                System.out.println("Client updated successfully.");
            } else {
                System.out.println("Failed to update client.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        String sql = "delete from clients where id = ?";
        try {
            int rowsAffected = database.executeUpdate(sql, id);
            if (rowsAffected > 0) {
                System.out.println("Client deleted successfully.");
            } else {
                System.out.println("Failed to delete client.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet get(int id) {
        try {
            ResultSet resultSet = Database.executeQuery("select * from clients where id = " + id);
            if (resultSet.next()) {
                return resultSet;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ResultSet list() {
        try {
            String sql = "SELECT * FROM clients";
            return Database.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ResultSet getByPhone(String phone) {
        try {
            String sql = "SELECT * FROM clients WHERE phone = '" + phone + "'";
            return Database.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}

