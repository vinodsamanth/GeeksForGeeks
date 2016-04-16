package categoryArrays;

import java.util.Arrays;

/**
 * Created by Vinod on 4/7/2016.
 */
public class ArraySumEqualValue {
    int[] arr;
    int len;

    public ArraySumEqualValue(int len) {
        this.len = len;
        this.arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = (int) (Math.random() * 10 % 10);
    }

    public void twoValues(int key) {
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++)
                if (arr[i] + arr[j] == key)
                    System.out.print(arr[i] + "+" + arr[j] + "=" + key);
        }
    }

    public void twoValuesSorted(int key) {
        System.out.println(key);
        Arrays.sort(arr);
        if (arr[len - 2] + arr[len - 1] < key)
            return;
        int left = 0, right = len - 1;
        while (left < right) {
            if (arr[left] + arr[right] == key)
                System.out.print(arr[left++] + "+" + arr[right] + "=" + key);
            else if (arr[left] + arr[right] > key)
                right--;
            else
                left++;
        }
    }

    public static void main(String[] args) {
        ArraySumEqualValue arraySumEqualValue = new ArraySumEqualValue(10);
        for (int val : arraySumEqualValue.arr)
            System.out.print(val + ", ");
        System.out.println();
        arraySumEqualValue.twoValuesSorted((int) (Math.random() * 100 % 10));
    }
}
