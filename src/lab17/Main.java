package lab17;

public class Main {
    public static void main(String[] args) {
        //region создание задач
        Task task1 = new Task("Анна", "TODO", TaskPriority.LOW);
        Task task2 = new Task("Борис", "IN_PROGRESS", TaskPriority.MEDIUM);
        Task task3 = new Task("Виктор", "TODO", TaskPriority.HIGH);
        //endregion

        //region выводим начальное состояние
        System.out.println("Исходные задачи:");
        System.out.println(task1);
        System.out.println(task2);
        System.out.println(task3);
        //endregion

        //region меняем приоритет у первой задачи
        System.out.println("\nИзменяем приоритет задачи Анны на HIGH...");
        task1.setPriority(TaskPriority.HIGH);
        //endregion

        //region выводим обновлённое состояние
        System.out.println("\nПосле изменения:");
        System.out.println(task1);
        System.out.println(task2);
        System.out.println(task3);
        //endregion
    }
}