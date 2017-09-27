package com.briup.day06;

public class ArrayMultipy{
	public static void main(String[] args) {
		int result = new ArrayMultipy().test1();
		System.out.println(result);
	}

	public int test1(){
		int result = 1;
        int[] arr = new int[10];
		for(int i =1;i<=10;i++){
            arr[i-1]=i;
            result *= arr[i-1];
		}
		return result;
	}
}

