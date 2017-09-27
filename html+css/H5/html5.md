#html

1.html:hypertext markup language 超文本标记语言

2.url:统一资源定位符（uniform resource locator）
  
  * http://www.baidu.com/index.html  网络协议：//域名或者主机名(IP地址)：端口号/资源
  * IP地址唯一标识一台主机

3.html5是html的一个版本
  
  * 标签必须小写和闭合

4.html元素：开始标签<> 结束标签< / >
  
  * 分类：
      ```
        块级元素    独占一行 可以设置宽高d
        行内元素    在一行显示
        空元素     <img/>
        替代元素   input
        (两种无意义的标签：span div)
      ```

5.html 属性

  * 属性名=“属性值” 属性名=“属性值”  多个属性用空格隔开 <table bgcolor="red"></table>
  
6.以.html或者.htm结尾

7.快捷键
```
  html:4t + tab键 快速生成html4.0传统版本文档
  html:4s + tab键 快速生成html4.0严格版本文档
  html:5 + tab键 快速生成html5 
  ctrl + enter 直接到下一行
  ctrl+shift+上下键 多行编辑
```

##块级元素

9.表格 table
``` 
    table的属性：
        border 
        cellspacing:单元格之间的间隙
        cellpadding:单元格内容与边框之间的间隙

    caption:标题  valign 属性设置标题位置

    colgroup:设置列的格式
        col:colgroup的子列表项 里面有span属性表示对几列进行设置

    thead:表头
    tbody:表体
    tfoot:表尾
    tr:行
        th:标题单元格
        td：单元格
    colspan:合并单元格(列)
    rowspan:合并行
```    

10.h5新增
```
   article
   aside
   section
   nav
   header
   footer
   address（行内元素）

   details和summary 详情和概要
   fieldset和gelend
   figure和figcaption 图片分组
```

12.列表 ：ol ul dl   
```
    ol 有序列表
        序号默认从1开始 start可设置开始的数字
    ul 无序列表
        默认圆点 
    dl 自定义列表
        dt 标题
        dd 内容

```

13.div

##行内元素

1.超链接 a
```
   href 跳转的地址
        属性值：路径   绝对路径和相对路径
               锚点   #id名
               email  mailto:licy@qq.com
               空连接 javascript:void(0);
              

   target 打开链接页面的方式
        _self 默认，当前页面打开
        _blank 打开一个新页面显示
        _top
        _parent
```

2.span：纯粹的行内元素

3.em:强调，斜体

4.strong:强调，加粗

5.b:加粗

6.i：斜体

7.ins:插入，样式为下划线

8.del:删除线，样式为中间线

9.u 删除线

#H5新增元素
#
##构建主体内容

####article元素

article:常用于博客中的 一篇文章，论坛中的 一个帖子，或者浏览者的 一段评论等， 表示独立的内容区块，通常包含头部(header)和底部元素(footer)

####section元素

1.section:需要包含一个标题(hn)元素，一般不用包含头部和底部元素，通常为那些有标题的元素内容进行分段

2.section和article的区别

  * article代表文档，页面或者应用程序中独立完整的可以被外部引用的内容，强调内容独立完整性。
  * section对页面上的内容进行分块处理，如对文章分段等，相邻的section应该是相关的。
```
<article>
    <header>
        <h1>潜行者的个人介绍</h1>
    </header>
    <p>潜行者2是一个中国人，是一个帅哥....dygfrUS日日女热死你葌UR好闺女UR给女方 UR个为还能出租或引入UR股女 </p>
    <section>
        <h2>评论</h2>
        <article>
            <h3>评论者：潜行者3</h3>
            <p>确实真的很帅</p>
        </article>
        <article>
            <h3>评论者：潜行者4</h3>
            <p>今天吃药了吗</p>
        </article>
    </section>
    <footer>江西潜水协会</footer>
</article>
```

####nav元素

是一个可以用于页面导航的链接组，其中导航元素链接到当前页面的其他部分或者其他页面，不是所有的链接都要放到链接组，只需要主要的，基本的链接组放进nav里面即可。 

```
<h1>技术资料</h1>
<!-- 链接到其他页面导航 -->
<nav>
    <ul>
        <li><a href="#">首页</a></li>
        <li><a href="#">博客</a></li>
    </ul>
</nav>
<article>
    <header>h5+css3</header>
    <!-- 文章中的导航 -->
    <nav>
        <ul>
            <li><a href="#h5"></a></li>
            <li><a href="#css3"></a></li>
        </ul>
    </nav>
    <section>
        <h2 id="h5">h5</h2>
        <p>UR如翡翠城图书馆凝聚沪深国际经济哦 人头狗刘素华</p>
    </section>
    <section>
        <h2 id="css3">css3</h2>
        <p>rsiycmkd关于日岁末放大镜看一个人回复奇偶的课程fig</p>
    </section>
</article>
```

