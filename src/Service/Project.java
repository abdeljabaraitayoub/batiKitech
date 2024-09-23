package Service;

import Repository.Client;
import Enum.ProjectStatus;
import Repository.Component;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Project {
    Repository.Project repository = new Repository.Project();

    public static void main(String[] args) {
        Project project = new Project();
//        project.create();
    }


    public List<Entitie.Project> list() {
        return repository.list().get();
    }

    public Entitie.Project create(Entitie.Project project) {
        repository.create(project);
        return last();
    }

    public Entitie.Project update(Entitie.Project project) {
        repository.update(project.getId(), project);
        return project;
    }

    public void delete(Entitie.Project project) {
        repository.delete(project.getId());
    }


    public Entitie.Project last() {
        return repository.list().get().stream().max((t1, t2) -> t1.getId() - t2.getId()).orElse(null);
    }


    public Entitie.Project get(int id) {
        return repository.get(id).orElse(null);
    }

    public List<Entitie.Project> filterByClient(String name) {
        return repository.filterByClient(new Service.Client().searchByName(name).getFirst().getId());
    }

    public List<Entitie.Project> filterByName(String name) {
        return repository.filterByName(name);
    }

}
