#java

##java配置

1. 如何搭建Java的开发环境
  
  * jdk安装
    
    * jdk(java dev kit)
      
      * jre(java runtime env)
      
    * 源码 src.zip
    * 公共JRE
  
  * jdk配置
    
    * JAVA_HOME 家目录 C:\Program Files\Java\jdk1.8.0_111（Java安装路径）
    * Path      在原路径上追加路径 %JAVA_HOME%/bin;(可执行文件路径)
    * CLASSPATH .(类加载路径)

  * 文本编辑器 sublime/editplus...java环境变量配置

2.环境变量配置原理

  * 环境变量的配置的目的是，在dos中让系统帮我们找到该命令所在的位置。可以使各语言的命令在dos中能直接进入安装目录中
  * 如果不进行环境变量的配置，就需要通过cd进入安装目录中找到该命令
   然后再运行程序

```
例如java中
1.没有进行环境变量配置时
  先在家目录chenjing中找-->然后在path找-->最后在当前家目录（java所在的家目录 C:\Program Files\Java\jdk1.8.0_111）--> /bin
 
 所以没配置path时，就去java家目录中找。相当于: 先进入安装目录[ cd C:\Program Files\Java\jdk1.8.0_111\bin (可以找到javac.exe) ] 然后运行 javac 要编译文件
 java命令 相当于先 cd C:\Program Files\Java\jdk1.8.0_111\bin (可以找到java.exe) 然后运行java 要执行文件

2.配置了环境变量
 javac命令 编译文件(让系统可以找到javac.exe的位置)
 java  执行文件

```

3. 如何编写Java代码
  
  * 源代码编写(src目录)
  
  * 进行代码编译(bin目录)
  ```
        Hello.java ->Hello.class
        编译 javac -d ./bin src/Hello.java
  ```
    
  * 运行
  ```
    java -cp ./bin com.briup.day01.Hello
  ```

4. 简单DOS命令

```
    d:              切换到D盘根目录
    cd 目录           进入指定目录
    mkdir 目录名   创建目录
    cls             清屏
    

    特殊目录：
        /   当前盘符的根目录
        .   当前目录
        ..  上一级目录
        ~   家目录 /home/licy(linux)
```

5. Java基本语法
  
  * java文件是以 ".java"结尾 。

  * 文件名要和类名保持一致。
    
  * 在一个Java文件中，能有多个Java类，只有一个类能被public修饰，每一个Java类对应一个.class文件
    
  * Java是一个编译型语言，Javascript是一个解释型语言
        
  ```
        编译：
            Hello.java -> Hello.class
        解释
            Hello.js
                可以直接运行在浏览器或者是Node中
  ```

  * Java跨平台语言: .class 运行在JVM上，java运行时，jvm调用运行的class文件里的main方法，并且可以在dos java命令中传递参数 进入main方法中的args数组中。
    
  * Java类顶级三要素
    
    * 包的声明:域名的反写 com.briup.day01;
    
    * 外部类的导入
    
    * 类的声明

  * 编写以及运行过程
    
    * 编写代码
    ```
            day01 
                bin
                src
                    Hello.java
            
            package com.briup.day01;
            import java.util.Date;

            public class Hello {
                public static void main(String[] args){
                    Date now = new Date();
                    
                    System.out.println("hello world");
                    System.out.println(now):
                }
            }
    ```

    * 编译  
    ``` 
            当前目录 CoreJava/day01
            
            javac [options] 源代码

            javac -d ./bin src/Hello.java
            将src/Hello.java进行编译，并且将编译后的结果放到当前目录下的bin目录下，并且将Hello.java中package的包结构转换为对应文件夹格式
    ```

    * 运行
    ```
            java [options] Java类的完整类名
            java -cp ./bin com.briup.day01.Hello

            -cp命令是指临时指向一条路径去该文件中找
            追加配置环境变量CLASSPATH:.;./bin即可省略-cp ./bin命令

            java -cp ./bin com.briup.day01.Hello
            运行时，jvm调用Hello中的main方法            
    ```

