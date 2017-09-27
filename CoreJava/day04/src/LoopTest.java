package com.briup.day04;

public class LoopTest{
	public static void main(String[] args){
		int a = new LoopTest().test2();
		System.out.println(a);
	}
	public int test1(){
        int sum=1;
		for(int i = 1;i <= 10;i++){
           sum *= i;
		}
		return sum;
	}
	public int test2(){
		int sum=1;
		int i=1;
		while(i<=10){
			sum *= i;
			i++;
		}
		return sum;
	}
	
}