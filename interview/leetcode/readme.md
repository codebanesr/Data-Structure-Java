<!-- zalando -->
Maximum Ascending Subarray Sum
maxDiffBetween2Elements

max 
total 
sum <->
addition somewhere in the subarray



public static int somemethod() {
    int total, max_, some more variables
    int someinitvalue = arr[...]
    for(int i=0; i<arr.length-1; i++) {
        local;

        if(sometjing happens) {
            ....
        }


        do someting here
    }


    return max or min of something here...., i used ternary but they used Math.max
}


1. max sum of substrings of length 2 in a string
2. possibly max diff b/w two elements such that larger element appears after the smaller element
3. Min cost to split chain into three pieces such that the cost is minimised, cant have adjacent links


```c++
int maximumDifference(vector<int>& nums) {
	int diff = INT_MIN;
	int max_diff = INT_MIN;
	int min_value = nums[0];

	for(int i = 0; i<nums.size()-1; i++){
		if(nums[i] < min_value) min_value = nums[i];
		if(min < nums[i+1]){
			diff = nums[i+1] - min_value;    
		} else {
			diff = -1;
		}
		if(diff>max_diff) max_diff = diff;
	}
	return max_diff;
}


### Practise kadane's algorithm and hope for the best

```java
public int maxDiffBetween2Elements(int arr[], int size) {
    int max_diff = -1;
    int min_element = arr[0];
    for (int i = 0; i < size; i++) {
        if (arr[i] - min_element > max_diff) {
            max_diff = arr[i] - min_element;
        }
        if (arr[i] < min_element) {
            min_element = arr[i];
        }
    }

    return max_diff;
}