package categoryArrays;

/**
 * Created by Vinod on 4/13/2016.
 */
public class MaxDiffArray {
    int[] arr;

    public MaxDiffArray(int len) {
        this.arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = (int) (Math.random() * 100 % 10) + 1;
    }

    public void maxDiff() {
        int min = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - min > maxDiff)
                maxDiff = arr[i] - min;
            if (arr[i] < min)
                min = arr[i];
        }
        System.out.println(maxDiff);
    }

    public void maxDiffEfficient() {
        int dif = arr[1] - arr[0];
        int cur_sum = dif;
        int max_sum = cur_sum;

        for (int i = 1; i < arr.length - 1; i++) {
            dif = arr[i + 1] - arr[i];

            if (cur_sum > 0)
                cur_sum += dif;
            else
                cur_sum = dif;

            if (cur_sum > max_sum)
                max_sum = cur_sum;
        }

        System.out.println(max_sum);
    }

    public static void main(String[] args) {
        MaxDiffArray maxDiffArray = new MaxDiffArray(10);
        for (int val : maxDiffArray.arr)
            System.out.print(val + ", ");
        System.out.println();
        maxDiffArray.maxDiff();
        maxDiffArray.maxDiffEfficient();
    }
}
