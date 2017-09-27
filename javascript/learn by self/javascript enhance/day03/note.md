#原型

##传统构造函数
1.在代码中重复执行的代码容易出现重复的对象

2.创建一个Person构造函数以创建对象
```
function Person(name,age,gender){
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.sayHello=function (){
			console.log(this.name +" "+ "say hello");
		}
	}
	var p1=new Person("zs",12,"女");
  var p2=new Person("li",18,"女");
	console.log(p1.sayHello==p2.sayHello);//false，两个对象的方法是不同的
	p1.sayHello();
```
```
    function sayHello(){
			console.log(" "+ "say hello");
		}//将方法抽取出来
	function Person(name,age,gender){
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.sayHello=sayHello;
	}
	var p1=new Person("zs",12,"女");
	var p2=new Person("li",18,"女");
	console.log(p1.sayHello==p2.sayHello);//true
```
3.传统的构造函数的定义方式会影响性能，容易造成多个对象有多个方法副本,应该将方法抽取出来，让所有对象共享。

4.可以考虑将方法全部放到外面但是有安全隐患

  * 在开发中会引入各种框架或者库，自定义的成员越多，出现的命名冲突几率越大
  
  * 可能在开发中会有多个构造函数，每个构造函数应该有多个方法，那么就会变得不容易维护

5.任意一个对象都会默认的链接到它的原型中

 * 创建一个函数，会附带的创建一个特殊的对象，该对象使用 函数.prototype 引用(作为函数的一个属性)，称其为函数的原型属性。
 
 * 每一个由该函数作为构造函数创建的对象，都会默认的链接到该对象上
 
 * 在该对象访问某一个方法或属性的时候，如果该对象没有，就会到这个神秘对象中去找

##传统构造函数出现的问题
```
function Foo(){
	this.sayHello=function(){
}
}
```
1.由于对象是有new Foo()创建的，因此每一个对象在创建的时候，函数sayHello()都会被创建
2.那么每一个对象都会含有一个独立的不同的但是功能一样的函数
3.在代码中方法会消耗性能。最典型的资源就是内存
4.所有可以把方法放在构造函数之外。那么构造函数中只需引用该函数即可
```
function sayHello(){};
function Foo(){
	this.say=sayHello;
}
```
5.但是会在开发中变得困难，不好维护。解决办法就是外面的函数如果不占用名字，而且在函数旗下即可。
6.每一个函数在定义时有一个神秘对象（Foo.prototype）被创建出来，每一个由构造函数创建的对象都会默认链接到神秘对象(Foo.prototype)上。
```
var p1=new Foo();
var p2=new Foo();
p1.say();//如果p1中没有say，那么就会在Foo.prototype原型对象上找
```
7.由构造函数创建出来的多个实例对象共享一个对象，即构造函数.prototype对象。
8.结论：只需要将重复会多占用内存的东西放到构造函数.prototype中，那么所有对象就可以共享了.
```
function Foo(){};
Foo.prototype.say=function(){
	
}
var p1=new Foo();
p1.say();
var p2=new Foo();
p2.say();
```

##原型相关的概念

1.面向对象的概念

  - 类class:在javascript中就是构造函数
  
	 - 在传统的面向对象语言中，使用一个叫做类的东西用来定义模板，使用模板创建对象
        
	 - 在构造方法中也具有类似功能，所以也可叫构造函数为类
	     ```
	     在java 中，最小代码单位是类
	     class Progroam{}//属于纯面向对象语言
	     ```

  - 实例(instance)和对象(object)
  
     - 实例是指某一个构造函数创建出来的对象，我们称为构造函数的实例
     
     - 实例就是对象，对象是一个泛称
     
     - 实例和对象是近义词
        
  - 键值对：属性和方法
  
     * 在js中键值对的集合称为对象
           
       * 如果值为数据，就称给键值对为属性property
           
       * 如果值为函数,就称该键值对为方法method
  
  - 父类和子类
  
     *  传统的对象语言中使用类来实现继承，那么就有父类和子类的概念，基类和子类。
        
     *  在js中常常称为父对象，子对象，基对象，派生对象。

2.原型相关的概念

 * （重）神秘对象针对构造函数称为"原型属性"，简称为原型(针对构函)

 * 神秘对象与构造函数创建出来的对象（实例对象）也有一定关系
 
    * 用构造函数创建的对象默认链接上神秘对象，(就是去构造函数上的原型属性上找)

 * （重）神秘对象针对构造函数创建出来的对象称为“原型对象”，简称原型（针对构函创建的对象）
 
 * 对象继承自其原型
 
    * 构函创建的对象继承自构函的原型属性
  
    * 构函创建的对象继承自该对象的原型对象
  
    * 构造函数所创建出来的对象（实例对象）与构造函数的原型属性表示的对象是两个不同的对象
    
         * 原型中的成员，可以直接被实例对象所使用
         * 也就是说实例对象直接含有原型中的成员
         * 因此实例对象继承自原型
         * 这样的继承就是“原型继承”。

