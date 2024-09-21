package Ui;

import java.util.List;
import java.util.Scanner;

public class Client extends Main {
    Scanner scanner = new Scanner(System.in);
    Service.Client service = new Service.Client();

    public void Menu() {
        while (true) {
            clear();
            display();
            choice();
        }
    }

    public void display() {
        System.out.println("=== Client Menu ===");
        System.out.println("1. Create a Client");
        System.out.println("2. List all clients");
        System.out.println("3. List professional client");
        System.out.println("4. Get clients by id");
        System.out.println("5. Update client by id");
        System.out.println("6. delete client by id");
        System.out.println("Enter your choice: ");
    }

    public void choice() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                clear();
                create();
                pause();
                break;
            case 2:
                clear();

                pause();
                break;
            case 3:
                clear();
                new Service.Client().filteronlyProfessional();
                pause();
                break;
            case 4:
                clear();
//                new Service.Client().get();
                pause();
                break;
            case 5:
                clear();
                new Service.Client().update();
                pause();
                break;
            case 6:
                clear();
                new Service.Client().delete();
                pause();
                break;

            default:
                new Menu();
                System.out.println("Invalid option");
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


    public Entitie.Client get() {
        System.out.println("Enter client id:");
        int id = scanner.nextInt();
        Entitie.Client client = service.get(id);
        System.out.println(client);
        return service.get(id);
    }

    public List<Entitie.Client> list() {
        return service.list();
    }

    public List<Entitie.Client> searchByName() {
        System.out.println("Enter client name: ");
        String name = scanner.next();
        List<Entitie.Client> clients = service.searchByName(name);
        System.out.println(clients);
        return clients;
    }
}
