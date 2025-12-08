package lab21;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            //region определение пути к файлу
            String filePath = "lab_data/tasks.txt";
            File file = new File(filePath);
            //endregion

            //region проверка существования файла
            if (!file.exists()) {
                throw new FileNotFoundException("Файл не найден: " + file.getAbsolutePath());
            }
            //endregion

            //region построчное чтение файла с обработкой исключений
            System.out.println("Начинаем чтение файла...\n");

            try (FileReader fileReader = new FileReader(file);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                String line;
                int lineNumber = 1;

                //region чтение до достижения конца файла
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println("Строка №" + lineNumber + ": " + line);
                    lineNumber++;

                    if (lineNumber == 3) {
                        processTaskLine(line);
                    }
                }
                //endregion

                System.out.println("\nЧтение файла выполнено успешно.");
                System.out.println("Всего прочитано строк: " + (lineNumber - 1));

            } catch (IOException e) {
                System.out.println("Ошибка ввода-вывода при чтении файла: " + e.getMessage());
            }
            //endregion

        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Рекомендация: убедитесь, что сначала запущена lab19.Main");

        } catch (SecurityException e) {
            System.out.println("Ошибка безопасности: " + e.getMessage());
            System.out.println("Проверьте права доступа к файлу.");

        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\nБлок finally: завершение работы с файловой системой.");
            System.out.println("Программа завершена (с обработкой исключений).");
        }
    }

    //region метод с обработкой исключений
    private static void processTaskLine(String line) {
        try {
            if (line == null || line.isEmpty()) {
                throw new IllegalArgumentException("Пустая строка с задачей");
            }

            if (!line.contains("Task{")) {
                System.out.println("Предупреждение: строка может иметь неверный формат: " + line);
            }

            int testCalculation = 10 / (line.length() > 0 ? 1 : 0);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка валидации строки: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Арифметическая ошибка при обработке строки: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Общая ошибка при обработке строки: " + e.getMessage());
        }
    }
    //endregion
}