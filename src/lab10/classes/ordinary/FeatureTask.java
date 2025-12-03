package lab10.classes.ordinary;

import lab10.classes.abstracts.PriorityTask;

public class FeatureTask extends PriorityTask {
    private String featureArea;
    private String acceptanceCriteria;

    public FeatureTask(String name, String description, String assignedTo, String priority, String dueDate, String featureArea, String acceptanceCriteria) {
        super(name, description, assignedTo, priority, dueDate);
        this.featureArea = featureArea;
        this.acceptanceCriteria = acceptanceCriteria;
        this.status = "Ожидает разработки";
    }

    @Override
    public void displayTaskInfo() {
        super.displayTaskInfo();
        System.out.println("Тип задачи: Функционал");
        System.out.println("Область функционала: " + featureArea);
        System.out.println("Критерии приемки: " + acceptanceCriteria);
    }

    @Override
    public void escalatePriority() {
        System.out.println("Эскалация приоритета для функционала обычно не применяется автоматически. Требуется ручная оценка.");
    }

    @Override
    public String generateReport() {
        return "Отчет по функционалу (ID: " + id + "):\n" +
                "  Название: " + name + "\n" +
                "  Статус: " + status + "\n" +
                "  Исполнитель: " + assignedTo + "\n" +
                "  Приоритет: " + priority + "\n" +
                "  Срок выполнения: " + dueDate + "\n" +
                "  Область: " + featureArea + "\n" +
                "  Критерии: " + acceptanceCriteria;
    }

    //region get and set
    public String getFeatureArea() {
            return featureArea;
    }
    public void setFeatureArea(String featureArea) {
            this.featureArea = featureArea;
        }
    public String getAcceptanceCriteria() {
            return acceptanceCriteria;
    }
    public void setAcceptanceCriteria(String acceptanceCriteria) {
            this.acceptanceCriteria = acceptanceCriteria;
    }
    //endregion
}
