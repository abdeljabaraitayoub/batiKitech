package Ui;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Client extends Main {
    Scanner scanner = new Scanner(System.in);
    Service.Client service = new Service.Client();

    public static void main(String[] args) {
        new Client().Menu();
    }

    public void Menu() {
        choice();
    }

    public void display() {
        clear();
        System.out.println("=== Client Menu ===");
        System.out.println("1. Create a Client");
        System.out.println("2. List all clients");
        System.out.println("3. List professional client");
        System.out.println("4. Get clients by id");
        System.out.println("5. Get clients by name");
        System.out.println("6. Update client");
        System.out.println("7. delete client");
        System.out.println("0.  Exit to main menu");
        System.out.println("Enter your choice: ");
    }

    public void choice() {
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 0) {
            display();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    clear();
                    create();
                    pause();
                    break;
                case 2:
                    clear();
                    list();
                    pause();
                    break;
                case 3:
                    clear();
                    filterByProfessional();
                    pause();
                    break;
                case 4:
                    clear();
                    get();
                    pause();
                    break;
                case 5:
                    clear();
                    searchByName();
                    pause();
                    break;
                case 6:
                    clear();
                    update();
                    pause();
                    break;
                case 7:
                    clear();
                    delete();
                    pause();
                    break;
                case 0:
                    clear();
                    new Menu();
                    break;

                default:
                    new Menu();
                    System.out.println("Invalid option");
            }
        }

    }


    public Entitie.Client create() {
        System.out.println("Enter client name: ");
        String name = scanner.next();
        System.out.println("Enter client phone: ");
        String phone = scanner.next();
        System.out.println("Enter client address: ");
        String address = scanner.next();
        System.out.println("Is the client a professional? (y/n): ");
        boolean isProfessional = scanner.next().equalsIgnoreCase("y");
        service.create(new Entitie.Client(0, name, phone, address, isProfessional));
        return service.last();
    }

    public Entitie.Client update() {
        Entitie.Client client = get();
        System.out.println("are you sure you want to update this client? (y/n): ");
        if (scanner.next().equalsIgnoreCase("n")) {
            return client;
        }
        System.out.println("Enter client name: ");
        client.setName(scanner.next());
        System.out.println("Enter client phone: ");
        client.setPhone(scanner.next());
        System.out.println("Enter client address: ");
        client.setaddress(scanner.next());
        System.out.println("Is the client a professional? (y/n): ");
        client.setIsProfessional(scanner.next().equalsIgnoreCase("y"));
        service.update(client);
        return service.get(client.getId()).get();
    }

    public Entitie.Client get() {
        System.out.println("Enter client id:");
        int id = scanner.nextInt();
        Entitie.Client client = service.get(id).orElse(null);
        System.out.println(client);
        return service.get(id).orElse(null);
    }

    public List<Entitie.Client> list() {
        List<Entitie.Client> clients = service.list();
        System.out.println(clients);
        return clients;
    }

    public void delete() {
        System.out.println("Enter client id: ");
        int id = scanner.nextInt();
        service.delete(id);
    }

    public List<Entitie.Client> filterByProfessional() {
        List<Entitie.Client> clients = service.filterByProfessional();
        System.out.println(clients);
        return clients;
    }

    public Optional<List<Entitie.Client>> searchByName() {
        System.out.println("Enter client name: ");
        String name = scanner.next();
        List<Entitie.Client> clients = service.searchByName(name);
        System.out.println(clients);
        return Optional.ofNullable(clients);
    }
}
