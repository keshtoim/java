package lab11;

import lab08.classes.History;
import lab08.classes.Mathematics;
import lab08.classes.Physics;
import lab08.classes.Subject;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //region создание списка
        LinkedList<Subject> subjectList = new LinkedList<>();

        subjectList.add(new Mathematics("Algebra", 30, 6, 2));
        subjectList.addLast(new Physics("Mechanics", 35, 7, true, 3));
        subjectList.add(new History("Ancient", 20, 5, "Ancient", 4));
        subjectList.addFirst(new Mathematics("Geometry", 25, 5, 1));
        subjectList.add(new Physics("Thermodynamics", 40, 8, false, 2));
        subjectList.add(new History("Modern", 22, 6, "Modern", 1));
        subjectList.add(new Mathematics("Calculus", 35, 9, 0));
        //endregion

        //region вывод списка
        System.out.println("Исходный список:");
        printList(subjectList);
        //endregion

        //region добавление элементов и вывод
        subjectList.addFirst(new History("Medieval", 28, 4, "Medieval", 3));
        subjectList.addLast(new Physics("Electromagnetism", 45, 9, true, 5));
        System.out.println("\nПосле добавления в начало и конец:");
        printList(subjectList);
        //endregion

        //region удаление элементов
        subjectList.removeFirst();
        subjectList.removeLast();
        System.out.println("\nПосле удаления первого и последнего:");
        printList(subjectList);
        //endregion

        //region получение элементов
        Subject first = subjectList.getFirst();
        Subject last = subjectList.getLast();
        System.out.println("\nПервый элемент: " + first);
        System.out.println("Последний элемент: " + last);
        //endregion

        //region первый предмет по условию
        Subject found = null;
        for (Subject s : subjectList) {
            if (s.getDifficulty() >= 8 || s.getProgress() > 50) {
                found = s;
                break;
            }
        }
        if (found != null) {
            System.out.println("\nНайден первый предмет с заданным условием:");
            System.out.println(found);
        } else {
            System.out.println("\nТаких предметов не найдено.");
        }
        //endregion

        //region удаление элементов по условию
        subjectList.removeIf(s -> s.  getDifficulty() >= 8 || s.getProgress() > 50);
        System.out.println("\nСписок после удаления всех таких элементов:");
        printList(subjectList);
        //endregion

        //region проверка на пустоту и вывод
        System.out.println("\nСписок пуст? " + subjectList.isEmpty());
        System.out.println("Размер списка: " + subjectList.size());
        //endregion
    }
    private static void printList(LinkedList<Subject> list) {
        if (list.isEmpty()) {
            System.out.println("Список пуст.");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}