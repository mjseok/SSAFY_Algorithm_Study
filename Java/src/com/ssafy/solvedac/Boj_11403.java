package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11403 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int n = Integer.parseInt(in.readLine());
		int[][] graph = new int[n][n];
	
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0;j<n;j++) {
				graph[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//거쳐가는 노드
		for(int k=0;k<n;k++) {
			//출발노드
			for(int i=0;i<n;i++) {
				//도착노드
				for(int j=0;j<n;j++) {
					//거쳐갈 때 경로 있나
					if(graph[i][k] ==1 && graph[k][j]==1) {
						graph[i][j]=1;
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(graph[i][j]).append(" ");
			}
			sb.append("\n");
		}
		out.write(sb.toString());
		out.flush();
		out.close();
		in.close();
	}
	
}