![](原型继承.png =50*30)  

3.常用对象

 - {}--构函是Object
 
 - []--构函是Array
 
 - /./--是正则表达式
 
 - function--构函是Function

##如何使用原型

1.为什么使用原型：提高函数复用性，实现继承

2.怎么使用

   * 利用对象的动态特性(点语法)
     ```
     构函.prototype.xxx=vvv;
     ```
   * 利用直接替换
     ```
      构函.prototype={
      constructor: ;
     	//添加方法
     }
     ```

![](原型使用.png =50*50)     

##markdown语法

1.ctrl+shift+p，绕后输入mp,选择markdown,进行浏览器浏览

2.  语法

  * (``````)插入代码块
   
  * 表示一到六级标题  #-######
  
  * 有序列表和无序列表
  
    * 可以用* - + 表示无序列表（必须前后有空格）
  
    * 用1 2 3表示有序列表
    
    * 用```![](路径 =width*height)```表示图片
    
##json对象与对象字面量的区别

1.json对象有两种：一种是传统的json对象(与对象字面量无差)；一种是符合json协议的对象。

2.符合json协议的对象要求所有的属性名必须带有引号
  ```
  var o1={name:"zs"};//传统
  var o={//符合协议的
  "name":"fh",
  "age":19
  }
  JSON.parse('{"name":"zs"}');
  ```

#
#
#
#

#`__proto__`属性

1.来由

  * 以前要访问原型，必须使用构函来实现，无法直接使用实例对象来访问原型

  * 火狐最早引入属性`__proto__`表示使用实例对象引用原型，但是早期是非标准的

  * 通过该属性可以允许使用实例对象直接访问原型
```
function Person(){}
//神秘对象就是Person.prototype
//那么只有使用构函才可以访问它
var o=new Person();
//以前不能用o来访问神秘对象
//现在有了__proto__之后
//o.__proto__也可以直接访问神秘对象（两条下划线）
//即o.__proto__===Person.prototype

```

2.神秘对象中默认都有一个属性`constructor`,翻译为构造器，表示该原型是与什么构造函数联系起来的。

3.`__proto__`有什么用

  * 可以访问原型
  
  * 在开发中除非特殊要求，不要使用实例修改原型，因此在开发时很少使用
  
  * 但是在调试过程中非常方便，可以轻易的访问原型进行原型成员查看

4.如果在早期的浏览器中使用实例访问原型如何处理
 
  * 可以使用实例对象访问 构造器，然后通过构造器访问原型
  ```
  var o=new Person();
  o.constructor.prototype
  ```

5.如果给实例继承自原型的属性赋值,原型中的属性不变，只能给自己的实例对象赋值

```
  function Foo(){};
  Foo.prototype.name="text";//原型中的属性，一直存在
  var o1=new Foo();
  var o2=new Foo();
  o1.name='zs';//不是修改原型中的name,而是自己增加了一个属性
  console.log(o1.name+"和"+o2.name);//zs和text
  //访问的时候优先考虑实例自身的属性，没有的时候再去原型中去找
```

#
#
#
#继承的概念

1.拿来主义，自己没有别人有的，拿过来自己用

2.继承的方法

  * 最简单的继承就是将别的对象强加到我的身上，那么我就有了这个成员
  
  * 利用原型也可以实现继承，不需要在实例身上添加任何成员，只要原型有，实例就有了
  
3.结论：因此可以结合两种方法,即混合式继承法，分为两种。

##混合式继承简单描述
  1.将属性和方法等成员利用混入的方法，加到构造函数的原型上，那么构函的实例就具有该方法了。
  ```
  var Person=function (){}
  //混入方法
  var extend=function(o1,o2){
    for(var k in o2){
      o1[ k ]=o2[ k ];
    }
  }
  //调用混入方法，把方法全部赋给原型
  extend(Person.prototype,{
    eat:function(){console.log("eating")},
    wear:function(){console.log('wearing')},
    run:function(){console.log('running')}
  })
  var p1=new Person();
  var p2=new Person();
  p1.run();
  p2.eat();
  ```
代码简化
```
    var Person=function(){}
    //直接把extend方法给原型
    Person.prototype.extend=function(o){
      for(var k in o){
        this[ k ]=o[ k ];
      }
    }
    //直接调用原型的混入方法即可给原型添加方法，则实例可以直接使用
    Person.prototype.extend({
      eat:function(){console.log("eating")},
      wear:function(){console.log('wearing')},
      run:function(){console.log('running')}
    })
    var p1=new Person();
    var p2=new Person();
    p1.run();
    p2.eat();
```

