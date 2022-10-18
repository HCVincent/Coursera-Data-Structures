package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class is_bst {
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

	public class IsBST {
		class Node {
			int key;
			int left;
			int right;

			Node(int key, int left, int right) {
				this.left = left;
				this.right = right;
				this.key = key;
			}
		}

		int nodes;
		Node[] tree;

		void read() throws IOException {
			FastScanner in = new FastScanner();
			nodes = in.nextInt();
			tree = new Node[nodes];
			for (int i = 0; i < nodes; i++) {
				tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
			}
		}

		boolean flag = true;

		boolean isBinarySearchTree() {
			// Implement correct algorithm here
			if (nodes == 0) {
				return true;
			}
			Node node = tree[0];
			return isValidBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		public boolean isValidBST(Node node, int min, int max) {
			boolean leftIsBst = false;
			boolean rightIsBst = false;
			if (node.key < min || node.key > max) {
				return false;
			}

			// Check this node!
			// This algorithm doesn't recurse with null Arguments.
			// When a null is found the method returns true;
			// Look and you will find out.
			/*
			 * Checking for Left SubTree
			 */

			// If the Left Node Exists
			if (node.left != -1) {
				// and the Left Data are Smaller than the Node Data
				if (tree[node.left].key < node.key) {
					// Check if the subtree is Valid as well
					leftIsBst = isValidBST(tree[node.left], min, node.key);
				} else {
					// Else if the Left data are Bigger return false;
					leftIsBst = false;
				}
			} else {// if the Left Node Doesn't Exist return true;

				leftIsBst = true;
			}

			/*
			 * Checking for Right SubTree - Similar Logic
			 */
			// If the Right Node Exists
			if (node.right != -1) {
				// and the Right Data are Bigger (or Equal) than the Node Data
				if (tree[node.right].key >= node.key) {
					// Check if the subtree is Valid as well
					rightIsBst = isValidBST(tree[node.right], node.key, max);
				} else {
					// Else if the Right data are Smaller return false;
					rightIsBst = false;
				}
			} else {// if the Right Node Doesn't Exist return true;
				rightIsBst = true;
			}

			// if both are true then this means that subtrees are BST too
			return (leftIsBst && rightIsBst);
		}

	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new is_bst().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		IsBST tree = new IsBST();
		tree.read();
		if (tree.isBinarySearchTree()) {
			System.out.println("CORRECT");
		} else {
			System.out.println("INCORRECT");
		}
	}
}
