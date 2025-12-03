package lab13.classes;

import lab10.classes.abstracts.PriorityTask;
import lab13.interfaces.Trackable;

public class BugTaskForInterface extends PriorityTask implements Trackable {
    private String severity;
    private String reproductionSteps;

    public BugTaskForInterface(String name, String description, String assignedTo,
                               String priority, String dueDate, String severity, String reproductionSteps) {
        super(name, description, assignedTo, priority, dueDate);
        this.severity = severity;
        this.reproductionSteps = reproductionSteps;
        this.status = "Открыт";
    }

    @Override
    public void displayTaskInfo() {
        super.displayTaskInfo();
        System.out.println("Тип задачи: Баг (с интерфейсом Trackable)");
        System.out.println("Критичность: " + severity);
        System.out.println("Шаги воспроизведения: " + reproductionSteps);
    }

    @Override
    public void escalatePriority() {
        if ("Низкий".equals(priority)) {
            setPriority("Средний");
            System.out.println("Приоритет бага " + id + " повышен до Среднего.");
        } else if ("Средний".equals(priority)) {
            setPriority("Высокий");
            System.out.println("Приоритет бага " + id + " повышен до Высокого!");
        } else {
            System.out.println("Приоритет бага " + id + " уже максимален.");
        }
    }

    @Override
    public String generateReport() {
        return "Отчет по багу (ID: " + id + "):\n" +
                "  Название: " + name + "\n" +
                "  Статус: " + status + "\n" +
                "  Приоритет: " + priority + "\n" +
                "  Критичность: " + severity;
    }

    @Override
    public void logProgress() {
        System.out.println("[BUG] Прогресс по багу ID=" + id + ": статус = " + status + ", приоритет = " + priority);
    }

    @Override
    public String getCurrentStatus() {
        return "Баг ID =" + id + " | Статус: " + status + " | Приоритет: " + priority;
    }

    @Override
    public void notifyTeam() {
        System.out.println("Срочное уведомление по багу ID =" + id + " отправлено!");
    }

    public String getSeverity() {
        return severity;
    }

    public String getReproductionSteps() {
        return reproductionSteps;
    }
}

