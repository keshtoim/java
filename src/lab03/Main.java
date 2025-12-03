package lab03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        absFound(a, b);

        String accessRights = scanner.next();

        accessRightsLearn(accessRights);

        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();

        timeFormatCheck(hours, minutes);

        scanner.close();
    }
    public static void absFound(int a, int b){
        if (Math.abs(a) > Math.abs(b)) {
            System.out.printf(String.valueOf(Math.abs(a)));
        }
        if (Math.abs(a) < Math.abs(b)) {
            System.out.printf(String.valueOf(Math.abs(b)));
        }
        else System.out.printf("equal");
    }
    public static void accessRightsLearn(String accessRights) {
        switch (accessRights) {
            case "admin":
                System.out.printf("full");
                break;
            case "manager":
                System.out.printf("limited");
                break;
            case "user":
                System.out.printf("basic");
                break;
            default:
                System.out.printf("denied");
                break;
        }
    }

    public static void timeFormatCheck(int hours, int minutes) {
        String checked = hours >= 0 && hours <= 24 && minutes >= 0 && minutes <= 60
                ? "valid" : "invalid";
        System.out.print(checked);
    }
}