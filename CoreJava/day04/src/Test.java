package com.briup.day04;

public class Test{
	public static void main(String[] args){
		String arg = args[0];
		String arg1 = args[1];

        int a= Integer.parseInt(arg);
        int b= Integer.parseInt(arg1);
        
        new Test().test2(a,b);
	}

	// public void test1(int a){
	// 	System.out.println("a : " + (a << 8));
	// 	int b = a || 0xffff;
	// 	return b;
	// }

	public void test2(int a,int b){
        // a=a+b;
        // b=a-b;
        // a=a-b;

        a=(a^b);
        b=b^a;
        a=b^a;
        System.out.println(a);
        System.out.println(b);
	}
}