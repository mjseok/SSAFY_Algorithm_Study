package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOj_14888 {
	static int[] num;
	static int[] opt;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str="";
		StringTokenizer st = null;
		N = Integer.parseInt(in.readLine());
		num = new int[N];
		opt = new int[4];
		str = in.readLine();
		st = new StringTokenizer(str," ");
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		str = in.readLine();
		st = new StringTokenizer(str," ");
		for(int i=0;i<4;i++) {
			opt[i] =  Integer.parseInt(st.nextToken());
		}
		dfs(num[0],0); 
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void dfs(int n, int cnt) {
		//연산자는 숫자보다 1개 덜 있음
		if(cnt==N-1) {
			max = max > n ? max: n;
			min = min < n ? min: n;
			return;
		}
		for (int i = 0; i <4; i++) {
			if(opt[i]>0) {
				opt[i]--;
				int next = cnt+1;
				if(i==0) dfs(n+num[next],cnt+1);
				if(i==1) dfs(n-num[next],cnt+1);
				if(i==2) dfs(n*num[next],cnt+1);
				if(i==3) dfs(n/num[next],cnt+1);
				opt[i]++;
			}
		}
	}
	
}
