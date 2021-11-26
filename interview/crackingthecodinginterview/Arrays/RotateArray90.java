package interview.crackingthecodinginterview.Arrays;

class RotateArray90 {
    public static void main(String args[]) {
        int arr[][] = { 
                { 1, 2, 3, 4 }, 
                { 5, 6, 7, 8 }, 
                { 3, 4, 8, 9 }, 
                { 2, 6, 5, 9 } 
            };

        rotate90(arr);
        print(arr);
    }

    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public static void rotate90(int arr[][]) {
        transpose(arr);

        // column i <--> column[n-i]
        interchangeColumns(arr);
    }

    public static void transpose(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            // dont start j from 0 otherwise in the end we will again get the original array
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    // rci -> right column index
    public static void interchangeColumns(int arr[][]) {
        for (int row = 0; row < arr.length; row++) {
            int lci = 0;
            int rci = arr.length - 1;

            while (lci < rci) {
                int temp = arr[row][lci];
                arr[row][lci] = arr[row][rci];
                arr[row][rci] = temp;
                rci--;
                lci++;
            }
        }
    }
}
