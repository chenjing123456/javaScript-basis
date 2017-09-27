package com.briup.day06;

public class Selection{
	public static void main(String[] args) {
		int[] arr = new int[]{23,4,65,3,2,8};
		
		for(int i =0;i < arr.length-1;i++){
			int k = i;
	        for(int j = k+1;j<arr.length;j++){
	        	if(arr[j] < arr[k]){
	        		k = j;
	        	}
	        }
	    
	    if(i != k){
			int temp = arr[i];
			arr[i] = arr[k];
			arr[k] = temp;
		    }		
	    }
		
		System.out.println();
		printArray(arr);
	}
    

	public static void printArray(int[] arr){
		for(int item : arr){
			System.out.print(item+" ");
		}
	}
}