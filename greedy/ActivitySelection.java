package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;


class Pair {
    private int start, end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return start + " - " + end;
    }
}


public class ActivitySelection {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        Pair activities[] = new Pair[11];
        System.out.println("Enter start and end for each activity on separate lines");
        for (int i = 0; i < 11; i++) {
            String se[] = x.nextLine().split(",");
            activities[i] = new Pair();
            activities[i].setStart(Integer.parseInt(se[0]));
            activities[i].setEnd(Integer.parseInt(se[1]));
        }

        Arrays.sort(activities, (y, z) -> {
            return Integer.compare(y.getEnd(), z.getEnd());
        });

        LinkedList<Pair> list = new LinkedList<Pair>();
        list.push(activities[0]);
        System.out.println("––––––––––––––––––––––––");
        for (int i = 1; i < activities.length; i++) {
            Pair lastPushed = list.peekFirst();
            if (lastPushed.getEnd() <= activities[i].getStart()) {
                list.push(activities[i]);
            }
        }
        for (Pair pair : list) {
            System.out.println(pair.toString());
        }

        System.out.println("END");
        x.close();
    }
}
