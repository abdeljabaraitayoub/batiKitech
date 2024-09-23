package Service;

import Entitie.Project;

import java.util.List;

public class Quote {
    private final Repository.Quote repository = new Repository.Quote();

    public void create(Entitie.Quote quote) {
        repository.create(quote);
    }

    public void update(int id, Entitie.Quote quote) {
        repository.update(id, quote);
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public List<Entitie.Quote> list() {
        return repository.list().orElse(null);
    }

    public Entitie.Quote get(int id) {
      
        return repository.get(id).orElse(null);
    }

    public List<Entitie.Quote> ListByProject(Project project) {
        return repository.listByProject(project.getId()).orElse(null);
    }


}
