package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1021 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String str=in.readLine();
		st = new StringTokenizer(str," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> deque=new LinkedList<>();
		
		int pos;
		int sum=0;
		str=in.readLine();
		st = new StringTokenizer(str," ");
		for(int i=1;i<=N;i++) {
			deque.offer(i);
		}
		for(int i=0;i<M;i++) {
			pos=Integer.parseInt(st.nextToken());
			if(check(deque,pos)) sum+=second(deque,pos);
			else sum+=third(deque,pos);
			deque.poll();
			
		}
		System.out.println(sum);
		
	}
	private static boolean check(Deque<Integer> deque,int pos) {
		Iterator<Integer> it = deque.iterator();
		for(int j=0;j<=deque.size()/2;j++) {
			if(pos == it.next()) {
				return true;
			}
		}
		return false;
	}
	private static int second(Deque<Integer> deque,int pos) {
		int cnt =0;
		while(deque.peek()!=pos) {
			cnt++;
			int num = deque.poll();
			deque.offer(num);
		}
		return cnt;
	}
	private static int third(Deque<Integer> deque,int pos) {
		int cnt =0;
		while(deque.peek()!=pos) {
			cnt++;
			int num = deque.pollLast();
			deque.offerFirst(num);
		}
		return cnt;
	}
}
