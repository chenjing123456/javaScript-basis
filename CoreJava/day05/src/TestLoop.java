package com.briup.day05;

public class TestLoop{
	public static void main(String[] args) {
		new TestLoop().test7();
	}
	
	public void test7(){
		int a = 3;
		System.out.println("before:"+a);
        changeA(a);
        System.out.println("after:"+a);
	}

	public void changeA(int a){
		a++;
	}

	public void test6(){
		int result = 0;
		int i = 1;
		for(;i<=100;i++){
			result +=i;
			i++;
		}
		Student stu = new Student();
		stu.age = 3;
        changeAge(stu);

		System.out.println(i);
        System.out.println(stu.age);

	}

    public void changeAge(Student stu){
    	stu.age++;
    }

    public void test4(){
    	int i = 1;
    	int result =0;
    	do{
            result += i;
            i++;
    	}while(i<=100);
    	System.out.println(result);
    }

    public void test3(){
        int i = 1;
        int result = 0;
    	while(i <= 100){
            result += i;
    		i++;

    	}
    	System.out.println(result);
    }

    int index =0;
	
	public void test1(){
		int result = 0;
		// int index = 0;
		for(int i =1;test5(i);i++){
			result += i;
		}
		System.out.println(index);
	}
    
    public boolean test5(int i){
        index++;
    	return i<=100;
    }

	public void test2(){
		for(int i = 1;i <= 9;i++){
			for(int j =1;j<i;j++){
				String space = "  ";
				if(i * j >9){
                   space = " ";

				}
				System.out.print(j+"*"+i+"="+i*j+space);
			}
			System.out.println();
		}
	}
}

class Student{
	public int age;
}