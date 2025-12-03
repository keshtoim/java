package lab10.classes.ordinary;

import lab10.classes.abstracts.PriorityTask;

public class BugTask extends PriorityTask {
    private String severity;
    private String reproductionSteps;

    public BugTask(String name, String description, String assignedTo, String priority, String dueDate, String severity, String reproductionSteps) {
        super(name, description, assignedTo, priority, dueDate);
        this.severity = severity;
        this.reproductionSteps = reproductionSteps;
        this.status = "Открыт";
    }
    @Override
    public void displayTaskInfo() {
        super.displayTaskInfo();
        System.out.println("Тип задачи: Баг");
        System.out.println("Критичность: " + severity);
        System.out.println("Шаги воспроизведения: " + reproductionSteps);
    }

    @Override
    public void escalatePriority() {
        if (this.priority.equals("Низкий")) {
            setPriority("Средний");
            System.out.println("Приоритет бага " + id + " повышен до Среднего.");
        } else if (this.priority.equals("Средний")) {
            setPriority("Высокий");
            System.out.println("Приоритет бага " + id + " повышен до Высокого!");
        } else {
            System.out.println("Приоритет бага " + id + " уже Высокий или не может быть повышен.");
        }
    }
    @Override
    public String generateReport() {
        return "Отчет по багу (ID: " + id + "):\n" +
                "  Название: " + name + "\n" +
                "  Статус: " + status + "\n" +
                "  Исполнитель: " + assignedTo + "\n" +
                "  Приоритет: " + priority + "\n" +
                "  Критичность: " + severity + "\n" +
                "  Шаги воспроизведения: " + reproductionSteps + "\n" +
                "  Срок выполнения: " + dueDate;
    }

    //region get and set
    public String getSeverity() {
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public String getReproductionSteps() {
        return reproductionSteps;
    }
    public void setReproductionSteps(String reproductionSteps) {
        this.reproductionSteps = reproductionSteps;
    }
    //endregion
}
