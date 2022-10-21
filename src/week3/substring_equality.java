package week3;

import java.util.*;
import java.io.*;

public class substring_equality {
	final static int m = 1000000007, m2 = 1000000009, x = 5;

	public class Solver {
		private String s;

		public Solver(String s) {
			this.s = s;
		}

		public boolean ask(int a, int b, int l) {
			int[] hashTable1 = hashTable(s, m);
			int[] hashTable2 = hashTable(s, m2);
			return areEqual(hashTable1, hashTable2, a, b, l);
		}
	}

	public static int[] hashTable(String s, int prime) {
		final char[] charArr = s.toCharArray();
		int n = charArr.length;
		int[] hashTable = new int[n + 1];
		hashTable[0] = 0;
		int xPow = x;
		for (int i = 1; i < n + 1; i++) {
			hashTable[i] = ((charArr[i - 1] - 'a' + 1) * xPow + hashTable[i - 1]) % prime;
			xPow = x * xPow % prime;
		}
		return hashTable;
	}

	static int hashValue(int[] hashTable, int prime, int start, int length) {
		return (hashTable[start + length] - hashTable[start]) % prime;
	}

	boolean areEqual(int[] table1, int[] table2, int a, int b, int l) {
		int y = (int) Math.pow(x, Math.abs(b - a));
		int ah1, bh1, ah2, bh2;
		if (b > a) {
			ah1 = (table1[a + l] - table1[a]) * y;
			bh1 = (table1[b + l] - table1[b]);

			ah2 = (table2[a + l] - table2[a]) * y;
			bh2 = (table2[b + l] - table2[b]);
		} else if(b < a){
			ah1 = (table1[a + l] - table1[a]);
			bh1 = (table1[b + l] - table1[b]) * y;

			ah2 = (table2[a + l] - table2[a]);
			bh2 = (table2[b + l] - table2[b]) * y;
		} else {
			return true;
		}

		if (ah1 == bh1 && ah2 == bh2) {
			return true;
		} else {
			return false;
		}
	}

	public void run() throws IOException {
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		String s = in.next();
		int q = in.nextInt();
		Solver solver = new Solver(s);
		for (int i = 0; i < q; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int l = in.nextInt();
			out.println(solver.ask(a, b, l) ? "Yes" : "No");
		}
		out.close();
	}

	static public void main(String[] args) throws IOException {
		new substring_equality().run();
	}

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
}
