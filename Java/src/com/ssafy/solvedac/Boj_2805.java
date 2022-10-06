package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[] tree= new long[n];
		long min = 0;
		long max = Integer.MIN_VALUE;
		long mid;
		long sum;
		
		st = new StringTokenizer(in.readLine()," ");
		for(int i=0;i<n;i++) {
			tree[i]=Integer.parseInt(st.nextToken());
			max = max < tree[i] ? tree[i]: max;
		}
		while(min<max) {
			sum=0;
			mid = (min+max)/2;
			for(long height : tree) {
				if(height - mid > 0) {
					sum+=(height-mid);
				}
			}
			if(sum<m) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		sb.append(min-1);
		//System.out.println(sb);
		out.write(sb+"");
		out.flush();
		out.close();
		in.close();
	}
}
