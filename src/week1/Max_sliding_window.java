package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
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
		int[] ans = new int[arr.length - k + 1];
		Deque<Integer> q = new LinkedList<>();
		for (int i = 0; i < arr.length; i++) {
			while (q.size() > 0 && arr[i] >= arr[q.getLast()]) {
				q.removeLast();
			}
			q.addLast(i);
			if (i - k + 1 >= 0) {
				ans[i - k + 1] = arr[q.getFirst()];
			}
			if(i - k + 1 >= q.getFirst()) {
				q.removeFirst();
			}
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
