package lab17;

public enum TaskPriority {
    LOW(1, "Низкий приоритет"),
    MEDIUM(2, "Средний приоритет"),
    HIGH(3, "Высокий приоритет");

    private final int id;
    private final String description;

    TaskPriority(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    // Метод с логикой: проверяет, можно ли повысить приоритет
    public boolean canBeUpgradedTo(TaskPriority newPriority) {
        return newPriority.id > this.id;
    }

    // Метод с логикой: проверяет, можно ли понизить приоритет
    public boolean canBeDowngradedTo(TaskPriority newPriority) {
        return newPriority.id < this.id;
    }

    // Универсальный метод проверки допустимости смены приоритета
    public boolean canChangeTo(TaskPriority newPriority) {
        // В простом случае разрешаем любое изменение
        // Но можно добавить бизнес-правило: например, нельзя из LOW сразу в HIGH без подтверждения
        return true;
    }
}
