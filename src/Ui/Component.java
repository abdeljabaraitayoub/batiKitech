package Ui;

import Entitie.Labor;
import Entitie.Material;

import java.util.Scanner;

public class Component extends Main {

    private final Service.Labor laborService = new Service.Labor();
    private final Service.Material materialService = new Service.Material();
    private final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        new Component().choice();
    }

    public void display() {
        clear();
        System.out.println("=== Component Menu ===");
        System.out.println("1. add a Component to a project");
        System.out.println("2. List all Components");
        System.out.println("3. Get Component by id");
        System.out.println("4. Get Component by project");
        System.out.println("5. Delete Component");
        System.out.println("Enter your choice: ");
    }

    @Override
    public void choice() {
        int option = 1;
        while (option != 0) {
            display();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    clear();
                    create(null);
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
                    listByProject(null);
                    pause();
                    break;
                case 5:
                    clear();
                    delete();
                    pause();
                    break;
            }
        }

    }

    public void list() {
        System.out.println("List of all components");
        System.out.println("1. List all materials");
        System.out.println("2. List all labor");
        System.out.println("Choose an option: ");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                materialService.list();
                break;
            case 2:
                laborService.list();
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    public void create(Entitie.Project project) {
        if (project == null) {
            project = new Project().get();
            if (project == null) {
                System.out.println("No project found");
                return;
            }
        }
        boolean addComponent = true;
        while (addComponent) {
            System.out.println("1.add material");
            System.out.println("2.add Labor");
            System.out.println("Choose an option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    materialService.create(project);
                    System.out.println("Do you want to add another component? (y/n): ");
                    addComponent = scanner.next().equalsIgnoreCase("y");
                    break;
                case 2:
                    laborService.create(project);
                    System.out.println("Do you want to add another component? (y/n): ");
                    addComponent = scanner.next().equalsIgnoreCase("y");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public void get() {
        System.out.println("Enter component id: ");
        int id = scanner.nextInt();
        Entitie.Component component = materialService.get(id) == null ? laborService.get(id) : materialService.get(id);
        if (component == null) {
            System.out.println("Component not found");
        } else {
            System.out.println(component);
        }

    }

    public void listByProject(Entitie.Project project) {
        if (project == null) {
            project = new Project().get();
            if (project == null) {
                System.out.println("No project found");
                return;
            }
        }
        clear();
        System.out.println("List of all components for project: " + project.getName());
        System.out.println(materialService.listByProject(project));
        System.out.println(laborService.listByProject(project));

    }

    public void delete() {

        System.out.println("Enter component id: ");
        int id = scanner.nextInt();
        Entitie.Component component = materialService.get(id) == null ? laborService.get(id) : materialService.get(id);
        if (component == null) {
            System.out.println("Component not found");
        } else {
            Material material = materialService.get(id);
            if (material != null) {
                materialService.delete(material);
            } else {
                Labor labor = laborService.get(id);
                laborService.delete(labor);
            }
        }
    }
}
