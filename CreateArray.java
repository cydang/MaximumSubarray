package cs146F20.dang.project2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class contains method to create arrays from given test cases in a file and contains method to generate arrays of size n with random integers
 * @author chloedang
 *
 */
public class CreateArray {
	
	public ArrayList<Integer> intList; //instantiate arraylist to hold parsed integers from array of strings containing the numbers from the txt file
	int[] intArray; //instantiate array to hold integers transfered from arraylist integer elements
	private Random random = new Random();	// pseudorandomizer
	
	/**
	 * constructor to initialize variables
	 */
	public CreateArray() {
		intList = new ArrayList<Integer>(); 
		intArray = new int[intList.size()];
	}
	
	//parsing the String numbers in String array into integers and adding to ArrayList of integers
		public ArrayList<Integer> arrayToArrayList(String[] arr) {
			for (int i = 0; i < arr.length; i++) {
				int val = Integer.parseInt(arr[i]);
				intList.add(val);
			}
			return intList;
		}
		
	//convert ArrayList of integers to array of integers
	public int[] listToArray(ArrayList<Integer> list) {
		intArray = new int[list.size()];
		for (int j = 0; j < list.size(); j++) { 
			  
            // Assign each value in ArrayList list to Integer array intArray
            intArray[j] = list.get(j); 
        }
		return intArray;
	}
	
	/**
	 * Generates an integer array of a test case in the given file maxSumtest.txt
	 * @param n -- test case # in given file maxSumtest.txt
	 * @return integer array of a test case 
	 * @throws IOException
	 */
	public int[] createArray(int n) throws IOException{
	   
		BufferedReader br = new BufferedReader (new FileReader ("maxSumtest.txt"));
		n = ((2*n)-2); //formula to get the line before the line that the test case # is located at
		
		//read file up to the line before the desured line that the test case is located at
		for (int i = 0; i < n; i++) {
			br.readLine ();
		}
		
		br.skip(1); 	//skip the first character in the line
		String line = br.readLine (); 	//read the test case line
		String[] strArray = line.trim().split("\\s+"); 	//split each number in the test case in the file into individual elements in a String array
		
		//parsing the String numbers in String array into integers and adding to ArrayList of integers
		intList = arrayToArrayList(strArray);
		
		//convert ArrayList of integers to array of integers
		intArray = listToArray(intList);
	
		br.close();
		//System.out.println(Arrays.toString(intArray));
		return intArray;
	}
	
	/**
	 * Generates random array of integers
	 * @param n -- input array size
	 * @return integer array of random integers
	 */
	public int[] randomArray(int n) {
	
		//Random random = new Random();
		int[] arr = new int[n];
		for (int i =0; i < arr.length; i++) {
			arr[i] = (random.nextInt(20)-10); //generates integers ranging [-10,10]
		}
		return arr;
	}
	
	
	
}
