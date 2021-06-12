// import java.io.IOException;
// import java.util.Arrays;
// import java.util.Scanner;

// class Heap {
//     int arr[];
//     int size;

//     public Heap(int arr[]) {
//         this.arr = arr;
//         this.size = arr.length;
//         this.buildHeap();
//     }

//     // find the index of the largest element in root, lc, rc -> store it in a var
//     // max_index
//     // call the swap root, max_index
//     public void heapify(int root) {
//         int max_index = root;
//         int child = 2 * root + 1;

//         if (child < this.size) {
//             if (this.arr[child] > this.arr[max_index]) {
//                 max_index = child;
//             }
//         }

//         if (child + 1 < this.size) {
//             if (this.arr[max_index] < this.arr[child + 1]) {
//                 max_index = child + 1;
//             }
//         }

//         this.swap(max_index, root);

//         if (max_index != root)
//             this.heapify(max_index);
//     }

//     void swap(int a, int b) {
//         int temp = this.arr[a];
//         this.arr[a] = this.arr[b];
//         this.arr[b] = temp;
//     }

//     void buildHeap() {
//         // size/2-1 because we dont want to check the leaf nodes for max heap property
//         for (int i = this.size / 2 - 1; i >= 0; i--) {
//             heapify(i);
//         }
//     }

//     int extractRoot() {
//         int max = this.arr[0];
//         this.arr[0] = this.arr[--this.size];
//         this.heapify(0);
//         return max;
//     }

//     int[] getHeap() {
//         return this.arr;
//     }

//     int getSize() {
//         return this.size;
//     }
// }

// class HeapSort {
//     public static void main(String args[]) throws IOException {
//         Scanner x = new Scanner(System.in);
//         System.out.println("Enter numbers for creating heap");
//         String line = x.nextLine();
//         int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
//         Heap heap = new Heap(arr);

//         System.out.println(Arrays.toString(heap.getHeap()));

//         while (heap.getSize() > 0) {
//             System.out.print(heap.extractRoot() + " ");
//         }
//         x.close();
//     }
// }