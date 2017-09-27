package com.briup.day04;

public class Divide{
	public static void main(String[] args) {
	    // int divide=new Divide().test1(90);
	    // System.out.println(divide);
	    // new Divide().test1();
	    int num = 90;
	    int n = num;
	    String str ="";
	    for(;n != 1;){
	    	for(int i = 2;i <= n;i++){
	    		if(isPrime(i)){
                    if(n % i==0){
                    	str += i+"*";
                    	n /= i;
                    	break;
                    }
	    		}
	    	}
	    }
	    System.out.println(num+"="+str.substring(0,str.length()-1));
	    divide();
	}

    

	public static boolean isPrime(int num){
		for(int i = 2;i<=(int)Math.sqrt(num);i++){
			if(num % i==0){
				return false;
			}
		}
		return true;
	}

	public static void divide(){
		int n = 90;
		String sum ="";
		for(int i =2;i <=n;i++){
			for(;n!=1;){
				if(isPrime(i)){
					if(n % i==0){
						sum += i+"*";
						n = n/i;
						break;
					}
			    }
			}
		}
		System.out.print(sum.substring(0,sum.length()-1));//字符串的长度是方法。数组的长度是属性
	}
}