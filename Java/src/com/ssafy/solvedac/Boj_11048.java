package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11048 {
	static int N,M;
	static int[] dx = new int[] {0,1,1};
	static int[] dy = new int[] {1,1,0};
	static int[][]map;
	static int[][]memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		StringTokenizer st = null;
		
		str = in.readLine();
		st = new StringTokenizer(str," ");
		N = Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		map = new int[N][M];
		memo = new int[N][M];
		for(int i=0;i<N;i++) {
			str=in.readLine();
			st = new StringTokenizer(str," ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		memo[0][0]=map[0][0];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				dp(i,j);
			}
		}
		System.out.println(memo[N-1][M-1]);
	}
	private static void dp(int x,int y) {
		int curX,curY;
		for(int i=0;i<3;i++) {
			curX=dx[i]+x;
			curY=dy[i]+y;
			if(!check(curX,curY)) continue;
			int cur =  memo[x][y]+map[curX][curY];
			
			memo[curX][curY] = memo[curX][curY]  >cur ?memo[curX][curY] :cur;
		}
	}
	private static boolean check(int nx, int ny) {
		return (nx>=0 && nx<N && ny>=0 && ny<M);
	}
}
