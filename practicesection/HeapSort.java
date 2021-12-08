class Heap {
    int arr[];
    int size;
    Heap(int arr[]) {
        this.arr = arr;
        size = arr.length;
        this.buildHeap();
    }
    

    private void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            this.heapify(i);
        }
    }


    private void heapify(int root) {
        int left = 2 * root+1;
        int right = 2 * root + 2;

        int smallestIndex = root;

        if (left < size && arr[smallestIndex] > arr[left]) {
            smallestIndex = left;
        }

        if (right < size && arr[smallestIndex] > arr[right]) {
            smallestIndex = right;
        }

        swap(root, smallestIndex);

        if (smallestIndex != root) {
            heapify(smallestIndex);
        }
    }
    
    int extractRoot() {
        int element = arr[0];
        arr[0] = arr[--size];
        heapify(0);

        return element;
    }

    void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = { 4, 5, 3, 6, 1, 8, 8, 3, 4, 1 };


        Heap minHeap = new Heap(arr);
        while (minHeap.size != 0) {
            System.out.print(minHeap.extractRoot() + ", ");
        }
    }
}