##混合式继承复杂描述

1.new divTag() 用来创建div对象

2.appendTo 加到某元素上

3.扩展
  
  * p
  * img
  * span
  * ...
4.结论，无论方法怎么写，方法是谁调用的，this就指向谁
     
#细节

1.用点语法给原型添加成员和与使用直接替换修改原型对象有什么区别 

  * 原型指向发生了变化
  
  * 构造函数所创建的对象所继承的原型不同
  
  * 新增的对象(即新指向的原型)默认是没有constructor属性

```
function Person(){}  
    //点语法添加成员
    Person.prototype.fuc=function(){
        console.log("11111");
    }
    var p1=new Person();
    //直接替换修改原型
    Person.prototype={
      fuc:function(){
        console.log("22222");
      }
    }
    var p2=new Person();
    p1.fuc();
    p2.fuc();
```

2.注意：所以在使用直接替换的方法修改原型的时候，一般都会添加constructor属性

```
function Person(){}
Person.prototype={
  constructor:Person //存入了构函的地址
};
```

3.有时候根据需要在构函内部还会调用构造函数

  * 在这种情况下，不要使用构造函数的名字，而应该使用this.constructor来表示构函。
 
```
function Person(){
  
  return new this.constructor();
  //而不能使用return new Person();
}
var F=Person;//把Person对象的地址赋给F
Person=123;//Person不再是构造函数
new F();
```
#原型实例构函三角图

1.三角图：![](原型实例构函三角图.png =50*50)

2.练习：

```
1.
function Person(){
  this.name='zs',
  this.sayHello=function(){
  console.log('hello');
  }
}
var p=new Person();
var q=new Person();
```
![](1.png =20*20)

```
2.点语法
function Person(){
  this.name='zs'
}
Person.prototype.sayHello=function(){
  console.log('hello');
  }
var p=new Person();
var q=new Person();
```
![](2.png =20*20)

```
3.直接替换法（新创建的原型默认没有constructor属性）
function Person(){
  this.name='zs'
}
Person.prototype={
  sayHello:function(){
  console.log('hello');
  }
}
var p=new Person();
var q=new Person();
```

![](3.png =20*20)

#自定义集合

自定义构造函数的prototype属性用数组代替

1.一般情况下，开发中尽量少修改内置的系统对象和构函，所以使用[]缓冲
```
function ItCastCollection(){};
  //要定义数组的方法为其添加成员
  ItCastCollection.prototype=[];
  //ItCastCollection.prototype=new Array(0);
  //一般情况下，开发中尽量少修改内置的系统对象
  var arr=new ItCastCollection();
  arr.push('2','d','f','4');
  //自定义集合的目的是让其向数组一样使用，但是同时有一些数组无法实现的方法
  ItCastCollection.prototype.sum=function(){};
  console.log([].sum);//undefined
```

2.不建议使用此方法，因为自己定义的特有方法会污染Array.prototype的内置方法
```
function ItCastCollection(){};
  //要定义数组的方法为其添加成员
  ItCastCollection.prototype=Array.prototype;//性能比上面好，但是会污染系统对象
  var arr=new ItCastCollection();
  arr.push('2','d','f','4');
  //自定义集合的目的是让其向数组一样使用，但是同时有一些数组无法实现的方法
  ItCastCollection.prototype.sum=function(){};
  console.log([].sum);//function,会污染系统的内置构函
```

#属性搜索原则

1.原型链

2.属性搜索原则
   
   * 就是对象在访问属性和方法的时候，首先在该对象中找，如果有该成员则停止查找，直接使用该属性和方法。
   
   * 如果没有，那么再在其原型对象中查找，如果有该成员则停止查找，直接使用该属性和方法。
   
   * 如果原型还没有，就到原型的原型中查找
   
   * 如此往复，直到Object.prototype中还没有，那么如果是访问属性则返回undefined；如果是调用方法则报错（xxx不是一个函数）
   
#静态成员和实例成员的概念
  从面向对象的语言中引入的

1.静态成员表示的是静态方法和静态属性的概念。所谓静态就是由构造函数所提供的。

```
Person.prototype.sayHello
```
2.实例成员表示的是实例方法和实例属性，所谓的实例就是由构造函数所创建的对象。

```
p.sayHello
```

3.一般工具型方法都由静态成员提供，一般与实例对象有关的方法由实例成员表示。

#面试题
 
1.将字符串> < & TM 空格...转义出来

2.逻辑中断
```
   foo=foo||bar;
  // ||逻辑或，左边为真则整个表达式为左边的值；
  //          左边为假整个表达式就是右边的值
  //一般考虑函数参数的时候，使用该方法兼容处理函数参数
  div.onclick=function( e ){
   e=e || window.event;
  }  
```

3.变量名提升

4.

