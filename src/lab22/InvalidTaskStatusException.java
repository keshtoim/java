package lab22;

class InvalidTaskStatusException extends Exception {
    private final String currentStatus;
    private final String newStatus;

    public InvalidTaskStatusException(String message, String currentStatus, String newStatus) {
        super(message);
        this.currentStatus = currentStatus;
        this.newStatus = newStatus;
    }

    @Override
    public String getMessage() {
        return super.getMessage() +
                " [Текущий статус: '" + currentStatus +
                "', Попытка изменить на: '" + newStatus + "']";
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }
}