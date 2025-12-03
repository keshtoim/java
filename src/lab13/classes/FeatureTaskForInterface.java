package lab13.classes;

import lab10.classes.abstracts.PriorityTask;
import lab13.interfaces.Trackable;

public class FeatureTaskForInterface extends PriorityTask implements Trackable {
    private String featureArea;
    private String acceptanceCriteria;

    public FeatureTaskForInterface(String name, String description, String assignedTo,
                                   String priority, String dueDate, String featureArea, String acceptanceCriteria) {
        super(name, description, assignedTo, priority, dueDate);
        this.featureArea = featureArea;
        this.acceptanceCriteria = acceptanceCriteria;
        this.status = "Ожидает разработки";
    }

    @Override
    public void displayTaskInfo() {
        super.displayTaskInfo();
        System.out.println("Тип задачи: Функционал (с интерфейсом Trackable)");
        System.out.println("Область функционала: " + featureArea);
        System.out.println("Критерии приемки: " + acceptanceCriteria);
    }

    @Override
    public void escalatePriority() {
        System.out.println("ℹ️ Эскалация функционала требует ручного вмешательства.");
    }

    @Override
    public String generateReport() {
        return "Отчет по функционалу (ID: " + id + "):\n" +
                "  Название: " + name + "\n" +
                "  Статус: " + status + "\n" +
                "  Приоритет: " + priority + "\n" +
                "  Область: " + featureArea;
    }

    // Реализация Trackable
    @Override
    public void logProgress() {
        System.out.println("[FEAT] Прогресс по функционалу ID =" + id + ": статус = " + status);
    }

    @Override
    public String getCurrentStatus() {
        return "Фича ID =" + id + " | Статус: " + status + " | Приоритет: " + priority;
    }


    public String getFeatureArea() { return featureArea; }
    public String getAcceptanceCriteria() { return acceptanceCriteria; }
}