package Repository.Dao;

import Database.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Project extends Dao {

    public void create(Entitie.Project project) {
        String sql = "INSERT INTO projects (name, profitMargin, totalCost, status, client_id) VALUES (?, ?, ?, CAST(? AS projectStatus), ?)";
        String status = project.getStatus().toString();
        try {
            int rowsAffected = database.executeUpdate(sql,
                    project.getName(),
                    project.getProfitMargin(),
                    project.getTotalCost(),
                    project.getStatus().toString(),
                    project.getClient().getId()
            );
            if (rowsAffected > 0) {
                System.out.println("Project inserted successfully.");
            } else {
                System.out.println("Failed to insert project.");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting project: " + e.getMessage());
        }
    }


    public void update(int id, Entitie.Project project) {
        String sql = "UPDATE projects SET name = ?, profitMargin = ?, totalCost = ?, status = CAST(? AS projectStatus), client_id = ? WHERE id = ?";
        try {
            int rowsAffected = database.executeUpdate(sql,
                    project.getName(),
                    project.getProfitMargin(),
                    project.getTotalCost(),
                    project.getStatus().toString(),
                    project.getClient().getId(),
                    id
            );
            if (rowsAffected > 0) {
                System.out.println("Project updated successfully.");
            } else {
                System.out.println("Failed to update project.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating project: " + e.getMessage());
        }
    }


    public void delete(int id) {
        String sql = "DELETE FROM projects WHERE id = ?";
        try {
            int rowsAffected = database.executeUpdate(sql, id);
            if (rowsAffected > 0) {
                System.out.println("Project deleted successfully.");
            } else {
                System.out.println("Failed to delete project.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting project: " + e.getMessage());
        }
    }


    public Entitie.Project get(int id) {
        String sql = "SELECT clients.name as client_name,* FROM projects join clients on clients.id = projects.client_id WHERE projects.id = '" + id + "'";
        try {
            var resultSet = Database.executeQuery(sql);
            if (resultSet.next()) {
                return Entitie.Project.mapResultSet(resultSet);
            } else {
                System.out.println("Project not found.");
                return null;
            }
        } catch (SQLException e) {
            System.err.println("Error getting project: " + e.getMessage());
            return null;
        }
    }

    public ResultSet list() {
        String sql = "SELECT clients.name as client_name,* FROM projects join clients on clients.id = projects.client_id";
        try {
            return Database.executeQuery(sql);
        } catch (SQLException e) {
            System.err.println("Error listing projects: " + e.getMessage());
            return null;
        }
    }


}