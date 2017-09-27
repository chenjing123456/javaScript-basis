package com.briup.day04;

public class Factor{
	public static void main(String[] args) {
		String arg = args[0];
		int n = Integer.parseInt(arg);
		int c = new Factor().factorial(n);
		System.out.println(c);
	}
    public int factorial(int n){
    	if( n <= 1){
    		return 1;
    	} else {
            return n*factorial(n-1);
    	}
    }
	
}