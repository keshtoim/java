package lab10.classes.abstracts;

public abstract class Task {
    private static int nextId = 1;
    protected int id;
    protected String name;
    protected String description;
    protected String status;
    protected String assignedTo;

    public Task(String name, String description, String assignedTo) {
        this.id = nextId++;
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
        this.status = "Новая";
    }
    public void displayTaskInfo() {
        System.out.println("--- Информация о задаче (ID: " + id + ") ---");
        System.out.println("Название: " + name);
        System.out.println("Описание: " + description);
        System.out.println("Статус: " + status);
        System.out.println("Исполнитель: " + assignedTo);
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        System.out.println("Статус задачи " + id + " обновлен на: " + newStatus);
    }

    public abstract void performTaskAction();
    public abstract String generateReport();

    public static int getCreatedTasksCount() {
        return nextId - 1;
    }

    //region get and set
    public int getId() { return id; }
    public String getName() { return name; }
    public String getStatus() { return status; }
    public String getAssignedTo() { return assignedTo; }

    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setAssignedTo(String assignedTo) { this.assignedTo = assignedTo; }
    //endregion
    }
