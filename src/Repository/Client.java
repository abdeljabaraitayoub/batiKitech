package Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static final Repository.Dao.Client clientDao = new Repository.Dao.Client();

    public static void main(String[] args) {
        Repository.Client client = new Repository.Client();
        Entitie.Client client1 = new Entitie.Client(1, "John Doe", "123456789", "123 Main St", true);
        Entitie.Client client2 = new Entitie.Client(2, "Jane Doe", "987654321", "456 Main St", false);
        Client.create(client1);
        Client.create(client2);
        System.out.println(Client.get(1));
        System.out.println(Client.get(2));
        client.update(1, new Entitie.Client(1, "John Doe", "123456789", "123 Main St", false));
        System.out.println(Client.get(1));
        client.delete(1);
        System.out.println(Client.get(1));
        System.out.print(client.list());
    }


    public static void create(Entitie.Client client) {
        clientDao.create(client);
    }

    public void update(int id, Entitie.Client client) {
        clientDao.update(id, client);
    }

    public void delete(int id) {
        clientDao.delete(id);
    }


    public static Entitie.Client get(int id) {
        return Entitie.Client.mapResultSet(clientDao.get(id));
    }

    public List<Entitie.Client> list() {
        List<Entitie.Client> clients = new ArrayList<>();
        try (ResultSet resultSet = clientDao.list()) {
            while (resultSet.next()) {
                clients.add(Entitie.Client.mapResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }


    public static List<Entitie.Client> searchByName(String name) {
        return new Client().list().stream().filter(client -> client.getName().contains(name)).toList();
    }

    public static List<Entitie.Client> searchByPhone(String phone) {
        return new Client().list().stream().filter(client -> client.getPhone().equals(phone)).toList();
    }


}
