package lab05;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = scanner.nextInt();
        int height = scanner.nextInt();

        rectangleArea(width, height);
        rectanglePerimeter(width, height);
        isSquare(width, height);
    }
    public static void rectangleArea(int width, int height) {
        int area = height * width;
        System.out.print("Площадь прямоугольника: " + area);
    }
    public static void rectanglePerimeter(int width, int height) {
        int pr = (height + width) * 2;
        System.out.print("\nПериметр прямоугольника: " + pr);
    }
    public static void isSquare(int width, int height) {
        double square = Math.pow(width, height);
        System.out.print("\nЧисло " + width + " в степени " + height + " равно " + square);
    }
}