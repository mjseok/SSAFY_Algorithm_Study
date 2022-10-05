package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1932 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer st = null;
		int n = Integer.parseInt(in.readLine());
		int[][] map = new int[n][n];
		int[][] dp = new int[n][n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력
		for (int i = 1; i < n ; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0)
					map[i][j] += map[i - 1][j];
				else if(j==i) map[i][j]+=map[i-1][j-1];
				else map[i][j] += Math.max(map[i - 1][j], map[i-1][j - 1]);
				
			}
			
		}
		for(int i=0;i<n;i++) {
			max = max < map[n-1][i] ? map[n-1][i]:max;
		}
		System.out.println(max);
	}
}
