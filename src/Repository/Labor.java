package Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Labor {

    private final Repository.Dao.Labor laborDao = new Repository.Dao.Labor();

    public static void main(String[] args) {
        Labor labor = new Labor();
//        System.out.println(labor.list().get());
//        System.out.println(labor.get(6).orElse(null));
        System.out.println(labor.ListByProject(2));

//        labor.create(labor.get(6).orElse(null));
//        labor.update(6, labor.get(7).orElse(null));

//        labor.delete(16);


    }


    public void create(Entitie.Labor labor) {
        laborDao.create(labor);
    }


    public void update(int id, Entitie.Labor labor) {
        laborDao.update(id, labor);
    }


    public void delete(int id) {
        laborDao.delete(id);
    }

    public Optional<List<Entitie.Labor>> list() {
        List<Entitie.Labor> labors = new ArrayList<>();
        try (ResultSet data = laborDao.list().orElse(null)) {
            while (data.next()) {
                labors.add(Entitie.Labor.mapResultSet(data));
            }
            return Optional.of(labors);
        } catch (Exception e) {
            System.out.println(e);
            return Optional.empty();
        }
    }


    public Optional<Entitie.Labor> get(int id) {
        try (ResultSet data = laborDao.get(id).orElse(null)) {
            if (data.next()) {
                return Optional.ofNullable(Entitie.Labor.mapResultSet(data));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return Optional.empty();
    }


    public Optional<List<Entitie.Labor>> ListByProject(int project_id) {
        return Optional.of(new Labor().list().get().stream().filter(labor -> labor.getProject() != null).filter(labor -> labor.getProject().getId() == project_id).toList());
    }


}
