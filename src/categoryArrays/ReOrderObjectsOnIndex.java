package categoryArrays;

/**
 * Created by Vinod on 4/13/2016.
 */
public class ReOrderObjectsOnIndex {
    char[] arrA = new char[]{'A', 'B', 'C', 'D', 'E'};
    int[] arrB = new int[]{4, 3, 1, 0, 2};

    public void reOrder() {
        for (int i = 0; i < arrA.length; i++) {
            while (arrB[i] != i) {
                swap(arrA, arrB[i], i);
                swapIndex(arrB, arrB[i], i);
            }
        }
        for (char val : arrA)
            System.out.println(val);
    }

    public void swap(char[] A, int i, int j) {
        char tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void swapIndex(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void sortByIndex() {
        int i = 0;
        while (i < arrB.length) {
            if (arrB[i] == i) {
                ++i;
            } else {
                swap(arrA, arrB[i], i);
                swapIndex(arrB, arrB[i], i);
            }
        }
        for (char val : arrA)
            System.out.println(val);
    }

    public static void main(String[] args) {
        ReOrderObjectsOnIndex reOrderObjectsOnIndex = new ReOrderObjectsOnIndex();
//        reOrderObjectsOnIndex.reOrder();
        for (char val : reOrderObjectsOnIndex.arrA)
            System.out.print(val + ", ");
        System.out.println();
        for (int val : reOrderObjectsOnIndex.arrB)
            System.out.print(val + ", ");
        System.out.println();
        reOrderObjectsOnIndex.sortByIndex();
    }

}
