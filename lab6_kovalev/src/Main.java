public class Main {
    public static void main(String[] args) {
        DateDMY defaultDate = new DateDMY();
        DateDMY paramDate = new DateDMY(11, 9, 2025);
        DateDMY copyDate = new DateDMY(paramDate);

        System.out.println("Дефолтная дата: " + defaultDate);
        System.out.println("Pretty format: " + defaultDate.pretty());
        System.out.println("Год: " + defaultDate.year());
        System.out.println();

        System.out.println("Дата с параметрами: " + paramDate);
        System.out.println("Pretty format: " + paramDate.pretty());
        System.out.println("Год: " + paramDate.year());
        System.out.println();

        System.out.println("Копия даты: " + copyDate);
        System.out.println("Pretty format: " + copyDate.pretty());
        System.out.println("Год: " + copyDate.year());
    }
}
class DateDMY {
    private int day, month, year;
    public DateDMY () {
        this.day = 12;
        this.month = 12;
        this.year = 2012;
    }
    public DateDMY (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public DateDMY (DateDMY other) {
        this.day = other.day;
        this.month = other.month;
        this.year = other.year;
    }
    public String toString() {
        return day + " " + month + " " + year + " ";
    }
    public String pretty() {
        return day + "." + month + "." + year + ".";
    }

    public int year() {
        return year;
    }
}