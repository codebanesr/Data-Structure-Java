package practicesection;

import java.util.*;
class Job {
    int deadline, profit;

    Job(int task, int deadline, int profit) {
        this.deadline = deadline;
        this.profit = profit;
    }
}


public class JobScheduling {
    public static void main(String[] args) {
        Job[] list = { new Job(1, 9, 15), new Job(2, 2, 2), new Job(3, 5, 18), new Job(4, 7, 1), new Job(5, 4, 25),
                new Job(6, 2, 20), new Job(7, 5, 8), new Job(8, 7, 10), new Job(9, 4, 12), new Job(10, 3, 5) };

        int totalSlots = 15;
        int result = findTotalProfit(list, totalSlots);

        System.out.println(result);
    }

    public static int findTotalProfit(Job[] jobs, int totalSlots) {
        boolean isOccupied[] = new boolean[totalSlots];
        int total = 0;
        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1.profit, j2.profit));
        for (int i = jobs.length - 1; i >= 0; i--) {
            for (int j = jobs[i].deadline - 1; j >= 0; j--) {
                if (!isOccupied[j]) {
                    total += jobs[i].profit;
                    isOccupied[j] = true;
                    // break out of this loop, otherwise we can count the same
                    // job for previous slots as well
                    break;
                }
            }
        }

        return total;
    }

}
