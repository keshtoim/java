package lab04;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] array = new int[size];

        for(int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        // Вывод:
        arrayPrint(array, size);
        // Количество нулей
        int zeroCount = 0;
        for(int i = 0; i < size; i++) {
            if (array[i] == 0) zeroCount++;
        }
        if (zeroCount > 0) System.out.println("\nКоличество нулей: " + zeroCount);
        else System.out.println("\nНулей нет");
        // Замена всех нулей на -1
        for(int i = 0; i < size; i++) {
            if (array[i] == 0) array[i] = -1;
        }
        arrayPrint(array, size);
    }
    public static void arrayPrint(int[] array, int size) {
        /*
        for(int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
         */
        for (int i : array) {
            System.out.print(i + "\t");
        }
    }
}