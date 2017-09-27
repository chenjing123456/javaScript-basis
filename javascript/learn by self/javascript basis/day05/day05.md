#js内置对象

1.String对象
  
  * 创建字符串对象
```
var str1 = "hello world";
var str2 = new String("hello world");
```

  * String对象的属性：length
  * String对象的方法：
  
    * 大小写转换：toLowerCase()：转为小写；toUpperCase()：转为大写。
    
    * 获取指定字符：
    ```
      charAt(index)：返回指定位置index的字符；
      
      charCodeAt(index)：返回指定位置index的字符的Unicode编码
         （ 注意事项：下标index从0开始。）
    ```

    * 查询指定字符串：
    ```  
       indexOf(findstr,index)：从前往后，从位置index开始查找指定的字符串findstr，并返回出现的首字符的位置。
      
       lastIndexOf(findstr)：从后往前，查找指定的字符串findstr，并返回出现的首字符的位置。（注意事项：index可省略，代表从0开始找。如果没有找到则返回-1。）
    ```

    * 获取子字符串：substring(startindex,endindex)：从start开始，到end结束，不包含end。
      ```
      var str1="abcdefgh";
      varstr2=str1.substring(2,4);alert(str2);//结果为 cd
      ```

          * 替换子字符串：replace(oldstr,newstr)：返回替换后的字符串。
      ```
      var str1="abcde";
      varstr2=str1.replace("cd","aaa");alert(str2);//结果为 abaaae
      ``` 

    * 拆分子字符串：stringObject.split(bystr,limit),limit是可选参数：用bystr分割字符串，并返回分割后的字符串数组
      bystr 可以为,和""
```
      没放逗号的字符串 
         var str="23456577";
         var str7=str.split(",");//数组长度是1
      放了逗号的字符串
         var str0="i,am, huang, qi";
          console.log(str0.split(""));//数组长度是13 每一个都会分割
```     

2.Number对象:Number对象是原始数值的包装对象。
 
  * 创建Number对象
```
      var myNum=new Number(value);创建了一个数值对象
      var myNun=Number(value);
      var a=5;
```

  * 常用方法
    
    * toString：数值转换为字符串。
    * toFixed(n)：数值转换为字符串，并保留小数点后n位数，多了就截断，四舍五入。少了就用0补足，常用作数值的格式化。

3.Boolean对象

4.数组对象
 
  * 检测数组
    
    * instanceof:instanceof 和 typeof 的区别

	    * typeof 可以获取任意变量的类型;但如果是对象的话,只能判断为Object,不能判断其具体的属于什么对象类型
	    * instanceof 可以判断对象的具体类型
    Array.isArray();html5新增

  * 创建数组对象
    
    * 数组字面量
```
    var arr = ["mary",10,true];//用中括号！不是大括号；常用；声明的同时并赋值。
```

    * 用内置对象创建
```
       1.var arr = new Array("mary",10,true);//声明的同时并赋值。
       2.var arr = new Array();或var arr = new Array(7);//可有长度也可没有长度。即便写了长度，也能把第8个数据存入！先声明后赋值。
```

  * 数组属性：length
  
  * 数组方法：
  
      * 数组转换为字符串
```
          ①join(bystr)：以bystr作为连接数组中元素的分隔字符，返回拼接后的数组。
          ②toString()：以字符串形式输出数组（以逗号隔开）。
      例如：var arr1=[1,2,3,4];
            alert(arr1.toString()); //1,2,3,4 
            alert(arr1.join("-"));//1-2-3-4
```

      * 连接数组，concat(value,…)：value作为数组元素连接到数组的末尾（数组连接），返回连接后的数组。
```
       例如：var a=[1,2,3];      var b=a.concat(4,5);
             alert(a.toString());//1,2,3 
             alert(b.toString());//1,2,3,4,5
            注意事项：concat方法并不改变原来数组的内容！
```

      * 获取子数组，（复制）slice(start,end)：截取从start开始到end结束（不包含end）的数组元素。end省略代表从start开始到数组结尾。
      
      * 数组反转，reverse()：改变原数组元素的顺序。
