package interview.crackingthecodinginterview.Dynamic;
import java.util.*;


class Box {
    int l,b,h;
    boolean isStacked = false;
    Box(int l, int b, int h) {
        this.b = b;
        this.l = l;
        this.h = h;
    }
}


public class StackOfBoxes {
    public static void main(String[] args) {
        Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        
        arr[2] = new Box(4, 5, 6);
        arr[1] = new Box(1, 2, 3);
        arr[3] = new Box(10, 12, 32);
        int result = calculateMaxHeight(arr, 0, arr.length, 0);

        System.out.println(result);
    }

    public static Stack<Box> stack = new Stack<>();
    public static int calculateMaxHeight(Box[] boxes, int remaining, int tlindex) {
        if(remaining <= 0) {
            return 0;
        }

        Box basePlate = boxes[tlindex];
        // take
        int takeHeight = basePlate.h + calculateMaxHeight(boxes, remaining --, tlindex+1);
        int leaveHeight = calculateMaxHeight(boxes, remaining --, tlindex);
        
        
        return Math.max(takeHeight, leaveHeight);
    }
}
