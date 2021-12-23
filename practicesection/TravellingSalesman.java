import java.util.HashSet;

public class TravellingSalesman {

    public static void main(String[] args) {
        
    }



    public static int Solution(int paths[][]) {
        HashSet<Integer> results = new HashSet<>();
        int total = Integer.MAX_VALUE;
        for (int i = 0; i < paths.length; i++) {
            total = Math.min(findMin(paths, results, i), total);
        }
        return total;
    }
    


    public static int findMin(int paths[][], HashSet<Integer> result, int currentVertex) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < paths.length; i++) {
            result.remove(i);
            int r = paths[currentVertex][i] + findMin(paths, result, i);
            min = Math.min(min, r);

            result.add(i);
        }
        result.remove(currentVertex);

        return min;
    }
}
