package com.briup.day04;

public class For{
    public static void main(String[] args){
        new For().test1();
   }
    public void test1(){
    	int n = 7;
    	for(int i = 1;i <= n;i++){
    		for(int j = 1;j <= n-i;j++) {
    			System.out.println(" ");
    		}
    		for(int j = 1;j <= 2*i-1;j++){
    			System.out.println("*");
    		}
    	}
    	System.out.println();
    }
}