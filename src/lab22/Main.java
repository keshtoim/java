package lab22;

import lab17.TaskPriority;

public class Main {
    public static void main(String[] args) {
        //region демонстрация работы собственного исключения
        System.out.println("=== Демонстрация работы собственного исключения ===\n");

        ManagedTask task1 = new ManagedTask("Анна", "DONE", TaskPriority.HIGH);
        ManagedTask task2 = new ManagedTask("Борис", "IN_PROGRESS", TaskPriority.MEDIUM);
        ManagedTask task3 = new ManagedTask("Виктор", "TODO", TaskPriority.LOW);

        ManagedTask[] tasks = {task1, task2, task3};
        String[] newStatuses = {"IN_PROGRESS", "TODO", "IN_PROGRESS"};
        //endregion

        //region обработка смены статусов с использованием try-catch
        for (int i = 0; i < tasks.length; i++) {
            ManagedTask task = tasks[i];
            String newStatus = newStatuses[i];

            System.out.println("\nПопытка изменить статус задачи " + (i + 1) + ":");
            System.out.println("Исполнитель: " + task.getAssignee());
            System.out.println("Текущий статус: " + task.getStatus());
            System.out.println("Новый статус: " + newStatus);

            try {
                task.changeStatus(newStatus);
                System.out.println("Успешно!");

            } catch (InvalidTaskStatusException e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("Детали: текущий статус = '" + e.getCurrentStatus() +
                        "', новый статус = '" + e.getNewStatus() + "'");

            } catch (Exception e) {
                System.out.println("Неизвестная ошибка: " + e.getMessage());
            }
        }
        //endregion

        //region демонстрация выбрасывания исключения вручную
        System.out.println("\n=== Демонстрация throw vs throws ===\n");

        try {
            ManagedTask invalidTask = new ManagedTask("", "TODO", TaskPriority.LOW);
            validateTask(invalidTask);

        } catch (InvalidTaskStatusException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }
        //endregion

    }
    //region метод, объявляющий исключение с throws
    private static void validateTask(ManagedTask task) throws InvalidTaskStatusException {
        if (task.getAssignee() == null || task.getAssignee().trim().isEmpty()) {
            // Выбрасываем исключение вручную с помощью throw
            throw new InvalidTaskStatusException(
                    "Исполнитель задачи не может быть пустым",
                    task.getStatus(),
                    task.getStatus()
            );
        }

        if (task.getPriority() == null) {
            throw new InvalidTaskStatusException(
                    "Приоритет задачи не может быть null",
                    task.getStatus(),
                    task.getStatus()
            );
        }

        System.out.println("Задача прошла валидацию: " + task.getAssignee());
    }
    //endregion
}