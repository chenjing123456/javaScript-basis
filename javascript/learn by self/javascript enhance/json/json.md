#json:javascript object Notation 

##json概念

1.含义：轻量级的文本数据数据交换格式

2.json使用js语法来描述数据对象，但是json独立于语言和平台。

##json语法

1.语法规则：数据在名称/值对中；数据由逗号分隔；大括号保存对象，中括号保存数组。

2.json书写格式 名称/值对: "name":"教程";

3.json值的数据类型：数字(1,2,33), 字符串("34"), 布尔值(true/false), 数组([1,2,3]), 对象({ "name":"ls",}), null.

  * 数字：{"age":30;}
  * 对象：{"name":"ls","age":19}
  * 数组：{"site":[1,2,3,4,5,6]}
  * 布尔值：{"flag":true}
  * null:{"runoob":null}

4.json对象语法
  
  * 在{}中书写( key:value ),key必须为字符串，value值必须是合法的JSON数据类型。
  ```
   var obj={
   "name":"run",
   "alexa":1000,
   "site":null
  }
  ```

  * 访问对象值：用.或者[]来访问
  * 循环对象：用for-in循环
  ```
  for(int x in obj){
  document.getElementById("demo").innerHTML+x+"<br>";
  }
  ```

  * json对象中可以包含另一个json对象
  ```
  myObj={
     "name":"run";
     "site":{
        "site1":"run1",
        "site2":"run2"
     }
  }
  可以用点或者[]来访问嵌套的json对象
  x = myObj.sites.site1或者myObj.sites["site1"];
  ```

  * 修改值：用.或[]修改json对象的值
  * 删除对象属性：用delete删除json对象的属性
  ```
  delete myObj.sites.site1或者myObj.sites["site1"];
  ```

5.json数组语法
```
obj ={
    "name":"sit",
    "sites":["google","ren","tb"]
}
可以用索引值来访问数组
 x = obj.sites[0];
```
  
  * 循环数组：for-in和for循环
  * 嵌套json对象的数组
  * 修改数组值
  * 删除数组元素

6.json.parse()方法

  * json通常用于与服务器交换数据，在接收服务器数据时一般是字符串，使用json.parse()方法将数据转换为js对象。
  * json.parse(text,reviver) text是一个有效的json字符串，reviver是可选参数，为对象的每个成员调用
  * json解析：从服务器端接收数据，用json.parse()处理数据，转为js对象。
  ```
  var obj = json.parse('{"name":"run","alex":1000}');
  document.getElementById("demo").innerHTML=obj.name;
  ```
  * 从服务器端接收json数据,可以使用Ajax从服务器请求json数据，并解析为js对象。
  ```
  XMLhttp.onreadystatechange=function(){
  if(this.readystate==4&&this.status==200){
      obj=json.parse(this.responseText);
      docunment.getElementById('demo').innerHTML=obj.name;
    }
  }
  ```

  * 异常
      
      * 解析数据
      ```
      json不能存储Date对象，如果需要存储Date对象，需要将其转换为字符串，之后再将字符串转为Date对象
      方法一：
      var text='{"name":"run","intiDate":"2013-12-14"}';
      var obj=json.parse(text);
      obj.intiDate=new Date(obj.initDate);
      $(#="demo").innerHTML=obj.initDate;
      方法二：用第二个参数
      var text='{"name":"run","intiDate":"2013-12-14"}';
      var obj=json.parse(text,function(key,value){
        if(key=="intiDate"){
        return new Date(value);
        }else{
        return value;
        }

      })


      ```

      * 解析函数:json不允许包含函数，但你可以将函数作为字符串存储，之后再将字符串转换为函数。eval()函数使用的是js编译器，可解析JSON文件，然后生成js对象。
      
      ```
      var text={"name":"run","alex":"function(){return 1000;}"};
      var obj=json.parse(text);
      obj.alex=eval( "("+obj.alex+")");

      eval("("+txt+")");//txt是一个json文本（字符串），要把文本包围在括号内。
      ```

7.json.Stringify()方法

  * 在向服务器发送数据时一般是字符串，可以用json.Stringify()方法将js对象转换为字符串。
  * 语法：js对象转换
  ```
  var obj={"name":"run","alex":1000};
  var myJson=json.String(obj);//myJson是一个字符串


  ```
  * 异常：
      
      * 解析数据：json不能存储Date对象，json.Stringify()会将所有日期转换为字符串,之后再把字符串转换为对象
      * 解析函数：json.Stringify()函数会删除js对象的函数
      ```
      我们可以在执行json.Stringify()函数前将函数转换为字符串
      var obj ={"name":"run","alex":"function(){return 100;}"};
      obj.alex=obj.alex.toString();
      var myJson=json.Stringify(obj);
      ```