##习题
```
1. JDK包含哪些内容？
    java开发工具集
        jvm     java虚拟机，java运行平台
        jre     java运行时环境，String,Date
        工具  javac java jar javadoc

2. Java语言的特性？
    编译型语言
    跨平台型
    自动垃圾回收机制(不能勉强)

3. Java安装之后需要配置哪些环境变量，分别代表什么意思
    JAVA_HOME   
    path        
    CLASSPATH   .


4. Java的编译命令为？Java的运行命令为？
    javac
    java

5. 一个Java文件中可以有几个Java类？
    多个，但是只能有一个类被public修饰


6. 以下哪个main方法的签名是正确的
    public static void main(String[] args)正确
    public void static main(String args[])
    static public void main(String args[])正确
    static void public mian(String args[])

7. 如何理解类加载机制？
    
    启动类加载
        核心Java包
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\rt.jar

        |   
    扩展类加载
        一般存放用于扩展Java包的其他包
        C:\Program Files\Java\jdk1.8.0_111\jre\lib\ext
        
        |   |
    系统类加载
        系统环境变量
        CLASSPATH   .;./bin

    java com.briup.day01.Hello(省略了-cp ./bin)

        com.briup.day01.Hello   系统类加载
        java.util.Date          启动类加载

    双亲委托机制

jar包由很多class文件组成
如需要打包：必须先进入Bin文件夹
    cd bin

    jar -cvf day01.jar *或者文件名
    将当前目录下的所有文件打包到day01中

```

##java基础语法

1.注释
  
  * 单行注释：//text——从"//"到本行结束的所有字符均作为注释而被编译器忽略
  * 多行注释：/*text*/——从"/*"到"*/"间的所有字符会被编译器忽略
  * 文档注释：
  ```
  /** 
  * text 
  */

  /**到"*/"间的所有字符会被编译器忽略。当这类注释出现在任何声明(如类的声明、类的成员变量的声明或者类的成员方法的声明之前时，会作为JavaDoc文档的内容；

  javadoc -d doc(帮助文档存放地) src/*.java

  ```
  
2.标识符

  * java标识符以字母，数字、_和$开头，不能以数字开头，后跟字母、数字、“_”和“$”的组合;
  * 大小写敏感
  * 没有长度限制。

3. 关键字

  * Java语言的关键字是程序代码中的特殊字符。包括：

    * 类和接口的声明——class, extends, implements, interface
    * 包引入和包声明——import, package
                 . 数据类型——boolean, byte, char, double, float* ort
    * 某些数据类型的可选值——false, true, null
                 . 流程控制——break, case, continue, default, do* , return, switch, while
    * 异常处理——catch, finally, throw, throws, try
                 . 修饰符——abstract, final, native, private* blic, static, synchronized, transient, volatile
    * 操作符——instanceof
    * 创建对象——new
    * 引用——this, super
    * 方法返回类型——void

  * Java语言的保留字是指预留的关键字，它们虽然现在没有作为关键字，但在以后的升级版本中有可能作为关键字。
    
    * 所有关键字都是小写；
    
    * friendly, sizeof不是Java语言的关键字，这有别于C++；
    
    * 程序中标识符不能以关键字命名；

