package categoryArrays;

/**
 * Created by Vinod on 4/8/2016.
 */
public class ProductArrayPuzzle {
    int len;
    int[] arr;

    public ProductArrayPuzzle(int len) {
        this.len = len;
        this.arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = (int) (Math.random() * 100 % 10) + 1;
    }

    public void productArray() {
        int[] arrCpy = new int[len];
        for (int i = 0; i < len; i++) {
            arrCpy[i] = 1;
            for (int j = 0; j < len; j++) {
                if (j != i)
                    arrCpy[i] *= arr[j];
            }
        }
        int i = 0;
        for (int val : arrCpy)
            arr[i++] = val;
    }

    public void productArrayEfficient() {
        int i, temp = 1;
        int[] prod = new int[len];

        for (i = 0; i < len; i++) {
            prod[i] = temp;
            temp *= arr[i];
        }

        temp = 1;

        for (i = len - 1; i >= 0; i--) {
            prod[i] *= temp;
            temp *= arr[i];
        }


        i = 0;
        for (int val : prod)
            arr[i++] = val;
    }


    public static void main(String[] args) {
        ProductArrayPuzzle productArrayPuzzle = new ProductArrayPuzzle(4);
        for (int val : productArrayPuzzle.arr)
            System.out.print(val + ", ");
        System.out.println();
        productArrayPuzzle.productArrayEfficient();
        for (int val : productArrayPuzzle.arr)
            System.out.print(val + ", ");
    }
}
