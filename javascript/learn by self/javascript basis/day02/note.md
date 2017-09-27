1.运算符优先级

  * ()最强
  * 一元运算符:++ -- ! 一元+  一元-。
  * 算数运算符：先* / 后 + -
  * 关系运算符：> >= < <=
  * 相等运算符：==   ！=  ===  ！==
  * 逻辑运算符：先&& 后||

2.continue和break

  * continue 结束本次（当前）循环，继续执行下一次循环。
  * break 满足条件时结束后面所有循环。

3.循环

  * for循环(确定循环次数的时候用)
  * while和do while循环(不确定循环次数的时候)
  
    * 区别： 
   
      * while循环是先判断条件再执行循环       
      * do while 是先执行循环再进行条件判断
```     
 eg.输入一个任意数，计算出它的位数
     用一个具体的数字来测试
     例如123，需要输出3
     123/10=12.3 i++(i表示位数，默认为1)
     12/10=1.2  i++
	     	while(number>=10) {
			number = parseInt(number / 10);
		    i++;	
			}	
			document.write(i);
            
   .输入一个整数，翻转输出这个数
     用一个具体的数字来测试
     例如123，需要输出3 2 1
     123%10=3 123/10=12.3（取整）
     12%10=2  12/10=1.2
	        do{
	          var tep=num%10;
	          num=parseInt(num/10);
	          console.log(tep);
	        }while(num!==0);
```

4.数组

  * 用array.length的值做索引,可以解决索引不连续的问题
``` 
     比如输出1-100之间所有的奇数并放入数组
      var array=[];
      for(i=1;i<=100;i++){
     	if(i % 2!=0){
          array[array.length]=i;
          document.write(array+"<br>");
    	}
     }
```

  * 假设法
```
     比如 求一组数中的最大值 最小值
     assum 4 7 8 4 6 9 10 中的最大值(循环次数是array.length-1)
    var max=array[0];//假设数组中的第一个元素是最大值
    var min=array[0];//假设数组中的第一个元素是最小值
    for(i=1;i<array.length;i++){
       if(max<array[i]) {//判断大小
       	max=array[i];
       }
       if(min>array[i]) {//判断大小
        min=array[i];
       }
       console.log(max);
       console.log(min);
   }
```

  * 冒泡排序法
  
      * 思路：
```
	假设数组为[34,45,24,3,4,8]，
	第一趟  比较6次，找出最大数放在最后
	第二趟  比较5次，找出最大数放在倒数第二
	第三趟  比较4次，找出最大数放在倒数第三 
	第四趟  比较3次，找出最大数放在倒数第四 
	第五趟  比较2次，找出最大数放在倒数第五


	方法一：内外循环次数一样 都执行array.length-1次
	  var array=[34,45,24,3,4,8];
	  var s=0;//内循环执行次数
	  var d=0;//外循环执行次数

	  // 外循环控制趟数 ，假设有n个数，则比较的趟数为n-1次
	  for(var i=0;i<array.length-1;i++) {
	  //内循环控制比较的次数
	    for(var j=0;j<array.length-1;j++){//j<array.length-1这个语句会使每次比较次数都为n-1次
	    	//两两比较大小 从小到大
	    	if(array[j]>array[j+1]){
	    		//交换两个数
	    		var tep=array[j];
	    		array[j]=array[j+1];
	    		array[j+1]=tep;
	    	}
	    	s++;
	    }  
	        d++;
	  }	
	  console.log(array);
	  console.log(s);
	  console.log(d);
    
    方法二：减少内循环次数
	  var array=[34,45,24,3,4,8];
	  var s=0;//内循环执行次数
	  var d=0;//外循环执行次数

	  // 外循环控制趟数 ，假设有n个数，则比较的趟数为n-1次
	  for(var i=0;i<array.length-1;i++) {
	  //内循环控制比较的次数
	    for(var j=0;j<array.length-1-i;j++){//比较的次数是array.length-1-i
	    	//两两比较大小 从小到大
	    	if(array[j]>array[j+1]){
	    		//交换两个数
	    		var tep=array[j];
	    		array[j]=array[j+1];
	    		array[j+1]=tep;
	    	}
	    	s++;
	    }  
	        d++;
	  }	
	  console.log(array);
	  console.log(s);
	  console.log(d);

    方法三：减少外循环次数
	  var array=[34,45,24,3,4,8];
	  var s=0;
	  var d=0;
	  //外循环控制趟数 ，假设有n个数，则比较的趟数为n-1次
	  for(var i=0;i<array.length-1;i++) {
	    var isSort=true;//假设已经排好序
	    //内循环控制比较的次数
	    for(var j=0;j<array.length-1-i;j++){
	    	//两两比较大小 从小到大
	    	if(array[j]>array[j+1]){//交换两个数
	    		isSort=false;//如果没有排序好，就继续交换
	    		var tep=array[j];
	    		array[j]=array[j+1];
	    		array[j+1]=tep;
	    	}
	    	s++;
	    }  
	    d++;
	    if(isSort){
	    	break;//已经排序好，就跳出循环
	    }
	  }	
	  console.log(array);
	  console.log(s);
	  console.log(d); 
```
