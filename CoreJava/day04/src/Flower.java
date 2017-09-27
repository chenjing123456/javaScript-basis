package com.briup.day04;

public class Flower{
	public static void main(String[] args){
       // new Flower().isFlower();
		int a = 0;
		int b = 0;
		int c = 0;
		for(int i = 100;i<=999;i++){
			//162
			a = i / 100;//1 两个整数相除取余
			b = i /10 %10;//6
			c = i % 100 %10;//2
			if(i==(Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3))){
				System.out.print(i+" ");
			}
		}
	}
	
}