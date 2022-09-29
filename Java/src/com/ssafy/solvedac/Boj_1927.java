package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj_1927 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int opr = Integer.parseInt(in.readLine());
			if (opr==0) {
				if (minHeap.size() == 0) {
					sb.append(0);
				} else
					sb.append(minHeap.poll());
				sb.append("\n");
			} else {
				minHeap.add(opr);
			}
		}
		System.out.println(sb);
	}
}
