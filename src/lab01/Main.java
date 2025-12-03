package lab01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double radian = 1.57;
        double gradus = radian * (180 / Math.PI);
        int i = 100 / 3;

        System.out.println("Результат перевода радиан в градусы: " + gradus);

        System.out.print("Введите сколько Вам полных лет: ");
        int age = scanner.nextInt();
        int ageInMonth = age * 12;
        System.out.println("Введенный возраст в месяцах: " + ageInMonth);

        int side = 9;
        double square = 0.5 * 9 * Math.sqrt(Math.pow(side, 2) - Math.pow(4.5, 2));
        System.out.println("Площадь равностороннего треугольника со стороной " + side + ": " + square);

        scanner.close();
    }
}