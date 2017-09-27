package com.briup.day06;

public class TestArray{

	public static void main(String[] args) {
		new TestArray().test7();
	}
    
    public void test7(){
        char[] arr={'h','e','l','l','o'};
        char[] temp= new char[arr.length+1];
        for(int i=0;i<arr.length;i++){
            temp[i]=arr[i];
        }
        temp[temp.length-1]='!';
        arr = temp;
        printArray2(arr);
    }

    public void test6(){
        int[] arr =new int[]{1,2};
        System.out.print("改变位置之前");
        printArray(arr);
        int temp = arr[0];
        arr[0]=arr[1];
        arr[1]=temp;
        System.out.print("改变位置之后");
        printArray(arr);
    }

    public void test5(){
        int[] array1 =new int[]{2,3,5,7,11,13,17,19};
        // printArray(array1);
        for(int item : array1){
        	System.out.print(item+",");
        }
        System.out.println();
        int[] array2 = array1;
        for(int i=0;i<array1.length;i++){
        	if(i % 2==0){
        		array2[i]=i;
        	}
        }
        // printArray(array1);
        for(int item : array1){
        	System.out.print(item+",");
        }
    }
    
    public void printArray(int[] arr){
       for(int item : arr){
        System.out.println(item);
       }
    }

    public void printArray2(char[] arr){
       for(char item : arr){
        System.out.print(item);
       }
    }
    
    public void test4(){
        Student stu1 = new Student("terry");
        Student stu2 = new Student("rry");
        Student stu3 = new Student("tey");

        Student[] stus = new Student[]{stu1,stu2,stu3};
        for(Student item : stus){
        	System.out.println(item.name);
        }
    }
    //系统初始化,与成员变量初始化一致
    public void test3(){
    	int[] a;
    	a = new int[3];
    	System.out.println(a);
    	for(int item :a){
           System.out.print(item+",");
    	}
    }
    //自定义初始化
	public void test2(){
		int[] a;
		a = new int[]{1,2,3,5,6};
		System.out.println(a);//
	}

    //字面量初始化
	public void test1(){
		int[] a={2,3,4};//创建数组a,数组总有三个元素
		System.out.println(a[0]);//打印出哈希码
        for(int i=0;i <a.length;i++){
        	System.out.print(a[i]);
        }
	}
}

class Student{
	public String name;
	public Student(String name){
		this.name = name;
	}
}