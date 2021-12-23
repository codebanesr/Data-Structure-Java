import java.util.HashSet;

public class MinCoinChange {
    public static void main(String[] args) {
        int coins[] =  {9, 6, 5, 1};
        int V = 11;


        MinCoinChange mcc = new MinCoinChange();
        System.out.println("Minimum coins required is "+ mcc.minChange(coins, V)); 
    }
    public int minChange(int coins[], int amount) {
        HashSet<Integer> removed = new HashSet<>();
        int result = minChangeUtil(coins, amount, removed);
        return result;
    }


    // there is a problem with integer overflow in this solution, thats why
    // i didn't assign total:=Integer.MAX_VALUE;;;;
    public int minChangeUtil(int coins[], int remAmount, HashSet<Integer> removed) {
        if (remAmount == 0) {
            return 0;
        }

        int total = 9999;
        for (int i = 0; i < coins.length; i++) {
            if (removed.contains(i)) {
                continue;
            }
            if (remAmount >= coins[i]) {
                total = 1 + Math.min(minChangeUtil(coins, remAmount - coins[i], removed), total);
            }

            removed.add(i);
            total = Math.min(minChangeUtil(coins, remAmount, removed), total);
            removed.remove(i);
        }


        System.out.println("total :: " + total);
        return total;
    }

}
