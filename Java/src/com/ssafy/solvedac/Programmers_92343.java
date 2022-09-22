package com.ssafy.solvedac;

import java.util.ArrayList;

public class Programmers_92343 {
	public static int maxSheep;
	public static int[] infoList;
	public static boolean[][][] visit;
	public static ArrayList<Integer>[] connect;

	public static int solution(int[] info, int[][] edges) {
		infoList = info;
		int len = info.length;
		connect = new ArrayList[len];
		for(int i=0;i<len;i++) {
			connect[i]= new ArrayList<>();
		}
		for (int i = 0, eLen = edges.length; i < eLen; i++) {
			connect[edges[i][0]].add(edges[i][1]);
			connect[edges[i][1]].add(edges[i][0]);
		}
		visit = new boolean[len][len + 1][len + 1];
		dfs(0, 0, 0);

		return maxSheep;
	}

	public static void dfs(int sheep, int wolf,int now) {
		if (infoList[now] == 0)
			sheep++;
		else if(infoList[now]==1)
			wolf++;

		if (wolf >= sheep)
			return;

		maxSheep = maxSheep < sheep ? sheep : maxSheep;

		for (int i = 0; i <  connect[now].size(); i++) {
			int next = connect[now].get(i);
			int tmp = infoList[now];
			if (!visit[next][sheep][wolf]) {
				infoList[now] = -1;
				visit[now][sheep][wolf] = true;
				dfs(sheep, wolf, next);
				infoList[now] = tmp;
				visit[now][sheep][wolf] = false;

			}
		}

	}

	public static void main(String[] args) {
		int[] info = new int[] { 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1 };
		int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 0, 8 }, { 8, 7 }, { 9, 10 }, { 9, 11 }, { 4, 3 },
				{ 6, 5 }, { 4, 6 }, { 8, 9 } };
		System.out.println(solution(info, edges));
		
	}

}
