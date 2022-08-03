package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1735 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringBuilder sb = new StringBuilder();
		str = in.readLine();
		// 분자A
		int numeratorA = Integer.parseInt(str.split(" ")[0]);
		// 분모A
		int denominatorA =Integer.parseInt(str.split(" ")[1]);
		str = in.readLine();
		// 분자B
		int numeratorB = Integer.parseInt(str.split(" ")[0]);
		// 분모B
		int denominatorB =Integer.parseInt(str.split(" ")[1]);
		
		int dapJa= numeratorA*denominatorB+denominatorA*numeratorB;
		int dapMo=denominatorA*denominatorB;
		for(int i=dapJa;i>=1;i--) {
			if(dapJa%i==0 && dapMo%i==0) {
				dapJa/=i;
				dapMo/=i;
			}
		}
		sb.append(dapJa).append(" ").append(dapMo);
		System.out.println(sb);
	}
}
