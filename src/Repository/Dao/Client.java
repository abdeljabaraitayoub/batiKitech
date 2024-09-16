package Repository.Dao;

import Database.Database;

import java.sql.ResultSet;

public class Client extends Dao {

    public void create(Entitie.Client client) {
        try {
            String sql = String.format("INSERT INTO clients (name, address, phone, isProfessional) VALUES ('%s', '%s', '%s', %s)",
                    escapeSQL(client.getName()),
                    escapeSQL(client.getaddress()),
                    escapeSQL(client.getPhone()),
                    client.getIsProfessional()
            );
            Database.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(int id, Entitie.Client client) {
        try {
            Database.executeUpdate("update clients set name = '" + client.getName() + "', phone = '" + client.getPhone() + "', address = '" + client.getaddress() + "', isProfessional = '" + client.getIsProfessional() + "' where id = " + id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        try {
            Database.executeUpdate("delete from clients where id = " + id);
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

}
