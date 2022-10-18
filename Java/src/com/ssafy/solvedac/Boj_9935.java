package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Boj_9935 {
	static String str, bomb;
//	static Stack<String> stack;
	static Stack<Character> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		str = in.readLine();
		bomb = in.readLine();
		stack = new Stack<>();

		for (int i = 0, len = str.length(); i < len; i++) {
			stack.push(str.charAt(i));
			if (stack.size() >= bomb.length()) {
				if (checkBomb()) {
					for (int j = 0; j < bomb.length(); j++) {
						stack.pop();
					}
				}
			}
		}
		if (stack.size() == 0)
			sb.append("FRULA");
		else {
//			for (String s : stack) {
			for (Character s : stack) {
				sb.append(s);
			}
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();

	}

	private static boolean checkBomb() {
		for (int j = 0, len = bomb.length(); j < len; j++) {
//			if (!stack.get(stack.size() - len + j).equals(bomb.charAt(j) + "")) {
			if (stack.get(stack.size() - len + j)!=(bomb.charAt(j))) {
				return false;
			}
		}
		return true;
	}
}
