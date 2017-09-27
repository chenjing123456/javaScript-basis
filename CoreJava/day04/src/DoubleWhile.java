package com.briup.day04;

public class DoubleWhile{
	public static void main(String[] args){
		String arg = args[0];
		String arg1 = args[1];
        int year = Integer.parseInt(arg);
        int month = Integer.parseInt(arg1);
		// String str = new DoubleWhile().test2(time);
		int str = new DoubleWhile().num(year,month);
		System.out.println(str);
	}
	public void test1(){
		for(int i = 1;i <= 9;i++){
			for(int j =1;j <= i;j++){
				System.out.println(i + "*" +j +"=" + i*j);
			}
		}
	}
	public String test2(int time){
        String str = "";
        if(time <= 12 && time >= 8){
           str = "早上好";
        } else if(time >= 14 && time <= 18){
        	str = "下午好";
        }else {
        	str ="晚上好";
        }
        return str;
	}
    public boolean isLeapYear(int year){
    	// boolean isLeap;
    	if((year % 4 ==0 && year % 100 ==0) || year % 400 == 0){
    		// isLeap = true;
    		return true;
    	}else {
    		// isLeap = false;
    		return false;
    	}
    	// return isLeap;
    }
    public int num(int year,int month){
    	int day = 30;
    	switch (month){
    		case 1:
    		case 3:
    		case 5:
    		case 7:
    		case 8:
    		case 10:
    		case 12:
    		    day = 31;
    		    break;
    		case 2:
    		    day = isLeapYear(year) ? 28 : 29;
    	}
    	return day;
    }
}