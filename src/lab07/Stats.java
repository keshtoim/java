package lab07;

public class Stats {
    private int first, second;


    public Stats (int first, int sec)
    {
        this.first = first;
        second = sec;
    }
    public Stats() {
        this.first = 5;
        this.second = 2;
    }

    public int average (int first, int second) {
        return (first + second) / 2;
    }
    public double average (double first, double second) {
        return (first + second) / 2.0;
    }
    public int average (int[] array) {
        int numbersSum = 0;
        for (int j : array) {
            numbersSum += j;
        }
        return numbersSum / array.length;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
