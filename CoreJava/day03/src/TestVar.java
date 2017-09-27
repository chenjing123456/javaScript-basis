package com.briup.day03;

public class TestVar{
	public static void main(String[] args) {
		convert(2);
	}
    public void test11(){
    	String a="hello";
    	System.out.println(a.hashCode());
    	a=a+"!";
    	System.out.println(a.hashCode());
    }
	public void test10(){
		boolean result=test9() && test8();
		boolean res=test8() || test9();
		System.out.println(result);
		System.out.println(res);
	}
	public boolean test8(){

		System.out.println("---b1---");
        return true;		
	}
	public boolean test9(){
		System.out.println("---b2---");
		return false;
	}
	public void test7(){
		int a =1;
	    int result = ++a + a++ +a-- + --a;
	    System.out.println(result);
	}
	public void test6(){

		String c = "hello";
		String d = "hello";
		String e = "he"+"llo";
		String f1 = "he";
		String f2 = "llo";
		String f = f1+f2;
		String g = new String("hello");
		String k = new String("hello");
		System.out.println(c==d);
		System.out.println(c==e);
		System.out.println(c==f);
		System.out.println(c==g);
		System.out.println(c==k);
	}
	public void test5(){
		double a=10;
		System.out.println(a);

		int b=12;
		double c=a+b;
		System.out.println(c);
	}
	public void test4(){
		long a=10;
		int b=5;
		long c=a+b;
		System.out.println(c);
	}
	public void test3(){
		byte a=10;
		byte b=5;
		int c=a+b;
		System.out.println(c);
	}
	public void test2(){
		long a=10L;
		int b=(int)a;
		int c=(int)10.3;
		long d=Math.round(10.9);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
	public void test1(){
		int a;
		a=3;
		System.out.println(a);
	}
	public static String convert(int num){
		return  ((num==1)?"1":
		          (num==2)?"2":
		          (num==3)?"3":
		          (num==4)?"4":
		          (num==5)?"5":
		          (num==6)?"6":
		          (num==7)?"7":
		          "not");
	}
}