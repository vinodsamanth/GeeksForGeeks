package categoryArrays;

/**
 * Created by Vinod on 4/8/2016.
 */
public class EquilibriumIndexArray {
    int len;
    int[] arr;

    public EquilibriumIndexArray(int len) {
        this.len = len;
        this.arr = new int[]{-7, 1, 5, 2, -4, 3, 0};
        /*for (int i = 0; i < len; i++)
            arr[i] = (int) (Math.random() * 100);*/
    }

    public void equiIndex() {
        for (int i = 1; i < len; i++) {
            int sumLeft = 0;
            int j = i - 1;
            while (j >= 0) {
                sumLeft += arr[j--];
            }
            int sumRight = 0;
            j = i + 1;
            while (j < len) {
                sumRight += arr[j++];
            }
            if (sumLeft == sumRight)
                System.out.println("Equilibrium Index is : " + i);
        }
    }

    public void equiIndexEfficient() {
        int sum = 0, leftSum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        for (int i = 0; i < len; i++) {
            sum -= arr[i];
            if (leftSum == sum)
                System.out.println("Equilibrium Index is : " + i);
            leftSum += arr[i];
        }
    }

    public static void main(String[] args) {
        EquilibriumIndexArray equilibriumIndexArray = new EquilibriumIndexArray(6);
        for (int val : equilibriumIndexArray.arr)
            System.out.print(val + ", ");
        System.out.println();
        equilibriumIndexArray.equiIndexEfficient();
    }
}
