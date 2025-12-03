package lab06;

public class Main {
    public static void main(String[] args) {
        DateDMY defaultDate = new DateDMY();
        DateDMY paramDate = new DateDMY(11, 9, 2025);
        DateDMY copyDate = new DateDMY(paramDate);

        //region default
        System.out.println("Дефолтная дата: " + defaultDate);
        System.out.println("Pretty format: " + defaultDate.pretty());
        System.out.println("Год: " + defaultDate.year());
        System.out.println();
        //endregion

        //region parameters
        System.out.println("Дата с параметрами: " + paramDate);
        System.out.println("Pretty format: " + paramDate.pretty());
        System.out.println("Год: " + paramDate.year());
        System.out.println();
        //endregion

        //region copy
        System.out.println("Копия даты: " + copyDate);
        System.out.println("Pretty format: " + copyDate.pretty());
        System.out.println("Год: " + copyDate.year());
        //endregion

    }
}