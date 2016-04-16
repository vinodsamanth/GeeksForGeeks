package categoryArrays;

/**
 * Created by Vinod on 4/4/2016.
 */
public class StockMaxProfit {
    int[] price;
    int len;

    class Interval {
        int buy, sell;
    }

    public StockMaxProfit(int len) {
        this.len = len;
        this.price = new int[]{100, 180, 260, 310, 40, 535, 695};
        /*for (int i = 0; i < len; i++)
            price[i] = (int) (Math.random() * 500);*/
    }

    public void maxProfit() {
        if (len == 0)
            return;
        int count = 0;
        Interval[] solution = new Interval[len / 2 + 1];
        for (int i = 0; i < len / 2 + 1; i++)
            solution[i] = new Interval();
        int i = 0;
        while (i < len - 1) {
            while (i < len - 1 && price[i] >= price[i + 1])
                i++;
            if (i == len - 1)
                break;

            solution[count].buy = i++;

            while (i < len && price[i - 1] <= price[i])
                i++;

            solution[count].sell = i - 1;

            count++;
        }
        if (count == 0)
            System.out.println("There is no day when buying the stock will make profit\n");
        else
            for (i = 0; i < count; i++) {
                System.out.println("Buy on day: " + solution[i].buy + "Sell on day: " + solution[i].sell);
            }

    }

    public static void main(String[] args) {
        StockMaxProfit stockMaxProfit = new StockMaxProfit(7);
        for (int val : stockMaxProfit.price)
            System.out.print(val + ", ");
        System.out.println();
        stockMaxProfit.maxProfit();
    }
}
