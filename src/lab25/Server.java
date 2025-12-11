package lab25;

import lab10.classes.abstracts.Task;
import lab10.classes.ordinary.BugTask;
import lab10.classes.ordinary.FeatureTask;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private static final int PORT = 12345;
    private static List<Task> tasks = new CopyOnWriteArrayList<>();
    private static int taskCounter = 1;

    public static void main(String[] args) {
        System.out.println("Сервер управления задачами запущен...");
        System.out.println("Ожидание подключений на порту " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Новое подключение: " + clientSocket.getInetAddress());

                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.err.println("Ошибка сервера: " + e.getMessage());
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Явно указываем UTF-8 кодировку
                in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

                out.println("Добро пожаловать в систему управления задачами!");
                out.println("Доступные команды:");
                out.println("  LIST - показать все задачи");
                out.println("  ADD_BUG <name>|<desc>|<assigned>|<priority>|<due>|<severity>|<steps>");
                out.println("  ADD_FEATURE <name>|<desc>|<assigned>|<priority>|<due>|<area>|<criteria>");
                out.println("  UPDATE <id> <new_status>");
                out.println("  ESCALATE <id>");
                out.println("  REPORT <id>");
                out.println("  INFO <id>");
                out.println("  COUNT - количество задач");
                out.println("  EXIT - выход");

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Получено от клиента: " + inputLine); // Логирование

                    if (inputLine.equalsIgnoreCase("EXIT")) {
                        out.println("До свидания!");
                        break;
                    }

                    String response = processCommand(inputLine);
                    out.println(response);
                }

                socket.close();
                System.out.println("Клиент отключен: " + socket.getInetAddress());

            } catch (IOException e) {
                System.err.println("Ошибка обработки клиента: " + e.getMessage());
            }
        }

        private String processCommand(String command) {
            String[] parts = command.split(" ", 2);
            String cmd = parts[0].toUpperCase();
            String args = parts.length > 1 ? parts[1] : "";

            try {
                switch (cmd) {
                    case "LIST":
                        return getTasksList();

                    case "ADD_BUG":
                        return addBugTask(args);

                    case "ADD_FEATURE":
                        return addFeatureTask(args);

                    case "UPDATE":
                        return updateTaskStatus(args);

                    case "ESCALATE":
                        return escalateTask(args);

                    case "REPORT":
                        return getTaskReport(args);

                    case "INFO":
                        return getTaskInfo(args);

                    case "COUNT":
                        return "Всего задач: " + tasks.size();

                    default:
                        return "Неизвестная команда. Используйте HELP для списка команд.";
                }
            } catch (Exception e) {
                return "Ошибка: " + e.getMessage();
            }
        }

        private String getTasksList() {
            if (tasks.isEmpty()) {
                return "Список задач пуст.";
            }

            StringBuilder sb = new StringBuilder();
            sb.append("СПИСОК ЗАДАЧ:\n");
            for (Task task : tasks) {
                sb.append(String.format("[ID: %d] %s - %s (%s)\n",
                        task.getId(), task.getName(), task.getStatus(), task.getAssignedTo()));
            }
            return sb.toString();
        }

        private String addBugTask(String args) {
            String[] params = args.split("\\|");
            if (params.length != 7) {
                return "Ошибка: Неверный формат. Нужно: name|desc|assigned|priority|due|severity|steps";
            }

            BugTask bug = new BugTask(
                    params[0].trim(), params[1].trim(), params[2].trim(),
                    params[3].trim(), params[4].trim(), params[5].trim(), params[6].trim()
            );
            tasks.add(bug);
            return "Баг добавлен! ID: " + bug.getId() + ", Название: " + bug.getName();
        }

        private String addFeatureTask(String args) {
            String[] params = args.split("\\|");
            if (params.length != 7) {
                return "Ошибка: Неверный формат. Нужно: name|desc|assigned|priority|due|area|criteria";
            }

            FeatureTask feature = new FeatureTask(
                    params[0].trim(), params[1].trim(), params[2].trim(),
                    params[3].trim(), params[4].trim(), params[5].trim(), params[6].trim()
            );
            tasks.add(feature);
            return "Функционал добавлен! ID: " + feature.getId() + ", Название: " + feature.getName();
        }

        private String updateTaskStatus(String args) {
            String[] params = args.split(" ");
            if (params.length != 2) {
                return "Ошибка: Используйте UPDATE <id> <new_status>";
            }

            int id = Integer.parseInt(params[0]);
            String newStatus = params[1];

            for (Task task : tasks) {
                if (task.getId() == id) {
                    task.updateStatus(newStatus);
                    return "Статус задачи " + id + " обновлен на: " + newStatus;
                }
            }
            return "Задача с ID " + id + " не найдена.";
        }

        private String escalateTask(String args) {
            try {
                int id = Integer.parseInt(args.trim());

                for (Task task : tasks) {
                    if (task.getId() == id && task instanceof lab10.classes.abstracts.PriorityTask) {
                        ((lab10.classes.abstracts.PriorityTask) task).escalatePriority();
                        return "Приоритет задачи " + id + " эскалирован.";
                    }
                }
                return "Задача с ID " + id + " не найдена или не поддерживает эскалацию.";
            } catch (NumberFormatException e) {
                return "Ошибка: Неверный ID задачи";
            }
        }

        private String getTaskReport(String args) {
            try {
                int id = Integer.parseInt(args.trim());

                for (Task task : tasks) {
                    if (task.getId() == id) {
                        return task.generateReport();
                    }
                }
                return "Задача с ID " + id + " не найдена.";
            } catch (NumberFormatException e) {
                return "Ошибка: Неверный ID задачи";
            }
        }

        private String getTaskInfo(String args) {
            try {
                int id = Integer.parseInt(args.trim());

                for (Task task : tasks) {
                    if (task.getId() == id) {
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        PrintStream ps = new PrintStream(baos, true, "UTF-8");
                        PrintStream old = System.out;
                        System.setOut(ps);

                        task.displayTaskInfo();

                        System.out.flush();
                        System.setOut(old);
                        return baos.toString("UTF-8");
                    }
                }
                return "Задача с ID " + id + " не найдена.";
            } catch (Exception e) {
                return "Ошибка: " + e.getMessage();
            }
        }
    }
}