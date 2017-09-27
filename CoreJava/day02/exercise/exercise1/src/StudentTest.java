package com.briup.exercise1;

public class StudentTest{
	public static void main(String [] args){
		Student stu=new Student();

		stu.name="zs";
		stu.sex="memale";
		stu.age=24;

		System.out.println(stu.name);
		System.out.println(stu.sex);
		System.out.println(stu.age);

        stu.increateAge();
        System.out.println("new age is "+""+stu.age);
	}
}