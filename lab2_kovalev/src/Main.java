import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int number = 5;
        int mul = 1;
        for (int i = 1; i <= 5; i++) {
            mul *= i;
        }
        System.out.println("Факториал числа " + number + ": " + mul);
        System.out.println("------------------------------------ " );
        int a=2;
        for (int i=0;i<=10;i++){
            System.out.printf(Math.pow(a,i) + " ");
        }
        System.out.println();
        System.out.println("------------------------------------ " );
        double r=1.85;
        double v=82;
        double b=v/(r*r);
        System.out.printf("%.0f",b);
        System.out.println();
        System.out.println("------------------------------------ " );
        String s="Санкт-Петербург";
        System.out.println(s);
        System.out.println("------------------------------------ " );
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int q;
        q=x;
        x=y;
        y=q;
        System.out.println(x + "  " + y);

    }
}