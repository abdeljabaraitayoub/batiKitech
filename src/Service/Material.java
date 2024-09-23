package Service;

import Entitie.Client;
import Enum.ProjectStatus;

import java.util.List;
import java.util.Scanner;

public class Material {

    public static void main(String[] args) {
        Material material = new Material();
        material.create(new Entitie.Project(1, "project", 0.00, 0.00, ProjectStatus.IN_PROGRESS, new Client(1, "client", "phone", "address", false)));
    }


    public void list() {
        new Repository.Material().list().ifPresent(materials -> {
            for (Entitie.Material material : materials) {
                System.out.println(material);
            }
        });
    }

    public Entitie.Material get(int id) {

        return new Repository.Material().get(id).orElse(null);

    }

    public void create(Entitie.Project project) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter material name: ");
        String name = scanner.next();
        System.out.println("Enter material price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter material quantity: ");
        int quantity = scanner.nextInt();
        System.out.println("Enter material transport cost: ");
        double transportCost = scanner.nextDouble();
        System.out.println("Enter material quality coefficient: ");
        double qualityCofficient = scanner.nextDouble();
        System.out.println();
        Entitie.Material material = new Entitie.Material(0, name, price, quantity, 0.00, transportCost, qualityCofficient, project);
        new Repository.Material().create(material);
    }

    public List<Entitie.Material> listByProject(Entitie.Project project) {
        List<Entitie.Material> materials = new Repository.Material().list().get().stream().filter(material -> material.getProject().getId() == project.getId()).toList();
        return materials;
    }

    public void delete(Entitie.Component material) {
        new Repository.Material().delete(material.getId());
    }
}