4.数据类型

  * 基本数据类型
    
    * 数值类型
      
        * 浮点数类型(有符号小数)
        ```
        1. 浮点类型表示有小数部分的数字。Java中有两种浮点类型：

          float: 占4个字节，共32位，称为单精度浮点数;有效小数位数是6-7位
          double: 占8个字节，共64位，称为双精度浮点数;有效小数位数是15位

        2. 在默认情况下，小数及采用十进制科学计数法表示的数字都是double类型，可以把它直接赋值给double类型变量。
          double a=12.3;
          double b=0.546793;
          double c=0.11E-2;

          float d=0.4367;//编译出错，默认是double类型的，转换成float会丢失精度
          float d=0.4367F;必须加上f/F可以改变默认，变成float.
        ```
      
        * 整数类型（有符号整数）
        ```

        1.分为四种：
        byte:1个字节，8位，范围是-2^7---2^7-1
        short：2个字节，16位，范围是-2^15---2^15-1
        int：4个字节，32位，范围是-2^31---2^31-1
        long：8个字节，64位，范围是-2^63---2^63-1
        2.int和long时默认是int类型的。
         long a=2836054;//编译成功，int类型转化成long类型不会出错
         long b=2476735L;//编译成功 ，可加L/l,也可以不加
        ```
      
        * 字符类型(无符号)
        ```
        char:2个字节，无符号数据类型 范围是0--2^16
        
        以下四种都可以:
        char c='a';
        char c='\u0061'// \u十六进制的转义
        char c=0x0061;//十六进制数据的unicode编码
        char c=97;//97对应的unicode编码

        ```
    
    * 布尔类型
    ```
    在Java源程序中不允许把整数或null赋给boolean类型的变量，这是有别于其它语言(如c语言)的地方. 只能是true or flase .
    例：
     boolean isMarried = 0;          //编译出错，提示类型不匹配
     boolean isMarried = null;       //编译出错，提示类型不匹配

    ```  

    
  * 引用数据类型
    
      * 类类型
    
      * 接口类型
    
      * 数组类型
  
  * 数据类型转换(除布尔类型之外的基本数据类型)
    
    * 强制类型转换(大范围转换为小范围)
    ```
      long a=10L;
      int b=(int)a;

      1. 截尾：将float/double转型为整型值时，总是对该数字执行截尾
        
      double a = 10.999;    int b = (int)a; //10
    
      2. 舍入
      可以调用Math.round()方法来实现。

      int a=(int)10.3;
    ```

    * 自动类型转换(小范围转换为大范围)
    ```
    long a=10;

    提升：在对基本数据类型执行算术运算或按位运算时，
      1.类型比int小（char,byte,short）那么在运算之前，这些值会自动转换成int,这样一来，最终生成的结果就是int类型。
      2.大于int类型的，表达式中出现的最大的数据类型决定了表达式最终结果的数据类型
    ```

5.推荐命名规则

  * 类名以大写字母开头；
  * 接口名以大写字母开头；
  * 方法名以小写字母开头；
  * 变量名以小写字母开头；
  * 常量名全部大写，多个单词以"_"连接；


6. 转义字符

  * Java编程人员在给字符变量赋值时，通常直接从键盘输入特定的符，而不会使用Unicode字符编码，因为很难记住各种字符的Unicode字符编码值。
  *  对于有些特殊字符，比如单引号，如不知道它的Unicode字符编码直接从键盘输入编译错误：
  ```
  char c = ''';           //编码出错
  为了解决这个问题，可采用转义字符来表示单引号和其他特殊字： 
  char c = '\'';
  char c = '\\';

  转义字符以反斜杠开头，常用转义字符：
  \n           换行符，将光标定位到下一行的开头；
  \t           垂直制表符，将光标移到下一个制表符的位置；
  \r           回车，将光标定位到当前行的开头，不会移到下一行；
  \\           反斜杠字符
  \'           单引号字符 
  ```

7.变量的声明和赋值

  * 定义变量的基本语法为：数据类型  变量名;
  * 先定义，再初始化，再使用的规则

8.对象
  
  * 万物皆为对象。问题领域中的实体和概念都可以抽象为对象。例如学生，成绩单、教师、课和教室。
  * 每个对象都是惟一的。正如世界上不存在一模一样的叶子。
  * 对象具有属性和行为。
  * 对象具有状态，状态是指某个瞬间对象的各个属性的取值。对象的某些行为会改变对象自身的状态，即属性的取值。
  * 每个对象都是某个类的实例。

9.创建类

  * 类是一组具有相同属性和行为对象的模板。面向对象编程的主要任务就是定义对象模型中的各个类。

