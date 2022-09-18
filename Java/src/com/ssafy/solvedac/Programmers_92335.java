package com.ssafy.solvedac;

public class Programmers_92335 {
	public static int solution(int n, int k) {
        int answer = 0;
        String num = Long.toString(n,k);
        String[] primeList = num.split("0");
        for(String prime: primeList) {
        	if(prime.length()==0) continue;
        	if(isPrime(prime)) {
        		answer+=1;
        	}
        }
        return answer;
    }
	private static boolean isPrime(String prime) {
		long num = Long.parseLong(prime);
		if(num==1) return false;
		for (int i = 2; i <=(int)Math.sqrt(num); i++) {
			if(num%i==0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
//		System.out.println(solution(437674,3));
		System.out.println(solution(110011,10));
	}
}
