package Ui;

import Repository.Client;

import Enum.ProjectStatus;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Project extends Main {
    Service.Project service = new Service.Project();

    public static void main(String[] args) {
        new Project();

    }

    public Project() {
        clear();
        display();
        choice();
    }

    public void display() {
        System.out.println("=== project menu ===");
        System.out.println("1. Create a project");
        System.out.println("2. List all projects");
        System.out.println("3. Get project by id");
        System.out.println("Enter your choice: ");

    }

    public void choice() {
        Service.Project project = new Service.Project();
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
                new Service.Project().list();
                break;
            default:
                new Menu();
                System.out.println("Invalid option");
        }
    }

    public void create() {
        Entitie.Client client = null;
        Ui.Client clientUi = new Ui.Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.search for client by name");
        System.out.println("2.create a new client");
        System.out.println("Choose an option:");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                List<Entitie.Client> clients = clientUi.searchByName();
                if (clients.isEmpty()) {
                    System.out.println("No client found");
                    return;
                } else {
                    System.out.println("enter client id: ");
                    client = Client.get(scanner.nextInt());
                }
                break;
            case 2:
                client = new Ui.Client().create();
                break;
            default:
                System.out.println("Invalid option");
        }

        System.out.println("Enter project name: ");
        String name = scanner.next();
        Entitie.Project tempProject = new Entitie.Project(0, name, 0, 0, ProjectStatus.IN_PROGRESS, client);
        Entitie.Project project = service.create(tempProject);
        System.out.println("do you want to add components? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            new Service.Project().addComponent(project);
        }
    }
}



