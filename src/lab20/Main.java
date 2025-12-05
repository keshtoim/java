package lab20;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        //region определение пути к файлу
        String filePath = "lab_data/tasks.txt";
        File file = new File(filePath);
        //endregion

        //region проверка существования файла
        if (!file.exists()) {
            System.out.println("Файл '" + filePath + "' не найден.");
            System.out.println("Абсолютный путь: " + file.getAbsolutePath());
            System.out.println("Убедитесь, что файл был создан в предыдущей лабораторной работе.");
            return;
        }
        //endregion

        System.out.println("Файл '" + filePath + "' найден.");
        System.out.println("Абсолютный путь: " + file.getAbsolutePath());
        System.out.println("Размер файла: " + file.length() + " байт");
        System.out.println();

        //region построчное чтение файла с использованием FileReader и BufferedReader
        System.out.println("Начинаем чтение файла...\n");

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            int lineNumber = 1;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Строка №" + lineNumber + ": " + line);
                lineNumber++;
            }

            System.out.println("\nЧтение файла выполнено.");
            System.out.println("Всего прочитано строк: " + (lineNumber - 1));

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            e.printStackTrace();
        }
        //endregion
    }
}