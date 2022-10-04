package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1012 {
	static int[][] map;
	static int M,N;
	static int[] dr = new int[] {0,1,0,-1};
	static int[] dc = new int[] {1,0,-1,0}; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			int cnt =0;
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			for (int i = 0; i < K; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1) {
						bfs(i,j);	
						cnt++;
					}
				}
			}
			System.out.println(cnt);

		}
	}

	private static void bfs(int r,int c) {
		Queue<int []>queue = new LinkedList<>();
		queue.add(new int[] {r,c});
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curR= cur[0];
			int curC= cur[1];
			for(int d=0;d<4;d++) {
				int nr = curR+dr[d];
				int nc = curC+dc[d];
				if(!check(nr,nc)) continue;
				if(map[nr][nc]==1) {
					map[nr][nc]=0;
					queue.add(new int[] {nr,nc});
				}
			}
		}
	}

	private static boolean check(int r, int c) {
		
		return r>=0 && r<N && c>=0 && c<M;
	}

}
