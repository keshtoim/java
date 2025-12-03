package lab13.interfaces;

public interface Trackable {
    void logProgress();
    String getCurrentStatus();

    default void notifyTeam() {
        System.out.println("Уведомление отправлено команде: задача обновлена.");
    }

    static String getSystemVersion() {
        return "Trackable v2.1";
    }
}