package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_14889 {
	static int[] start;
	static int half;
	static int N;
	static boolean[] visited;
	static int min= Integer.MAX_VALUE;
	static int[] people;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		half = N/2;
		start = new int[half];
		visited = new boolean[N];
		people = new int[N];
		for(int i=0;i<N;i++) {
			people[i]=i;
		}
		
		map = new int[N][N];
		StringTokenizer st = null;
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(in.readLine()," ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		ncr(0,0);
		System.out.println(min);
	}
	private static void ncr(int s, int cnt) {
		if(cnt==half) {
			cal(start);
			//System.out.println(Arrays.toString(start));
			return;
		}
		for(int i=s;i<N;i++) {
			visited[i]=true; 
			start[cnt] = people[i];
			ncr(i+1,cnt+1);
			visited[i] = false;
		}
	}
	private static void cal(int[] start) {
		int startPower = 0;
		int linkPower = 0;
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(visited[i] == true &&visited[j]==true) {
					//start팀
					startPower+=map[i][j];
					startPower+=map[j][i];
				}else if(visited[i]==false && visited[j]==false) {
					//link팀
					linkPower+=map[i][j];
					linkPower+=map[j][i];
				}
			}
		}
		int diff = Math.abs(startPower-linkPower);
		min = diff<min ? diff:min;
		
	}
}
