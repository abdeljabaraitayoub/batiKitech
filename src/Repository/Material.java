package Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Optional;

public class Material {
    Repository.Dao.Material materialDao = new Repository.Dao.Material();

    public static void main(String[] args) {
        Repository.Material material = new Repository.Material();
//        System.out.println(material.list().get());
//        material.get(9);
//        material.create(new Entitie.Material(1, "Material", 10, 100, 1, 1, 1, new Entitie.Project(1, "Project 1", 0.1, 1000, ProjectStatus.IN_PROGRESS, new Entitie.Client(1, "John Doe", "123456789", "123 Main St", true))));
        material.delete(11);
    }


    public Optional<ArrayList<Entitie.Material>> list() {
        ArrayList<Entitie.Material> materials = new ArrayList<>();
        try (ResultSet data = materialDao.list().orElse(null)) {
            while (data.next()) {
                materials.add(Entitie.Material.mapResultSet(data));
            }
            return Optional.of(materials);
        } catch (Exception e) {
            System.out.println(e);
            return Optional.empty();
        }
    }

    public Optional<Entitie.Material> get(int id) {
        Entitie.Material material = null;
        try (ResultSet data = materialDao.get(id).get()) {
            if (data.next()) {
                return Optional.ofNullable(Entitie.Material.mapResultSet(data));
            } else {
                System.out.println("Material not found.");
                return Optional.empty();
            }

        } catch (Exception e) {
            System.out.println(e);
            return Optional.empty();
        }
    }


    public void create(Entitie.Material material) {
        try {
            materialDao.create(material);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(Entitie.Material material) {
        try {
            materialDao.update(material.getId(), material);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void delete(int id) {
        try {
            materialDao.delete(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
