package Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private final Repository.Dao.Client clientDao = new Repository.Dao.Client();

    public static void main(String[] args) {
        Repository.Client client = new Repository.Client();
        Entitie.Client client1 = new Entitie.Client(1, "John Doe", "123456789", "123 Main St", true);
        Entitie.Client client2 = new Entitie.Client(2, "Jane Doe", "987654321", "456 Main St", false);
        client.create(client1);
        client.create(client2);
        System.out.println(client.get(1));
        System.out.println(client.get(2));
        client.update(1, new Entitie.Client(1, "John Doe", "123456789", "123 Main St", false));
        System.out.println(client.get(1));
        client.delete(1);
        System.out.println(client.get(1));
        System.out.print(client.list());
    }


    public void create(Entitie.Client client) {
        clientDao.create(client);
    }

    public void update(int id, Entitie.Client client) {
        clientDao.update(id, client);
    }

    public void delete(int id) {
        clientDao.delete(id);
    }


    public Entitie.Client get(int id) {
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
}
