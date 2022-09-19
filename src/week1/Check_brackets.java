package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
	Bracket(char type, int position) {
		this.type = type;
		this.position = position;
	}

	boolean Match(char c) {
		if (this.type == '[' && c == ']')
			return true;
		if (this.type == '{' && c == '}')
			return true;
		if (this.type == '(' && c == ')')
			return true;
		return false;
	}

	char type;
	int position;
}

class Check_brackets {
	public static void main(String[] args) throws IOException {
		InputStreamReader input_stream = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input_stream);
		String text = reader.readLine();
		int index = 0;
		Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
		for (int position = 0; position < text.length(); ++position) {
			char next = text.charAt(position);
			Bracket b = new Bracket(next, position + 1);
			if (next == '(' || next == '[' || next == '{') {
				// Process opening bracket, write your code here
				opening_brackets_stack.push(b);
			}

			if (next == ')' || next == ']' || next == '}') {
				// Process closing bracket, write your code here
				if (opening_brackets_stack.empty()) {
					index = position + 1;
					break;
				} else if (!opening_brackets_stack.pop().Match(next)) {
					index = position + 1;
					break;
				}
			}
		}
		if (index == 0) {
			if (opening_brackets_stack.empty()) {
				System.out.println("Success");
			} else {
				System.out.println(opening_brackets_stack.pop().position);
			}
		} else {
			System.out.println(index);
		}

	}
}
