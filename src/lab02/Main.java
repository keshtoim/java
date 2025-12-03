package lab02;

public class Main {
    public static void main(String[] args) {
        int number = 5;
        int mul = 1;
        for (int i = 1; i <= 5; i++) {
            mul *= i;
        }
        System.out.println("Факториал числа " + number + ": " + mul);
    }
}