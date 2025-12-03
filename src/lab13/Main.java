package lab13;

import lab10.classes.abstracts.Task;
import lab13.classes.BugTaskForInterface;
import lab13.classes.FeatureTaskForInterface;
import lab13.interfaces.Trackable;

public class Main {
    public static void main(String[] args) {
        BugTaskForInterface bug = new BugTaskForInterface(
                "UI-Баг: Кнопка неактивна",
                "Кнопка 'Отправить' неактивна после заполнения формы.",
                "Иван Петров",
                "Средний",
                "2023-10-25",
                "Критичный",
                "1. Заполнить форму, 2. Не перезагружать"
        );

        FeatureTaskForInterface feature = new FeatureTaskForInterface(
                "Темная тема",
                "Добавить переключатель темной темы.",
                "Елена Сидорова",
                "Средний",
                "2023-11-15",
                "Фронтенд",
                "Сохранение выбора, стили для всех компонентов"
        );

        System.out.println("Всего задач: " + Task.getCreatedTasksCount());


        Task taskRef1 = bug;
        Task taskRef2 = feature;
        taskRef1.displayTaskInfo();
        System.out.println("Отчет (через Task): " + taskRef1.generateReport());

        bug.escalatePriority();
        bug.logProgress();

        Trackable trackableBug = bug;
        Trackable trackableFeature = feature;

        System.out.println("\n--- Через интерфейс Trackable ---");
        System.out.println(trackableBug.getCurrentStatus());
        trackableBug.notifyTeam();

        System.out.println(trackableFeature.getCurrentStatus());
        trackableFeature.notifyTeam();

        System.out.println("\nВерсия системы: " + Trackable.getSystemVersion());

        System.out.println("\n--- Полиморфизм через интерфейс ---");
        Trackable[] tasks = {bug, feature};
        for (Trackable t : tasks) {
            t.logProgress();
        }

        System.out.println("\nКонец программы. Всего задач: " + Task.getCreatedTasksCount());
    }
}