```
        例如：var arr1=[32,12,111,444];
              alert(arr1.reverse());//444,111,12,32
```     

      * 数组排序
      
        * sort()：数组排序，默认按照字符串的编码顺序进行排序。
        * sort(sortfunc)：sortfunc用来确定元素顺序的函数名称。
        
      * 添加和删除数组元素
```
       pop()删除并返回最后一个元素
       push()在最后添加元素，输出结果是数组长度
       shift()删除并返回第一个元素
       unshift()在头部添加元素，输出结果是数组长度
```

      * splice(start,number of remove,"str")从某一位置移除并添加新元素
      
  * 多维数组

5.Math对象：用于执行相关的数学计算。（直接使用）
           
  * 没有构造函数Math()。
  * 不需要创建，直接把Math作为对象使用就可以调用其所有属性和方法。如：不需要创建var data=Math.PI; 直接使用Math.PI;像Java中的静态类一样。
  * 常用属性：
    
    * 都是数学常数，如：Math.E（自然数）、Math.PI（圆周率）、Math.LN2（ln2）、Math.LN10（ln10）等
  * 常用方法：
```
      ①三角函数：Math.sin(x)、Math.cos(x)、Math.tan(x)等
      ②反三角函数：Math.asin(x)、Math.acos(x)等
      ③计算函数：Math.sqrt(x)、Math.log(x)、Math.exp(x)等
      ④数值比较函数：Math.abs(x)、Math.max(x,y,...)、Math.random()、Math.round(x)等
       注意事项：
       Math.random()：是一个 >=0 且 <1 的正小数
       Math.floor(x)：地板，小于等于x，并且与它最接近的整数。注意：将负数舍入为更小的负数，而不是向0进行舍入。 
       Math.ceil(x)：天花板，返回大于等于x，并且与它最接近的整数。注意：不会将负数舍人为更小的负数，而是向0舍入。
```

6.Date对象：Date对象用于处理日期和时间。
      [注意]在ECMAScript5中，如果使用标准的日期时间字符串格式规则的字符串中，数学前有前置0，则会解析为UTC时间，时间没有前置0，则会解析为本地时间。其他情况一般都会解析为本地时间
  
  * 静态方法
    
    * Date.now()
       ECMAScript5新增了now()方法，该方法返回当前时间距离1970年1月1日0点UTC的毫秒数。该方法不支持传递参数
    * Date.parse()

      * 该方法用于解析一个日期字符串，参数是一个包含待解析    的日期和时间的字符串，返回从1970年1月1日0点到给定日期的毫秒数
      * 该方法会根据日期时间字符串格式规则来解析字符串的格式，除了标准格式外，以下格式也支持。如果字符串无法识别，将返回NaN
```
         1、'月/日/年' 如6/13/2004
         2、'月 日,年' 如January 12,2004或Jan 12,2004
 　　    3、'星期 月 日 年 时:分:秒 时区' Tue May 25 2004 00:00:00 GMT-0700
　　    [注意]浏览器不支持不表示日期只表示时间的字符串格式
        [注意]该方法返回的是Number数字类型
```

    * Date.UTC()
         
      * Date.UTC()同样返回给定日期的毫秒数，但其参数并不是一个字符串，而是分别代表年、月、日、时、分、秒、毫秒的数字参数
      * Date.UTC(year,month,day,hours,minutes,seconds,ms)，year和month参数是固定的，其余参数可选，日期时间格式规则详见此
         因为该函数有7个形参，所以其length值为7

  * Date构造函数使用
    
    * Date()函数可以不带new操作符，像一个函数一样调用。它将忽略所有传入的参数，并返回当前日期和时间的一个字符串表示
              　[注意]由于Date()函数没有使用操作符，实际上它不能被称为构造函数。是string类型
    
    * Date()函数使用new操作符，且不带参数时，将根据当前时间和日期创建一个Date对象
    
    * Date()函数可接受一个数字参数，该参数表示设定时间与1970年1月1日0点之间的毫秒数
    
    * Date()函数可接受一个字符串参数，参数形式类似于Date.parse()方法。但parse()方法返回的是一个数字，而Date()函数返回的是一个对象 
    
    * Date()函数可接受参数形式类似于Date.UTC()方法的参数，但Date.UTC()方法返回是一个毫秒数，且是UTC时间，而Date()函数返回是一个对象，且是本地时间
    
  * 常用方法（三类）
    
    * 【to类】to类方法从Date对象返回一个字符串，表示指定的时间
