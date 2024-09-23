package Ui;

import Repository.Client;

import Enum.ProjectStatus;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

public class Project extends Main {
    Service.Project service = new Service.Project();

    public static void main(String[] args) {
        new Project();

    }


    public void display() {
        clear();
        System.out.println("=== project menu ===");
        System.out.println("1. Create a project");
        System.out.println("2. List all projects");
        System.out.println("3. Get project by id");
        System.out.println("4. Get project by name");
        System.out.println("5. Get project by Client");
        System.out.println("6. Update a project");
        System.out.println("7. Delete a project");
        System.out.println("8. Mark as Completed");
        System.out.println("9. mark as Cancel");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");

    }

    public void choice() {
        display();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (true) {
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
                    get();
                    pause();
                    break;
                case 4:
                    clear();
                    getByName();
                    pause();
                    break;
                case 5:
                    clear();
                    getByClient();
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
                case 8:
                    clear();
                    markAsCompleted();
                    pause();
                    break;
                case 9:
                    clear();
                    markAsCancelled();
                    pause();
                    break;

                case 0:
                    new Menu().choice();
                default:
                    System.out.println("Invalid option");
            }
            display();
            option = scanner.nextInt();
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
                Optional<List<Entitie.Client>> clientsOptional = clientUi.searchByName();
                if (!clientsOptional.isEmpty()) {
                    List<Entitie.Client> clients = clientsOptional.get();
                    System.out.println("Enter client id: ");
                    client = Client.get(scanner.nextInt()).orElse(null);
                } else {
                    return;
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
        System.out.println("enter profit margin in percentage: ");
        double profitMargin = scanner.nextDouble();
        Entitie.Project tempProject = new Entitie.Project(0, name, profitMargin, 0, ProjectStatus.IN_PROGRESS, client);
        Entitie.Project project = service.create(tempProject);
        System.out.println("do you want to add components? (y/n): ");
        if (scanner.next().equalsIgnoreCase("y")) {
            new Component().create(project);
        }
        new Quote().create(project);
    }

    public void update() {
        Entitie.Project project = get();
        if (Objects.isNull(project)) {
            System.out.println("Project not found");
            return;
        }
        System.out.println("are you sure you want to update this project? (y/n): ");
        if (!new Scanner(System.in).next().equalsIgnoreCase("y")) {
            return;
        }
        System.out.println("Enter new project name: ");
        project.setName(new Scanner(System.in).next());
        System.out.println("Enter new profit margin: ");
        project.setProfitMargin(new Scanner(System.in).nextDouble());
        System.out.println("Enter new total cost: ");
        project.setProfitMargin(new Scanner(System.in).nextDouble());
        service.update(project);
    }

    public void delete() {
        Entitie.Project project = get();
        if (project == null) {
            System.out.println("Project not found");
            return;
        }
        System.out.println("are you sure you want to delete this project? (y/n): ");
        if (!new Scanner(System.in).next().equalsIgnoreCase("y")) {
            return;
        }
        service.delete(project);
    }

    public List<Entitie.Project> list() {
        List<Entitie.Project> projects = service.list();
        projects.forEach(System.out::println);
        return projects;
    }

    public Entitie.Project get() {
        System.out.println("enter project id: ");
        int id = new Scanner(System.in).nextInt();
        Entitie.Project project = service.get(id);
        System.out.println(project);
        return project;
    }

    public List<Entitie.Project> getByName() {
        System.out.println("enter project name: ");
        String name = new Scanner(System.in).next();
        List<Entitie.Project> projects = service.filterByName(name);
        System.out.println(projects);
        return projects;
    }

    public List<Entitie.Project> getByClient() {
        System.out.println("enter Client name: ");
        String name = new Scanner(System.in).next();
        List<Entitie.Project> projects = service.filterByClient(name);
        System.out.println(projects);
        return projects;
    }

    public void markAsCompleted() {
        Entitie.Project project = get();
        if (Objects.isNull(project)) {
            System.out.println("Project not found");
            return;
        }
        System.out.println("are you sure you want to mark this project as completed? (y/n): ");
        if (!new Scanner(System.in).next().equalsIgnoreCase("y")) {
            return;
        }
        System.out.println("Enter total cost: ");
        project.setTotalCost(new Scanner(System.in).nextDouble());
        project.setStatus(ProjectStatus.COMPLETED);
        service.update(project);
    }

    public void markAsCancelled() {
        Entitie.Project project = get();
        if (Objects.isNull(project)) {
            System.out.println("Project not found");
            return;
        }
        System.out.println("are you sure you want to mark this project as cancelled? (y/n): ");
        if (!new Scanner(System.in).next().equalsIgnoreCase("y")) {
            return;
        }
        project.setStatus(ProjectStatus.CANCELLED);
        service.update(project);
    }

}



