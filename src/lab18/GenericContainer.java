package lab18;

import lab17.Task;
import java.util.ArrayList;

public class GenericContainer<T extends Task> {
    private ArrayList<T> items;

    public GenericContainer(T item) {
        items = new ArrayList<>();
        items.add(item);
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public void displayAll() {
        System.out.println("Содержимое контейнера:");
        for (T item : items) {
            System.out.println(item);
        }
    }

    public int getSize() {
        return items.size();
    }
}
