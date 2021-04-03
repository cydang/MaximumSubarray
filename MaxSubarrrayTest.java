package cs146F20.dang.project2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Arrays;

/**
 * JUnit class to run test cases and calculate running times of each algorithm
 * @author chloedang
 *
 */
class MaxSubarrrayTest {

	CreateArray createArrayTest; //instantiate a CreateArray object to use its methods 
	int[] actualArray; 			 //instantiate to store array generated from createArray(int n) method in CreateArray class
	int[] expectedReturnedArray; //instantiate to store the expected output array in the form [maxSum, arrival day, departure day]
	int[] actualReturnedArray; //instantiate to store the actual output array in the form [maxSum, arrival day, departure day]
	
	RunTime bfRunTimeTest; //instantiate RunTime object to calculate the runtime of brute force algorithm 
	RunTime dncRunTimeTest; //instantiate RunTime object to calculate the runtime of divide and conquer algorithm 
	RunTime kdRunTimeTest; //instantiate RunTime object to calculate the runtime of kadane's algorithm 
	BruteForce bfTest; //instantiate BruteForce object to call the brute force algorithm method
	DivideAndConquer dncTest; //instantiate DivideAndConquer object to call the divide and conquer algorithm method 	
	Kadane kdTest; //instantiate Kadane object to call the kadane's algorithm method 
		
	//Initialize variables
	@BeforeEach
	void setUp() throws Exception {
		createArrayTest = new CreateArray();
		bfRunTimeTest = new RunTime();
		dncRunTimeTest = new RunTime();
		kdRunTimeTest = new RunTime();
		bfTest = new BruteForce();
		kdTest = new Kadane();
		dncTest = new DivideAndConquer();
	}
	
	//Calculate algorithm runtimes for arrays of size 100
	@Test
	void RunTime100() throws IOException{
		System.out.println("For input size n=100, listed in the order: Brute Force, Divide and Conquer, Kadane, are as follows: ");
		System.out.println(bfRunTimeTest.bfRunTime(100));
		System.out.println(dncRunTimeTest.dncRunTime(100));
		System.out.println(kdRunTimeTest.kdRunTime(100));
	}
	
	//Calculate algorithm runtimes for arrays of size 200
	@Test
	void RunTime200() throws IOException{
		System.out.println("For input size n=200, listed in the order: Brute Force, Divide and Conquer, Kadane, are as follows: ");
		System.out.println(bfRunTimeTest.bfRunTime(200));
		System.out.println(dncRunTimeTest.dncRunTime(200));
		System.out.println(kdRunTimeTest.kdRunTime(200));
	}
	
	//Calculate algorithm runtimes for arrays of size 500
	@Test
	void RunTime500() throws IOException{
		System.out.println("For input size n=500, listed in the order: Brute Force, Divide and Conquer, Kadane, are as follows: ");
		System.out.println(bfRunTimeTest.bfRunTime(500));
		System.out.println(dncRunTimeTest.dncRunTime(500));
		System.out.println(kdRunTimeTest.kdRunTime(500));
	}
	
	//Calculate algorithm runtimes for arrays of size 1000
	@Test
	void RunTime1000() throws IOException{
		System.out.println("For input size n=1000, listed in the order: Brute Force, Divide and Conquer, Kadane, are as follows: ");
		System.out.println(bfRunTimeTest.bfRunTime(1000));
		System.out.println(dncRunTimeTest.dncRunTime(1000));
		System.out.println(kdRunTimeTest.kdRunTime(1000));
	}

	//Calculate algorithm runtimes for arrays of size 2000
	@Test
	void RunTime2000() throws IOException{
		System.out.println("For input size n=2000, listed in the order: Divide and Conquer, Kadane, are as follows: ");
		System.out.println(dncRunTimeTest.dncRunTime(2000));
		System.out.println(kdRunTimeTest.kdRunTime(2000));
	}
	
	//Calculate algorithm runtimes for arrays of size 5000
	@Test
	void RunTime5000() throws IOException{
		System.out.println("For input size n=5000, listed in the order: Divide and Conquer, Kadane, are as follows: ");
		System.out.println(dncRunTimeTest.dncRunTime(5000));
		System.out.println(kdRunTimeTest.kdRunTime(5000));
	}
	
	//Calculate algorithm runtimes for arrays of size 10000
	@Test
	void RunTime10000() throws IOException{
		System.out.println("For input size n=10000, listed in the order: Divide and Conquer, Kadane, are as follows: ");
		System.out.println(dncRunTimeTest.dncRunTime(10000));
		System.out.println(kdRunTimeTest.kdRunTime(10000));
	}
	
	
	/*test1(), test2(),..., test10() check if each algorithm returns an output array equal to the expected output array 
	 * containing [maxSum, arrive, depart] of the respective test case listed in maxSumtest.txt file
	 */
	//test case 1 in maxSumtest.txt file; output array should be [590, 78, 103]
	@Test
	void test1() throws IOException {
		actualArray = createArrayTest.createArray(1);
		expectedReturnedArray = new int[] {590, 78, 103};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		
	}
	
	//test case 2 in maxSumtest.txt file; output array should be [793, 51, 103]
	@Test
	void test2() throws IOException {
		actualArray = createArrayTest.createArray(2);
		expectedReturnedArray = new int[] {793, 51, 103};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		
	}
	
