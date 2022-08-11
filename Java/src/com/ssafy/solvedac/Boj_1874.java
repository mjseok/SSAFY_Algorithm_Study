package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int n = 0;
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(in.readLine());
			if (stack.isEmpty() || stack.peek() < input) {// 비어있을 경우
				while (input != n) {
					n++;
					stack.push(n);
					sb.append("+").append("\n");
				}
			}

			if (stack.peek() == input) { // 스택에 들어있는 마지막 값이 들어올 값보다 크거나 같으면 pop
				stack.pop();
				sb.append("-").append("\n");

			}

			else {// if(stack.peek()>input)
				System.out.println("NO");
				return;
			}

		}
		System.out.println(sb);

	}
}
