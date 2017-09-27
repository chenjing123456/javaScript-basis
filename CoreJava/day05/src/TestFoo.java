package com.briup.day05;

public class TestFoo{
	public static void main(String[] args){
		new TestFoo().test1(345);
	}

	public void test1(int a){
       System.out.println(a>>8);
	}

	public void test2(){
		int b =0xffff;
		System.out.println(a|b);
	}
  }