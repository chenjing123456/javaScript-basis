#构造函数的作用

##构造函数是干什么用的

1.初始化数据的

2.在js中给对象添加属性用的，初始化属性值用的

##自定义构造函数：构造一个对象 并且返回的函数
  * 构造函数的过程（原理）
  
    * 内存开辟空间 储存新创建的对象new Object();
    
    * 会把this设置为当前对象
     
    * 执行函数内部的代码，设置对象的属性和方法
   
    * 返回新创建的对象

##用构函创建对象的过程

1.代码：'var p=new Person();'

2.首先new创建了一个对象,它类似于{}；是一个没有任何成员的对象

 - 使用new创建的对象，对象的类型就是创建它的构造函数名

 - 使用{}创建的对象，无论如何都是Object类型，相当于'var p=new Object();'

3.然后调用构造函数为其初始化成员

 - 构造函数在调用的一开始，有一个赋值操作，把this=(指向)刚刚创建出来的对象

4.在构造函数中利用对象的动态特性为对象添加成员。

5.返回新创建的对象。（构函默认省略掉了）

#异常与捕获

#####异常：程序在运行过程中出现的错误。在js中浏览器会给出错误码，即错误消息，由错误类型与错误的信息构成。

  * 异常会导致程序中断。

#####异常的处理：出现异常还能继续执行

###常见异常：

1.运行环境的多性样

2.语法错误，代码错误

**try--catch语法**：尝试这么做，如果出现错误，捕获错误
```
try{
	可能出现错误的代码
}
catch(e){//e表示error或者exception
	处理错误的代码
}
```
1.代码正常执行，如果try中出现错误，try中出现错误代码后面的代码都不会执行，直接跳转到catch中

2.catch中处理错误的信息

3.然后继续执行后面的代码

4.如果try中没有出现错误，那么不走catch直接执行后面的代码

##如何抛出异常:自己写函数限制别人传入的参数信息时用抛出异常
 ```
 throw 对象
 ```
 1.throw 是抛出异常的语法，其后跟一个对象，即消息错误对象
 
 2.一般该对象使用new Error(“错误消息”)创建，也支持任意对象

##异常补充
 1.try--catch--fanally
 ```
 try{

 }catch(e){

 }finally{
   结束try这个代码块之后执行，即最后执行（必须执行的代码）
 }
 ```
2.层级传递
```
function f1(){//f1是调用函数，f2是被调用函数
	f2();
}
function f2(){
	f3();
}
function f3(){
	throw new Error("出现错误");//f3抛出异常后没有处理，就一级一级往上传递，看是否有异常处理，直到给全局时，抛出错误。
}
f1();
```

#Dom操作

##绘制Dom树:childNodes和attributes
  
  * 利用浏览器查看Dom树的结点
  
  * html标签特殊，与子元素没有空白文本

  
##任何一个DOM数的结论
  1.一般dom操作，操作的是什么：增删改查
 
  2.一般DOM树结构
```
    父节点
	       兄弟节点
	       当前节点（要操作的）
		              属性节点
		              子节点
	       兄弟节点
```
  3.从一个中心元素访问其所有直系亲属元素

   * 访问父节点：parentNode
    
   * 访问上一个兄弟节点：previousSibing
    
   * 访问下一个兄弟节点：nextSibing
    
   * 访问第一个属性节点：attributes[1]
    
   * 访问最后一个子节点：lastChild或者childNodes[childNodes.length-1]
##Dom操作：增删改查

###查询：即获取元素
 
   1.标准Dom API
 
   * document.getElementsById
 
   * document.getElementsByTagName
 
   * document.getElementsByClassName
 
   * document.getElementsByName
 
   * document.querySelectorAll
 
   2.亲属访问

   * 访问父节点：parentNode
    
   * 访问上一个兄弟节点：previousSibing
    
   * 访问下一个兄弟节点：nextSibing
   
   * 访问第一个属性节点：attributes[1]
   
   * 访问最后一个子节点：lastChild或者childNodes[childNodes.length-1]
   
   3.属性获取
   
   * getAttribute 获取属性的值
   
   * getAttributeNode 获取属性节点对象（标准API）
   ```
   //标准API结构，先获取这个属性节点，再取得属性节点的属性值
   var attrNode=node.getAttributeNode('属性名');
   attrNode.nodeValue;
   //简化版，直接通过属性名获取属性值
   node.getAttribute('属性名');
   ```
  
  ###增加（先创建再加入）

 1.创建
  
   * document.createElement
  
   * document.createTextNode
  
   * document.createAttribute创建属性节点
  
   * innerHTML
  
   * innerText
  
   * cloneNode()
  
 2.加入

   * appendChlid 追加到结尾处
 
   * innerHTML
   
   * setAttributeNode()添加属性节点
 
   * insertBefore  将新元素插入到某一个旧元素前面 怎么调用？ 父元素.insertBefore(新元素,旧元素);
     
 3.其他

   * style的操作
   
   * setAttribute(属性名，属性值)
  
###删除 
  
  * removeChild 删除元素
  ```
  //删除子元素
  //1.从node 中删除一个div
  node.removeChild(div);
  //2.如果div变量不存在，先获取这个节点，再删除(标准DOM API)
  var div=node.getElementById('');
  div.removeChild(div);
  //3.假设node节点中只有一个元素
  node.innerHTML=" ";
  ```
  
  * removeAttribute删除属性
  
  * removeAttributeNode 删除属性节点(必须先取得属性节点)
  ```
  //标准DOM API,先获取属性，再删除它
   var attrNode=node.getAttributeNode('属性名');
   node.removeAttributeNode(attrNode);
   //简化版,直接删除
   node.removeAttribute('属性名');
  ```
###修改
  
  1.修改节点

  * 删除节点再加入
    
  * replace()
    
  2.修改样式
    
  * style.xxx=aaa;
    
  * setAttribute
    
  3.修改文本

  * innerHTML
  	
  * innerText
  	
  * 节点操作
  	
  * nodeValue  表示节点的值，一般文本节点才使用该属性
    
  4.修改属性

  * setAttribute
    
  * .xxx=aaa;

##Dom节点的属性和方法

###常见的节点属性

1.nodeValue 表示节点的值，一般文本节点才使用该属性

2.nodeName 表示节点名字，虽然所有节点都有该属性，但是一般元素节点才使用.
  
   * 元素节点打印的元素均为大写字母
  
   * 文本节点使用该属性会打印出 #text
  
   * 属性节点使用该属性会打印出 字符串
   
3.nodeType 节点类型

   * 1 表示元素节点
  
   * 2 表示属性节点
  
   * 3 表示文本节点
  
   * 9 表示document节点
   
##面试
 1.js是什么语言呢

   * 基于对象：没有对象什么都做不了
    
   * 脚本语言：不严格定义，写出来解析执行的语言，和编译型语言对立
    
   * 基于原型的：与继承有关
   
 2.什么情况下出现undefined

   * 访问数组或者对象不存在的成员/属性
   
   * 定义变量未赋值
   
   * 函数没有返回值或return后没有数据