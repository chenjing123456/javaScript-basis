#原型

##Object.create的方法

1.es5中新引入的方法，功能是实现继承，创建一个 原型继承 自参数的对象。就是返回新对象，原型是参数中表示的对象。

```
    var o={
        sayHello:function(){
            console.log('hello');
        }
    }
    var o1=Object.create(o);//创建一个新对象O1,该对象的原型是o
```
```
eg:创建一个对象，有数组的方法，添加值并且遍历出来
var a=Object.create([]);
a.push('2','2','3','3');
for(var i=0;i< .length;i++){
    console.log('['+i+']'+'='+arr[i]);
}
```

2.如果浏览器不支持Object.create属性（兼容浏览器）
```
//方法一：不能改变系统内置的对象,所以不能用
    if(!Object.create){
  Object.create=function(){};
  }
```
```
方法二：兼容浏览器，函数要实现原型继承，返回的对象应该继承obj
function inherit(obj){
      if(Object.create){
        return Object.create(obj);
      }else{
        function F(){};
        F.prototype=obj;//利用直接替换把原型指向obj
        return new F();
    }   
    }
    var arr=inherit([]);
```

##对象的原型链

###原型链

   * 凡是对象就有原型

   * 原型也是对象

   * 因此凡是给定一个对象，那么就可以找到它的原型，原型又是对象，原型又有原型，如此往复，就构成一个对象序列，就称该结构为原型链

###原型链结构

1.默认的原型链结构
  
   * 凡是使用构造函数创建出来的对象，并且没有利用赋值的方式修改原型，就说该对象保留默认原型。
   
   * 默认原型链的结构是什么样的？
      所有构函的默认原型都是Object的一个实例，所以可以调用Object.prototype的方法

```
function Person(){}
var p=new Person();

```
   * 原型链结构就是：当前对象-->构造函数.prototype-->Object.prototype-->null

2.修改的原型链结构
   
   * 在实现继承的时候有时会利用替换的方法实现原型继承，那么原型链结构会发生改变
   * 
```
    function F(){};
    F.prototype=[];
    var a=new F();
```
   * 修改的原型链结构：a-->[]-->Array.prototype-->Object.prototype-->null

##原型式继承

1.所谓原型式继承就是利用修改原型链的结构（增加一个节点，删除一个节点，修改节点中的成员）来使得实例对象可以使用整条链中的所有成员。
使用规则必须满足搜索原则。

2.在js中，所有的对象字面量在解析以后，就是一个具体的对象了，那么可以理解为调用了对应的构造函数。

```
var a={};
var arr=[];
```
![](1.png =50*50) 

#函数的构造函数Function

##函数
1.在js中，使用Function可以实例化函数对象，也就是说在js中函数与普通对象一样，也是一个对象类型。
2.函数是对象，就可以使用对象的动态特性
3.函数是对象，就有构造函数创建函数
3.函数是函数，可以创建其他对象
4.函数是唯一可以限定变量作用域的结果
5.要解决的问题

  * Function如何使用
  * Function与函数的关系
  * 函数的原型链结构

###函数是Function的实例

1.语法
```
new Function(arg0,arg1,arg2,arg3,...argn,body);
```

2.Function中的参数全部都是字符串
3.该构造函数参数的作用是将参数连接起来组成函数

  * 如果参数只有一个，表示函数体
  * 如果参数有多个，那么最后一个表示函数体，前面的所有参数表示函数的参数
  * 如果没有参数，表示创建一个空函数
