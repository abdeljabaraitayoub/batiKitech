package Entitie;

import Enum.ComponentType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Labor extends Component {
    private double hourlyRate;
    private double hoursWorked;
    private double workerProductivity;

    public static void main(String[] args) {
        Labor labor = new Labor(1, "Labor", 100, 1, ComponentType.LABOR, 0.2, 10, 10, 0.5, new Repository.Project().get(1).get());
        System.out.println(labor);
    }

    public Labor(int id, String name, double unitCost, int quantity, ComponentType type, Double vatRate, double hourlyRate, double hoursWorked, double workerProductivity, Project project) {
        this.id = id;
        this.name = name;
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.type = type;
        this.vatRate = vatRate;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.workerProductivity = workerProductivity;
        this.project = project;

    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getWorkerProductivity() {
        return workerProductivity;
    }

    public void setWorkerProductivity(double workerProductivity) {
        this.workerProductivity = workerProductivity;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public static Labor mapResultSet(ResultSet resultSet) {
        try {
            return new Labor(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("unitcost"),
                    resultSet.getInt("quantity"),
                    ComponentType.valueOf("LABOR"),
                    0.00,
                    resultSet.getDouble("hourlyrate"),
                    resultSet.getDouble("hoursworked"),
                    resultSet.getDouble("workerproductivity"),
                    new Repository.Project().get(resultSet.getInt("project_id")).orElse(null));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String toString() {
        String border = "=".repeat(50);
        return border + "\n" +
                "Labor ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Unit Cost: " + unitCost + "\n" +
                "Quantity: " + quantity + "\n" +
                "VAT Rate: " + vatRate + "\n" +
                "Hourly Rate: " + hourlyRate + "\n" +
                "Hours Worked: " + hoursWorked + "\n" +
                "Worker Productivity: " + workerProductivity + "\n" +
                "Project: " + (project != null && project.getName() != null ? project.getName() : "not assigned") + "\n" +
                border;
    }


    public double calculateTotalCost() {
        return this.unitCost * this.quantity + this.hourlyRate * this.hoursWorked * this.workerProductivity;
    }


}
