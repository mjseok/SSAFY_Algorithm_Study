package com.ssafy.solvedac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_5582 {
    static char[] strChar1;
    static char[] strChar2;
    static int[][] dt;
    static int len1,len2;
    static ArrayList<Character> ans;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str1 = in.readLine();
        String str2 = in.readLine();
        len1 = str1.length();
        len2 = str2.length();
        strChar1 = new char[len1];
        strChar2 = new char[len2];
        dt = new int[len1+1][len2+1];
        ans = new ArrayList<>();
        for(int i=0;i<str1.length();i++) {
            strChar1[i] = str1.charAt(i);
        }
        for(int i=0;i<str2.length();i++) {
            strChar2[i] = str2.charAt(i);
        }
        find();
        for(int i=0;i<ans.size();i++) {
            System.out.print(ans.get(i));
        }
        
    }
    private static void find() {
        int max =0;
        int tmp=0;
        for(int i=1;i<=len1;i++) {
            for(int j=1;j<=len2;j++) {
                if(strChar1[i-1]==strChar2[j-1])dt[i][j] = dt[i-1][j-1]+1; 
                if(dt[i][j]>max) {
                    max=dt[i][j];
                    tmp=i;
                }
            }
        }
        while(max<0) {
            max--;
            ans.add(strChar1[tmp-1]);
            tmp--;
        }
    }
}
// https://namu.wiki/w/%EB%AC%B8%EC%9E%90%EC%97%B4%20%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98