package DataStructures;

import java.util.PriorityQueue;

public class Heap {
  public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    int c = 100;
    while (c>0) {
      pq.add((int)Math.ceil(Math.random()*100));
      c--;
    }

    c = 100;
    while(c>0) {
      c--;
      System.out.print(pq.poll() + " ");
    }
  }
}
