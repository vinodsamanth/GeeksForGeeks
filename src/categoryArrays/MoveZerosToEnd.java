package categoryArrays;

/**
 * Created by Vinod on 4/7/2016.
 */
public class MoveZerosToEnd {
    int[] arr;
    int len;

    public MoveZerosToEnd(int len) {
        this.len = len;
        this.arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = (int) (Math.random() * 10 % 4);
    }

    public void moveZeros() {
        int count = 0;
        for (int i = 0; i < len; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i];

        while (count < len)
            arr[count++] = 0;
    }

    public static void main(String[] args) {
        MoveZerosToEnd moveZerosToEnd = new MoveZerosToEnd(10);
        for (int val : moveZerosToEnd.arr)
            System.out.print(val + ", ");
        System.out.println();
        moveZerosToEnd.moveZeros();
        for (int val : moveZerosToEnd.arr)
            System.out.print(val + ", ");
    }
}
