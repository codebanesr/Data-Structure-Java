package interview.crackingthecodinginterview.StackProblems;

public class SortStack {
	public static void sort(java.util.Stack<Integer> unsorted, java.util.Stack<Integer> sorted) {
		while (!unsorted.isEmpty()) {
			int x = unsorted.pop();

			while (!sorted.isEmpty()) {
				if (sorted.peek() > x) {
					unsorted.push(sorted.pop());
				} else {
					sorted.push(x);
					break;
				}
			}

			if (sorted.isEmpty()) {
				sorted.push(x);
			}
		}

	}

	public static void main(String args[]) {
		java.util.Stack<Integer> unsorted = new java.util.Stack<>();
		java.util.Stack<Integer> sorted = new java.util.Stack<>();

		unsorted.push(11);
		unsorted.push(10);
		unsorted.push(17);
		unsorted.push(100);
		unsorted.push(0);


		sort(unsorted, sorted);
		while (!sorted.isEmpty()) {
			System.out.println(sorted.pop() + ", ");
		}
	}
}