```
        toString()返回本地时区的日期字符串
        toUTCString()返回UTC时间的日期字符串
        toISOString()返回Date对象的标准的日期时间字符串格式的字符串
        toDateString()返回Date对象的日期部分的字符串
        toTimeString()返回Date对象的时间部分的字符串
        toJSON()返回一个符合JSON格式的日期字符串，与toISOString方法的返回结果完全相同
        toLocaleString()  toString()方法的本地化转换
        toLocaleTimeString()　toTimeString()方法的本地化转换
        toLocaleDateString()　toDateString()方法的本地化转换
```

    * 【get类】Date对象提供了一系列get类方法，用来获取实例对象某个方面的值
         在介绍get类方法之前，首先要介绍valueOf()方法
```
        valueOf()  返回距离1970年1月1日0点的毫秒数
　　              因此，可以方便地使用比较运算符来比较日期值
        getTime()　　返回距离1970年1月1日0点的毫秒数，同valueOf()　　在ECMAScript5之前，可以使用getTime()方法实现Date.now()
        getTimezoneOffset()
             返回当前时间与UTC的时区差异，以分钟表示(8*60=480分钟)，返回结果考虑到了夏令时因素
        getYear()　　返回距离1900年的年数(已过时)
        get[UTC]FullYear()　　返回年份(4位数)
        get[UTC]Month()　　返回月份(0-11)
        get[UTC]Date()　　返回第几天(1-31)
        get[UTC]Day()　　返回星期几(0-6)
        get[UTC]Hours()　　返回小时值(0-23)
        get[UTC]Minutes()　　返回分钟值(0-59)
        get[UTC]Seconds()　　返回秒值(0-59)
        get[UTC]Milliseconds()　　返回毫秒值(0-999)
        [注意]通过标准日期时间格式字符串，且有前置0的形式的参数设置，设置的是UTC时间
```

    * 【set类】Date对象提供了一系列set类方法，用来设置实例对象的各个方面
       set方法基本与get方法相对应，set方法传入类似于Date.UTC()的参数，返回调整后的日期的内部毫秒数
       [注意]星期只能获取，不能设置
```
     setTime() 使用毫秒的格式，设置一个Date对象的值3
     set[UTC]FullYear() 设置年份(4位数)，以及可选的月份值和日期值
     set[UTC]Month() 设置月份(0-11)，以及可选的日期值
     set[UTC]Date() 设置第几天(1-31)
     set[UTC]Hours() 设置小时值(0-23)，以及可选的分钟值、秒值及毫秒值
     set[UTC]Minutes() 设置分钟值(0-59)，以及可选的秒值及毫秒值
     set[UTC]Seconds() 设置秒值(0-59)，以及可选的毫秒值
     set[UTC]Milliseconds() 设置毫秒值(0-999)
  MDN文档：http://devoloper.mozilla.org/zh-CN
```

#内置对象DOM

1.Document Object model文档对象模型，是一套操作html和xml文档的API

2.ducument可以做什么
  
  * 找对象（元素）
  * 设置元素的属性
  * 设置元素的样式
  * 动态创建和删除元素
  * 事件--触发响应  
       
    * 事件的触发者（事件源）
    * 事件名称
    * 事件响应程序

