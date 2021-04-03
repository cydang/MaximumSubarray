package cs146F20.dang.project2;

/**
 * Class to run brute force algorithm to find the maxsubarray in a given array and generate an output array that displays the maxSum and index bounds of the maxsubarray
 * @author chloedang
 *
 */
public class BruteForce {
	
	int[] output; //instantiate output array of length 3
	private int maxSum; //instantiate maxSum to 0
	private int arrive; //instantiate day of arrival
	private int depart;//instantiate day of departure
	
	/**
	 * Brute force constructor to initialize variables
	 */
	public BruteForce() {
		
		output = new int[3]; //initialize output array of length 3
		maxSum = 0;	//initialize maxSum to 0
		
		//note: arrive and depart correspond to the day, not the array index; i.e. array index = 0 --> day 1
		arrive = -1; //initialize day of arrival to -1
		depart = -1; //initialize day of departure to -1
		
	}
	
	/**
	 * Generates an output array that displays the [maxSum, arrival day, departure day] of the array passed as to this method as a parameter
	 * @param arr Array to call brute force algorithm on to find max subarray
	 * @return int[] array that corresponds to [maxSum, arrival day, departure day]
	 */
	public int[] BfOutputArray(int[] arr) {
		maxSum = bruteForce(arr); //calls the bruteForce(int[] arr] method to get the maxSum
	
		//assigns maxSum, arrive index, and depart index to respective indexes in output array
		output[0] = maxSum; 
		output[1] = arrive;
		output[2] = depart;
		return output;
	}
	
	/**
	 * brute force algorithm that follows O(n^2)
	 * @param arrNum Array to call brute force algorithm on to find max subarray
	 * @return int maxSum amongst all the possible subarrays
	 */
	public int bruteForce(int[] arrNum) {
		
		int n = arrNum.length; //initialize the length of the array passed as parameter
		int maxTemp = 0; //initialize a temp variable to store a sum to compare it with the maxSum
		
		//start at all position indexes and calculate running sums of each subarray
		for (int i = 0; i < n; i++) {
			maxTemp = 0;
			for (int j = i; j < n; j++) {
				maxTemp += arrNum[j];
				//if current maxTemp sum is greater than maxSum, update maxSum and arrive and depart days
				if (maxTemp > maxSum) {
					maxSum = maxTemp;
					arrive = i+1;
					depart = j+1;
				}
			}
		}
		
		return maxSum;
	}
}
