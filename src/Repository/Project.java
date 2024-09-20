package Repository;

import Enum.ProjectStatus;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Project {
    private final Repository.Dao.Project projectDao = new Repository.Dao.Project();

    public static void main(String[] args) {
        Repository.Project project = new Repository.Project();
//        Entitie.Project project1 = new Entitie.Project(1, "Project 1", 0.1, 1000, ProjectStatus.IN_PROGRESS, new Entitie.Client(1, "John Doe", "123456789", "123 Main St", true));
//        project.create(project1);
//        System.out.println(project.get(1));
        System.out.println(project.get(2));
        Entitie.Project project2 = project.get(2).orElse(null);
        System.out.println(project2.getComponent());
//        project.update(1, new Entitie.Project(1, "Project 1", 0.1, 1000, ProjectStatus.IN_PROGRESS, new Entitie.Client(1, "John Doe", "123456789", "123 Main St", false)));
//        System.out.println(project.get(99).orElse(null));
//        project.delete(12);
//        System.out.print(project.list());

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
            projectDao.update(id, project);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public Optional<Entitie.Project> get(int id) {
        try (ResultSet data = projectDao.get(id).get()) {
            if (data.next()) {
                return Optional.ofNullable(Entitie.Project.mapResultSet(data));
            } else {
                return Optional.empty();
            }

        } catch (Exception e) {
            System.out.println(e);
            return Optional.empty();
        }
    }

    public void delete(int id) {
        try {
            projectDao.delete(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public Optional<ArrayList<Entitie.Project>> list() {
        ArrayList<Entitie.Project> projects = new ArrayList<>();
        try (ResultSet data = projectDao.list().get()) {
            while (data.next()) {
                projects.add(Entitie.Project.mapResultSet(data));
            }

        } catch (Exception e) {
            System.out.println(e);
            return Optional.empty();
        }
        return Optional.of(projects);
    }

}
