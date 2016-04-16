package categoryArrays;

/**
 * Created by Vinod on 4/8/2016.
 */
public class TwoRepeatingElements {
    int len;
    int[] arr;

    public TwoRepeatingElements(int len) {
        this.len = len;
        this.arr = new int[]{4, 2, 4, 5, 2, 3, 1};
    }

    public void repeatingElements() {
        int[] count = new int[len];
        for (int i = 0; i < len + 2; i++) {
            if (count[arr[i] - 1] == 1)
                System.out.println(arr[i] + " duplicate");
            else
                count[arr[i] - 1]++;
        }
    }

    public void repeatingElementsEfficient() {
        int sum = 0;
        int prod = 1;
        for (int val : arr) {
            sum += val;
            prod *= val;
        }
        int xSumy = sum - (len * (len + 1) / 2);
        int xPrody = prod / fact(len);
        int xSuby = (int) Math.sqrt((xSumy * xSumy) - 4 * xPrody);

        int x = (xSumy + xSuby) / 2;
        int y = (xSumy - xSuby) / 2;

        System.out.println("xSumy : " + xSumy + ", xSuby : " + xSuby);
        System.out.println("xPrody : " + xPrody);

        System.out.println("X : " + x + ", Y : " + y);
    }

    private int fact(int len) {
        return (len == 0) ? 1 : len * fact(len - 1);
    }

    public static void main(String[] args) {
        TwoRepeatingElements twoRepeatingElements = new TwoRepeatingElements(5);
        twoRepeatingElements.repeatingElementsEfficient();
    }
}
