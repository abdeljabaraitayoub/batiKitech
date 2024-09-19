package Service;

import Repository.Client;
import Enum.ProjectStatus;

import java.util.List;
import java.util.Scanner;

public class Project {
    Repository.Project repository = new Repository.Project();

    public static void main(String[] args) {
        Project project = new Project();
        project.create();
    }

    public void list() {
        repository.list().get().forEach(System.out::println);
    }

    public void create() {
        Entitie.Client client = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.search for client by name");
        System.out.println("2.create a new client");
        System.out.println("Choose an option:");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                System.out.println("Enter client name: ");
                String name = scanner.next();
                List<Entitie.Client> clients = Client.searchByName(name);
                clients.forEach(System.out::println);
                if (clients.isEmpty()) {
                    System.out.println("No clients found");
                    return;
                } else {
                    System.out.println("Enter client id: ");
                    client = Client.get(scanner.nextInt());
                }
                break;
            case 2:
                System.out.println("Enter client name: ");
                String name1 = scanner.next();
                System.out.println("Enter client phone: ");
                String phone = scanner.next();
                System.out.println("Enter client address: ");
                String address = scanner.next();
                System.out.println("Is the client a professional? (y/n): ");
                boolean isProfessional = scanner.next().equalsIgnoreCase("y");
                client = new Entitie.Client(0, name1, phone, address, isProfessional);
                Client.create(client);
                client = Client.searchByPhone(phone).getFirst();
                break;
            default:
                System.out.println("Invalid option");
        }

        System.out.println("Enter project name: ");
        String name = scanner.next();
        Entitie.Project project = new Entitie.Project(0, name, 0, 0, ProjectStatus.IN_PROGRESS, client);
        repository.create(project);
    }
}