####aside元素

用来表示当前页面或者其他页面的附属信息部分。可以包含当前页面或者主要内容相关的引用，侧边栏，广告，导航条以及其他类似的有别于主要内容的部分。

  * 作为主要内容的附属信息部分，包含在article中，其中的内容可以是与当前文章有关的参考资料和名词解释等。

  * 作为页面或者站点全局的附属信息部分，在article之外使用，最典型的是侧边栏，其中可以有友情链接，博客中的其他文章列表，广告单元等。
  
```
<!-- 作为页面或者全局站点的附属信息 -->
<aside>
    <nav>
        <h2>友情链接</h2>
        <ul>
            <li><a href="#">baidu</a></li>
            <li><a href="#">baidu</a></li>
            <li><a href="#">baidu</a></li>
        </ul>

    </nav>
```

####设计微格式

1.H5增加了一种新元素来无歧义的明确的对机器的日期和时间进行编码，这个元素是time元素。

2.time元素代表24小时中某个时刻(年月日时分秒)或者某个日期(年月日)，表示时刻时允许有时差。可以定义很多格式的时间。 

3.datatime属性中日期和时间之间要用T间隔，加字母Z表示UTC时间。

```
<time datetime="2012-11-13">2012年11月13号</time>
<time datetime="2012-11-13">11月13号</time>
<time datetime="2012-11-13">我的生日</time>
<time datetime="2012-11-13T20:00">我的生日是晚上八点</time>
<time datetime="2012-11-13T20:00Z">我的生日是晚上八点</time>
<time datetime="2012-11-13T20:00+9:00">我的生日是晚上八点的美国时间</time>
```

4.添加发布日期(pubdate属性)
  
  * pubdate属性是一个可选的布尔值属性，可用在article元素中time元素中，意思是time元素代表了文章或整个页面的发布日期。
  
  * 由于time元素不仅仅表示发布时间，还可以表示其他用途的时间，如通知约会等，为了避免引擎误解发布日期，使用pubdate还可以显示告诉引擎文章哪个是正确的发布日期。

```
<article>
    <header>
        <h1>谷歌董事长密令:每天关机一小时</h1>
        <p>发布日期<time date="2012-5-20" pubdate>2012年5月20日</time></p>
        <p>关于<time date="2012-5-23" pubdate>2012年5月23日</time>更正通知</p></header>
    <p>㒑rg89ah局融合女热加工费风湿热一个iOS人规划出嗨哟个人狙后入式恢复仍</p>
    <footer>
        <p>http://www.github.com</p>
    </footer>
</article>
```


#
##添加语义模块

####标题块header

具有引导和导航作用的结构元素，通常用来放置整个页面或者页面内的一个内容的区块标题。

####标题分组hgroup
为标题及其子标题进行分组，通常与h1-h6联系

####脚注块footer
内容块的注脚，如父级内容添加注释，或者给网页添加版权信息，脚注信息有多种形式，如作者，相关阅读链接及版权信息。

####联系信息addresss(行内元素)
在文档中定义联系信息包括文档作者，文档编辑者名称，电子邮箱，真实的地址电话号码


#
#
#
#h5表单form
#
###新增的input类型

1.form元素的属性

  ```
  action:提交表单数据到哪里
                
  target：服务器返回页面的显示位置
                
  method:表单数据提交的方式 
        get:默认 数据在地址栏中，容易暴露，不安全
        post:数据在请求体中，相对安全
              怎么将项目部署到服务器上：
                           
                  将项目复制到apache2/htdocs 
                           
                  启动服务器 cd ../bin  sudo ./apachectl -k start
                           
                  访问项目 :在浏览器中输入http://192.168.159.200/index.html
                           
                  查看请求体:F12 -->NetWork-->params(数据所在)

  name:表单名

  ectype:表示表单数据的编码方式
                      一共有三种
  ```

