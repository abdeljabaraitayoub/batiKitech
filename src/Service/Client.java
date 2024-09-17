package Service;

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


    public void list() {
        repository.list().forEach(System.out::println);
    }

    public void filteronlyProfessional() {
        repository.list().stream().filter(client -> client.getIsProfessional()).forEach(client -> System.out.println(client));
    }

    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client name: ");
        String name = scanner.nextLine();
        System.out.println("Enter client phone: ");
        String phone = scanner.nextLine();
        System.out.println("Enter client address: ");
        String address = scanner.nextLine();
        System.out.println("Is the client a professional? (y/n): ");
        boolean isProfessional = scanner.nextLine().equalsIgnoreCase("y");
        Entitie.Client client = new Entitie.Client(0, name, phone, address, isProfessional);
        repository.create(client);
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

    public void searchByName(String name) {
        repository.list().stream().filter(client -> client.getName().contains(name)).forEach(client -> System.out.println(client));
    }
}
