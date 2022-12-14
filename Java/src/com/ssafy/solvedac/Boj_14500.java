package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_14500 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
	}
}
