package cs146F20.dang.project2;

/**
 * Class to run divide and conquer algorithm to find the maxsubarray in a given array and generate an output array that displays the maxSum and index bounds of the maxsubarray
 * @author chloedang
 *
 */
public class DivideAndConquer {
	

	int[] output; //instantiate output array of length 3
	private int maxSum; //instantiate maxSum to 0
	private int arrive; //instantiate day of arrival
	private int depart;//instantiate day of departure
	
	/**
	 * Divide and Conquer constructor to constructor to initialize variables
	 */
	public DivideAndConquer() {
		
		output = new int[3]; //initialize output array of length 3
		maxSum = 0;	//initialize maxSum to 0
		
		//note: arrive and depart correspond to the day, not the array index; i.e. array index = 0 --> day 1
		arrive = -1; //initialize day of arrival to -1
		depart = -1; //initialize day of departure to -1
		
	}
	
	/**
	 * Generates an output array that displays the [maxSum, arrival day, departure day] of the array passed as to this method as a parameter
	 * @param arrArray to call divide and conquer algorithm on to find max subarray
	 * @param low index
	 * @param high index
	 * @return int[] array that corresponds to [maxSum, arrival day, departure day]
	 */
	public int[] DncOutputArray(int[] arr, int low, int high) {
		
		int mid = (low+high)/2; //mid index of array
		maxSum = maxSubarray(arr, low, high);
		
		//accounts for test cases where the maxSum is the first element in the array/all negative or 0s with a positive first element
		if (maxSum == arr[0]) {
			arrive = 1;
			depart = 1;
		}
		
		//accounts for test cases where the maxSum is the last element in the array/all negative or 0s with a positive last element
		if (maxSum == arr[arr.length-1]) {
			arrive = arr.length;
			depart = arr.length;
		}
		
		//accounts for test cases with all negative numbers or all negative or 0s
		if (maxSum <= 0) {
			maxSum = 0;
			arrive = -1;
			depart = -1;
		}
		
		//accounts for test cases where the max subarray is the single element at the mid index
		if (maxSum == arr[mid] && arrive == -1 && arrive == -1) {
			arrive = mid+1;
			depart = mid+1;
		}
		
		//assigns maxSum, arrive index, and depart index to respective indexes in output array
		output[0] = maxSum;
		output[1] = arrive;
		output[2] = depart;
		return output;
	}
	
	/**
	 * Finds the maximum subarray that crosses the midpoint
	 * @param arrNum
	 * @param low
	 * @param mid
	 * @param high
	 * @return max cross subarray sum
	 */
	public int maxCrossSubarray(int[] arrNum, int low, int mid, int high) {
		
		int sum = 0;
		
		int leftSum = 0;
		//for elements left side of mid, finds leftSum and max-left index which corresponds to the arrival day
		for (int i = mid; i >= low; i--) {
			sum += arrNum[i];
			if (sum > leftSum) {
				leftSum = sum;
				arrive = i+1;
			}
		}
		
		sum = 0;
		int rightSum = 0;
		//for elements right side of mid, finds rightSum and max-right index which corresponds to the departure day
		for (int j = mid+1; j <= high; j++) {
			sum += arrNum[j];
			if (sum > rightSum) {
				rightSum = sum;
				depart = j+1;
			}
		}
		
		//return sum of the leftSum and rightSum to get the sum of the cross subarray
		return (leftSum + rightSum);
	}
	
	/**
	 * Returns sum of the maximum sum subarray using recursive calls
	 * @param arrNum
	 * @param low
	 * @param high
	 * @return sum of maximum subarray
	 */
	public int maxSubarray(int[] arrNum, int low, int high) {
		
		int leftSum; //instantiate variable to store sum of subarrays left of the midpoint
		int rightSum; //instantiate variable to store sum of subarrays right of the midpoint
		int crossSum; //instantiate variable to store sum of subarrays that cross the midpoint
		int leftLow = 1; //initialize first index of the subarrays left of the midpoint
		int leftHigh = 1; //initialize last index of the subarrays left of the midpoint
		int rightLow; //initialize first index of the subarrays right of the midpoint
		int rightHigh; //initialize last index of the subarrays right of the midpoint
		int crossLow; //initialize first index of the subarrays crossing the midpoint
		int crossHigh; //initialize last index of the subarrays crossing the midpoint
		
		//base case: only one element
		if (low == high) {
			return arrNum[low];	
		}
		else {
			int mid = (low+high)/2; //intialize midpoint

			//Case 1 T(n/2) maxSubarray left of the midpoint
			leftSum = maxSubarray(arrNum, low, mid);
			leftLow = arrive; leftHigh = depart;
			
			//Case 2 T(n/2) maxSubarray right of the midpoint
			rightSum = maxSubarray(arrNum, mid+1, high);
			rightLow = arrive; rightHigh = depart;
			
			//Case 3 O(n) maxSubarray that crosses through the midpoint
			crossSum = maxCrossSubarray(arrNum, low, mid, high);
			crossLow = arrive; crossHigh = depart;
			
			//if leftSum >= rightSum and crossSum, return leftSum as the maxSum
			if ((leftSum >= rightSum) && (leftSum >= crossSum)) {
				arrive = leftLow; depart = leftHigh;
				return leftSum;
			}
			
			//if rightSum >= leftSum and crossSum, return righttSum as the maxSum
			else if ((rightSum >= leftSum) && (rightSum >= crossSum)) {
				arrive = rightLow; depart = rightHigh;
				return rightSum;
			}
			
			//return crossSum as the maxSum
			else {
				arrive = crossLow; depart = crossHigh;
				return crossSum;
			}
		}
	
	}
}
