#this

1.this指向在创建执行上下文（函数调用）的时候被确定。

2.this出现的四种情况

  * 作为函数调用：函数直接被调用，this指向全局对象window
```
function make(x){
    this.x=x;
}
make(5);//直接调用，会把this指向全局对象，
相当于隐式声明了一个全局变量x(Grobal.x=5)
```
    
     * 对于内部函数(声明在另一个函数体内的函数)来说，这种绑定到全局对象的方式会产生问题
     
```
var point={
    x:0,
    y:0,
    moveTo:function(x,y){
        var that=this;
      var moveX=function(x){
       this.x=x;
    },
      var moveY=function(y){
       this.y=y;
    }
      moveX(x);//直接调用，this指向全局变量
      movey(y);
    }
}
point.moveTo(1,2);
```

  ```
var point={
    x:0,
    y:0,
    moveTo:function(x,y){
      var that=this;//保留了this指向point
      var moveX=function(x){
       that.x=x;//that指向ponit
    },
      var moveY=function(y){
       that.y=y;
    }
      moveX(x);//直接调用，this依然指向全局变量
      movey(y);
    }
}
point.moveTo(1,2);
  ```

  * 作为对象方法调用：this被自然绑定给该对象
  
  ```
  var point={
  x:0,
  y:0,
  moveTo:function(x,y){
  this.x=this.x+x;
  this.y=this.y+y;
  }
  }
  point.moveTo(1,2);
  ```

  * 作为构造函数调用：this指向有构造函数创建的对象实例上
  * 使用apply或者call调用：可以切换函数执行的上下文环境(this指向)

#this语法糖

1.转换为call方法的方式，与call本身的方法不冲突

2.两种情况

  * foo()--->foo.call(window)
  * obj.foo()--->obj.foo.call(obj)

3.foo()--->foo.call(window)  
  
  * 把直接调用调解为一种语法糖，在严格模式下，不是window而是undefined
  * 匿名函数的自调用（有作用域）也是如此，指向window
    
    ```
    (function(x){ })('')--->(function(x){}).call(window)
    ```

4.obj.foo()--->obj.foo.call(obj)或者obj.child.foo()--->obj.child.foo.call(obj.child)

  * 函数作为对象方法被调用
  * 作为对象方法内部的函数，会发生问题
    
    * 解决方法是应该保留外部函数的this指向到内部函数里面

#this深入
  
  * obj.c不是函数调用，所以不根据上面的规则来，要根据obj是在那个环境下声明的
  * 当obj在全局环境中声明时，指向window
  * 当obj在函数环境中声明时，判断是否为严格模式，obj.c非严格模式下会指向window,严格模式下指向undefined,会报错

```
// 'use strict'
  var a=20;
  var obj={
      a:10,
      c:this.a+20,
      fn:function (){
        return this.a;
      }
    }
  console.log(obj.c);//obj.c是40
  console.log(obj.fn());
  当obj在全局环境中声明时，无论obj.c在哪里调用，严格模式和非严格模式都指向window
```

```
// 'use strict'
  var a=20;
  function foo(){
    var a=1;
    var obj={
      a:10,
      c:this.a+20,
      fn:function (){
        return this.a;
      }
    }
    return obj.c;//当obj在函数环境中声明时，obj.c非严格模式下会指向window,严格模式下指向undefined,会报错
  }
  console.log(foo());
```

#call apply bind

1.call方法

  * 语法：call(thisObj,arg1,arg2,...argn);
  * 作用：可以代替另一个对象调用一个方法；将一个函数的执行上下文指向由thisObj指向的新对象。
  * 如果call方法（bind,apply也适用）没有thisObj参数，或者为null 和undifined,则指向全局对象window.
  
2.apply方法

  * 语法：apply(thisObj,[args]);
  * 

3.bind方法