	//test case 3 in maxSumtest.txt file; output array should be [361, 101, 103]
	@Test
	void test3() throws IOException {
		actualArray = createArrayTest.createArray(3);
		expectedReturnedArray = new int[] {361, 101, 103};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case 4 in maxSumtest.txt file; output array should be [667, 61, 103]
	@Test
	void test4() throws IOException {
		actualArray = createArrayTest.createArray(4);
		expectedReturnedArray = new int[] {667, 61, 103};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case 5 in maxSumtest.txt file; output array should be [632, 55, 103]
	@Test
	void test5() throws IOException {
		actualArray = createArrayTest.createArray(5);
		expectedReturnedArray = new int[] {632, 55, 103};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case 2 in maxSumtest.txt file; output array should be [593, 65, 103]
	@Test
	void test6() throws IOException {
		actualArray = createArrayTest.createArray(6);
		expectedReturnedArray = new int[] {593, 65, 103};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case 2 in maxSumtest.txt file; output array should be [793, 51, 103]
	@Test
	void test7() throws IOException {
		actualArray = createArrayTest.createArray(7);
		expectedReturnedArray = new int[] {466, 39, 103};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case 2 in maxSumtest.txt file; output array should be [495, 88, 103]
	@Test
	void test8() throws IOException {
		actualArray = createArrayTest.createArray(8);
		expectedReturnedArray = new int[] {495, 88, 103};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case 2 in maxSumtest.txt file; output array should be [395, 92, 103]
	@Test
	void test9() throws IOException {
		actualArray = createArrayTest.createArray(9);
		expectedReturnedArray = new int[] {395, 92, 103};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case 10 in maxSumtest.txt file; output array should be [474, 5, 103]
	@Test
	void test10() throws IOException {
		actualArray = createArrayTest.createArray(10);
		expectedReturnedArray = new int[] {474, 5, 103};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//all negative numbers test case; output array should be [0, -1, -1]
	@Test
	void allNegTest() throws IOException {
		actualArray = new int[] {-3, -8, -4, -7, -9, -15};
		expectedReturnedArray = new int[] {0, -1, -1};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//all positive numbers test case; output array should be [55, 1, 10]
	@Test
	void allPosTest() throws IOException {
		actualArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		expectedReturnedArray = new int[] {55, 1, 10};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//simple test case; output array should be [19, 3, 11]
	@Test
	void simpleTest1() throws IOException {
		actualArray = new int[] {-2, -3, 4, -1, -2, 1, 5, -3, 7, 2, 6};
		expectedReturnedArray = new int[] {19, 3, 11};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case where first element is the only positive number in the array; output array should be [2, 1, 1]
	@Test
	void simpleTest2() throws IOException {
		actualArray = new int[] {2, -2, -2, -3};
		expectedReturnedArray = new int[] {2, 1, 1};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case where the only positive number is the last element in the array; output array should be [3, 4, 4]
	@Test
	void simpleTest3() throws IOException {
		actualArray = new int[] {-2, -2, -2, 3};
		expectedReturnedArray = new int[] {3, 4, 4};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case with all negative numbers and 0s; output array should be [0, -1, -1]
	@Test
	void simpleTest4() throws IOException {
		actualArray = new int[] {-3, -4, -5, -6, -7, -8, -9, -10, 0, 0, -1};
		expectedReturnedArray = new int[] {0, -1, -1};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//simple test case with small array size; output array should be [5, -1, 3]
	@Test
	void simpleTest5() throws IOException {
		actualArray = new int[] {5, -1, 5};
		expectedReturnedArray = new int[] {9, 1, 3};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//simple test case with small array size and only positive number is the first element; output array should be [6, 1, 1]
	@Test
	void simpleTest6() throws IOException {
		actualArray = new int[] {6, -1, -2};
		expectedReturnedArray = new int[] {6, 1, 1};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//simple test case with small array size; output array should be [6, 1, 2]
	@Test
	void simpleTest7() throws IOException {
		actualArray = new int[] {6, 1, -2};
		expectedReturnedArray = new int[] {7, 1, 2};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case with small array size where element at midpoint is the max; output array should be [1, 2, 2]
	@Test
	void simpleTest8() throws IOException {
		actualArray = new int[] {-6, 1, -2};
		expectedReturnedArray = new int[] {1, 2, 2};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case where element at midpoint is the max; output array should be [1, 2, 2]
	@Test
	void simpleTest9() throws IOException {
		actualArray = new int[] {-6, -1, 4, -7, -2};
		expectedReturnedArray = new int[] {4, 3, 3};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case with one element and is a negative element; output array should be [0, -1, -1]
	@Test
	void simpleTest10() throws IOException {
		actualArray = new int[] {-3};
		expectedReturnedArray = new int[] {0, -1, -1};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case with one element and is a positive element; output array should be [3, 1, 1]
	@Test
	void simpleTest11() throws IOException {
		actualArray = new int[] {3};
		expectedReturnedArray = new int[] {3, 1, 1};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	//test case where sum of the max subarray left of the midpoint is equal to the element at the midpoint; output array should be [6, 1, 2]
	@Test
	void simpleTest12() throws IOException {
		actualArray = new int[] {3, 3, -20, 6, -20, -2, -4};
		expectedReturnedArray = new int[] {6, 1, 2};
		actualReturnedArray = bfTest.BfOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = kdTest.KdOutputArray(actualArray);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
		actualReturnedArray = dncTest.DncOutputArray(actualArray, 0, actualArray.length -1);
		assertTrue(Arrays.equals(expectedReturnedArray, actualReturnedArray));
	}
	
	
	
}
