package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main_1003 {
	static ArrayList<Integer> zero;
	static ArrayList<Integer> one;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(in.readLine());
		for(int tc=0;tc<T;tc++) {
			zero = new ArrayList<>();
			 one = new ArrayList<>();
			zero.add(1);
			zero.add(0);
			one.add(0);
			one.add(1);
			int N = Integer.parseInt(in.readLine());
			fibonacci(N);
			sb.append(zero.get(N)).append(" ").append(one.get(N)).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
	private static void fibonacci(int n) {
		for(int i=2;i<=n;i++) {
			zero.add(zero.get(i-1)+zero.get(i-2));
			one.add(one.get(i-1)+one.get(i-2));
			
		}
	}
}
