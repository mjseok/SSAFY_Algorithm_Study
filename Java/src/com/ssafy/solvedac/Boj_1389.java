package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1389 {
	static ArrayList<Integer>[] friend;
	static int[] bacon;
	static int res = Integer.MAX_VALUE;
	static int resIdx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		friend = new ArrayList[N + 1];
		bacon = new int[N + 1];
		for(int i=0;i<=N;i++) {
            friend[i] = new ArrayList<>();
        }
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			friend[A].add(B);
			friend[B].add(A);
		}
		for (int i = 1; i <= N; i++) {
			calBacon(i);
		}
		out.write(resIdx+"");
		out.flush();
		out.close();
		in.close();
	}

	private static void calBacon(int start) {
		int cnt = 0;
		
		Arrays.fill(bacon, -1);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : friend[cur]) {
				if (bacon[next]!=-1)
					continue;
				bacon[next] = bacon[cur] + 1;
				cnt += bacon[next];
				queue.add(next);
			}
		}
		if(res>cnt) {
			res = cnt;
			resIdx = start;
		}
	}
}