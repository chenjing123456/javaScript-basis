package com.briup.day02;

public class Test{
	public static void main(String [] args){
		// stu.setName()=args[0];

		// Student stu=new Student();
		showHello();
		// System.out.println(stu.getName());
		new Test().Test4();
	}
	public void Test4(){
	   char a='3';
	   char b=65;
	   char c="\u0042"
	   System.out.println(a);
	   System.out.println(b);
	}
	public void Test3(){
       float a=1.33759674365F;
       double b=2.456729875693;
       float c=3.55697F;
       System.out.println(a);
       System.out.println(b);
       System.out.println(c);
	}
	public void Test1(){
		short a=234;
		long b=100085;
		int c=24795;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
	public static void showHello(){
		System.out.println("hello");
	}
}