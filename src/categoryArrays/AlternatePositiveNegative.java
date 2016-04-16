package categoryArrays;

/**
 * Created by Vinod on 4/4/2016.
 */
public class AlternatePositiveNegative {
    int[] arr;
    int len;

    public AlternatePositiveNegative(int len) {
        this.len = len;
        this.arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = Math.random() > 0.8 ? (int) (Math.random() * 100 % 10) : -(int) (Math.random() * 100 % 10);
    }

    public int[] rearrangeArrayEqual() {
        int posIndex;
        int negIndex;
        if (arr[0] < 0) {
            posIndex = 1;
            negIndex = 0;
        } else {
            posIndex = 0;
            negIndex = 1;
        }
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            if (arr[i] < 0) {
                result[negIndex] = arr[i];
                negIndex += 2;
            } else {
                result[posIndex] = arr[i];
                posIndex += 2;
            }
        }
        return result;
    }

    public void rearrangeArray() {
        int i = -1, temp = 0;
        for (int j = 0; j < len; j++) {
            if (arr[j] < 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int posIndex = i + 1, negIndex = 0;
        while (posIndex < len && negIndex < posIndex && arr[negIndex] < 0) {
            temp = arr[negIndex];
            arr[negIndex] = arr[posIndex];
            arr[posIndex] = temp;
            negIndex += 2;
            posIndex++;
        }
    }

    public static void main(String[] args) {
        AlternatePositiveNegative alternatePositiveNegative = new AlternatePositiveNegative(10);
        for (int val : alternatePositiveNegative.arr)
            System.out.print(val + ", ");
        System.out.println();
        alternatePositiveNegative.rearrangeArray();
        for (int val : alternatePositiveNegative.arr)
            System.out.print(val + ", ");
    }
}
