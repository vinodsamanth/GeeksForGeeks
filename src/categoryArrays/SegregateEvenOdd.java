package categoryArrays;

/**
 * Created by Vinod on 4/8/2016.
 */
public class SegregateEvenOdd {
    int len;
    int[] arr;

    public SegregateEvenOdd(int len) {
        this.len = len;
        this.arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = (int) (Math.random() * 1000 % 100);
    }

    public void segregateEvenOdd() {
        int left = 0, right = len - 1;
        while (left < right) {
            while (arr[left] % 2 == 0 && left < right)
                left++;
            while (arr[right] % 2 == 1 && left < right)
                right--;
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                right--;
            }
        }
    }


    public static void main(String[] args) {
        SegregateEvenOdd segregateEvenOdd = new SegregateEvenOdd(10);
        for (int val : segregateEvenOdd.arr)
            System.out.print(val + ", ");
        System.out.println();
        segregateEvenOdd.segregateEvenOdd();
        for (int val : segregateEvenOdd.arr)
            System.out.print(val + ", ");
    }
}
