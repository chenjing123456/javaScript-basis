#函数

1.函数三要素
  
  * 功能
  * 参数
  * 返回值

2.函数的参数
  
  * 形参 定义函数的时候，没有实际的值 给形参占位置
  * 实参 调用函数时有实际的值
    
    * 调用函数的时候 形参个数和实参个数可以不一致
    * 调用函数f(x,y)时，会把x y的值复制给函数内部的a b，函数内部是新赋值的值，无法修改函数外部x y 的值（x,y是基本数据类型）

3.函数返回值
  
  * 如果return后面跟了内容就返回后面的内容
  * 如果return后面没有跟内容就返回undefined
  * 如果函数内部没有return,返回undefined
  * 推荐：要么让函数始终返回一个值，要么永远都不要返回值
  
4.函数内部可以调用其它函数
    
  * 也可以函数内部自己调用自己，称为递归函数arguments.callee()
  
5.javascript语言中没有 重载（名字相同，参数不同）
  js中下面定义相同名字的函数会把前面的覆盖

6.函数声明的两种方式
  
  * 函数声明
     function funName(){
     return ;
     }
  * 函数表达式
     var value=function(){
     return ;
    }

7.变量作用域：变量在什么位置可以使用

  * 作用域
  
    * 全局作用域：在任何位置都可以访问（全局变量）
    * 局部作用域：在函数内部声明一个变量，只有在该函数内部使用(局部变量)

  * 当变量超出作用域之后会被销毁

  * 不用var 声明的变量和在script标签内定义的标签是全局变量
  * 在函数内部用var定义的变量是局部变量

  * 函数内部可以访问到该函数的外部作用域的变量

8.(*)解析器解析过程（先全局作用域再局部作用域）
  
  * 预解析：找var和function以及参数,找到之后把他们的声明提前（变量提升和函数提升）
  * 解析一行执行一行
```
eg:       var a=10;
          f1();
          function f1 () {
            console.log(a);
            var a=20;
          }

```          
  
  * 实例解析：
    
    * 全局作用域
      
       * 先找到Var 和function的声明
               
              function f1 () {
               console.log(a);
               var a=20;
            }
              var a;
       * 留下剩余的赋值和调用...
               a=10;
               f1();

    * 执行到f1()时，进入局部作用域
               function f1 () {
        
        * 先找到var fun的声明
                var a;
        * 接着执行
                console.log(a);//undefined
                a=20;
                }

9.先在当前作用域找a，如果没有则去上一层作用域找，如果在全局作用域还没有找到则报错

10.如下f3()和f4()的区别
```
  f3();
  function f3(){
    var a=b=c=9;//a是局部变量，bc是全局变量
    console.log(a);  9
    console.log(b);  9 
    console.log(c);  9
  }
    console.log(c);  9
    console.log(b);  9
    console.log(a);  出错（a is not defined）

  f4();
  function f4(){
    var a,b,c;
    a=b=c=10;//a,b,c是局部变量.局部作用域解析过程中a,b,c的声明全部被提前
    console.log(a); 10
    console.log(b); 10
    console.log(c); 10
  }
    console.log(c); 报错
    console.log(b); 报错
    console.log(a); 报错
```