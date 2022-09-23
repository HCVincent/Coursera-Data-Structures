package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Max_sliding_window {

	public static void main(String[] args) throws IOException {
		FastReader s = new FastReader();
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int m = s.nextInt();
		arr = maxSlidingWindow(arr, m);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int[] maxSlidingWindow(int[] arr, int k) {

		// For Finding Next Greater Element
		int[] nge = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(arr.length - 1);
		nge[arr.length - 1] = arr.length;
		for (int i = arr.length - 2; i >= 0; --i) {
			while (!st.isEmpty() && arr[i] >= arr[st.peek()])
				st.pop();
			if (st.isEmpty())
				nge[i] = arr.length;
			else
				nge[i] = st.peek();
			st.push(i);
		}

		int[] ans = new int[arr.length - k + 1];
		int j = 0; // To travel in nge
		for (int i = 0; i <= arr.length - k; ++i) {
			if (j < i)
				j = i;
			while (nge[j] < i + k)
				j = nge[j];
			ans[i] = arr[j];
		}

		return ans;
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
