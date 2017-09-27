package com.briup.exercise3;

/**
*this is TestMyPoint class
*declare MyPoint Object
*/
public class TestMyPoint{
	public static void main(String[] args){
		/**
        * this is a MyPoint object1
		*/
		MyPoint start = new MyPoint();
		start.x=10;
		start.y=10;
        /**
        * this is a MyPoint object2
		*/
		MyPoint end = new MyPoint();
		end.x=20;
		end.y=30;
		// end.toString();

		System.out.println("start point is "+start.toString());
		System.out.println("end point is "+end);
        
        /**
        * this is a MyPoint object3
		*/
		MyPoint stray = new MyPoint();
		stray=end;

		System.out.println("stary point is "+stray);
		System.out.println("end point is "+end);

        stray.x=47;
        stray.y=50;

        System.out.println("stary point is "+stray);
        System.out.println("end point is "+end);
        System.out.println("start point is "+start);

	}
}