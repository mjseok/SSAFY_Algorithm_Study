package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj_2872 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(in.readLine());
		int[] books = new int[N];
		boolean[] visited = new boolean[N+1];
		for(int i=0;i<N;i++) {
			int book = Integer.parseInt(in.readLine());
			books[i] = book;
		}
		int find = N;
		for(int i=N-1;i>=0;i--) {
			if(books[i]==find) {
				visited[find]=true;
				find--;//다음에 찾을 거
			}
		}
		int answer = 0;
		for(int i=1;i<=N;i++) {
			if(!visited[i]) answer++;
		}
		out.write(answer+"");
		out.flush();
		out.close();
		in.close();
	}
	
}
