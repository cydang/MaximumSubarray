package cs146F20.dang.project2;

/**
 * Class to run Kadane's algorithm to find the maxsubarray in a given array and generate an output array that displays the maxSum and index bounds of the maxsubarray
 * @author chloedang
 *
 */
public class Kadane {
	
	int[] output; //instantiate output array of length 3
	private int maxSum; //instantiate maxSum to 0
	private int arrive; //instantiate day of arrival
	private int depart;//instantiate day of departure
	
	/**
	 * Kadane constructor to initialize variables
	 */
	public Kadane() {
		
		output = new int[3]; //initalize output array of length 3
		maxSum = 0;	//initialize maxSum to 0
		
		//note: arrive and depart correspond to the day, not the array index; i.e. array index = 0 --> day 1
		arrive = -1; //initialize day of arrival to -1
		depart = -1; //initialize day of departure to -1
		
	}
	
	/**
	 * Generates an output array that displays the [maxSum, arrival day, departure day] of the array passed as to this method as a parameter
	 * @param arr Array to call kadane's algorithm on to find max subarray
	 * @return int[] array that corresponds to [maxSum, arrival day, departure day]
	 */
	public int[] KdOutputArray(int[] arr) {
		maxSum = kadane(arr);
		output[0] = maxSum;
		output[1] = arrive;
		output[2] = depart;
		return output;
	}
	
	/**
	 * kadane's algorithm that follows O(n)
	 * @param arrNum Array to call kadane's algorithm on to find max subarray
	 * @return int maxSum amongst all the possible subarrays
	 */
	public int kadane(int[] arrNum) {
		
		int n = arrNum.length; //initialize the length of the array passed as parameter
		int maxTemp = 0; //initialize a temp variable to store a sum to compare it with the maxSum and/or 0
		int tempArrive = 0; //initialize a temp arrival day 
		
		/*keep only positive contiguous summations, kept in maxTemp, that are computed by iterating through all elements and 
		 * adding one element each iteration until the greatest maxTemp value is found to then assign it to maxSum
		 */
		for (int i = 0; i < n; i++) {
			
			maxTemp += arrNum[i];
			
			//if maxTemp is a negative number, reset maxTemp to 0 and increment the arrival day
			if (maxTemp < 0) { 
				maxTemp = 0;
				arrive = i+1;
			}
			
			//if maxTemp is greater than maxSum, update maxSum with value stored in maxTemp and increment departure day and update tempArrival
			if (maxSum < maxTemp) {
				maxSum = maxTemp;
				depart = i+1;
				tempArrive = arrive+1; 
			}
		}
		
		arrive = tempArrive;
		
		//condition statement to set arrival day to -1 for when all numbers are negative or 0, making maxSum = 0
		if (maxSum == 0) {
			arrive = -1;
		}
		
		//condition statement to set arrival day to 1 for when all numbers are positive
		if (maxSum !=0 && arrive == 0) {
			arrive = 1;
		}
		
		return maxSum;
	}
}
