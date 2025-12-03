package lab10.classes.abstracts;

public abstract class PriorityTask extends Task {
    protected String priority;
    protected String dueDate;

    public PriorityTask(String name, String description, String assignedTo, String priority, String dueDate) {
        super(name, description, assignedTo);
        this.priority = priority;
        this.dueDate = dueDate;
    }
    @Override
    public void displayTaskInfo() {
        super.displayTaskInfo();
        System.out.println("Приоритет: " + priority);
        System.out.println("Срок выполнения: " + dueDate);
    }
    public abstract void escalatePriority();

    @Override
    public void performTaskAction() {
        if (this.status.equals("Новая") || this.status.equals("В ожидании")) {
            updateStatus("В работе");
            System.out.println("Начата работа над задачей с приоритетом: " + this.priority);
        } else {
            System.out.println("Задача уже находится в работе или завершена.");
        }
    }


    //region get and set
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    //endregion
}
