#事件

##事件模型

###DOM0事件模型

1.定义：直接在dom对象中注册事件名称（所有浏览器都支持
）

2.写在js上的。
```
var btn = document.getElementById("test");
btn.onclick=function(ev){
    alert(this.id);//this指向绑定事件的dom对象
}
```
  
  * 事件被触发时，会默认传入一个参数ev，
  * 基于Dom0事件对于同一个DOM节点而言，只能注册一个，后面注册会覆盖前面。
  * 事件触发时，this就是指该事件在哪一个dom对象上触发
、
3.直接写在html上的事件
```
<div onclick="exec();"></div>
```

  * 通过这种方法注册的事件，只能注册一个，遵循覆盖原则
  * 相当于动态调用函数(eval)，因此不会传入event对象
  * 同时this指向window,不再是触发事件的dom对象写在js中的事件

###DOM2事件模型

1.定义：支持在同一个dom元素注册多种事件，新增捕获和冒泡事件

2.Dom2事件通过注册addEventListener（添加事件）和removeEventListener（移除事件）
管理。但是在IE8以下，用attachEvent和detachEvent，this指向触发事件的dom对象。

3.事件流：某一个元素触发了某个事件，最先得到通知的是window,documnet,依次而入，直到目标元素，这个过程称为事件捕获。接下来。事件会从目标元素开始气泡。再依次而出，直到window对象为止，这个过程称为事件冒泡。

4.真正触发事件的dom元素（目标元素），必须是内层的。

  * 点击内层的div
  
      * 在外层div上注册捕获和冒泡事件，捕获事件比冒泡事件先执行。
      * 在内层div上注册捕获和冒泡事件，哪个先注册，哪个先执行。
      * 如果外层div和内层div同时注册了捕获事件，那么内层div时，外层捕获事件一定是先触发的
      * 如果外层div和内层div同时注册了冒泡事件，那么内层div时，内层冒泡事件一定是先触发的

5.对于div嵌套，同时注册了冒泡事件，点击内层元素时，外层事件也会触发，所以要阻止外层事件发生（阻止冒泡）。事件触发时会默认传入一个event对象，这个对象有一个方法stopPropagation();通过此方法可以阻止冒泡。但是IE9之前的不支持，需要用e.cancelBubble = true;
```
外层 btn.addEventListener('click',function(){alert("ok");},false);
内层 btnInner.addEventListener('click',function(e){
    e.stopProgation();
    alert("ok");
    }
    ,false);

```

6.解除事件：要想注册过的事件都被解除，必须将回调函数保存起来，否则无法解除
```
   var fn = function(){
      alert("ok");
   }
   btn.addEventListener("click",fn,false);
   btn.removeEventListener("click",fn,false);
```

7.取消事件的浏览器默认操作
```
event.preventDefault();
兼容IE9之前的版本
event.returnValue = false;
```

8.事件流的写法以及实现方式

  * 标准实现方式是：dom对象.addEventListener(eventType,fn,事件机制(true/false))
  * 兼容IE写法：dom对象.attachEvent('on'+eventType,fn);
```
if(dom.addEventListener){
    dom对象.addEventListener(eventType,fn,事件机制(true/false);//this指向dom对象
    }else{
    if(dom.attachEvent){
      dom对象.attachEvent('on'+eventType,fn);//this指向window
    }
    }
```

##事件对象(event)

1.代表事件的状态，比如鼠标位置，鼠标按钮等。

2.什么时候会产生事件对象：当用户单击某一个元素时，我们给这个对象注册的事件就会触发，该事件本质是一个函数，函数的形参会接收一个event对象。

3.事件通常与函数结合使用，函数不会在事件发生前执行。

```
IE8之前的不会传递形参event对象，而是通过window.event属性(全局变量event)来得到
var ev = event||window.event;
```
