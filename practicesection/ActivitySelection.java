
/* 
    https://www.studytonight.com/data-structures/activity-selection-problem 
    selection of non-conflicting activities that needs to be executed by a single person or machine in a given time frame.
*/
import java.util.*;
class Activity {
    int startTime, endTime;

    Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String toString() {
        return "start -> " + this.startTime + ", " + "end -->" + this.endTime;
    }
}

// sort based on end time, push first element since it is not dependent on
// any other element. From next element onwards you need to check if
// previous job has been finished
public class ActivitySelection {
    public static void main(String[] args) {
        int s[] = { 1, 3, 0, 5, 8, 5 };
        int f[] = { 2, 4, 6, 7, 9, 9 };

        Activity activities[] = new Activity[s.length];
        for (int i = 0; i < s.length; i++) {
            activities[i] = new Activity(s[i], f[i]);
        }

        Arrays.sort(activities, (a1, a2) -> Integer.compare(a1.endTime, a2.endTime));
        Stack<Activity> stack = new Stack<>();
        stack.push(activities[0]);
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].startTime >= stack.peek().endTime) {
                stack.push(activities[i]);
            }
        }


        for (Activity a : stack) {
            System.out.println(a);
        }
    }
}
