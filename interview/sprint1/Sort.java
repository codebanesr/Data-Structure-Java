package interview.sprint1;

import java.util.Arrays;

public class Sort {
  public static void main(String args[]) {
    int arr1[] = {1,5,3,8,5,2};
    insertionSort(arr1);
    System.out.println(Arrays.toString(arr1));


    int arr2[] = {1,5,3,8,5,2};
    Heap h = new Heap(arr2);
    for(int i=0; i<arr2.length; i++) {
      System.out.print(h.extractMax() + " ");
    }
  }

  public static void insertionSort(int arr[]) {
    for(int i=1; i<arr.length; i++) {
      int root = arr[i];
      int j = i - 1;
      while(j>=0 && arr[j]>root){
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = root;
    }
  }
}


class Heap {
  int arr[];
  int size;
  public Heap(int arr[]) {
    this.arr = arr;
    this.size = arr.length;
    this.buildHeap(arr);
  }
  public void swap(int i, int maxIndex) {
    int temp = arr[maxIndex];
    arr[maxIndex] = arr[i];
    arr[i] = temp;
  }

  public void heapify(int i) {
    int left = 2 * i + 1;
    int right = left + 1;
    int index_of_max_element = i;

    if (left < size && arr[left] > arr[index_of_max_element]) {
      index_of_max_element = left;
    }

    else if (right < size && arr[right] > arr[index_of_max_element]) {
      index_of_max_element = right;
    }

    swap(i, index_of_max_element);
    if (index_of_max_element != i) {
      // heapify the position where exchange occured, not the root element. 
      heapify(index_of_max_element);
    }
  }

  public void buildHeap(int arr[]) {
    for(int i=arr.length/2-1; i>=0; i--) {
      heapify(i);
    }
  }


  public int extractMax() {
    int max = arr[0];
    arr[0] = arr[--size];
    
    // heapify 0th index not the element
    heapify(0);
    return max;
  }
}