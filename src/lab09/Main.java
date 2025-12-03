package lab09;

import java.util.ArrayList;
import lab08.classes.Subject;
import lab08.classes.History;
import lab08.classes.Mathematics;
import lab08.classes.Physics;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        ArrayList<Subject> subjects = new ArrayList<>();

        //region arrayMaking
        subjects.add(new Mathematics("Algebra", 30, 6, 0));
        subjects.add(new History("Ancient", 25, 5, "Egypt", 0));
        subjects.add(new Physics("Mechanics", 35, 7, true, 0));
        subjects.add(new Mathematics("Geometry", 28, 5, 2));
        subjects.add(new History("Medieval", 20, 4, "Europe", 3));
        //endregion

        //region arrayPrint
        System.out.println("Вывод через for:");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i));
        }

        System.out.println("\nВывод через foreach:");
        int idx = 1;
        for (Subject s : subjects) {
            System.out.println((idx++) + ". " + s);
        }
        //endregion

        //region addObjectsInArrayAndSize
        subjects.addFirst(new Physics("Thermodynamics", 40, 8, false, 0));
        subjects.add(new Mathematics("Calculus", 50, 9, 1));
        System.out.println("\nПосле добавления: " + subjects.size() + " предметов");
        //endregion

        //region removeObjects
        Subject removedByIndex = subjects.removeLast();
        System.out.println("Удалён по индексу: " + removedByIndex.getTitle());

        Subject first = subjects.getFirst();
        System.out.println("Удалён по значению: " + first);

        System.out.println("Текущий размер: " + subjects.size());
        //endregion

        System.out.println("Вывод названия третьего предмета: " + subjects.get(2).getTitle());

        //region renameSubjectTitle
        subjects.get(2).setTitle("Dynamic");
        System.out.println("Изменение названия третьего предмета: " + subjects.get(2));
        //endregion

        //region searchFirstByCondition
        Subject found = null;
        for (Subject s : subjects) {
            if (s.getProgress() < 40) {
                found = s;
                break;
            }
        }
        if (found != null) {
            System.out.println("\nНайден предмет с прогрессом < 40:\n" + found);
        }
        //endregion

        //region contains()
        Subject subject = subjects.get(2);
        boolean isAvailable = subjects.contains(subject);
        System.out.println("\nИмеется ли предмет c данными\n" + subjects.get(2) + "\nв ArrayList: " + isAvailable);
        //endregion

        //region clear()
        subjects.clear();
        System.out.println("\nПосле clear: размер = " + subjects.size());
        //endregion
    }
}