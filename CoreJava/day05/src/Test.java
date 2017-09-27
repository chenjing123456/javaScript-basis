package com.briup.day05;

public class Test{
	public static void main(String[] args){
		Object result = new Test().test1();
		System.out.println(result);
		new Test().test5();
	}

    public void test5(){
    	for(int i = 1;i <= 7;i++){
    		for(int j =1;j <i;j++){
    			System.out.print("*");
    		}
    		System.out.println();
    	}
    }

	public Object test1(){
		int a = 2;
		Object result = (a == 3) ? test2() : test3();
		return result;
	}
	
	public Double test2(){
		System.out.println("fh");
		return 3.2;
	}
	
	public Object test3(){
		System.out.println("frg");
		return new Student();
	}
	
	class Student{

	}
}