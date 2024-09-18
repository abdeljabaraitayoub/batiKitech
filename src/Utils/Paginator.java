package Utils;

import java.util.ArrayList;

public class Paginator {


    public static ArrayList<?> paginate(ArrayList<?> list, int page, int limit) {
        int start = (page - 1) * limit;
        int end = Math.min(start + limit, list.size());
        return new ArrayList<>(list.subList(start, end));
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        System.out.println(Paginator.paginate(list, 1, 5));
    }
}
