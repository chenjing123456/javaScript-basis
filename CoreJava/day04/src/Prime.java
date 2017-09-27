package com.briup.day04;

public class Prime{
	public static void main(String[] args){
		new Prime().test1();
	}

	public void test1(){
        for(int j = 101;j <= 200;j++){
        	if(isPrime(j)){
        		System.out.print(j+ " ");
        	}
        }
	}

    public static boolean isPrime(int n){
    	for(int i = 2;i < n;i++){
            if(n % i ==0){
            	return false;
            }
    	}
        return true;
    }
		
}