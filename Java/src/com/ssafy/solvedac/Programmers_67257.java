package com.ssafy.solvedac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_67257 {
	public static long solution(String expression) {
		long answer = 0;

		// ArrayList<String> numbers = new ArrayList<>();
		ArrayList<String> opt = new ArrayList<>();
		ArrayList<String> copyOpt = new ArrayList<>();
		String[][] priors = new String[][] { { "-", "*", "+" }, { "-", "+", "*" }, { "*", "-", "+" }, { "*", "+", "-" },
				{ "+", "*", "-" }, { "+", "-", "*" } };
		// opt순서대로 담기
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '+')
				copyOpt.add("+");
			if (expression.charAt(i) == '-')
				copyOpt.add("-");
			if (expression.charAt(i) == '*')
				copyOpt.add("*");
		}

		// num담기
		String[] expressions = expression.split("\\+|\\-|\\*");
		List<String> numbers = new ArrayList<>();
		List<String> copyNumbers = new ArrayList<>(Arrays.asList(expressions));

		for (String[] prior : priors) {
			numbers.addAll(copyNumbers);
			opt.addAll(copyOpt);
			for (String p : prior) {

				while (true) {
					int i = opt.indexOf(p);
					if (i == -1)
						break;
					String calcNum = Long.toString(calc(numbers.get(i), numbers.get(i + 1), p));
					numbers.add(i, calcNum);
					numbers.remove(i + 1);
					numbers.remove(i + 1);
					System.out.println(numbers);
					opt.remove(i);

				}
			}
			long tmpAnswer = Math.abs(Long.parseLong(numbers.get(0)));
			answer = answer > tmpAnswer ? answer : tmpAnswer;
			numbers.remove(0);
			opt.clear();
		}
		return answer;
	}

	private static long calc(String n1, String n2, String opt) {
		long num1 = Long.parseLong(n1);
		long num2 = Long.parseLong(n2);

		if (opt.equals("+"))
			return num1 + num2;
		else if (opt.equals("*"))
			return num1 * num2;
		else
			return num1 - num2;
	}

	public static void main(String[] args) {
		System.out.println(solution("100-200*300-500+20"));

	}
}
