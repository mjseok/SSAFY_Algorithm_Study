package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
	static int N, M;
	static int[][] miro;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = null;

		st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new int[N][M];
		for (int i = 0; i < N; i++) {
			str = in.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = str.charAt(j)-'0';
			}
		}
		System.out.println(bfs(0, 0));
	}

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, 1 });
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int cnt = cur[2];
			if(curX==N-1 && curY==M-1) {
				return cnt;
			}
			for (int d = 0; d < 4; d++) {
				int nx = curX + dx[d];
				int ny = curY + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (miro[nx][ny] == 1) {
					queue.add(new int[] { nx, ny, cnt + 1 });
					miro[nx][ny] = 0;
				}
			}

		}
		return -1;
	}
}
