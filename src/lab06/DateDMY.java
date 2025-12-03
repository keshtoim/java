package lab06;

public class DateDMY {
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
