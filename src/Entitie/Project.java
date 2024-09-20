package Entitie;

import Enum.ProjectStatus;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import Enum.ComponentType;
import Repository.Component;

public class Project {

    private int id;
    public String name;
    private double profitMargin;
    private double totalCost;
    private ProjectStatus status;
    private Client client;
    private Map<ComponentType, List<?>> component;

    public Project(int id, String name, double profitMargin, double totalCost, ProjectStatus status, Client client) {
        this.id = id;
        this.name = name;
        this.profitMargin = profitMargin;
        this.totalCost = totalCost;
        this.status = status;
        this.client = client;
        this.component = null;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(double profitMargin) {
        this.profitMargin = profitMargin;
    }


    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }


    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Map<ComponentType, List<?>> getComponent() {
        return Component.ListByProject(id);
    }

    public void setComponent(Map<ComponentType, List<?>> component) {
        this.component = component;
    }

    public static Project mapResultSet(ResultSet data) {
        try {
            return new Project(
                    data.getInt("id"),
                    data.getString("name"),
                    data.getDouble("profitMargin"),
                    data.getDouble("totalCost"),
                    ProjectStatus.valueOf(data.getString("status")),
                    Repository.Client.get(data.getInt("client_id")));
        } catch (SQLException e) {
            System.err.println("Error mapping project: " + e.getMessage());
            return null;
        }
    }

    public String toString() {
        String border = "=".repeat(50);
        Component.ListByProject(id);
        return border + "\n" +
                "Project: " + name + "\n" +
                "Status: " + status + "\n" +
                "Profit Margin: " + profitMargin * 100 + "%\n" +
                "Total Cost: " + totalCost + "€\n" +
                "Client: " + (client != null ? client.getName() : "Not assigned") + "\n" +
                "components:" + Component.ListByProject(id) + "\n" +
                border;
    }


}
