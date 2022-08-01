package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Boj2615 {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> zero=new ArrayList<>(Arrays.asList(1,0,1));//0,1,2
	static ArrayList<Integer> one=new ArrayList<>(Arrays.asList(0,1,1));//0,1,2
	
	public static void fibonacci(int n) {
		int len = zero.size();
		if(len<=n) {
			for (int i = len; i <= n; i++) {
				zero.add(zero.get(i-1)+zero.get(i-2));
				one.add(one.get(i-1)+one.get(i-2));		
			}
		}
		sb.append(zero.get(n)).append(" ").append(one.get(n)).append("\n");
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			int tmp=Integer.parseInt(in.readLine());	
			fibonacci(tmp);
		}
		System.out.println(sb);
	}
}
