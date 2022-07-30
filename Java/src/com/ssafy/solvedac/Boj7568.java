package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj7568 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringBuilder sb = new StringBuilder();;
		StringTokenizer st = null;
		int T=Integer.parseInt(in.readLine());
		int info[][]= new int[T][2];
		for(int tc=0;tc<T;tc++) {
			str=in.readLine();
			st= new StringTokenizer(str," ");
			info[tc][0]=Integer.parseInt(st.nextToken());
			info[tc][1]=Integer.parseInt(st.nextToken());	
		}
		int range[]=new int[T];
		for(int i=0;i<T;i++) {
			for(int j=0;j<T;j++) {
				//자기자신 빼고
				if(i!=j) {
					if(info[i][0]<info[j][0] && info[i][1]<info[j][1]) {
						range[i]++;
					}
				}
			}
		}
		for(int r:range) {
			System.out.print((r+1)+" ");
		}
		
	}
}