2.form控件

  * input控件的属性
      
    * name
    * value
    * maxlength
    * size
    * disabled
    * readonly
    * checked：radio和checkbox的默认选中
  
    * type属性取值：
      ```
      原有的十种：
         text 单行输入文本域
         password 密码域
         radio 单选框
         checkbox 复选框
         submit 提交按钮
         reset 重置按钮
         image 图片提交按钮
         button 普通按钮
         hidden 定义隐藏的字段
         file 上传文件
       
       h5新增的type属性
         火狐不支持
            * datepickers日期检出器类型(包含属性max,min,step,value) 火狐不支持
    
              + date类型 用于选取年月日的，选择一个具体日期
              + time类型 用于选取时间的，具体到小时和分钟
              + week类型 选取周年
              + month 选取年月，选择具体月份
              + datetime类型 选取时间，年月日，其中时间指UTC时间（Z）
              + datetime-local类型：选取时间，年月日，其中时间指本地时间

         火狐和谷歌都支持的：
          - email类型 专门用于输入email的文本输入域，在提交表单时，会自动验证email的值，如果不是有效的值，则不会提交该表单
          - url类型 提供用于输入url地址的这类特殊文本的文本框，
          - number类型 提供用于输入数值的文本框，有min,max,step,value属性
          - range类型 

             - 提供用于输入包含一定范围内数字值的文本框，有min,max,step,value属性
             - number和range都是数值的文本框，他们区别主要是在浏览器中的显示形式不一样，range显示为滑动条。
          
          - search类型 用于输入搜索关键字的文本框
          - tel类型 用于专门用于输入电话号码的文本框，不限定于数字，不自动验证。
          - color类型 专门用于用于设置颜色的文本框，可以快速打开拾色面板
      ```
     
      

  * button控件 默认在表单内部是可以提交的，（不放type属性时）
      ```
        type属性：button  不可提交
              submit
              reset
        name
        value

      ```

  * label控件 for属性 取值为某控件的id值
  
  * select控件  name属性
      ```
        selected：默认选中
        option  value属性
        optgroup：分组，用label属性设置组名
           option
      ```

  * textarea控件
    ```
        cols属性
        rows属性
        name属性
        wrap属性
        disabled
          <textarea></textarea>
    ```   
  * label元素：用来给input元素做标记
  
        * 把input标签放入label内
        
        * 用for属性与input相关联
        ```
            <label for="id名"></label>
            <input id="id名">
        ```

  * fieldset元素和legend元素
        将表单中相关元素进行分组，legend是给fieldset定义组名

  * 新增属性details和summary元素
        
        * 用来描述某个文档或文本的内容。summary用来给它设置标题
        
        * 当点击按钮时会出现内容，默认情况是不可见的。可用open属性改变默认为可见。

  * pregress 进度条 
    ```
            value属性
            min属性
            max属性
    ```
  * meter 磁盘容量
    ```
            min
            max
            low
            high
            optimum 最优值
               如果optimum<low 越低越好  value<low,绿色； low<=value<=high 黄色；value>high 红色
               如果low<optimum<high 在中间最好 low<=value<=high为绿色 ；其他为黄色
               如果optimum>high 越高越好  value<low 红色；low<value<high 黄色；value>high 绿色
    ```

  * output 用于在浏览器中显示计算结果或脚本输出(name属性)

  * datalist 数据列表,option与list相匹配使用,每一个option元素必须先设置value值
    ```
            与select的option的对比，
                1.如果在option标签内部写了内容的话，点击之后，datalist显示的是value值，select那边显示的是option的value值
                2.数据提交都提交的是option的value值
                3.datalist与select在浏览器中的区别火狐只显示内容，谷歌上显示value跟内容
    ```
  * keygen元素:密匙对生成器，能够使用户验证更为可靠
  
  
#
###新增input属性

1.form属性 写在表单控件中，将外部的表单控件包裹在表单内，值是form标签的值

2.其他
```
  autocomplete属性 自动完成功能，属性值有on,off,空值三种

  height和width属性 只能用于image类型的提交按钮
  
  min,max和step属性 适用于datepickes,number,range
  
  novalidate  (true/false) 用于在提交表单时取消对整个表单的验证
  
  required 必填选项 规定用户输入的内容不能为空
  
  multiple属性 复选属性，file,select
  
  pattern 正则表达式 用于验证input类型输入框用户输入的内容是否与自定义的正则表达式相匹配
  
  autofocus 自动聚焦
  
  list属性 表示输入框所属的datalist,属性值为datalist的id
  
  placeholder 占位符，在输入框为空时显式出现，当获得焦点时会消失
            与value值区别
             1.显示上，placeholder是灰色的，value正常色
             2.提交的时候，placeholder值不会提交，value值是会提交的
             3.输入数据之后，placeholder的会消失，value值会先删掉再填写
```

3.重写属性，写在提交按钮或提交图片上的，对原先表单的重写(reset submit image)
        formnovalidate
        formtarget
        formenctype
        formmethod
        formaction

###其他h5新增元素

  * mark 高亮显示
  * cite    引用 显示样式是倾斜 通常把电影等标题放进里面
  * ol     start="4"   reversed  反转或者倒序




#
#canvas元素
