package lab07;

public class WeightStats {
    public int average(int[] array) {
        int numbersSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                numbersSum += array[i];
            }
        }
        return numbersSum / array.length;
    }
}
