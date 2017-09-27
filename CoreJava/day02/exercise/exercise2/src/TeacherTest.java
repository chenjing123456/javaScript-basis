package com.briup.exercise2;

public class TeacherTest{
	public static void main(String[] args){
        Teacher te=new Teacher();
        te.name="ls";
        te.age=35;
        te.salary=10000.75;

        System.out.println(te.name);
        System.out.println(te.age);
        System.out.println(te.salary);
        
        te.increaseSalary();
        System.out.println("new salary are "+""+te.salary);
 	}
}