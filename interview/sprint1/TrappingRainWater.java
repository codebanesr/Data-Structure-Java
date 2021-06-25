package interview.sprint1;

public class TrappingRainWater {
  public static void main(String args[]) {
    int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
    int trapped = 0;
    for (int i = 1; i < arr.length; i++) {
      LRW lrw = findLhRhWidth(arr, i);

      if (lrw.lh == -1 || lrw.rh == -1) {
        // pass
      } else {
        System.out.println(lrw + " for index: " + i);
        trapped += (Math.min(lrw.lh, lrw.rh) - arr[i]) * lrw.width;
      }
    }
    System.out.println(trapped);
  }

  public static LRW findLhRhWidth(int arr[], int i) {
    LRW lrw = new LRW();

    int rh = -1;
    int width = 0;
    for (int j = i + 1; j < arr.length; j++) {
      width++;
      if (arr[j] >= arr[i]) {
        rh = arr[j];
        break;
      }
    }
    lrw.setRh(rh);

    int lh = -1;
    for (int j = i - 1; j >= 0; j--) {
      width++;
      if (arr[j] >= arr[i]) {
        lh = arr[j];
        break;
      }
    }
    lrw.setLh(lh);
    lrw.setWidth(width);
    return lrw;
  }
}

class LRW {
  int lh, rh, width;

  public void setLh(int lh) {
    this.lh = lh;
  }

  public void setRh(int rh) {
    this.rh = rh;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public String toString() {
    return this.lh + ", " + this.rh + ", " + this.width;
  }
}
