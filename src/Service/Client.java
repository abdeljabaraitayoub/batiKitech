package Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Client {
    private final Repository.Client repository = new Repository.Client();

    public static void main(String[] args) {
        Client client = new Client();
//        client.list();
//        client.filteronlyProfessional();
//        client.create();
//        client.update();
//        client.delete();
        client.searchByName("a");
    }


    public List<Entitie.Client> list() {
        return repository.list();
    }

    public Optional<Entitie.Client> get(int id) {
        return Optional.ofNullable(Repository.Client.get(id)).orElse(null);
    }

    public List<Entitie.Client> filterByProfessional() {
        return repository.list().stream().filter(client -> client.getIsProfessional()).toList();
    }

    public void create(Entitie.Client client) {
        Repository.Client.create(client);
    }

    public void update(Entitie.Client client) {
        repository.update(client.getId(), client);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public List<Entitie.Client> searchByName(String name) {
        List<Entitie.Client> clients = Repository.Client.searchByName(name);
        if (clients.isEmpty()) {
            System.out.println("No clients found");
            return null;
        } else {
            return clients;
        }
    }

    public Entitie.Client last() {
        return Repository.Client.last();
    }


}
