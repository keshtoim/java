package lab12;

import lab10.classes.abstracts.Task;
import lab10.classes.ordinary.BugTask;
import lab10.classes.ordinary.FeatureTask;

public class Main {
    public static void main(String[] args) {
        //region создание объектов
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

        Task[] taskList = {bug1, feature1};
        processTasks(taskList);
    }

    public static void processTasks(Task[] tasks) {
        System.out.println("\n--- Обработка задач через полиморфизм ---");
        for (Task task : tasks) {
            System.out.println(task.generateReport());
        }
    }
}