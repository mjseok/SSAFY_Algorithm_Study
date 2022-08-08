package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5464 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());//주차공간수
		int M = Integer.parseInt(st.nextToken());//차량 수
		int[] Rs=new int[N+1];//주차공간의 단위 무게당 요금
		int[] Wk=new int[M+1];
		int[] space=new int[N+1];//주차공간에 주차된 차
		int[] carPos = new int[M+1];//차가 주차된 위치(주차공간)
		int profit =0;
		boolean full =false;
		for(int i=1;i<=N;i++) {
			Rs[i]=Integer.parseInt(in.readLine());
		}
		for(int i=1;i<=M;i++) {
			Wk[i]=Integer.parseInt(in.readLine());
		}
		Queue<Integer> wait = new LinkedList<>();
		
		for(int i=0;i<2*M;i++) {
			int car = Integer.parseInt(in.readLine());
			full =true;
			if(car>0) {
				//들어가
				for(int j=1;j<=N;j++) {
					if(space[j]==0) {//빈자리있다
						space[j]=car;
						carPos[car]=j;
						full=false;
						break;
					}
				}				
				if(full) {//다 차있다
					wait.offer(car);
				}
			}
			if(car<0) {
				int pos = carPos[-1*car];
				space[pos]=0;
				profit += Rs[pos] * Wk[car*(-1)];
				if(!wait.isEmpty()) {//대기하는 차가 있으면
					int waitCar = wait.poll();
					space[pos] =waitCar;//바로 주차공간에 넣는다
					carPos[waitCar] = pos;
					
				}
			}
		}
		sb.append(profit);
		System.out.println(sb);
		
	}
}
