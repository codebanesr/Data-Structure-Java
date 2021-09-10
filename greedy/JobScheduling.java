package greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Job {
    int deadline;
    int profit;
    int task;

    public Job(int task, int deadline, int profit) {
        this.task = task;
        this.deadline = deadline;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return task + " " + deadline + " "+ profit;
    }
}
public class JobScheduling {
    public static void main(String[] args) {
        List<Job> list = Arrays.asList(new Job(1, 9, 15), new Job(2, 2, 2), new Job(3, 5, 18), new Job(4, 7, 1),
                new Job(5, 4, 25), new Job(6, 2, 20), new Job(7, 5, 8), new Job(8, 7, 10), new Job(9, 4, 12),
                new Job(10, 3, 5));

        int totalSlots = 15;
        int result = scheduleJobs(list, totalSlots);

        System.out.println(result);
    }

    private static int scheduleJobs(List<Job> list, int totalSlots) {
        Collections.sort(list, (x, y) -> y.profit - x.profit);

        boolean isOccupied[] = new boolean[totalSlots];
        int result = 0;
        for (Job job : list) {
            // remember that job.deadline - 1, reason :: 
            // if job ends at 10 it has to start at 9
            for (int i = job.deadline - 1; i >= 0; i--) {
                if (!isOccupied[i]) {
                    isOccupied[i] = true;
                    result += job.profit;
                    System.out.println(job.toString());
                    break;
                }
            }
        }

        return result;
    }
}
