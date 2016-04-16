package categoryArrays;

/**
 * Created by Vinod on 4/8/2016.
 */
public class ArrayElementsConsecutive {
    int len;
    int[] arr;

    public ArrayElementsConsecutive(int len) {
        this.len = len;
        this.arr = new int[len];
        int temp = (int) (Math.random() * 100);
        for (int i = 0; i < len; i++)
            arr[i] = (int) (Math.random() * 100) % len;
    }

    public void isConsecutive() {
        int max = findMax();
        int min = findMin();

        boolean[] visited = new boolean[len];

        if (max - min + 1 == len) {
            for (int val : arr) {
                if (visited[val - min]) {
                    System.out.println("NOT");
                    return;
                } else
                    visited[val - min] = true;
            }
            System.out.println("IS");
        } else {
            System.out.println("NOT");
        }
    }


    private int findMin() {
        int min = Integer.MAX_VALUE;
        for (int val : arr)
            if (val < min)
                min = val;
        return min;
    }

    private int findMax() {
        int max = Integer.MIN_VALUE;
        for (int val : arr)
            if (val > max)
                max = val;
        return max;
    }

    public static void main(String[] args) {
        ArrayElementsConsecutive arrayElementsConsecutive = new ArrayElementsConsecutive(10);
        for (int val : arrayElementsConsecutive.arr)
            System.out.print(val + ", ");
        System.out.println();
        arrayElementsConsecutive.isConsecutive();

    }
}
