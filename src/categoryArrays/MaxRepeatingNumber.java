package categoryArrays;

/**
 * Created by Vinod on 4/4/2016.
 */
public class MaxRepeatingNumber {
    int len, k;
    int[] arr;

    public MaxRepeatingNumber(int len, int k) {
        this.len = len;
        this.k = k;
        this.arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * k) % k;
        }
    }

    public int maxRepeatNumber() {
        for (int i = 0; i < len; i++) {
            arr[(arr[i] % k)] += k;
        }
        int max = arr[0], result = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
                result = i;
            }
        }
        for (int i = 0; i < len; i++) {
            arr[i] = arr[i] % k;
        }
        return result;
    }

    public static void main(String[] args) {
        MaxRepeatingNumber maxRepeatingNumber = new MaxRepeatingNumber(8, 8);
        for (int val : maxRepeatingNumber.arr)
            System.out.print(val + ", ");
        System.out.println();
        System.out.println(maxRepeatingNumber.maxRepeatNumber());
        for (int val : maxRepeatingNumber.arr)
            System.out.print(val + ", ");
    }
}
