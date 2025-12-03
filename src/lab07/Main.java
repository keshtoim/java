package lab07;

public class Main {
    public static void main(String[] args) {
        Stats stat = new Stats();
        System.out.println("Среднее арифметическое 5 и 2 (округление до целого): " + stat.average(5, 2));
        System.out.println("Среднее арифметическое 2.5 и 10.5: " + stat.average(2.5, 10.5));
        int[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Среднее арифметическое чисел от 0 по 10: " + stat.average(array1));

        WeightStats statWeight = new WeightStats();
        int[] array2 = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        System.out.println("Среднее арифметическое чисел от -5 по 5, " +
                "не считая отрицательные числа и нуль " +
                "(округление до целого): " + statWeight.average(array2));
    }
}