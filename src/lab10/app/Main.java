package lab10.app;

import lab10.classes.abstracts.Task;
import lab10.classes.ordinary.BugTask;
import lab10.classes.ordinary.FeatureTask;

public class Main {
    public static void main(String[] args) {

        //region создание объектов классов
        BugTask bug1 = new BugTask(
                "UI-Баг: Кнопка неактивна при определенных условиях",
                "Кнопка 'Отправить' остается серой после заполнения формы без перезагрузки страницы.",
                "Иван Петров",
                "Высокий",
                "2023-10-25",
                "Критичный",
                "1. Открыть форму. 2. Заполнить все поля. 3. Не перезагружать. 4. Кнопка неактивна."
        );

        FeatureTask feature1 = new FeatureTask(
                "Реализовать темную тему для интерфейса",
                "Добавить опцию переключения на темную тему в настройках пользователя.",
                "Елена Сидорова",
                "Средний",
                "2023-11-15",
                "Фронтенд",
                "Должна быть кнопка в профиле, сохранение выбора, все элементы стилизованы."
        );
        //endregion

        System.out.println("\nВсего создано задач: " + Task.getCreatedTasksCount());

        bug1.displayTaskInfo();
        bug1.performTaskAction();
        bug1.updateStatus("В тестировании");
        bug1.escalatePriority();
        bug1.displayTaskInfo();
        System.out.println("Отчет по багу:\n" + bug1.generateReport());

        System.out.println("\n--- Работа с FeatureTask ---");
        feature1.displayTaskInfo();
        feature1.performTaskAction();
        feature1.updateStatus("На ревью");
        feature1.escalatePriority();
        feature1.displayTaskInfo();
        System.out.println("Отчет по функционалу:\n" + feature1.generateReport());

        System.out.println("\n--- Полиморфизм ---");

        Task genericTask1 = bug1;
        Task genericTask2 = feature1;

        System.out.println("\nИспользование ссылки на BugTask:");
        genericTask1.displayTaskInfo();
        System.out.println("Отчет: " + genericTask1.generateReport());

         genericTask2.displayTaskInfo();
        System.out.println("Отчет: " + genericTask2.generateReport());

        System.out.println("\nОбщее количество задач на конец программы: " + Task.getCreatedTasksCount());
    }
}