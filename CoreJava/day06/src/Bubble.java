package com.briup.day06;

public class Bubble{
	public static void main(String[] args) {
		new Bubble().test1();
	}

	public void test1(){
		int[] arr = {1,23,4,6,3,75,87};
		for(int i=0;i<arr.length-1;i++){
			boolean isSort =true;
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp =arr[j+1];
					arr[j+1]=arr[j];
                    arr[j]=temp;
                    isSort =false;
				}
			}
			if(isSort){
                    break;
			    }
			// System.out.print();
			for(int a :arr){
				System.out.print(a+" ");
			}
			System.out.println();
		}
	}
}