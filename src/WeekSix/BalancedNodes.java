package WeekSix;

public class BalancedNodes {
	public static void main(String[] args) {
		BalancedNodes bn = new BalancedNodes();
		
		// defining binary tree
		int root[] = {1, 2, 3, 0, 4, 5, 6, 0, 0, 0, 0, 0, 0, 7, 8};
		int head[] = {3, 6};
		System.out.println("Output: " + bn.areBalanced(head, root));
	}
	
		
	public int indexOf(int value, int arr[]) {
		// perform linear search to find the index of a value
		int indx = -1;
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == value) {
				indx = i;
				break;
			}
		}
		return indx; 	
	}
			
	public boolean areBalanced(int head[], int root[]) {
		// checks if a node has balanced child nodes
		boolean balanced = false;
		int head_index, left_child, right_child;
		for(int i=0; i<head.length; i++) {
			head_index = indexOf(head[i], root);
			left_child = root[(2*head_index) + 1];
			right_child = root[(2*head_index) + 2];
			
			// if either left or right child has -1 value, it should return false
			if (left_child != 0 && right_child != 0) {
				balanced = true;
			} else {
				balanced = false;
				break;
			}
		}
		return balanced;
	}
}



