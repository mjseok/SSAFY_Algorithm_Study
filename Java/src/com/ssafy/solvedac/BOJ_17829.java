package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17829 {
	public static int second(int[] num) {
		Arrays.sort(num);
		return num[2];

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		int[][] matrix = new int[N][N];
		int[] check = new int[4];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while (N > 1) {
			ArrayList<Integer> polling = new ArrayList<>();
			for (int i = 0; i < N; i += 2) {
				for (int j = 0; j < N; j += 2) {
					check[0] = matrix[i][j];
					check[1] = matrix[i][j + 1];
					check[2] = matrix[i + 1][j];
					check[3] = matrix[i + 1][j + 1];
					polling.add(second(check));

				}
			}
			N/=2;
			matrix=new int[N][N];
			int idx=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					matrix[i][j]=polling.get(idx);
					idx++;
				}
			}
			if(N==1)
				sb.append(polling.get(0));
		}
		System.out.println(sb);
	}
}
