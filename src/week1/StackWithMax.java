package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackWithMax {
	// main stack
	static Stack<Integer> mainStack = new Stack<Integer>();

	// Stack to keep track of max element
	static Stack<Integer> trackStack = new Stack<Integer>();

	static void push(int x) {
		mainStack.push(x);
		if (mainStack.size() == 1) {
			trackStack.push(x);
			return;
		}
		if (x > trackStack.peek())
			trackStack.push(x);
		else
			trackStack.push(trackStack.peek());
	}

	static int getMax() {
		return trackStack.peek();
	}

	static void pop() {
		mainStack.pop();
		trackStack.pop();
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

	public void solve() throws IOException {
		FastScanner scanner = new FastScanner();
		int queries = scanner.nextInt();

		for (int qi = 0; qi < queries; ++qi) {
			String operation = scanner.next();
			if ("push".equals(operation)) {
				int value = scanner.nextInt();
				StackWithMax.push(value);
			} else if ("pop".equals(operation)) {
				StackWithMax.pop();
			} else if ("max".equals(operation)) {
				System.out.println(StackWithMax.getMax());
			}
		}
	}

	static public void main(String[] args) throws IOException {
		new StackWithMax().solve();
	}

}
