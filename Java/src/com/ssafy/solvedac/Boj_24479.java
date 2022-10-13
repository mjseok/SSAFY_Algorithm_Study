package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_24479 {
	static boolean[] isVisit;
	static int N,M,R;
	static ArrayList<Integer>[] adjArr;
	static int[] answer;
	static int cnt = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		adjArr = new ArrayList[N+1];
		isVisit = new boolean[N+1];
		answer = new int[N+1];
		for(int i=0;i<=N;i++) {
			adjArr[i]= new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adjArr[u].add(v);
			adjArr[v].add(u);
		}
		dfs(R);
		for(int i=1;i<=N;i++) {
			sb.append(answer[i]).append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
	private static void dfs(int now) {
		isVisit[now] = true;
		cnt+=1;
		answer[now] = cnt;
		Collections.sort(adjArr[now]);
		for(int next:adjArr[now]) {
			if(!isVisit[next]) {
				dfs(next);
			}
		}
	}
}
