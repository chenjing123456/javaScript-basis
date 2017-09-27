package com.briup.day04;

public class Flow{
	public static void main(String[] args) {
		String arg=args[0];//String 类型的args数组
        int day=Integer.parseInt(arg);//转换为int类型
		String week=new Flow().test3(day);
        System.out.println(week);
	}

    public String test3(int day){
    	String week="";
    	switch(day){
    		case 1:
    		    week="1";
    		    break;
    		case 2:
    		    week="2";
    		    break;
    		case 3:
    		    week="3";
    		    break;
    		default :
    		    week="7";
    	}
    	return week;
    }

	public String test2(int day){
		String week="";
        if(day==1){
            week="1";
        } else if(day==2){
            week ="2";
        }else if(day==3){
        	week="3";
        }else{
        	week="7";
        }
        return week;
	}

	public void test1(int age){
		if(age > 18){
			System.out.println("older");
		} else {
			System.out.println("young");
		}
	}
}