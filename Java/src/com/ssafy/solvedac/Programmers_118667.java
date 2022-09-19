package com.ssafy.solvedac;

import java.util.ArrayDeque;
import java.util.Queue;

public class Programmers_118667 {
	public static int solution(int[] queue1, int[] queue2) {
		int answer = -1;
		long total = 0;
		long sum1 = 0;
		long sum2 = 0;
		int len = queue1.length;
		
		Queue<Integer> q1 = new ArrayDeque<>();
		Queue<Integer> q2 = new ArrayDeque<>();
		for(int val:queue1) {q1.add(val); sum1+=val;}
		for(int val:queue2) {q2.add(val); sum2+=val;}
		
		total=sum1+sum2; 
		// 원래부터 같을 경우
		if (sum1 == sum2)
			return 0;
		// 합을 같게 만들 수 없는 경우
		if (total % 2 == 1)
			return -1;

		// 한 곳에서 빼서 한 곳에 넣기 -> 1회
		long cal1 = 0; 
		long cal2=0;
		while (cal1<=len*2 && cal2<=len*2) {
			if(sum1 == sum2) return (int) (cal1+cal2);
			if (total / 2 < sum1) {
				// queue1에서 빼서 queue2로 넣기
				int last = q1.peek();
				if(last >total/2) return -1;
				sum1-=last;
				sum2+=last;
				q2.add(q1.poll());
				cal1++;
			} else {
				// queue2에서 빼서 queue1로 넣기
				int last = q2.peek();
				if(last >total/2) return -1;
				sum1+=last;
				sum2-=last;
				q1.add(q2.poll());
				cal2++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] queue1 = new int[] { 3, 2, 7, 2 };
		int[] queue2 = new int[] { 4, 6, 5, 1 };
		System.out.println(solution(queue1, queue2));
	}
}