```
//只带一个参数的情况
// 传统的函数 
  function foo(){
    console.log("你好");
  }
  //Function构函
  var fuc=new Function('console.log("你好");');
  foo();
  fuc();
  //功能是一样的
```
```
//没有任何参数的
var foo=new Function();
```
```
//带有参数的
var foo=new Function("num","console.log(num)";);
```
4.例题：写一个函数，实现输出三个数中的最大数
```
传统实现方法
   function sum( a , b , c ){
    var reg = a > b ? a : b;
    reg = reg > c ? reg : c;
    return reg;
   }
   console.log(sum(123,234,4));
用Function构函实现
   var sum=new Function("a","b","c","var reg = a > b ? a : b;reg = reg > c ? reg : c;return reg;")
   console.log(sum(123,234,4));
```
```
上述构函的方法使代码冗长，下面提供解决方法
//方法一：利用链接字符串符号
   var sum1=new Function("a","b","c",
    "var reg = a > b ? a : b;"+
    "reg = reg > c ? reg : c;"+
    "return reg;"
    )
   console.log(sum1(123,345,5));
//方法二：利用字符串特性
   function sum( a , b , c ){
    var reg = a > b ? a : b;
    reg = reg > c ? reg : c;
    return reg;
   }
   var sum2=new Function("a","b","c","return sum(a,b,c)");
   console.log(sum2(23,233,567));
//方法三：es6,键盘左上角的左单引号表示可换行鉴定符，少有浏览器实现
   var sum3=new Function("a","b","c",
    `var reg = a > b ? a : b;
    reg = reg > c ? reg : c;
    return reg;`)
   console.log(sum(123,234,908));
//方法四：利用Dom方法完成(DIV要先解析)
<body>
<div id="code" style="display:none;">
  var res=a > b ? a : b;
  res=res > c ? res : c ;
  return res;  
</div>
<script>
    var txt=document.getElementById('code').lastChild.nodeValue;
    var sum4=new Function("a","b","c",txt);
    console.log(sum4(4,56,5));
</script>
</body>
```

#arguments对象（函数的内部属性，this也是函数内部属性）

1.arguments是一个伪数组对象，有length属性（实参的个数）和callee属性（表示函数自身），表示 在函数调用的过程中传入的所有参数 的集合，
  
  * 在函数调用过程中没有规定参数的个数和类型，因此函数就具有灵活性，那么为了方便使用，在每一个函数调用过程中，函数的代码体内默认有一个对象arguements,它存储着实际传入的所有参数。
   
2.js中函数并没有规定如何传参
  
  * 定义函数的时候不写参数，一样可以在调用的时候传参
  * 定义的时候写了参数，调用的时候可以不传参
  * 定义的时候写了一个参数，调用的时候可以随意的传递多个参数

3.使用：在代码设计中，如果需要带有任意个参数的时候，一般就不带有任何参数，所有的参数利用arguements来获取
```
function foo(/* */){
  
}
```
4.例题：利用Function创建一个函数，要求允许函数调用时传入任意个参数，并且函数返回这些数字中的最大数。
```
var foo=new Function(
 var args=arguments;
 var max=args[0];//假设第一个参数最大
 for(var i=1;i<args.length;i++){
  if(max<args[i]){
   max=args[i];
    }
  }
 return max;
//谷歌可用
)

```

#函数的原型链结构

1.任意一个函数（构函或者func），都是相当于Function的实例,类似于{}与new Object()的关系
```
（相当于字面量）
function foo(){
  //告诉解释器，有一个对象叫foo，他是一个函数
  //相当于new Function()得到一个函数对象
}
```
2.问题
  
  * 函数应该有什么属性：.__proto__
  * 函数的构造函数是什么：Function
  * 函数应该继承自'Function.prototype'
  * Function.prototype继承自Object.prototype

3.绘制函数原型三角形结构（Function和一般函数func的关系）
  
  * Object构函是Function的一个实例对象。
  * Object作为对象是继承自Function.prototype;又有Function.prototype继承自Object.prototype。
  * Function是自己的构造函数

![](2.png =20*10)
4.绘制Function(Func和Func之间的关系)的原型三角形结构
  
  * Function是自己的构造函数
![](3.png =20*20)


5.绘制Function的完整原型链结构
  
  * function和所有构造函数都是Function的实例
![](4.png =20*20)

#对象的完整的原型链结构（对象和函数的原型链）

  * 假设自定义一个构函Person

![](5.png =20*20)