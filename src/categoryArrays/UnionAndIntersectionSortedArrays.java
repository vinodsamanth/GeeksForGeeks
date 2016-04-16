package categoryArrays;

import java.util.Arrays;

/**
 * Created by Vinod on 4/13/2016.
 */
public class UnionAndIntersectionSortedArrays {
    int[] arrA, arrB;

    public UnionAndIntersectionSortedArrays(int lenA, int lenB) {
        this.arrA = new int[lenA];
        this.arrB = new int[lenB];
        for (int i = 0; i < lenA; i++)
            arrA[i] = (int) (Math.random() * 1000 % 10);
        for (int i = 0; i < lenB; i++)
            arrB[i] = (int) (Math.random() * 1000 % 10);
        Arrays.sort(arrA);
        Arrays.sort(arrB);
    }

    public void unionOfArrays() {
        int i = 0, j = 0;
        while (i < arrA.length && j < arrB.length) {
            while (i < arrA.length - 1 && arrA[i] == arrA[i + 1])
                i++;
            while (j < arrB.length - 1 && arrB[j] == arrB[j + 1])
                j++;
            if (arrA[i] < arrB[j]) {
                System.out.print(arrA[i++] + ", ");
            } else if (arrB[j] < arrA[i]) {
                System.out.print(arrB[j++] + ", ");
            } else {
                System.out.print(arrB[j] + ", ");
                i++;
                j++;
            }
        }
        while (i < arrA.length)
            System.out.print(arrA[i++] + ", ");
        while (j < arrB.length)
            System.out.print(arrB[j++] + ", ");
    }

    public void intersectionOfArrays() {
        int i = 0, j = 0;
        while (i < arrA.length && j < arrB.length) {
            if (arrA[i] < arrB[j]) {
                i++;
            } else if (arrB[j] < arrA[i]) {
                j++;
            } else {
                System.out.print(arrB[j++] + ", ");
                i++;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        UnionAndIntersectionSortedArrays unionAndIntersectionSortedArrays = new UnionAndIntersectionSortedArrays(5, 10);
        for (int val : unionAndIntersectionSortedArrays.arrA)
            System.out.print(val + ", ");
        System.out.println();
        for (int val : unionAndIntersectionSortedArrays.arrB)
            System.out.print(val + ", ");
        System.out.println();
        unionAndIntersectionSortedArrays.unionOfArrays();
        System.out.println();
        unionAndIntersectionSortedArrays.intersectionOfArrays();
    }

}
