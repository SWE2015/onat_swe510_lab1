import java.util.Random;

/**
 * 
 * @author onatbas
 *
 * This class has our main() method and also is our main number storage class.
 */
public class Numbers {

	/**
	 * After initializeRandom() call, this array is filled with random numbers.
	 * 
	 * \As initializeRandom()
	 */
	public int[] randomNumbers = new int[100];

	/**
	 * Initializes the randomNumbers array with random numbers up to 1000.
	 * A seed is used to get same number sequence each time this method is called, 
	 * which is 1.
	 */
	public void initializeRandom() {
		Random random = new Random();
		random.setSeed(1);
		for (int i = 0; i < randomNumbers.length; i++) {
			randomNumbers[i] = random.nextInt(1000);
		}
	}

	/**
	 * Sums all the values
	 * @return sum of all values
	 */
	public int sumAll() {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += randomNumbers[i];
		}
		return sum;
	}

	/**
	 * Returns the amount of numbers that are bigger than the avg.
	 * @return the amount of numbers that are bigger than the avg.
	 */
	public int getCountNumbersBiggerThanAvg() {
		int length = 0;
		float avg = (float) (sumAll() / 100.0);
		for (int i = 0; i < 100; i++) {
			if (randomNumbers[i] > avg)
				length++;
		}
		return length;
	}

	/**
	 * Returns the numbers that are bigger than the avg.
	 * @return An array containing the numbers that are bigger than the avg.
	 */
	public int[] getBiggerThanAvg() {

		int[] largerThanAvg = new int[getCountNumbersBiggerThanAvg()];
		float avg = (float) (sumAll() / 100.0);
		int lastIndex = 0;
		for (int i = 0; i < 100; i++) {
			if (randomNumbers[i] > avg)
				largerThanAvg[lastIndex++] = randomNumbers[i];
		}
		return largerThanAvg;
	}

	/**
	 * Sorts given array using bubble sort algorithm.
	 * Keep in mind that the original array is modified.
	 * @param array Array to be sorted and overwritten.
	 */
	public static void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * Calculates the variance of a given array
	 * @param array Array of integers of which variance will be calculated
	 * @return The variance of given array.
	 */
	public static float getVariance(int[] array) {
		float avg = 0;
		for (int i = 0; i < array.length; i++) {
			avg += array[i];
		}
		avg /= array.length;

		float total = 0;
		for (int i = 0; i < array.length; i++) {
			float dist = array[i] - avg;
			total += dist * dist;
		}
		return total / array.length;
	}

	public static void show(String message, float x) {
		System.out.print(message + '	');
		System.out.println(x);
	}

	/**
	 * Prints given array sequentially
	 */
	public static void show(String message, int[] x) {
		System.out.print(message + '	');
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
	

	/**
	 * Prints Linked list sequentially
	 * @throws Exception 
	 */
	public static void show(String message, LinkedList x) throws Exception {
		System.out.print(message + '	');
		for (int i = 0; i < x.getSize(); i++) {
			System.out.print("" + x.getNth(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {

		// Create variables
		Numbers nums = new Numbers();

		// Get randomized numbers
		nums.initializeRandom();
		int sum = nums.sumAll();
		
		show("1. Sum of numbers: ", sum);
		
		int[] biggerThanAvg = nums.getBiggerThanAvg();
		float variance = getVariance(biggerThanAvg);
		show("2. Variance of nums bigger than avg:", variance);
		
		sort(biggerThanAvg);
		show("3. Conventional array(sorted):", biggerThanAvg);
		
		LinkedList list = new LinkedList();
		list.appendAll(nums.getBiggerThanAvg());
		list.sort();
		show("4. Linked List(sorted):	", list);
		
		BinaryTree tree = new BinaryTree();
		tree.addValues(nums.getBiggerThanAvg());
		int[] sorted = tree.getSorted();
		show("5. Binary Tree(sorted):	", sorted);
	}

}
