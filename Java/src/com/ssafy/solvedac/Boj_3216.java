package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_3216 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		int[] d = new int[N];
		int[] v = new int[N];
		int time = 0;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			d[i] = Integer.parseInt(st.nextToken());
			time += Integer.parseInt(st.nextToken());
			v[i]=time;
		}
		answer+=v[0];//최소
		int idx=0;//몇번째 곡인지
		int song =0;//틀 수 있는 노래

		for(int t=v[0];t<v[N-1]+d[N-1];t++) {
			if(idx==N) break;
			if(v[idx]==t) {
				//다운 다 되면
				song+=d[idx];//틀 수 있는 곡
				idx+=1;
			}
			song-=1;//1초당 듣는 곡
			if(song<0) {
				song=0;
				answer++;
			}
			
		}
		out.write(answer+"");
		out.flush();
		out.close();
		in.close();
	}
}
