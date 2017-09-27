#HTML

1.标签的学习

2.a元素
  
  * 超链接的五种链接：链接到外部网站；链接到本地文档；使用图片链接；电子邮箱链接（href="mailto:邮箱"）；下载链接。
  * 属性：href链接的目标地址(绝对地址，相对地址，锚点，email)；target用于打开页面的方式(_blank _self _parent _top)。
  * 锚点:内部文档链接
    ```
       <a href="#id名">top</a>
       <h1 id="id名"></h1>
    ```

3.img元素
``` 
   src:图片路径
   alt:图片出不来的替代文字
   title:鼠标点击时显示的文本
   width and height
```

4.table元素
```
   table:定义表格
   tr:行
   td:单元格

   th:也属于单元格（标题单元格），居中加粗显示
   caption:给表格添加标题
   colspan:横向合并单元格
   rowspan:纵向合并单元格
   colgroup:组合列。用span属性设置数目
   col：单标签，是colgroup的子元素 用style属性设置样式，用span属性设置数目
   thead:表头 tbody:表内容 tfoot:表脚
```

5.列表

  * ol:有序列表
	    li标签作为列表项
  * ul:无序列表
	    li标签作为列表项
　* dl:自定义列表
	    
    * dt作为列表项,dd列表项的内容 
    
6.div元素:块级元素，用id或者class属性设置样式
7.meta元素:通常有name content http-equiv属性
    
    * name与content组合使用：name的值有description,keywords,robots,author

    * http-equiv与content组合使用：http-equiv的值通常有pragma.expires.refresh

8.iframe内联框架
```
    src:指定框架要显示的URL
    height and width
    seamless:h5新增，不希望出现滚动条的地方
    name属性与a标签的target属性实现跳转
      eg:<a href="baidu.com" target="myframe"></a>
         <iframe src="51.zxw.com" name="myframe"></iframe>
```

9.form元素
```
   action:指定表单提交地址
   method:指定表单的提交方式
   name:表单名称
   target:设置返回信息的方式
   enctype:设置表单资料的编码方式
   h5新增 autocomplete:规定form和input是否开启自动记忆功能；属性值为on/off.
          novalidate:规定在提交表单时不应该验证form和input.
          placeholder：占位符
```

10.input元素：设置form内容项
```
	   type：输入内容的类型
	   name:名称
	   value：默认值
	   maxlength:输入字数的最大值
	   readonly:只读属性，提交时会发送至服务器
	   disabled：不可用
	   required：必填选项，属性值可为空，可不填，也可为required
	   autofocus:自动获得焦点
	   form：规定输入域所属的一个或者多个表单。
	       <input form="id名">
	       <form id="id名"></form>
	   list：规定输入域的datalist
	       <input list="id名">
	       <datalist id="id名">
	   pattern：规定用于验证的input域的正则表达式
```

```
	<--type属性的属性值
		   text:默认，单行文本框
		   password：密码状态输入框
		   submit：提交按钮
		   reset:重置按钮
		   button:普通按钮
		   image:图片式提交按钮
		   hidden:隐藏字段，不会显示在页面
		   url:输入一个网址
		   tel:输入一个电话号码
		   number:输入数字，与max,min,step 一起使用。
		   range:带滑块的活动条，与max,min,step 一起使用。
		   时间类 time:时间。几点
		          date:日期
		          week:星期，##年##周
		          month:##年##月
		          datatime:utc时间
		          datatime-local:本地时间，时间+日期
		   color:颜色选择框
		   search:搜索框，与每一个提交按钮一起使用，用来供用户输入搜索的keywords
		   file:创建文件选取输入框
		        通过accept属性规定文件选取的类型；multiple属性设定一次允许多个文件
		   checkbox:复选框，checked设置默认的选取值
		   radio:单选框，checked设置默认的选取值，必须设置相同的name值
```

11.textarea文本域元素:建立多行文本输入框，元素标签中的内容以文本框默认值的形式呈现

12.select元素:下拉选择框，不仅在表单中使用，还可在其他元素中使用。
	
  * name：下拉选择框的名字
	
  * size：能显示多个选项的列表框
	
  * multiple：允许用户从这个列表中选择多个选项。
	
  * option元素：用来建立一个选项，即下拉菜单的一个菜单项
	   
    * value：指定选项的值
    
	* selected：用来指定页面加载时被选择的默认项
    
    * optgroup：用来对option进行分组，用label来设置组	

13.datalist元素：建立一个选项列表, datalist元素的内容不会直接显示在网页上，只会在用户输入时作为候选项，通常与input元素配合使用。
```
    <input list="id名">
    <datalist id="id名"></datalist>
```

14.button元素:默认是可以提交的，让用户更好的控制按钮的显示方式，允许其他元素出现在button内。
   
   * type :submit  button(不可以提交的) reset
15.label元素：用来给input元素做标记
  
  * 把input标签放入label内
  
  * 用for属性与input相关联
```
       <label for="id名"></label>
       <input id="id名">
```

16.fieldset元素和legend元素
  将表单中相关元素进行分组，legend是给fieldset定义组名

17.新增属性details和summary元素
  
  * 用来描述某个文档或文本的内容。summary用来给它设置标题
  
  * 当点击按钮时会出现内容，默认情况是不可见的。可用open属性改变默认为可见。




