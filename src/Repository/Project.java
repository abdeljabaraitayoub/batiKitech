package Repository;

import Enum.ProjectStatus;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
    private final Repository.Dao.Project projectDao = new Repository.Dao.Project();

    public static void main(String[] args) {
        Repository.Project project = new Repository.Project();
//        Entitie.Project project1 = new Entitie.Project(1, "Project 1", 0.1, 1000, ProjectStatus.IN_PROGRESS, new Entitie.Client(1, "John Doe", "123456789", "123 Main St", true));
//        project.create(project1);
        System.out.println(project.get(188));
//        System.out.println(project.get(2));
//        project.update(1, new Entitie.Project(1, "Project 1", 0.1, 1000, ProjectStatus.IN_PROGRESS, new Entitie.Client(1, "John Doe", "123456789", "123 Main St", false)));
//        System.out.println(project.get(1));
//        System.out.print(project.list());
//        project.delete(7);
    }

    public void create(Entitie.Project project) {
        try {
            projectDao.create(project);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(int id, Entitie.Project project) {
        try {
//            projectDao.update(id, project);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public Entitie.Project get(int id) {
        try {
            return projectDao.get(id).orElse(null);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void delete(int id) {
        try {
            projectDao.delete(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public ArrayList<Entitie.Project> list() {
        ArrayList<Entitie.Project> projects = new ArrayList<>();
        try (ResultSet data = projectDao.list()) {
            while (data.next()) {
                projects.add(Entitie.Project.mapResultSet(data));
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return projects;
    }

}
