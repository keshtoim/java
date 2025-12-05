package lab18;

import lab17.Task;

public class Main {
    public static void main(String[] args) {
        //region создаём задачи из предыдущей работы
        Task task1 = new Task("Анна", "TODO", lab17.TaskPriority.LOW);
        Task task2 = new Task("Борис", "IN_PROGRESS", lab17.TaskPriority.MEDIUM);
        Task task3 = new Task("Виктор", "DONE", lab17.TaskPriority.HIGH);
        //endregion

        //region создание контейнера для Task
        GenericContainer<Task> container = new GenericContainer<>(task1);
        container.addItem(task2);
        container.addItem(task3);
        //endregion

        container.displayAll();

        //region получение задачу по индексу
        Task retrieved = container.getItem(1);
        System.out.println("\nПолученная задача по индексу 1: " + retrieved);
        //endregion

        System.out.println("Количество задач в контейнере: " + container.getSize());

        // GenericContainer<String> stringContainer = new GenericContainer<>("test");
    }
}