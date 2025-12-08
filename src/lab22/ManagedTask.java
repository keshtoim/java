package lab22;

import lab17.Task;
import lab17.TaskPriority;

class ManagedTask extends Task {
    public ManagedTask(String assignee, String status, TaskPriority priority) {
        super(assignee, status, priority);
    }

    public void changeStatus(String newStatus) throws InvalidTaskStatusException {
        String currentStatus = getStatus();

        if (currentStatus.equals("DONE") && !newStatus.equals("ARCHIVED")) {
            throw new InvalidTaskStatusException(
                    "Завершенную задачу можно только архивировать",
                    currentStatus, newStatus
            );
        }

        if (newStatus.equals("TODO") && currentStatus.equals("IN_PROGRESS")) {
            throw new InvalidTaskStatusException(
                    "Нельзя вернуть задачу в статус TODO из IN_PROGRESS",
                    currentStatus, newStatus
            );
        }

        if (newStatus.isEmpty() || newStatus.trim().isEmpty()) {
            throw new InvalidTaskStatusException(
                    "Статус задачи не может быть пустым",
                    currentStatus, newStatus
            );
        }

        System.out.println("Статус задачи изменен: " + currentStatus + " -> " + newStatus);
    }
}
