package com.ssafy.solvedac;

public class Programmers_92342 {
	 public static int[] solution(int n, int[] info) {
	        int[] answer = {-1};//라이언이 이길 수 없는 경우
	        
	        return answer;
	    }
	 public static void main(String[] args) {
		 int[] info = new int[] {2,1,1,1,0,0,0,0,0,0,0};
		 int[] info1 = new int[] {1,0,0,0,0,0,0,0,0,0,0};
		 int[] info2 = new int[] {0,0,1,2,0,1,1,1,1,1,1};
		 int[] info3 = new int[] {0,0,0,0,0,0,0,0,3,4,3};
		 solution(5,info);
		 solution(1,info1);
		 solution(9,info2);
		 solution(10,info3);
	 }
}