10.操作符
  
  * 算术运算符
    
      * 数据类型的提升
      ```
      byte a = 3;
      short b = 4;
      int result = a+b;//小于int转换为int
      float c = 4.3F;
      float result2 = c + result;//大于int 取大的
      ```

  
      *  加
      *  减
      *  乘
      *  除(整数运算取整，浮点数运算正常除法)
    ```
       int a=3;
       int b=7;
       a/b=2

       int a=2;
       int b=9.0;
       b/a=4.5
    ```

      * % 取膜(整数取余)
    ```
       int a=3;
       int b=7;
       a%b=1

       int a=2;
       int b=9.0;
       b&a=1.0
    ```

  * 一元加、减操作符:+ -
  
  ```
  一元减用于转变数据的符号。int a=2;  -a=-2;
    
  一元加为了与一元减号对应，唯一的作用是将较小的类型的操作数提升为int   short a=23;  +a (转为int)

  ```

  * 自动递增和递减
    
    * ++ --
    
    ```
    1.前缀式
      先执行运算，再生成值。
      int a = 3;
      ++a;  //a = a+1=4; a =4;
  
    2.后缀式
      先生成值，再执行运算
      int a = 3;
      a++;  //a=3 a=4
    例如：
      int a = 3;
      System.out.println("++a:"+ ++a);  //4
    ```

  * 关系操作符:生成的是一个boolean(布尔)结果，他们计算的是操作数之间的关系。
  
  ```
  > 大于，不适用于boolean
  < 小于，不适用于boolean
  >=  大于等于，不适用于boolean
  <=  小于等于，不适用于boolean
  ==  等于，适用于所有基本数据类型，应用于引用数据类型的时候比较的是指向对象的指针。
  !=  不等，适用于所有基本数据类型，应用于引用数据类型的时候比较的是指向对象的指针。
  ```

  * 逻辑运算符:根据参数的逻辑关系，生成一个boolean(布尔)结果，逻辑运算符只能应用于布尔值。
  
  ```
  && 并且，短路运算符，当第一个表达式为false的时候，不再计算第二个表达式的值,结果为false

  ||  或者，短路运算符，当第一个表达式为true的时候，不再计算第二个表达式的值，结果为true
  
  ! 非
  ```

  * 直接常量:直接常量后面的后缀字标志了它的类型 long a=23456L;
  
  * 三元运算符  表达式? true:false
  
  * 按位操作符
  
  ```
  1.按位与
  2.按位或
  3.按位异或
        正数的元反补都一样，负数的元反补不同。
        负数的反码是除符号位之外，都取反。补码是在反码的基础上加1.
        int a=-3;
        int b=3;
        
        a=-3
        元码：1000 0011
        反码：1111 1100
        补码：1111 1101
        
        b=3
        元码：0000 0011
        反码：0000 0011
        补码：0000 0011

        a&b (补码参与运算，再把补码转换为元码，再转为十进制输出)
        1111 1101 
        0000 0011
        0000 0001=1

        a|b
        1111 1101 
        0000 0011
        1111 1111 =1111 1110(反码)=1000 0001(元码)=-1

        a^b
        1111 1101 
        0000 0011
        1111 1110=1111 1101(反码)=1000 0010(元码)=-2
  ```

  4.位移
    (1) <<左位移 (乘以2的位移位数的次方)
        
    (2) >>右位移(除以2的位移位数的次方)
        int a = 3;
        int b = -12;
         a<<2  3 * 2^2=12
         a>>2  3 / 2^2=0
         a>>1  a / 2^1=1
    (3)
        ```

11.import:导入其他类，导入后在当前类调用该类时可以直接使用类名，不用加包名
  
  * 不需要导入的类的情况有两种
      
      * 需要导入的类在java.lang下
      ```
      String
      Math
      Exception
      Boolean/Character/Integer/Long...
      ```

      * 需要导入的类与当前类在同包下

12.String类型的变量

  * 声明的字符串是不可变的
  * 用String类声明的变量是引用数据类型
  * 用String类创建的String实例对象放在堆中
  * 用String类声明的字面量是存放在堆中的常量池中的.(字面量形式声明字符串时特有)
    
      * 例如：常量池中先前如果存放了“hello”时，则后面再有是hello的字符串就可以直接拿原先存放在常量池中的hello,不需要新建
      
  * 数据的比较 比较的是在栈中储存的变量的值；基本数据类型比较的是储存在栈中变量的值；引用数据类型的比较比较的是存放在栈中变量的引用地址

![]( day03/字符串.png=20*30)

13.变量

  * 变量的使用有一个作用域的问题，作用域是指它的存在范围，只有在这个范围内，程序代码才能访问它。
  * 作用域决定了变量的生命周期。变量的生命周期是指从一个变量被创建并分配内存空间开始，到这个变量被销毁并清除其所占用内存空间的过程。当一个变量被定义时，它的作用域就被确定了。按照作用域的不同，变量可分为以下类型：
  
      * 局部变量
      ```
      1.定义在方法的内部或方法的一个代码块的内部
      2.局部变量没有默认值，必须初始化
      3.局部变量不能使用访问修饰符修饰
      4.生命周期（创建分配内存空间到销毁清除内存空间）
        public class Sample {
          public int add() {
                int addResult = 1;
                addResult = addResult+2;
                return addResult;
            }
          public int subtract() {
                int subResult = 1;
                subResult = subResult-2;
                return subResult;                                          
          }
          public static void main(String[] args) {
              Sample s = new Sample();
              s.add();//开始局部变量addResult的生命周期，位于Java栈区；结束局部变量addResult的生命周期，退回到main方法；
              s.add();//开始局部变量addResult的生命周期，位于Java栈区；结束局部变量addResult的生命周期，退回到main方法；
                            }
                     }
        调用Sample实例的add方法，开始局部变量addResult的生命周期，addResult位于Java栈区。执行完毕Sample实例的add方法，结束局部变量addResult的生命周期，退回到main方法；
      5.

      ```

      * 实例变量(成员变量)
      
        ```
        1.在类中声明，作用域是整个类(定义在类中方法外的变量也称为全局变量或者属性)
          
          char  \u0000
          byte  (byte)0
          short (short)0
          int  0
          long 0L
          float 0.0F
          double 0.0D
          引用类型 null

        2.实例变量有默认值，使用之前可无须初始化直接使用
        3.全局变量可以使用访问修饰符修饰
        4.声明周期
           class Test {
                private int n1=0;
                private int n2=0;
                  public int add() {
                        int result = n2 + n2;
                        n1 = n1+1;
                        n2 = n2+2;
                        return result;
                  }
                  public static void main(String[] args) {
                        Test t1 = new Test();
                        Test t2 = new Test();
                        t1.add();
                        t1.add();
                        t2.add();
                             }
                       }  
          创建Test实例，开始实例变量n1,n2的生命周期，n1,n2位于堆区。执行完毕Test类的main方法，结束Test实例及它的实例变量n1，n2的生命周期，卸载Sample类，Java虚拟机运行结束。
                     
        ```

      * 方法参数:方法或者构造方法的参数，它的作用域是整个方法或者构造方法。
      * 异常处理参数:和方法参数很相似，差别在于前者是传递参数给异常处理代码块，而后者是传递参数给方法或者构造方法。异常处理参数是指catch(Exception e)语句中的异常参数"e"，它的作用域是紧跟着catch(Exception e)语句后的代码块。

14.三目运算符
  
    * 必须要确定返回值
    * 返回值的类型必须要符合exp1的返回值类型和exp2的返回值类型
    ```
    int a = 3;
    double result = (a == 3) ? 3.2 :2 ;
    Object reesult = (a == 3) ? "fh" : 3.2 ;
    ```

##控制执行语句

###分支语句

1.if-else

  * if后面的表达式必须是布尔表达式，而不能为数字类型，
  * 假如if语句或else语句的程序代码块中包括多条语句，则必须放在大括号{}内。若程序代码块只有一条语句则可以不用大括号{}。流程控制语句(如if...else语句)可作为一条语句看待

  
2.switch-case

  * 语法
  ```
  语法：switch(expr) {
      case value1:
         statements;
        break;
    ...
      case valueN
         statments;
         break;

      default:
         statements;
         break; 
         }
  ```

  * expr的类型必须是byte, short, char或者int;
  * valuesN类型必须是byte, short, char或者int,该值必须是常量。各个case子句的valueN值不同；
  * 当switch表达式的值不与任何case子句匹配时，程序执行default子句，假如没有default子句，则程序直接退出switch语句。default子句可以位于switch语句中的任何位置。default子句放在最后可以不加break;但放在其他位置必须要break
   


###循环语句

1.for循环
  
  * 语法：for(初始化部分；循环条件；迭代部分) {
              循环体
          }
  * 在执行for语句时，先执行初始化部分，这部分只会被执行一次；接下来计算作为循环条件的布尔表达式，如果为true，就执行循环体；接着执行迭代部分，然后再计算作为循环条件的布尔表达式，如此反复；
  * 在for语句内声明的变量的作用域为当前for语句，不能在for语句以外的地方使用它。

2.while循环

  * 语法：[初始化部分]
          while(循环条件) {
             循环体,包括迭代部分
           }
  * 当循环条件为true时，就重复执行循环，否则终止循环；
  
3.do while循环（必须有分号）

  * 语法：[初始化部分]
        do {
            循环体,包括迭代部分
        } while(循环条件);
  * 和while非常类似，只不过先执行循环体，然后再判断循环条件。

4.for和while 判断结束条件比do-while循环 多一次。
```
  

