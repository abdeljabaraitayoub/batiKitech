package Repository.Dao;

import Database.Database;
import Enum.ComponentType;
import Enum.ProjectStatus;

import java.sql.ResultSet;
import java.util.Optional;

public class Labor extends Dao {
    public static void main(String[] args) {
        Repository.Dao.Labor labor = new Repository.Dao.Labor();
        Entitie.Labor labor1 = new Entitie.Labor(1, "Labor", 0.1, 10, 10, 1, new Entitie.Project(1, "Project 1", 0.1, 1000, ProjectStatus.IN_PROGRESS, new Entitie.Client(1, "John Doe", "123456789", "123 Main St", true)));
//        labor.create(labor1);
//        System.out.println(labor.list().get());
//        System.out.println(labor.get(1).get());

    }

    public void create(Entitie.Labor labor) {
        String query = "INSERT INTO labors (name, type,  hourlyrate, hoursworked, workerproductivity,project_id) VALUES (?, CAST(? AS componenttype), ?, ?, ?, ?)";
        try {
            int rowsAffected = database.executeUpdate(query, labor.getName(), "Labor", labor.getHourlyRate(), labor.getHoursWorked(), labor.getWorkerProductivity(), labor.getProject().getId());
            if (rowsAffected > 0) {
                System.out.println("Labor created successfully.");
            } else {
                System.out.println("Failed to create labor.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Optional<ResultSet> list() {
        String sql = "SELECT * FROM labors";
        try {
            return Optional.of(Database.executeQuery(sql));
        } catch (Exception e) {
            System.out.println(e);
            return Optional.empty();
        }
    }

    public Optional<ResultSet> get(int id) {
        String sql = "SELECT * FROM labors WHERE id = '" + id + "'";
        try {
            ResultSet data = Database.executeQuery(sql);
            return Optional.ofNullable(data);
        } catch (Exception e) {
            System.out.println(e);
            return Optional.empty();
        }
    }

    public void update(int id, Entitie.Labor labor) {
        String sql = "UPDATE labors SET name = ?, type = CAST(? AS componenttype), hourlyrate = ?, hoursworked = ?, workerproductivity = ?, project_id = ? WHERE id = ?";
        try {
            int rowsAffected = database.executeUpdate(sql, labor.getName(), "Labor", labor.getHourlyRate(), labor.getHoursWorked(), labor.getWorkerProductivity(), labor.getProject().getId(), id);
            if (rowsAffected > 0) {
                System.out.println("Labor updated successfully.");
            } else {
                System.out.println("Failed to update labor.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM labors WHERE id = ?";
        try {
            int rowsAffected = database.executeUpdate(sql, id);
            if (rowsAffected > 0) {
                System.out.println("Labor deleted successfully.");
            } else {
                System.out.println("Failed to delete labor.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
