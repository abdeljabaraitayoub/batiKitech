package Entitie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Material extends Component {
    private double transportCost;
    private double qualityCoefficient;

    public Material(int id, String name, double unitCost, int quantity, double vatRate, double transportCost, double qualityCoefficient, Project project) {
        this.id = id;
        this.name = name;
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.vatRate = vatRate;
        this.transportCost = transportCost;
        this.qualityCoefficient = qualityCoefficient;
        this.project = project;
    }

    public double getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(double transportCost) {
        this.transportCost = transportCost;
    }


    public double getQualityCoefficient() {
        return qualityCoefficient;
    }

    public void setQualityCoefficient(double qualityCoefficient) {
        this.qualityCoefficient = qualityCoefficient;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


    public double calculateTotalCost() {
        return this.unitCost * this.quantity + this.transportCost + this.qualityCoefficient;
    }


    public String toString() {
        String border = "=".repeat(50);
        return border + "\n" +
                "Material ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Unit Cost: " + unitCost + "\n" +
                "Quantity: " + quantity + "\n" +
                "VAT Rate: " + vatRate + "\n" +
                "Transport Cost: " + transportCost + "\n" +
                "Quality Coefficient: " + qualityCoefficient + "\n" +
                "project: " + project.getName() + "\n" +
                border;
    }


    public static Material mapResultSet(ResultSet resultSet) {
        try {

            return new Material(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("unitcost"),
                    resultSet.getInt("quantity"),
                    0,
                    resultSet.getDouble("transportcost"),
                    resultSet.getDouble("qualitycoefficient"),
                    new Repository.Project().get(resultSet.getInt("project_id")).orElse(null)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
