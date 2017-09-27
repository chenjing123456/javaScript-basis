package com.briup.day03.test;

import com.briup.day03.bean.*;

public class Test{
	public static void main(String[] args){
		Student stu1 =new Student();
		Student stu2 =new Student();
		Student stu3 =new Student();

		stu1.setName("zs");
		stu2.setName("we");
		stu3.setName("ls");

		System.out.println(stu1.getName());
		System.out.println(stu2.getName());
		System.out.println(stu3.getName());
	}
}
