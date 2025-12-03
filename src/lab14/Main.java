package lab14;

import lab10.classes.abstracts.PriorityTask;
import lab10.classes.abstracts.Task;
import lab10.classes.ordinary.BugTask;
import lab10.classes.ordinary.FeatureTask;

public class Main {
    public static void main(String[] args) {

        //region создание объектов класса
        BugTask bug = new BugTask(
                "UI-Баг: Кнопка неактивна",
                "Кнопка 'Отправить' неактивна после заполнения формы.",
                "Иван Петров",
                "Высокий",
                "2023-10-25",
                "Критичный",
                "1. Открыть форму. 2. Заполнить поля. 3. Кнопка неактивна."
        );

        FeatureTask feature = new FeatureTask(
                "Темная тема",
                "Добавить переключатель темной темы.",
                "Елена Сидорова",
                "Средний",
                "2023-11-15",
                "Фронтенд",
                "Кнопка в настройках, сохранение выбора."
        );
        //endregion

        //region upcasting
        System.out.println("=== Восходящее приведение (upcasting) ===");
        Task task1 = bug;
        Task task2 = feature;
        PriorityTask pTask = bug;

        task1.displayTaskInfo();
        task2.displayTaskInfo();
        //endregion

        //region downcasting с instanceof
        System.out.println("\n=== Безопасное нисходящее приведение (downcasting с instanceof) ===");

        if (task1 instanceof BugTask) {
            BugTask castedBug = (BugTask) task1;
            System.out.println("Downcast успешен. Критичность бага: " + castedBug.getSeverity());
            castedBug.escalatePriority();
        }

        if (task2 instanceof FeatureTask) {
            FeatureTask castedFeature = (FeatureTask) task2;
            System.out.println("Downcast успешен. Область фичи: " + castedFeature.getFeatureArea());
            castedFeature.escalatePriority();
        }
        //endregion

        //region работа через полиморфизм и безопасное приведение
        System.out.println("\n=== Работа с массивом через полиморфизм и безопасное приведение ===");
        Task[] tasks = {bug, feature};

        for (Task t : tasks) {
            System.out.println("\nОбработка задачи ID = " + t.getId());

            System.out.println("Отчёт: " + t.generateReport().split("\n")[0]);

            if (t instanceof BugTask) {
                BugTask b = (BugTask) t;
                System.out.println("Тип: Баг, Критичность: " + b.getSeverity());
            } else if (t instanceof FeatureTask) {
                FeatureTask f = (FeatureTask) t;
                System.out.println("Тип: Фича, Область: " + f.getFeatureArea());
            }
        }
        //endregion
    }
}