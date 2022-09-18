package com.ssafy.solvedac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Programmers_72412 {
	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		ArrayList<String[]> arr = new ArrayList<>();
		for (String i : info) {
			String[] list = i.split(" ");
			arr.add(list);
		}

		for (int i = 0; i < query.length; i++) {
			String[] list = query[i].split(" ");
			
			for (String[] eachInfo : arr) {
				if (!list[0].equals("-") && !eachInfo[0].equals(list[0]))
					continue;
				if (!list[2].equals("-") && !eachInfo[1].equals(list[2]))
					continue;
				if (!list[4].equals("-") && !eachInfo[2].equals(list[4]))
					continue;
				if (!list[6].equals("-") && !eachInfo[3].equals(list[6]))
					continue;
				if (Integer.parseInt(list[7]) > Integer.parseInt(eachInfo[4]))
					continue;
				answer[i] += 1;

			}

		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	public static void main(String[] args) {
		String[] info = new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = new String[] { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };
		solution(info, query);
	}
}
