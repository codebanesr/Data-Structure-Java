package interview.sprint1;


public class BuyAndSellKTransaction {
  public static void main(String args[]) {
    // add a trailing 0 at the end to get the correct answer, because you should sell it at
    // the last day anyways
    int arr[] = { 100, 180, 260, 310, 40, 535 };
    int buyingPrice = arr[0];
    int profit = 0;
    int sellingPrice = arr[0];
    for(int i=1; i<arr.length; i++) {
      if (arr[i] > buyingPrice) {
        sellingPrice = arr[i];
      } else {
        profit += (sellingPrice-buyingPrice);
        System.out.println(buyingPrice + "," + sellingPrice);
        
        // reset condition
        buyingPrice = arr[i];
        sellingPrice = arr[i];
      }
    }


    // for the last element, if sellingPrice > buyingPrice
    profit += sellingPrice - buyingPrice;
    System.out.println(profit);
  }
}
