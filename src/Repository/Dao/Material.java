package Repository.Dao;

import Database.Database;

import java.sql.ResultSet;
import java.util.Optional;

import Enum.ProjectStatus;

public class Material extends Dao {


    public static void main(String[] args) {
        Material material = new Material();
//        System.out.println(material.list().get());
//        System.out.println(material.get(9));
//        material.create(new Entitie.Material(1, "Material", 10, 100, 1, 1, 1, new Entitie.Project(1, "Project 1", 0.1, 1000, ProjectStatus.IN_PROGRESS, new Entitie.Client(1, "John Doe", "123456789", "123 Main St", true))));
//        material.delete(12);
//        material.update(13, new Entitie.Material(13, "Material", 10, 1000, 1, 1, 1, new Entitie.Project(1, "Project 1", 0.1, 1000, ProjectStatus.IN_PROGRESS, new Entitie.Client(1, "John Doe", "123456789", "123 Main St", true))));
    }

    public Optional<ResultSet> list() {
        String sql = "SELECT * FROM materials where false";
        try {
            return Optional.of(Database.executeQuery(sql));
        } catch (Exception e) {
            System.out.println(e);
            return Optional.empty();
        }
    }

    public Optional<ResultSet> get(int id) {
        String sql = "SELECT * FROM materials WHERE id = '" + id + "'";
        try {
            ResultSet data = Database.executeQuery(sql);
            return Optional.ofNullable(data);
        } catch (Exception e) {
            System.out.println(e);
            return Optional.empty();
        }
    }


    public void create(Entitie.Material material) {
        String sql = "INSERT INTO materials (name, unitcost,quantity,type,project_id,transportcost,qualitycoefficient) VALUES (?, ?, ?, CAST(? AS componenttype), ?, ?, ?)";
        try {
            int rowsAffected = database.executeUpdate(sql, material.getName(), material.getUnitCost(), material.getQuantity(), "Material", material.getProject().getId(), material.getTransportCost(), material.getQualityCoefficient());
            if (rowsAffected > 0) {
                System.out.println("Material created successfully.");
            } else {
                System.out.println("Failed to create material.");
            }
        } catch (Exception e) {
            System.err.println("Error creating material: " + e.getMessage());
        }
    }


    public void update(int id, Entitie.Material material) {
        String sql = "UPDATE materials SET name = ?, unitcost = ?, quantity = ?, type = CAST(? AS componenttype), project_id = ?, transportcost = ?, qualitycoefficient = ? WHERE id = ?";
        try {
            int rowsAffected = database.executeUpdate(sql, material.getName(), material.getUnitCost(), material.getQuantity(), "Material", material.getProject().getId(), material.getTransportCost(), material.getQualityCoefficient(), id);
            if (rowsAffected > 0) {
                System.out.println("Material updated successfully.");
            } else {
                System.out.println("Failed to update material.");
            }
        } catch (Exception e) {
            System.err.println("Error updating material: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM materials WHERE id = ?";
        try {
            int rowsAffected = database.executeUpdate(sql, id);
            if (rowsAffected > 0) {
                System.out.println("Material deleted successfully.");
            } else {
                System.out.println("Failed to delete material.");
            }
        } catch (Exception e) {
            System.err.println("Error deleting material: " + e.getMessage());
        }
    }


}
