package lab23;

import lab17.TaskPriority;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        //region создание объекта для сериализации
        System.out.println("=== Лабораторная работа: Сериализация объекта ===\n");

        SerializableTask task = new SerializableTask(
                "Анна Петрова",
                "IN_PROGRESS",
                40,
                TaskPriority.HIGH
        );

        System.out.println("Исходный объект:");
        System.out.println(task);
        System.out.println();
        //endregion

        //region сериализация объекта в файл
        String fileName = "serialized_task.dat";
        System.out.println("Начинаем сериализацию в файл: " + fileName);

        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(task);
            System.out.println("Объект успешно сериализован и сохранён в файл.");

            //region дополнительная информация о файле
            File file = new File(fileName);
            System.out.println("Размер файла: " + file.length() + " байт");
            System.out.println("Абсолютный путь: " + file.getAbsolutePath());
            //endregion

        } catch (IOException e) {
            System.out.println("Ошибка при сериализации: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        //endregion

        //region проверка transient-поля
        System.out.println("\nПроверка transient-поля (secretNote):");
        System.out.println("В исходном объекте secretNote = '" + task.getSecretNote() + "'");
        System.out.println("Примечание: это поле помечено как transient и не будет сохранено.");
        //endregion

        //region создание второго объекта для демонстрации списка
        System.out.println("\n=== Дополнительно: сериализация коллекции ===");

        SerializableTask task2 = new SerializableTask(
                "Борис Иванов",
                "TODO",
                20,
                TaskPriority.MEDIUM
        );

        java.util.ArrayList<SerializableTask> taskList = new java.util.ArrayList<>();
        taskList.add(task);
        taskList.add(task2);

        String listFileName = "serialized_task_list.dat";

        try (FileOutputStream fileOut = new FileOutputStream(listFileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(taskList);
            System.out.println("Коллекция из " + taskList.size() + " задач сериализована в файл: " + listFileName);

        } catch (IOException e) {
            System.out.println("Ошибка при сериализации коллекции: " + e.getMessage());
        }
        //endregion
    }
}