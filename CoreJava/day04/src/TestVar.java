package com.briup.day04;

public class TestVar{
	int a;
	String b;
	boolean c;
	public static void main(String[] args){
        new TestVar().test3();
	}
	public void test3(){
		int a = -3;//1000 0011 1111 1101
		int b = 3;
		System.out.println(a & b);
		System.out.println(a | b);
		System.out.println(a ^ b);
	}
	public void test2(){
		int a = 3;
		int b = -12;
		System.out.println("a<< : "+ (a<<2) );
		System.out.println("a>> : "+ (a>>1) );
		System.out.println("b>> : "+ (b>>2) );//   / 2^2
		System.out.println("b>> : "+ (b<<1) );//   * 2^1
	}
	public void test1(){
		int a = 1;
		{
			int b = 2;
			System.out.println(a);
		}
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

}