package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9465 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(in.readLine());
			int[][] sticker = new int[2][n+1];
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				sticker[0][i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				sticker[1][i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 2; i <= n; i++) {
				sticker[0][i] += Math.max(sticker[1][i - 1], sticker[1][i - 2]);
				sticker[1][i] += Math.max(sticker[0][i - 1], sticker[0][i - 2]);
			}
			System.out.println(Math.max(sticker[0][n], sticker[1][n]));
		}
	}
}