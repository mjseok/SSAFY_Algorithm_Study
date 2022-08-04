package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 배낭 물건 뽑거나 안뽑거나, 동전 뒤집거나 안뒤집거나  
public class Boj_9079 {
	static StringBuilder sb = new StringBuilder();
	static int min;
	static boolean[] isFlipped;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < N; tc++) {
			min=Integer.MAX_VALUE;
			String[][] coins = new String[3][3];
			String str = "";
			StringTokenizer st = null;
			isFlipped =new boolean[8];
			for (int i = 0; i < 3; i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				for (int j = 0; j < 3; j++) {
					coins[i][j] = st.nextToken();
				}
			}
			doflip(coins,0,0);
			min = min==Integer.MAX_VALUE ? -1 :min;
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}

	// 모두 같은 면인지 아닌지 확인
	private static boolean isSame(String[][] coins) {
		String check = coins[0][0];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (coins[i][j] != check)
					return false;
			}
		}
		return true;

	}
	//subset
	private static void doflip(String[][] coins, int where, int cnt) {// 어디를 뒤집을지말지를 고려
		//System.out.println(min);
		if (isSame(coins)) { // 같은 면 나오는 방법이 여러개일 때 최소값 나오기
			min = min > cnt ? cnt : min;
			return;
		}
		if (where == 8) { // 모든 방법을 다 썼을 때
			return;
		}
		// 동전 뒤집거나
		int tmp = where % 3;
		//System.out.println(tmp);
		switch (where) {
		case 0:// 가로
		case 1: 
		case 2:
			for (int i = 0; i < 3; i++) {
				coins[tmp][i] = coins[tmp][i].equals("H") ? "T" : "H";
			}
			break;
		case 3:
		case 4:
		case 5:
			for (int i = 0; i < 3; i++) {
				coins[i][tmp] = coins[i][tmp].equals("H") ? "T" : "H";
			}
			break;
		case 6: //대각선
			for (int i = 0; i < 3; i++) {
				coins[i][i] = coins[i][i].equals("H")? "T" : "H";
			}
			break;
		case 7:
			for (int i = 0; i < 3; i++) {
				coins[i][2 - i] = coins[i][2 - i].equals("H") ? "T" : "H";
			}
			break;
			
		}
		doflip(coins,where+1,cnt+1);

		
		// 동전 안뒤집기_안뒤집을거면 뒤집었던거 돌려놔야되니까
		switch (where) {
		case 0:// 가로
		case 1: 
		case 2:
			for (int i = 0; i < 3; i++) {
				coins[tmp][i] = coins[tmp][i].equals("H") ? "T" : "H";
			}
			break;
		case 3:
		case 4:
		case 5:
			for (int i = 0; i < 3; i++) {
				coins[i][tmp] = coins[i][tmp].equals("H") ? "T" : "H";
			}
			break;
		case 6: //대각선
			for (int i = 0; i < 3; i++) {
				coins[i][i] = coins[i][i].equals("H")? "T" : "H";
			}
			break;
		case 7:
			for (int i = 0; i < 3; i++) {
				coins[i][2 - i] = coins[i][2 - i].equals("H") ? "T" : "H";
			}
			break;
			
		}
		doflip(coins,where+1,cnt);
	}
}
