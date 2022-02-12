import java.util.*;

public class Elevator {
    // class ElevatorPair {
    //     int floor;
    //     boolean isPressed;

    // }
    private static int currentFloor;

    private static String elevator_current_direction;

    public static void main(String[] args) {

        List<Integer> up_requests = new LinkedList();
        List<Integer> down_requests = new LinkedList();

        if (elevator_current_direction == "down") {
            for (Integer req : up_requests) {

            }
        } else if (elevator_current_direction == "up") {
            for (Integer req : up_requests) {

            }
        }

    }
    

    public int processRequest

    // true->up; false -> down
    public void travel(boolean direction, int pressed_floor, LinkedList<Integer> up, LinkedList<Integer> down) {

    }

    private void changeDirection(boolean change_direction) {
        // 
    }

    public void setFloor(int floor) {
        currentFloor = floor;
    }

    public int getFloor(int floor) {
        return currentFloor;
    }
}
