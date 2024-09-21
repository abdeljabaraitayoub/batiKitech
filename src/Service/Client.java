package Service;

import java.util.List;
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

    public Entitie.Client get(int id) {
        return Repository.Client.get(id);
    }

    public void filteronlyProfessional() {
        repository.list().stream().filter(client -> client.getIsProfessional()).forEach(client -> System.out.println(client));
    }

    public void create(Entitie.Client client) {
        Repository.Client.create(client);
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client id: ");
        int id = scanner.nextInt();
        System.out.println("Enter client name: ");
        String name = scanner.next();
        System.out.println("Enter client phone: ");
        String phone = scanner.next();
        System.out.println("Enter client address: ");
        String address = scanner.next();
        System.out.println("Is the client a professional? (y/n): ");
        boolean isProfessional = scanner.next().equalsIgnoreCase("y");
        Entitie.Client client = new Entitie.Client(id, name, phone, address, isProfessional);
        repository.update(id, client);
    }

    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client id: ");
        int id = scanner.nextInt();
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
