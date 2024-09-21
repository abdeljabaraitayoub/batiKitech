package Service;

import Entitie.Project;

import java.util.Scanner;

import Enum.ProjectStatus;

public class Labor {

    public static void main(String[] args) {
        Labor labor = new Labor();
        labor.create(new Project(1, "project", 0.00, 0.00, ProjectStatus.IN_PROGRESS, new Entitie.Client(1, "client", "phone", "address", false)));
    }

    public void create(Project project) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter labor name: ");
        String name = scanner.next();
        System.out.println("Enter labor hourly rate: ");
        double hourlyRate = scanner.nextDouble();
        System.out.println("Enter labor hours worked: ");
        double hoursWorked = scanner.nextDouble();
        System.out.println("Enter labor Productivity: ");
        double productivity = scanner.nextDouble();
        new Repository.Labor().create(new Entitie.Labor(0, name, 0.00, hourlyRate, hoursWorked, productivity, project));
    }
}
