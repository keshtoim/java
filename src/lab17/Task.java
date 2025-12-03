package lab17;

public class Task {
    private String assignee; // исполнитель
    private String status;   // например: "TODO", "IN_PROGRESS", "DONE"
    private TaskPriority priority;

    public Task(String assignee, String status, TaskPriority priority) {
        this.assignee = assignee;
        this.status = status;
        this.priority = priority;
    }

    public void setPriority(TaskPriority newPriority) {
        if (this.priority.canChangeTo(newPriority)) {
            this.priority = newPriority;
        } else {
            System.out.println("Недопустимая смена приоритета для задачи: " + this);
        }
    }

    // Геттеры
    public String getAssignee() { return assignee; }
    public String getStatus() { return status; }
    public TaskPriority getPriority() { return priority; }

    @Override
    public String toString() {
        return String.format("Task{assignee='%s', status='%s', priority=%s (%s)}",
                assignee, status, priority.name(), priority.getDescription());
    }
}