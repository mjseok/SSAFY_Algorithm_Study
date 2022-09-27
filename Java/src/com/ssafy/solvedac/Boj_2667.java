package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_2667 {
	static int N;
	static char[][] map;
	static ArrayList<Integer> danji = new ArrayList<>();
	static int[] dx = new int[] { 1, -1, 0, 0 };
	static int[] dy = new int[] { 0, 0, 1, -1 };
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(in.readLine());
		map = new char[N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			String str = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == '1')
					danji.add(bfs(i, j));
			}
		}
		sb.append(danji.size());
		sb.append("\n");
		danji.sort(Comparator.naturalOrder());
		for(int d:danji) {
			sb.append(d);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		map[x][y]=0;
		 int cnt=1;
		
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if (!check(nx, ny))
					continue;
				if (map[nx][ny] == '1') {
					map[nx][ny]=0;
					queue.add(new int[] { nx, ny});
					cnt+=1;
				}
			}
		}
		return cnt;
	}

	private static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
