package com.briup.day06;

import java.util.Arrays;

public class Array2D{
	public static void main(String[] args) {
		int[][] twoD = new int[4][];

		int[] arr1 = new int[4];
		int[] arr2 = new int[5];
		int[] arr3 = new int[6];
		int[] arr4 = new int[7];

		twoD[0]=arr1;
		twoD[1]=arr2;
		twoD[2]=arr3;
		twoD[3]=arr4;

		// for(int[] item : twoD){
		// 	for(int item1 :item){
		// 		System.out.print(item1+" ");
		// 	}
		// 	System.out.println();
		// }

		// for(int[] item :twoD){
  //           for(int item1 :item){
  //           	item1 = (int)(Math.random()*100);
  //           	System.out.print(item1+" ");
		// 	}
		// 	System.out.println();		
		// }
		for(int i = 0;i<twoD.length;i++){
			for(int j = 0;j<twoD[i].length;j++){
				System.out.print(twoD[i][j]+"\t");
			}
			System.out.println();
		}
		
		int[] oneD = new int[4];
		twoD[0]=oneD;
		oneD[0]=oneD[1]=oneD[2]=oneD[3];
		System.out.print("oneD:"+Arrays.toString(oneD));

		for(int i =0;i<twoD.length;i++){
			for(int j =0;j<twoD[i].length;j++){
				System.out.print(twoD[i][j]+"\t");
			}
			System.out.println();
		}

        System.out.println();

        for(int[] item4 :twoD){
            for(int item3 :item4){
            	// item1 = (int)(Math.random()*100);
            	System.out.print(item3+" ");
			}
			System.out.println();		
		}
	}
}