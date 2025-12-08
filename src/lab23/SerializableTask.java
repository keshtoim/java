package lab23;

import lab17.TaskPriority;

import java.io.Serial;

class SerializableTask implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 1543L;


    private String assignee;
    private String status;
    private int estimatedHours;
    private transient String secretNote;
    private TaskPriority priority;

    //region конструктор
    public SerializableTask(String assignee, String status, int estimatedHours, TaskPriority priority) {
        this.assignee = assignee;
        this.status = status;
        this.estimatedHours = estimatedHours;
        this.priority = priority;
        this.secretNote = "Временная заметка: " + assignee;
        System.out.println("Вызван конструктор SerializableTask для: " + assignee);
    }
    //endregion

    //region геттеры
    public String getAssignee() { return assignee; }
    public String getStatus() { return status; }
    public int getEstimatedHours() { return estimatedHours; }
    public TaskPriority getPriority() { return priority; }
    public String getSecretNote() { return secretNote; }
    //endregion

    @Override
    public String toString() {
        return String.format("SerializableTask{assignee='%s', status='%s', hours=%d, priority=%s, secretNote='%s'}",
                assignee, status, estimatedHours, priority, secretNote);
    }
}
