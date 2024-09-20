package Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Enum.ComponentType;

public class Component {

    public static void main(String[] args) {
        System.out.println(Component.List());
        System.out.println(Component.ListByProject(2));
    }


    public static Map<ComponentType, List<?>> List() {
        Map<ComponentType, List<?>> components = new HashMap<>();
        components.put(ComponentType.LABOR, new Labor().list().get());
        components.put(ComponentType.MATERIAL, new Material().list().get());
        return components;
    }

    public static Map<ComponentType, List<?>> ListByProject(int id) {
        Map<ComponentType, List<?>> components = new HashMap<>();
        components.put(ComponentType.LABOR, new Labor().ListByProject(id).get());
        components.put(ComponentType.MATERIAL, new Material().ListByProject(id).get());
        return components;
    }
}
