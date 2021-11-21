package interview.crackingthecodinginterview.Dynamic;

public class TowerOfHanoi {
    public static void main(String[] args) {
        move(3, 1, 2, 3);
    }
    

    // move n from source using buffer to destination
    public static void move(int n, int s, int buffer, int d) {
        if (n <= 0)
            return;
        move(n - 1, s, d, buffer);
        System.out.println(s + " -> " + buffer);
        move(n - 1, s, buffer, d);
    }
}
