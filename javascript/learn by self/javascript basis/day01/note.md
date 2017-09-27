###转义字符


   * (\'单引号)
   
   * (\\ 斜杠)
   
   * (\r 回车)
   
   * (\b 退格)

   * (\"双引号)

   * \n换行

   * \t缩进(tab键) 八个空格 并且是必须放在<pre></pre>标签中的 \t包括内容

###+号的作用（算数运算符中的+）

   * 两个操作符不是string和object;把两者转换为数值（Number()）再进行运算。

   * 两个数值相加 加号是加法运算符

   * 两个中有一个是字符串类型。加号起连接作用
   
   * 两个中有一个是Object类型，则默认调用toString()方法；如果对象中重写了toString()方法则调用重写的；如果重写了valueOf()方法则调用valueOf()；如果对象中两个函数都重写了，则调用valueOf()方法。

###变量的命名
 以数字 字母 下划线 $ 组合而成；不能以数字开头 ；驼峰命名规则；不能使用关键字和保留字

###当值为NaN，null,undefined,0,false和空字符串时，布尔类型都转换为false;否则为true.
  
  此方法可以用来判断变量是否有值
  
```
  var meg="";
	if(meg){
        console.log(meg);
	}
	else{
        console.log("please enter a number!");
	}
```

###两个短路运算符
   * &&(当第一个为false则不用判断下一个)
   * ||((当第一个为true则不用判断下一个))
   * 如果两个操作数都不是布尔类型时
     
     * && 如果第一个操作数为false,则返回第一个操作数
       如果第一个为true,则返回第二个操作数
     * || 如果第一个操作数为true,则返回第一个操作数
       如果第一个为false,则返回第二个操作数

###两个变量之间的交换

```
    用一个转换变量
          var tep=n1;
          n1=n2;
          n2=tep;
    不用转换变量
          n1=n1+n2;
          n2=n1-n2;
          n1=n1-n2;
    用异或
    用数组[a,b]=[b,a]
```

###字符串和数值(修改时)

  * 字符串是不可变的，当重新给字符串赋值时需要在栈内存中开辟新空间,内存地址发生改变（哈希码改变）。
  * 数值是可变的，当重新给数值变量赋值时内存不用开辟新空间，内存地址不变，可直接修改

###script标签的属性

  * defer:异步，多个人同时做多件事情；当文档被全部解析完成后再执行下载完的脚本。
  * async:异步，多个人同时做多件事情；当脚本下载完成后立即执行脚本。
  * sync:同步，一个人有序的做多件事情。
  * type 类型为text/javascript.
  * src 引入外部的js文件地址

  * defer和async的区别
  ```
  异步加载
  defer：是新建了一个进程用来下载js脚本
  async:是h5新增的异步属性，用来异步下载js脚本
  两者是在执行的时候有区别
  defer是在文档全部解析完成后执行脚本，在load事件之前执行，当有几个js脚本的时候，执行顺序是依次来的。在DOMCotnet事件之前
  async是在脚本下载完之后直接停止dom加载来执行脚本，当有几个js脚本的时候，执行顺序是不固定的
  ```

###数据类型的转换

1. 类型转换（其他数据类型转换为基本数据类型的boolean string number）
  &强制转换（显式转换）
    01) 其他数据类型到Boolean类型转换
        通过Boolean() 函数转换
        除了0 null undefined "" NaN转换为false之外。其余的都转换为true.

           【Boolean   true      false】
            String      非空字符串   ""
            Number      任何非0        0和NaN
            Object      任何对象    null
            Undefined   n/a         undefined   (n/a not applicable 不适用)
        例如：
            Boolean("");        //false
            Boolean(0);         //false
            Boolean(NaN);       //false
            Boolean(null)       //false
            Boolean(undefined)  //false
            Boolean("briup");   //true
            Boolean(1);         //true

    02) 其他数据类型到数值类型转换
        1.Number()

            1) 如果转换的值是null,undefined,boolean,number
        *       Number(undefined);  //NaN
                Number(true);       //1
                Number(false);      //0
                Number(null);       //0
                Number(10);         //10 如果是数字值,原样输出
        
            2) 如果是字符串：
                Number("");     //空字符串被转换为0

                Number("123");  //如果仅包含数值，转换为对应的数值
                Number("234.1");//解析为对应的小数
                Number("+12.1");// 12.1 首位为符号位，其余为为数值，转换为对应的数值
                Number("-12.1"); //-12.1

        *       Number("1+2.3");//NaN 符号位出现在非首位位置，解析为NaN
        *       Number("123ac");//包含其他字符： NaN
        *       Number("123/");//包含其他字符： NaN

                Number("0xa");  //如果仅包含十六进制格式，转为为对应的十进制的值
                Number("010");  //【注意！】不会当做八进制被解析，结果为10
                
                Number(" 12");  //12
        *       Number("1 2");  //NaN 非首位出现特殊字符(符号位和空格)转换为NaN
        ****总结：1.转换为NaN的三种情况
                        undefined
                        当字符串里 符号位和空格出现在非首位的位置
                        当字符串 包含其他字符时（包括英文字符和特殊字符/$&*等）
                  2.其余的字符串类型都可以转换为数值，并且不解析字符串形式的八进制，忽略前导0直接进行输出；但是解析字符串的十六进制，会进行转换然后输出
                  3.符号位出现在首位的位置的字符串类型，是可以变成正数和负数的数值

        2.parseInt()
            1) 如果转换的值是null,undefined,boolean,number
            *   parseInt(true);     //NaN
            *   parseInt(false);    //NaN
            *   parseInt(null);     //NaN
            *   parseInt(undefined);//NaN
                parseInt(10);       //10 如果是整数值，原样输出
                parseInt(10.3);     //10 如果是小数，舍去小数点一级后面的内容
                parseInt(0);    //0
            2) 如果是字符串：
            *   parseInt("");     //NaN；空字符串被转换为NaN
                parseInt("123");  //123；如果仅包含数值，转换为对应的数值
                parseInt("234.1");//234；小数点后面的数值省略
                parseInt("+12.1");//12； 首位为符号位，其余为为数值，转换为整数
                parseInt("0xa");  //10； 如果仅包含十六进制格式，转为为对应的十进制的值
                parseInt("010");  //10； 【注意！】不会当做八进制被解析，结果为10
                parseInt("1+2.3");//1;  如果首位为数值，依次向后解析，找到连续的数值，直到遇到第一个非数值的，将之前获取的数值转换为Number返回
                parseInt("123ac");//123;

            ****总结：1.转换为NaN的几种情况：
                            ""   null undefined NaN boolean 以及 不包含数字的任意字符串
                     2.其他包含数字类型的字符串遵循 从前到后解析直到遇到特殊字符的时候就结束解析 并输出当前位置之前所解析的数值
                     3.剩下的字符串类型都可以转换为数值，并且不解析字符串形式的八进制，忽略前导0直接进行输出；但是解析字符串的十六进制，会进行转换然后输出
                     4.符号位出现在首位的位置的字符串，是可以变成正数和负数的数值
        
        3.parseFloat()
            与parseInt() 类似，特点基本上一致，但是有下面两点不同： 
                1.字符串中的第一个小数点是有效的，而第二个小数点则无效其后的内容会被省略
                2.始终忽略前导0（字符串为八进制和十六进制的都不会进行解析，直接输出）
                    parseFloat("22.3.4")    //22.3
                    parseFloat("022.34");   //22.34
    
    03) 其他数据类型(这里不包括Object类型)到字符串类型转换
        1. toString()函数
        
        ***toString()函数是Object的一个方法，不能被基本数据类型调用，所以当基本数据类型来调用toString()方法来进行字符串数据转换时，
        浏览器会帮我们进行自动装箱和自动拆箱操作，使我们的基本数据类型能够调用toString()方法
        自动装箱：是把我们要调用toString()方法的基本数据类型的变量 封装成函数对象，使他能调用Object的toString()
        自动拆箱：是在进行装箱操作实现调用之后再进行拆箱 即把它从对象转换为原来声明在js中的变量值的默认类型


            1.默认情况下，toString()是以十进制格式返回数值的字符串表示，通过传递参数，可以输入以二进制，八进制，十六进制乃至任意有效进制格式的字符串值
                
                var num = 10;       数值类型
                num.toString();              "10"
                      自动装箱成Number(num)
               随后进行自动拆箱Number(num)--> num   
                
                num.toString(2);    "1010" 先把num转换为二进制再调用toString()方法
                num.toString(8);    "12"   八进制输出
                num.toString(16);   "a"   十六进制输出

            2.所以number和boolean以及string是可以调用toString()方法
            3.但是null ,undefined 没有toString() 方法
                null.toString()         //报错 TypeError: null has no properties   
                undefined.toString();   //报错 TypeError: undefined has no properties

        2. String() 构造函数
            不管你是什么数据类型的值都会转换成值为本身的一个字符串

                String(null)         "null"
                String(true)         "true"
                String(12)              "12"
                String(undefined);   "undefined"

  &自动转换（隐式转换）
    01)其他数据类型隐式转换为number
        一元运算符加+     a=+a;
        一元运算符减-     a=-a;(如果是数值，直接为负号；如果不是，通过Number()转换为数值再变成负号)
        ""-0
        ""*1
        算术运算符+       当m,n两个数不为String,Object类型的时候，先将m,n转换为Number类型，然后再进行计算
        算术运算符-       返回值为【数值类型】。无论操作数为任何类型，先将其使用Number()转换器转换为Number类型，然后再计算。
        算术运算符*      如果有一个操作数不是数值，则先调用Number()将其转换为数值
        算术运算符/      如果有一个操作数不是数值，则先调用Number()将其转换为数值
        算术运算符%      如果有一个操作数不是数值，则先调用Number()将其转换为数值
    02)其他数据类型隐式转换为string
        +""  空字符串（不能放空格的）
        加空字符串 3+""="3";
    03)其他数据类型隐式转换为boolean
        !!a;
            转换为布尔 !!2=true;


###null和undefined的区别
  
  * undefined和null都属于基本数据类型，但是Undefined表示的是定义了但是没有赋值的变量，而null是指即将要指向一个引用数据类型的内存空间;
  ```
  var a;
  console.log(a);//undefined
  console.log(typeof a);//undefined

  var b=null;
  console.log(b);//null
  console.log(typeof b);//Object

  ```

  * 相等不全等
   ```
   undefined=null;//true
   undefined===null;//false
   ```语句中
   

###es5没有块级作用域，es6是有块级作用域的

  * 块级作用域是程序中一个片段，一个代码块，有自己封闭的作用域
  * 我们常见的if流程控制语句和for循环等语句都没有块级作用域，因此在这些语句中定义的变量是可以被外部所访问的。
  * 而我们所定义的函数是有函数作用域的，在函数内部定义的变量不能被函数外部所访问
