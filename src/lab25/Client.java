package lab25;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");

        System.out.println("Клиент системы управления задач");
        System.out.println("Подключение к серверу " + SERVER_ADDRESS + ":" + SERVER_PORT);

        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
                BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Подключение установлено!");

            String line;
            for (int i = 0; i < 11; i++) {
                line = in.readLine();
                if (line != null) {
                    System.out.println(line);
                }
            }

            System.out.println("\nВведите команду (или 'exit' для выхода):");

            String userInput;
            while (true) {
                System.out.print("> ");
                userInput = consoleInput.readLine();

                if (userInput == null || userInput.trim().isEmpty()) {
                    continue;
                }

                if (userInput.equalsIgnoreCase("exit")) {
                    out.println("EXIT");
                    break;
                }

                out.println(userInput);
                System.out.println("Отправлено: " + userInput);

                readServerResponse(in);
            }

            System.out.println("Клиент завершает работу.");

        } catch (UnknownHostException e) {
            System.err.println("Неизвестный хост: " + SERVER_ADDRESS);
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода: " + e.getMessage());
        }
    }

    private static void readServerResponse(BufferedReader in) throws IOException {
        StringBuilder response = new StringBuilder();
        String line;
        int emptyLineCount = 0;

        while (true) {
            if (!in.ready()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }

                if (!in.ready()) {
                    break;
                }
            }

            line = in.readLine();
            if (line == null) {
                break;
            }

            if (line.isEmpty()) {
                emptyLineCount++;
                if (emptyLineCount > 1) {
                    break;
                }
            } else {
                emptyLineCount = 0;
            }

            response.append(line).append("\n");

            if (line.startsWith("Всего задач:") ||
                    line.startsWith("Баг добавлен!") ||
                    line.startsWith("Функционал добавлен!") ||
                    line.startsWith("Статус задачи") ||
                    line.startsWith("Приоритет задачи") ||
                    line.startsWith("Задача с ID") ||
                    line.startsWith("Ошибка:") ||
                    line.startsWith("Неизвестная команда") ||
                    line.equals("До свидания!") ||
                    line.equals("Список задач пуст.")) {
                break;
            }
        }

        if (response.length() > 0) {
            System.out.println("Ответ сервера:");
            System.out.println(response.toString());
        }
    }
}