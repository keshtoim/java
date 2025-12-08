package lab24;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //region десериализация одиночного объекта
        System.out.println("=== Лабораторная работа: Десериализация объекта ===\n");

        String fileName = "serialized_task.dat";
        File file = new File(fileName);

        //region проверка существования файла
        if (!file.exists()) {
            System.out.println("Файл не найден: " + fileName);
            System.out.println("Сначала запустите lab23.Main для создания файла сериализации.");
            System.out.println("Абсолютный путь для проверки: " + file.getAbsolutePath());
            return;
        }
        //endregion

        System.out.println("Файл найден: " + fileName);
        System.out.println("Размер файла: " + file.length() + " байт\n");

        //region процесс десериализации
        System.out.println("Начинаем десериализацию...");

        SerializableTask restoredTask = null;

        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            Object obj = objectIn.readObject();

            if (obj instanceof SerializableTask) {
                restoredTask = (SerializableTask) obj;
                System.out.println("Объект успешно восстановлен из файла.");
            } else {
                System.out.println("Ошибка: восстановленный объект не является SerializableTask");
                return;
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            System.out.println("Класс объекта не найден: " + e.getMessage());
            return;
        }
        //endregion

        //region анализ восстановленного объекта
        System.out.println("\n=== Анализ восстановленного объекта ===");

        if (restoredTask != null) {
            System.out.println("Восстановленный объект:");
            System.out.println(restoredTask);

            //region проверка полей
            System.out.println("\nДетальная проверка полей:");
            System.out.println("1. assignee: '" + restoredTask.getAssignee() + "'");
            System.out.println("2. status: '" + restoredTask.getStatus() + "'");
            System.out.println("3. estimatedHours: " + restoredTask.getEstimatedHours());
            System.out.println("4. priority: " + restoredTask.getPriority());
            System.out.println("5. secretNote: '" + restoredTask.getSecretNote() + "'");

            //region анализ transient-поля
            System.out.println("\nВажное наблюдение:");
            System.out.println("Поле secretNote помечено как transient.");
            System.out.println("При десериализации оно получило значение по умолчанию: null");
            System.out.println("Исходное значение ('Временная заметка: Анна Петрова') было потеряно.");
            //endregion

            //region анализ конструктора
            System.out.println("\nАнализ работы конструктора:");
            System.out.println("При десериализации конструктор НЕ вызывался.");
            System.out.println("Доказательство: если бы конструктор вызвался,");
            System.out.println("поле secretNote получило бы значение 'Временная заметка: Анна Петрова'.");
            System.out.println("Но сейчас secretNote = " +
                    (restoredTask.getSecretNote() == null ? "null" : "'" + restoredTask.getSecretNote() + "'"));
            //endregion
        }
        //endregion

        //region десериализация коллекции
        System.out.println("\n=== Дополнительно: десериализация коллекции ===");

        String listFileName = "serialized_task_list.dat";
        File listFile = new File(listFileName);

        if (listFile.exists()) {
            try (FileInputStream fileIn = new FileInputStream(listFileName);
                 ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

                Object obj = objectIn.readObject();

                if (obj instanceof java.util.ArrayList) {
                    @SuppressWarnings("unchecked")
                    java.util.ArrayList<SerializableTask> restoredList =
                            (java.util.ArrayList<SerializableTask>) obj;

                    System.out.println("Восстановлена коллекция из " + restoredList.size() + " задач:");
                    for (int i = 0; i < restoredList.size(); i++) {
                        System.out.println((i+1) + ". " + restoredList.get(i).getAssignee());
                    }
                }

            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Ошибка при десериализации коллекции: " + e.getMessage());
            }
        } else {
            System.out.println("Файл коллекции не найден: " + listFileName);
        }
        //endregion

        //region итоговые выводы
        System.out.println("\n=== Итоговые выводы ===");
        System.out.println("1. Десериализация успешно восстановила состояние объекта.");
        System.out.println("2. Все обычные поля сохранены корректно.");
        System.out.println("3. Transient-поля получили значения по умолчанию.");
        System.out.println("4. Конструктор класса при десериализации НЕ вызывается.");
        System.out.println("5. Java восстанавливает объект напрямую, заполняя поля сохранёнными значениями.");
        //endregion

        System.out.println("\n=== Десериализация завершена ===");
    }
}