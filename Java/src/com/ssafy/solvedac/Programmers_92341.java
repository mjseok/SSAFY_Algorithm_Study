package com.ssafy.solvedac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Programmers_92341 {
	 public static int[] solution(int[] fees, String[] records) {
	        int basic_min = fees[0];
	        int basic_fee = fees[1];
	        int per_min = fees[2];
	        int per_fee = fees[3];
	        ArrayList<String> parked=new ArrayList<>(); //주차되어있는 차
	        ArrayList<Integer> parkingTimes = new ArrayList<>();//주차된 시간
	        HashMap<String,Integer> outCars = new HashMap<String,Integer>();
	        
	        for(String record : records) {
	        	String info[] = record.split(" ");
	        	
	        	if(info[2].equals("IN")) {//입차	        		
	        		parked.add(info[1]);
	        		parkingTimes.add(toMin(info[0]));
	        	}
	        	else {//출차
	        		int idx = parked.indexOf(info[1]);
	        		
	        		int parkingTime = toMin(info[0])-parkingTimes.get(idx);
	        		if(outCars.containsKey(info[1])) { //과거 기록이 있을 경우
	        			int pastRecords=outCars.get(info[1]);
	        			outCars.replace(info[1],pastRecords+parkingTime);
	        		}
	        		else {	//없을 경우
	        			outCars.put(info[1], parkingTime);
	        		}
	        		parked.remove(info[1]);
	        		parkingTimes.remove(idx);
	        		
	        	}
	        }
	        //출차 내역 없을 경우
	        for(int i=0,len=parked.size();i<len;i++) {
	        	int parkingTime =1439-parkingTimes.get(i);
	        	if(outCars.containsKey(parked.get(i))) { 
	        		int pastRecords=outCars.get(parked.get(i));
	        		outCars.replace(parked.get(i),pastRecords+parkingTime);
	        	}
	        	else {	//없을 경우
        			outCars.put(parked.get(i), parkingTime);
        		}
	        }
	       
	        //계산
	        List<String> sortedOutCars = new ArrayList<>(outCars.keySet());
	        sortedOutCars.sort((s1,s2)->s1.compareTo(s2));
	        int[] answer = new int[sortedOutCars.size()];
	        int index=0;
		    for(String car : sortedOutCars) {
		    	int cal = basic_fee;
		    	if(outCars.get(car)>basic_min) {
		    		double cal1 = (double)(outCars.get(car)-basic_min)/(double)per_min;
		    		cal = (int) (Math.ceil(cal1)*per_fee+basic_fee) ;		    	
		    		
		    	}
		    	answer[index++]=cal;
		    }
	        return answer;
	    }
	
	 public static int toMin(String time) {
		 //분으로 바꿔줌
		 String[] timeInfo = time.split(":");
		 int hour = Integer.parseInt(timeInfo[0]);
		 int min = Integer.parseInt(timeInfo[1]);
		 return hour*60 +min;
	 }
	 public static void main(String[] args) {
		 int[] fees=new int[] {1, 461, 1, 10};
		 String[] records = new String[] {"00:00 1234 IN"};
		 int[] answer =solution(fees,records);
		 for(int a : answer)
			 System.out.println(a);
	}
}
