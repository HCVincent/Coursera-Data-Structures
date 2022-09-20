package week1;

import java.util.*;
import java.io.*;

public class Tree_height {
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

	public class TreeHeight {
		int n;
		int parent[];
		int heights[];

		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
		}

		int computeHeight() {
//			for (int i = 0; i < n; i++) {
//				heights[i] =getHeight(i);
//			}
			int result = 0;
			for(int i = 0; i < n; i++) {
				result = Math.max(result, getHeight(i));
			}
			return result;
		}

		int getHeight(int index) {
			if(parent[index] == -1) {
				return 1;
			}
			return getHeight(parent[index]) + 1;
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new Tree_height().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
