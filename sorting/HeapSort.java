package sorting;
class Heap {
    int arr[];
    int size;
    public Heap(int arr[]) {
        this.arr = arr;
        this.size = arr.length;


        buildHeap();
    }


    void buildHeap() {
        for(int i=this.size/2-1; i>=0; i--) {
            heapify(i);
        }
    }


    void heapify(int root_index) {
        int max_index = root_index;
        int child = root_index * 2 + 1;
        // size is not the same as arr.length .... size will change if elements
        // are taken out of the heap
        if(child<size) {
            if(arr[child] > arr[max_index]) {
                max_index = child;
            }
        }

        if(child+1<size) {
            if(arr[child+1]>arr[max_index]) {
                max_index = child+1;
            }
        }


        swap(arr, root_index, max_index);
        if(root_index!=max_index) {
            heapify(max_index);
        }
    }


    void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    int extractRoot() {
        int max = arr[0];
        arr[0] = arr[--size];
        heapify(0);


        return max;
    }

    int getSize() {
        return size;
    }
}


class HeapSort {
    public static void main(String args[]) {
        int arr[] = { 4, 5, 3, 6, 1, 8, 8, 3, 4, 1 };
        Heap h = new Heap(arr);

        while(h.getSize()>0) {
            System.out.print(h.extractRoot()+", ");
        }
    }
}