package com.ssafy.solvedac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Programmers_67257 {
	 public static long solution(String expression) {
	        long answer = 0;
	     
	        //ArrayList<String> numbers = new ArrayList<>();
	        ArrayList<String> opt = new ArrayList<>();
	        String[][] priors = new String[][] { {"-","*","+"},
	        	{"-","+","*"},
	        	{"*","-","+"},
	        	{"*","+","-"},
	        	{"+","*","-"},
	        	{"+","-","*"}
	          };
	         //opt순서대로 담기
	         for(int i=0;i<expression.length();i++) {
	        	 if(expression.charAt(i)=='+') opt.add("+");
		         if(expression.charAt(i)=='-')opt.add("-");
		         if(expression.charAt(i)=='*')opt.add("*");	 
	         }
	         //num담기
	         String[] expressions = expression.split("\\+|\\-|\\*");
	         List<String> numbers = new ArrayList<>(Arrays.asList(expressions));
	        
	        for(String[] prior:priors) {
	        	for(String p:prior) {
	        		
	        		for(int i=0;i<opt.size();i++) {
	        			if(opt.get(i)==p) {
	        				//console.log(i);
	        				String calcNum =Integer.toString(calc(numbers.get(i),numbers.get(i+1),p));
	        				numbers.add(i, calcNum);
	        				numbers.remove(i+1);
	        				numbers.remove(i+1);
	        				System.out.println(numbers);
	        				opt.remove(i);
	        			}
	        		}
	        	}
	        	int tmpAnswer = Math.abs(Integer.parseInt(numbers.get(0)));
	        	answer = answer>tmpAnswer?answer:tmpAnswer;
	        }
	        return answer;
	    }
	 private static int calc(String n1, String n2, String opt) {
		 int num1 = Integer.parseInt(n1);
		 int num2 = Integer.parseInt(n2);
		 
		 if(opt.equals("+")) return num1+num2;
		 else if(opt.equals("*")) return num1*num2;
		 else return num1-num2;
	 }

	 public static void main(String[] args) {
		 System.out.println(solution("100-200*300-500+20"));
		 
	}
}
