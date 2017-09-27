package com.briup.day06;

import java.util.Arrays;

/**
*排序算法：插入排序算法
*从第二个数开始
*/

public class Push{

	public static void main(String[] args){
        
        int[] arr = new int[]{1,3,5,2,6,0,7};
        
        for(int i=1;i<arr.length;i++){//外层循环表示趟数,执行length-1次
        	int k = i;//i表示数组下标，从第二个数开始，就是下标为1.
        	for(int j=k;j>0;j--){
        		if(arr[j]<arr[j-1]){

	        		arr[j-1] = arr[j-1]+arr[j];
	        		arr[j] = arr[j-1]-arr[j];
	        		arr[j-1] = arr[j-1]-arr[j];
        		}
        	}
        }
        System.out.println(Arrays.toString(arr));
    }
    
	// public static void insertSort(int[] source){
	// 	int i,j;//i趟数
	// 	int insert;//插入的数（拿出来比较的数）

	// 	for(i = 1;i < source.length;i++){
	// 		insert = source[i];//第一趟比较第二个数，第二趟比较第三个数.
	// 		j = i -1;
	// 		while((j>=0)&& insert<source[j]){
	// 			source[j+1] = source[j];
	// 			j--;
	// 		}
	// 		source[j+1] =insert;
	// 		System.out.print("第"+i+"趟");
	// 		System.out.println();
	// 		printArray(source);
	// 	}
	// }s
	// public static void printArray(int[] source){
	// 	for(int item:source){
	// 		System.out.print(item+" ");
	// 	}
	// }
}