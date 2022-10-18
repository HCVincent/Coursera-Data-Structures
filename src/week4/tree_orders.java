package week4;

import java.util.*;
import java.io.*;

public class tree_orders {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeOrders {
		int n;
		int[] key, left, right;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) {
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			// Finish the implementation
			// You may need to add a new recursive method to do that
			inOrderList(result, key[0], left[0], right[0]);
			return result;
		}

		void inOrderList(List<Integer> list, int keyValue, int leftValue, int rightValue) {
			if (leftValue != -1) {
				inOrderList(list, key[leftValue], left[leftValue], right[leftValue]);
			}
			list.add(keyValue);
			if (rightValue != -1) {
				inOrderList(list, key[rightValue], left[rightValue], right[rightValue]);

			}
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			// Finish the implementation
			// You may need to add a new recursive method to do that
			preOrderList(result, key[0], left[0], right[0]);
			return result;
		}

		void preOrderList(List<Integer> list, int keyValue, int leftValue, int rightValue) {
			list.add(keyValue);
			if (leftValue != -1) {
				preOrderList(list, key[leftValue], left[leftValue], right[leftValue]);
			}
			if (rightValue != -1) {
				preOrderList(list, key[rightValue], left[rightValue], right[rightValue]);
			}
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			// Finish the implementation
			// You may need to add a new recursive method to do that
			postOrderList(result, key[0], left[0], right[0]);
			return result;
		}

		void postOrderList(List<Integer> list, int keyValue, int leftValue, int rightValue) {
			if (leftValue != -1) {
				postOrderList(list, key[leftValue], left[leftValue], right[leftValue]);
			}
			if (rightValue != -1) {
				postOrderList(list, key[rightValue], left[rightValue], right[rightValue]);
			}
			list.add(keyValue);
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new tree_orders().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
