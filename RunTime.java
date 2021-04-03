package cs146F20.dang.project2;

/**
 * class for caulculating the runtimes of brute force, divide and conquer, and kadane algorithms in nanoseconds
 * @author chloedang
 *
 */
public class RunTime {
	
	CreateArray randArray; 	//instantiate randArray object
	BruteForce bfArray;		//instantiate array to run brute force algorithm from
	Kadane kdArray; 		//instantiate array to run kadane algorithm from
	DivideAndConquer dncArray; //instantiate array to run divide and conquer algorithm from
	int[] randomArray;		 //instantiate randomArray to store array of randomly generated integers
	long bfElapsedTime;		//instantiate to store brute force algorithm elapsed time
	long dncElapsedTime;	//instantiate to store divide and conquer algorithm elapsed time
	long kdElapsedTime;		//instantiate to store kadane algorithm elapsed time
	long startClock;		//variable to store start time
	long endClock;			//variable to store end time
	
	public RunTime() {
		randArray = new CreateArray();
		bfArray = new BruteForce();
		dncArray = new DivideAndConquer();
		kdArray = new Kadane();

		randomArray = new int[0]; //initialize randomArray
		bfElapsedTime = 0;			//initialize brute force elapsed time
		dncElapsedTime = 0;			//initialize divide and conquer elapsed time
		startClock = 0;			//initialize start time to 0
		endClock = 0;			//initialize start time to 0
	}
	
	/**
	 * calculates the runtime of a brute force algorithm
	 * @param n -- array input size
	 * @return runtime of brute force algorithm in nanoseconds
	 */
	public long bfRunTime(int n) {
		
		for (int i = 0; i < 10; i++) {
			randomArray = randArray.randomArray(n); //generate array of random integers
			startClock = System.nanoTime();			//start time
			bfArray.BfOutputArray(randomArray);		//run brute force algorithm
			endClock = System.nanoTime();			//end time
			bfElapsedTime += (endClock-startClock); //calculate elapsed time
		}
		
		return (bfElapsedTime/10); //calculate and return average elapsed time from 10 random integer arrays
	}
	
	/**
	 * calculates the runtime of a divide and conquer algorithm
	 * @param n -- array input size
	 * @return runtime of divide and conquer algorithm in nanoseconds
	 */
	public long dncRunTime(int n) {

		for (int i = 0; i < 10; i++) {
			randomArray = randArray.randomArray(n);
			startClock = System.nanoTime();
			dncArray.DncOutputArray(randomArray, 0, randomArray.length - 1);
			endClock = System.nanoTime();
			dncElapsedTime += (endClock-startClock);
		}
		
		return (dncElapsedTime/10);
	}
	
	/**
	 * calculates the runtime of a kadane algorithm
	 * @param n -- array input size
	 * @return runtime of kadane algorithm in nanoseconds
	 */
	public long kdRunTime(int n) {
		
		for (int i = 0; i < 10; i++) {
			randomArray = randArray.randomArray(n);
			startClock = System.nanoTime();
			kdArray.KdOutputArray(randomArray);
			endClock = System.nanoTime();
			kdElapsedTime += (endClock-startClock);
		}
		
		return (kdElapsedTime/10);
	}
}

