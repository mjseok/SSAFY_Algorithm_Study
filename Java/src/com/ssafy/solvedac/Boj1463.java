package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1463 {
	public static int min = Integer.MAX_VALUE;
	public static int cnt =0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int minCnt[] = new int[N+1];//최소 연산 값 저장
		for(int i=2;i<=N;i++) {
			minCnt[i]=minCnt[i-1]+1;//이건 무조건 수행하니까
			if(i%2==0) minCnt[i]=Math.min(minCnt[i],minCnt[i/2]+1);
			if(i%3==0) minCnt[i]=Math.min(minCnt[i],minCnt[i/3]+1);
		}
		System.out.println(minCnt[N]);
	}
}
