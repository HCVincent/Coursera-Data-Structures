package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StackWithMax {
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

	public void solve() throws IOException {
		FastScanner scanner = new FastScanner();
		int queries = scanner.nextInt();
		MyStack stack = new MyStack();

		for (int qi = 0; qi < queries; ++qi) {
			String operation = scanner.next();
			if ("push".equals(operation)) {
				int value = scanner.nextInt();
				stack.myPush(value);
			} else if ("pop".equals(operation)) {
				stack.myPop();
			} else if ("max".equals(operation)) {
				System.out.println(stack.getMax());
			}
		}
	}

	static public void main(String[] args) throws IOException {
		new StackWithMax().solve();
	}

	public class MyStack {
		int maxValues[] = new int[400000];
		int index = 0;

		void myPush(int value) {
			maxValues[index] = value;
			index++;
		}

		void myPop() {
			index--;
			maxValues[index] = 0;
		}

		int getMax() {
			int[] filteredArray = Arrays.stream(maxValues).filter(num -> num != 0).toArray();
			Arrays.sort(filteredArray);
			return filteredArray.length == 0 ? 0 : filteredArray[filteredArray.length - 1];
		}
	}
}
