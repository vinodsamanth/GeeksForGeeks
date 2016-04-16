package categoryArrays;

import java.util.ArrayList;

/**
 * Created by Vinod on 4/4/2016.
 */
public class IncreasingSubMaxProduct {
    int len;
    int[] arr;
    ArrayList<LSLRG> list;

    class LSLRG {
        int lSl, lRG, curValue;
    }

    public IncreasingSubMaxProduct(int len) {
        this.len = len;
        this.arr = new int[len];

        list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 100 * (i * Math.random() * 10) % 9) + 1;
        }
    }

    public void subArray() {
        int value;
        for (int i = 0; i < len; i++) {
            LSLRG lslrg = new LSLRG();
            lslrg.curValue = arr[i];
            value = 0;
            for (int p = 0; p < i; p++) {
                if (value < arr[p])
                    value = arr[p];
            }

            lslrg.lSl = value;

            value = 0;

            for (int q = i + 1; q < len; q++) {
                if (value < arr[q])
                    value = arr[q];
            }

            lslrg.lRG = value;
            if (lslrg.lSl <= lslrg.curValue && lslrg.curValue <= lslrg.lRG)
                list.add(lslrg);
        }
    }

    public static void main(String[] args) {
        IncreasingSubMaxProduct increasingSubMaxProduct = new IncreasingSubMaxProduct(10);
        for (int val : increasingSubMaxProduct.arr)
            System.out.print(val + ", ");
        System.out.println();
        increasingSubMaxProduct.subArray();
        System.out.println();
        for (LSLRG val : increasingSubMaxProduct.list)
            System.out.print(val.lSl + " : " + val.curValue + " : " + val.lRG + "\t");
    }
}
