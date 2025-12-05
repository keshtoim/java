package lab19;

import lab17.Task;
import lab17.TaskPriority;
import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //region создание коллекции задач
        LinkedList<Task> taskList = new LinkedList<>();
        taskList.add(new Task("Анна", "TODO", TaskPriority.LOW));
        taskList.add(new Task("Борис", "IN_PROGRESS", TaskPriority.MEDIUM));
        taskList.add(new Task("Виктор", "DONE", TaskPriority.HIGH));
        taskList.add(new Task("Мария", "REVIEW", TaskPriority.HIGH));
        taskList.add(new Task("Иван", "TODO", TaskPriority.MEDIUM));
        //endregion

        //region создание директории для хранения данных
        String directoryPath = "lab_data";
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            boolean created = directory.mkdir(); // создаем одну директорию
            if (created) {
                System.out.println("Директория '" + directoryPath + "' успешно создана.");
            } else {
                System.out.println("Не удалось создать директорию '" + directoryPath + "'.");
                return;
            }
        } else {
            System.out.println("Директория '" + directoryPath + "' уже существует.");
        }
        //endregion

        //region проверка, что путь является директорией
        if (!directory.isDirectory()) {
            System.out.println("Путь '" + directoryPath + "' не является директорией.");
            return;
        }
        //endregion

        //region создание файла в директории
        String filePath = directoryPath + File.separator + "tasks.txt";
        File file = new File(filePath);
        //endregion

        //region запись в файл
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (Task task : taskList) {
                writer.println(task.toString());
            }
            System.out.println("Запись в файл '" + filePath + "' выполнена успешно.");
            System.out.println("Записано задач: " + taskList.size());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
        //endregion

        //region проверка результата
        System.out.println("\nПроверка результата:");
        System.out.println("Абсолютный путь к файлу: " + file.getAbsolutePath());
        System.out.println("Размер файла: " + file.length() + " байт");
        System.out.println("Файл существует: " + file.exists());

        System.out.println("\nДля проверки откройте папку: " + directory.getAbsolutePath());
        System.out.println("и файл: " + file.getName());
        //endregion
    }
}