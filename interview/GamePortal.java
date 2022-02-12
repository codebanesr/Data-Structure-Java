import java.util.*;

class Item {
    int timestamp, score;
    String userid;

    Item(String userid, int timestamp, int score) {
        this.userid = userid;
        this.timestamp = timestamp;
        this.score = score;
    }
}

public class GamePortal {
    static int total = 0;

    Queue<Item> q;

    public GamePortal() {
        q = new LinkedList<>();
    }


    public int insertItem(Item item) {
        q.add(item);
        total += item.score;
        return item.score;
    }

    // Thread that calls it at regular intervals and then we call this method just before
    // trying to fetch the score
    public void updateQueueAndGetScore() {
        while (!q.isEmpty()) {
            Item item = q.peek();
            if (item.timestamp < new Date().getTime() - 3600) {
                total -= item.score;
                q.remove();
            } else {
                break;
            }
        }
    }
    
    public int updateQueueAndGetScore(int timestamp) {
        while (!q.isEmpty()) {
            Item item = q.peek();
            if (item.timestamp < timestamp - 3600) {
                total -= item.score;
                q.remove();
            } else {
                break;
            }
        }
        
        return total;
    }
    public static void main(String[] args) {
        GamePortal gp = new GamePortal();
        gp.insertItem(new Item("U1", 123400, 2));
        gp.insertItem(new Item("U2", 124400, 3));
        gp.insertItem(new Item("U1", 124500, 2));
        gp.insertItem(new Item("U3", 125400, 4));

        System.out.println(gp.updateQueueAndGetScore(125500));
    }
}
