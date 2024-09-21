package Service;

import Repository.Client;
import Enum.ProjectStatus;
import Repository.Component;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Project {
    Repository.Project repository = new Repository.Project();

    public static void main(String[] args) {
        Project project = new Project();
//        project.create();
    }

    public void list() {
        repository.list().get().forEach(System.out::println);
    }

    public Entitie.Project create(Entitie.Project project) {
        repository.create(project);
        return last();
    }

    public void addComponent(Entitie.Project project) {
        boolean addComponent = true;
        while (addComponent) {
            System.out.println("1.add material");
            System.out.println("2.add Labor");
            System.out.println("Choose an option: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    new Material().create(project);
                    System.out.println("Do you want to add another component? (y/n): ");
                    addComponent = scanner.next().equalsIgnoreCase("y");
                    break;
                case 2:
                    new Labor().create(project);
                    System.out.println("Do you want to add another component? (y/n): ");
                    addComponent = scanner.next().equalsIgnoreCase("y");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public Entitie.Project last() {
        return repository.list().get().stream().max((t1, t2) -> t1.getId() - t2.getId()).orElse(null);
    }


    public void get() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter project id: ");
        int id = scanner.nextInt();
        System.out.println(repository.get(id).orElse(null));
    }

    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter project id: ");
        int id = scanner.nextInt();
        System.out.println("Enter project name: ");
        String name = scanner.next();
        System.out.println("Enter project cost: ");
        double cost = scanner.nextDouble();
        System.out.println("Enter project price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter project status: ");
        ProjectStatus status = ProjectStatus.valueOf(scanner.next().toUpperCase());
        System.out.println("Enter client id: ");
        int clientId = scanner.nextInt();
        Entitie.Client client = Client.get(clientId);
        Entitie.Project project = new Entitie.Project(id, name, cost, price, status, client);
        repository.update(id, project);
    }
}
