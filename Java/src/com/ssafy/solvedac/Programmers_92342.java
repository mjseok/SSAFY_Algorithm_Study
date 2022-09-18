package com.ssafy.solvedac;

import java.util.Arrays;

public class Programmers_92342 {
	static int N = 11;
	static int R;
	static int[] scores= {0,1,2,3,4,5,6,7,8,9,10};
	static int[] res;
	static int[] ryan = new int[11];
	 public static int[] solution(int n, int[] info) {
	        int[] answer = {-1};//라이언이 이길 수 없는 경우
	        R= n;
	        res = new int[R];
	        combi(0,0);
	        return answer;
	    }
	 private static void combi(int cnt,int start) {
		 
		 if(cnt==R) {
			 for(int i=0;i<R;i++) {
				 ryan[10-res[i]]+=1;
			 }
				System.out.println(Arrays.toString(ryan));
				ryan = new int[11];
				return;
			}
			for (int i = N-1; i >=start; i--) {
				res[cnt] = scores[i];
				combi(cnt+1,i);
				
			}
	 }
	 public static void main(String[] args) {
		 int[] info = new int[] {2,1,1,1,0,0,0,0,0,0,0};
//		 int[] info1 = new int[] {1,0,0,0,0,0,0,0,0,0,0};
//		 int[] info2 = new int[] {0,0,1,2,0,1,1,1,1,1,1};
//		 int[] info3 = new int[] {0,0,0,0,0,0,0,0,3,4,3};
		 solution(5,info);
//		 solution(1,info1);
//		 solution(9,info2);
//		 solution(10,info3);
	 }
}
