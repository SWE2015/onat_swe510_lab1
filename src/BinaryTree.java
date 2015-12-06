import java.util.Arrays;


/** 
 * This BinaryTree class is created solely for purpose of storing int
 * numbers in a sorted order.
 * This main BinaryTree contains a single node(BinaryNode) which holds all the 
 * other nodes.
 * @author onatbas
 */
public class BinaryTree {
	
	/**
	 * BinaryNode class is the main tree component in this BinaryTree implementation.
	 * Whether this node is the main one (stored in BinaryTree) or a subnode (stored
	 * in another BinaryNode) is irrelevant. See methods.
	 * @author onatbas
	 */
	private class BinaryNode {
		/**
		 * left node stores values that are smaller or equal than the vlaue in this node
		 */
		public BinaryNode left = null;
		/**
		 * right node stores values that are bigger than the value in this node.
		 */
		public BinaryNode right = null;

		/**
		 * The value stored in THIS node.
		 */
		public int value;
		
		/**
		 * This bool value is TRUE if this node is initialized with an actual value,
		 * otherwise the value in "value" attribute is irrelevant (uninitialized).
		 */
		public boolean added = false;
		public int size = 0;

		/**
		 * How this method works is as follows:
		 * 	> Is this node holding a value? (added is TRUE if so)
		 * 		>NO: Store the value here, return.
		 * 		>YES: Is the value bigger than the value in this node?
		 * 			>YES: Pass it to the right node
		 * 			>NO: Pass it to the left node.
		 * @param val Integer you want to store in the array.
		 */
		public void addValue(int val) {
			size++; // I know I cheated, sue me.
			if (!added) {
				added = true;
				this.value = val;
				return;
			}

			if (this.value > val) {
				if (right == null)
					right = new BinaryNode();
				right.addValue(val);
			} else {
				if (left == null)
					left = new BinaryNode();
				left.addValue(val);
			}
		}

		
		/**
		 * This method returns the binary tree in a sequential array.
		 * Since the binary trees are sorted by the way it works, the deal is
		 * just to make it into an array.
		 * How this works is as follows:
		 * > An array with enough size must be provided.
		 * > By starting where the previous node left placing values, start placing your own values, like this:
		 * > Tell the right node to place it values first,
		 * > Place the value this node stores.
		 * > Tell the left node to place it values, last.
		 * 
		 * By doing so you recursively tell the right-most node to store it's values and left-most node
		 * to store last. 
		 * 
		 * @param target The sorted array will be stored in the array.
		 * @return The same array user passed will be returned, for recursiveness.
		 */
		public int[] getSorted(int[] target) {
			if (!added) return target;
			
			if (right != null)
				right.getSorted(target);

			target[target[target.length - 1]++] = value;

			if (left != null)
				left.getSorted(target);

			return target;
		}
	}

	/**
	 * Main binary tree node, first bracnh.
	 */
	private BinaryNode node = null;

	
	/**
	 * Store a value in binary tree
	 * @param i the integer value
	 */
	public void addValue(int i) {
		if (node == null)
			node = new BinaryNode();

		node.addValue(i);
	}

	/**
	 * A helper method to store all values of an integer array
	 * @param values Array of integers.
	 */
	public void addValues(int[] values) {
		for (int i : values) {
			addValue(i);
		}
	}

	/**
	 * This method returns all the integers stored in the tree
	 * in a sorted order.
	 * @return An array of integer containing all the vlaues.
	 */
	public int[] getSorted() {
		if (node == null)
			return null;

		int[] list = new int[node.size + 1]; // last element to store last index
		list[list.length - 1] = 0;
		
		node.getSorted(list);

		int[] result = Arrays.copyOfRange(list, 0, list.length-1); // Get rid of last index.
		return result;
	}

}