```

### 跳出循环
    
1. return:该关键字具有两方面的用途: 一方面指定一个方法返回什么值；另一方面它会导致当前的方法退出，并返回那个值。
  
2. break:用于强行退出循环，不执行循环中剩余的语句。
    
3. continue:用于停止执行当前的迭代，然后退回循环起始处，开始下一次迭代

##数组

1.定义：数组是存放一系列相同数据类型值的集合。通过索引号来访问数组中的元素。数组一旦被创建，不能修改其大小

2.声明：
  
  * 数据类型[] 变量名
  * 或者 数据类型 变量名[]

3.初始化：使用new 关键字初始化数组 int[] arr = new int[]{ }
  
  * 系统初始化：初始化规则与实例变量初始化规则相同  int[] arr = new int[5];  //创建长度为5的数组，数组中的元素默认被初始化为0
  * 自定义初始化：int[] arr = new int[]{1,2,3,4,5};
  * 字面量初始化：int[] arr = {1,2,3,4};

4.访问：通过索引来访问数组中的元素，索引的范围为0~数组长度-1。一旦超出这个访问，将会报运行时异常ArrayIndexOutOfBoundsException（编译阶段不会被发现，只能在运行时刻才能看到）。

5.遍历：
  
  * 增强for循环
  ```
  for(数据类型 item : 数组){}

  for(int item : arr){
     System.out.print(item+"");
  }
  ```

  * for.while和do-while

6.数组拷贝
  
  * 引用地址拷贝 int[] arr = new int[]{1,2,3,4};  int[] arr2 =arr;//将原数组的指针传递给arr2.
  
  * 数组值拷贝 如果想要将arr数组的值拷贝给arr2，需要调用Array.copyOf()方法

7.多维数组（数组中的数组）

  * 声明
      
      * int[][] arr; //int[]表示数据类型，后面的[]表示变量是一个数组
      * int arr[][];//表示数组arr中存放了int类型的数组
      
  * 初始化
  
      * 系统初始化
      * 自定义初始化
      * 字面量初始化
      ```
      1.系统初始化
      int[][] arr =new int[2][3];
      arr数组中可以包含2个元素，这两个元素均为数组，每个子元素中包含3个元素，每个元素为0

      int[][] arr =new int[3][];
      arr数组中可以包含3个元素，每个元素的数据类型为数组，但是子数组没有初始化，所以这三个元素的默认值为null
      
      2.自定义初始化
      int[][] arr=new int[][]{{12,3,4},{45,78,0}};

      3.字面量初始化
      int[][]={{34,87},{4,67}};

      ```

###注意点

1.字符串的长度是方法。数组的长度是属性

  String str = "hello";
  System.out.print(str.length());

  int[] arr = new int[];
  System.out.print(arr.length);


#算法


