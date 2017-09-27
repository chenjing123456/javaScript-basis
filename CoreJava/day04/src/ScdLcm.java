package com.briup.day04;

public class ScdLcm{
	
	public static void main(String[] args){

		int m = 24;
		int n = 5;
		int scdl = scd(m,n);
		int lcml = lcm(m,n,scdl);

		System.out.println("最大公约数"+scdl);
		System.out.println("最小公倍数"+lcml);
	}

	public static int scd(int m,int n){
        for(;n!=0;){
        	int r =m % n;
        	m = n;
        	n = r;
        }
        return m;
	}

	public static int lcm(int m,int n,int scdl){
       return m*n/scdl;
	}
}