import java.util.*;
public class SeatManager {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    int N;

    public SeatManager(int n) {
        N = n;
        for (int i = 1; i <= N; i++) {
            pq.add(i);
        }

    }

    // O(logn)
    public void unreserveSeat(int index) {
        if(pq.contains(index)) {
            System.out.println("This seat is already reserved");
        }
        // check if it is reserved already
        pq.add(index);
    }

    // O(1)
    public int reserve() {
        if (pq.size() == 0) {
            System.out.println("Can't reserve more seats");
        }

        return pq.remove();
    }

    public static void main(String[] args) {
        SeatManager sm = new SeatManager(5);
        System.out.println(sm.reserve());
        System.out.println(sm.reserve());
        sm.unreserveSeat(2);
        System.out.println(sm.reserve());
        System.out.println(sm.reserve());
        System.out.println(sm.reserve());
        System.out.println(sm.reserve());
        sm.unreserveSeat(5);
    }
}
