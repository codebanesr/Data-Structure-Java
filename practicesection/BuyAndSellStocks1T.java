public class BuyAndSellStocks1T {
    class Pair {
        int index, value;
        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        BuyAndSellStocks1T b = new BuyAndSellStocks1T();
        int price[] = { 1, 2, 90, 10, 110 };
        int result = b.solve(price);
        System.out.println(result);
    }
    

    public int solve(int price[]) {
        int N = price.length;
        return solveUtil(price, N);
    }


    public int solveUtil(int price[], int N) {
        Pair minsofar = new Pair(0, price[0]);
        int profit = 0;

        for (int i = 1; i < price.length; i++) {
            if (price[i] < minsofar.value) {
                minsofar = new Pair(i, price[i]);
            }

            else if (price[i] > minsofar.value) {
                profit = Math.max(profit, price[i] - minsofar.value);
            }
        }

        return profit;
    }    
}
