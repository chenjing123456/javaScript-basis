package com.briup.day04;

public class Digit{
	public static void main(String[] args){
		// int z=0;
		// for(int i = 1;i <= 4;i++){
  //           int a = i *100;
  //           for(int j = 1;j <= 4;j++){
  //           	int b = a + j *10;
  //           	for(int k = 1;k <= 4;k++){
  //           		int c = b + k;
  //           		if(c % 100 != ((int)(c / 10)) % 10 ){
  //           			if(((int)(c / 10)) % 10 != (int)(c /100)){
  //           				if(c % 100 != (int)(c /100)){
  //           					System.out.println(c);
  //           				}
  //           			}
  //           		}
  //           	}
  //           }
		// }

            int count = 0;
            for(int i = 1;i<=4;i++){
                  for(int j=1;j<=4;j++){
                        for(int k =1;k<=4;k++){
                              if(i!=j&&i!=k&&j!=k){
                                    System.out.println(i*100+j*10+k);
                                    count++;
                              }
                        }
                  }
            }

            System.out.println();
            System.out.println("总数:"+count);
      new Digit().digit();

	}
      public void digit(){
            int coun = 0;
            for(int i = 1;i <=4;i++){
                  for(int j =1;j <=4;j++){
                        for(int k =1;k <=4;k++){
                              for(int l =1; l<=4;l++){
                                    if(i!=j&&i!=k&&i!=l&&k!=l&&j!=k){
                                          coun++;
                                          System.out.print(i*1000+j*100+k*10+l+" ");
                                    }
                              }
                        }
                  }
            }
            System.out.print("总数"+coun);
      }

}