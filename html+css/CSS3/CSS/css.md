#CSS自学

1.文字属性：font:style weight size/line-height family
    
  * 文字字体如果需要给中文和英文分别设置字体，则font-family:英文字体 中文字体（备选方案）;
  
  * 文本属性：text-decoration/align/indent.
  
2.选择器

  * 后代选择器：（选择器1 选择器2）先找到所有的1，再从1中找到所有的后代2
  * 子元素选择器：（选择器1>选择器2）先找到所有的1，再从1中找到所有的选择器为2的子元素
  * 序选择器   
    
    * 同级别的第几个： ( :first-child;:last-child;:nth-child(n);:nth-last-child(n);:only-child;)  
    * 同级别同类型的第几个(:first-of-type;:last-of-type;:nth-of-type(n);:nth-last-of-type(n);:only-of-type;)
             nth-child(odd);nth-child(even);
    * 同级别同类型奇偶数
             nth-of-type(odd); nth-of-type(even);
    * 同级别的奇偶数（不分类型）
             :nth-child(nx+y);自定义的，n为计数器
  * 属性选择器 
    
    * 标签[attribute]
    * 标签[attribute=value]
    * 属性取值以什么开头  选择器[attribute^=value]
    * 属性取值以什么结尾  选择器[attribute$=value]
    * 属性取值包含什么    选择器[attribute*=value]
    
3.嵌套盒子内的水平垂直居中
     
  * 给外盒子设置padding(首推)：增加padding和border都会改变盒子的宽高；
                                如果想盒子的大小不变，则修改width或者 增加box-sizing:border-box.
     
     
  * 给内盒子设置margin：    
    
    * 如果给内盒子设置了顶部外边距(margin-top),外面盒子也会被顶下来，如果不想外盒子顶下来 就给外盒子添加边框(border)或者overflow:hidden;
    
  * 利用margin:0 auto;来使里面的盒子在外面盒子内部居中.垂直居中就通过改变0的值[(外盒高-内盒高)/2].
  
4.盒子居中和内容居中

  * 盒子水平居中 margin:0 auto;
  
  * 内容
    
    * 水平居中 text-align:center;
  
    * 垂直居中：一行文字时 line-height=height；多行文字时 利用padding属性

5.overflow:hidden;的作用

  * 清除浮动.IE6不兼容
```
添加如下代码：
      (给第一个盒子).box1{
                    *zoom:1;
                  }
                       
```
  * 嵌套盒子中，内盒子设置了margin-top,为了不让外盒子被顶下来可设置此属性.
  * 将超出标签范围的内容裁剪掉.

6.绝对定位中的水平居中(margin: 0 auto;不能用)
```
     left:50%;
     margin-left:-的元素的一半(要水平居中的元素)
```

#css day01

1.CSS:层叠样式表(Cascading Style Sheets); 是一种修饰语言
    ```
    html   css        js
    脸     化妆技术    动画
    ```

2.语法
    
  * css声明(style属性)
  ```
        属性名:属性值;
        属性名:属性值;
  ```

  * css声明块
  ```
        {
            属性名:属性值;
            属性名:属性值;
        }
    css选择器
        div{
            属性名:属性值;
            属性名:属性值;
        }

        <div></div>
        <div></div>

  ```

3.margin  速记属性
```
        margin:0px 0px 0px 0px;
            上 右 下 左
        margin:0 0;
            上下  左右
        margin:0 0 0;
            上  左右  下
        margin:0;
            上下左右都是

    margin-top
    margin-bottom
    margin-left
    margin-right
```

4.css样式表的位置
        
  * 内联样式表   style="width:100px;"

  * 内部样式表
  ```
            <style>
                div{
                    width:100px;
                }
            </style>
  ```
            
  * 外部样式表
  ```
            外部css文件中
            引入css文件:
                1.将css文件引入到html文件中,使用link标签的href属性.
                2.将源css文件(common.css)引入到目标css文件(style.css)中,在目标css文件中写:@import url("common.css");
  ```

  * 三种样式表优先级: 遵循就近原则
  ```
          link
          style
            div style=""

            行内样式表>内部样式表>外部样式表
    
            style
            link
                div style=""
            行内样式表>外部样式表>内部样式表
  ```

5.浏览器加载页面的过程:
  
  ```
    加载html-解析html------------DOM--展示
                    |           |
                  加载css----解析css
  ```

  ```
    text-align   元素内部的内容居中
        left center  right
    display     展示形式
        none   隐藏
        inline  行内显示
        block   块级显示
        inline-block  行内显示但是有块级元素的特点,可以设宽高
    float    浮动
        将一个元素飘起来,脱离文档流
        left right
        靠左还是靠右显示 

        作业:将ul中的li一行显示   
        将6页面的img实现点击图片之后跳转到图片大图,新选项卡方式打开

  ```

#css day02

1.属性
  color：前景色(元素内容的颜色)
  background-color:背景色
  width
  height
  margin:top right bottom left; 
         top/bottom left/right;  
         top/bottom/left/right; 
         0 auto ;水平居中   div{
                           margin:0 auto;让div居中
                           text-align:center; 让div的内容水平居中
                           line-height：div的高；垂直居中
                           }
#######默认div占一行，高度由子元素撑起来，一般在div上设置宽度，在子元素设置高度，

  padding
  background
  background-color:背景颜色
  float:left right
      浮动。脱离文档流飘起来
       如果第一个元素浮动，那么在原来的位置飘起来。之后的元素占用其位置
       如果两个都左浮动，那么第二个跟在第一个之后飘起来，之后的顶上去
       如果两个都右浮动，那么第一个在右侧，正常情况下，需要第一个在左侧，那么只需更换两者在文档流中的位置

       浮动中的左右边距问题：
         正常情况下，没有浮动，两个相邻元素的上下margin取较大者，
         如果两个元素都浮动，两个相邻元素的左右margin不共用，累加。

       浮动与父级的关系
         如果子元素都浮动的话，父级没有高度，跟父级同一级别的之后元素会上顶被覆盖；如果父级想有高度，父级使用overflow:hiddeen;就有高度，不影响布局
         如果只是想不影响之后的布局，在之后布局的元素内部。使用clear:both;父级来清除浮动。没有高度  
              （clear：both是同一级别的元素进行清除浮动）

  border:width style color;


****overflow:hidden和clear:both

   overflow:hidden;
       如果子元素都浮动的话，父级没有高度，如果父级想有高度，父级使用overflow:hidden;就有高度，不影响布局
         并且跟父级同一级别的元素（之后的布局元素）会保留自己所在文档流中
         
   clear：both
       如果子元素都浮动的话，父级没有高度，如果只是想不影响之后的布局，在之后布局的元素内部使用clear:both;来清除浮动。这样父级没有高度
       并且是设置在同一级别的元素进行清除浮动

#css day03

1.浮动
   float属性：none(默认，不浮动) left right
    
  浮动的特点：
    1.脱离文档流，浮动一个元素，飘在原来位置的上面，并不是飘在页面的左上角，如果后面还有(不浮动)元素会顶上去。
        浮动元素浮动之后的位置跟浮动元素浮动之前在文档流的位置有关。
    2.同方向上的浮动，先浮动的在前面，后浮动的在后面。
    3.不同方向的浮动，左浮动找左浮动，右浮动找右浮动。

  浮动对父元素的影响：
    1.如果父元素包裹两个子元素，子元素都浮动，那么父元素没有高度，
       如果想让父元素有高度，使用overflow:hidden;那么不影响跟父元素同一级别的元素（后面元素）布局
        div (parent)        overflow:hidden;
           div  float:left
           div  float:left
           div  mormal      clear:both
        div (other) mormal
        一般给父元素设置宽度，给子元素设置高度，父元素的高度由子元素撑起来，子元素的宽度就可以使用百分比
          父元素宽度1000；子元素设置为30%；则子元素高度为300px；

2.选择器：选择符合条件的元素，元素选择出来之后。在css声明块中给样式
  id选择器
  class选择器
  标签选择器
  普遍选择器
  子元素-后代-兄弟选择器
      >    儿子 
      空格  后代（儿子和孙子）
      +    后一个兄弟（紧跟其后的一个）
      ～   在该元素之后的所有兄弟

  组合选择器（并集）div,.one 选中div和class为one的
  嵌套选择器(交集) div.one  选中class为one的div
  后代选择器      div .one  选中div下 calss为one的所以后代元素
  属性选择器 
             [key]  选择有某个属性的元素
                 div[title]
             [key=value] 选择的是属性名=属性值的
             [key^=value] 选择的是属性值以什么开始的
             [key$=value] 选择的是属性值以什么结束的
             [key*=value] 选择的是属性值包含什么字符
             [key~=value] 选择的是属性值有什么值 

  伪类选择器
     1. 子代选择器
      不分类型的：
        p:only-child 独生子p
        p:first-child p元素作为第一个孩子的被选中
        p:last-child p元素作为最后一个孩子的被选中
        p:nth-child(n) p元素作为第几个孩子的被选中
        p:nth-last-child(n) p元素作为倒数第几个孩子的被选中
      分类型的：
        后代:first-of-type 每个类型的第一个
        后代:last-of-type 每个类型的最后一个
        后代:nth-of-type(n) 每个类型的第几个
        后代:nth--last-of-type(n) 每个类型的倒数第几个
          括号的取值:
            n 自然数
            2n+1
            odd 奇数
            even 偶数

     2. 状态选择器 达到某一特定情况下激发
        a:link 未访问状态
         :visited 已访问状态
         :hover 鼠标悬停状态
         :active 激活状态，点击时

        form *:focus 聚焦状态
              
              *:disabled 禁用状态
              *:enabled 不可用状态
              
              *:checked 单选或者多选的选中状态
              *:default 单选或者多选的默认的选中状态
              
              *:valid 通过验证的状态
              *:invalid 未通过验证的状态

              *:required 必填选项
              *:optional 非必填选项
              
              *:in-range 范围内
              *:out-of-range 范围外

  伪元素选择器
     ::before 在选中的元素前面添加内容
     ::after 在选中的元素后面添加内容
     ::first-letter 块级元素第一个字符
     ::first-line 块级元素第一行
     ::selection 选中的元素
  
3.选择器的优先级
  选择器的继承

            
#css day04

选择器
   选中元素给样式

   id选择器 #test
   类选择器  .test
   标签选择器 div
   普遍选择器 *     div *
   嵌套选择器 div.test（交集）
   组合选择器 div,.test（并集）
   子代选择器
      空格 后代
      >  直接子代
      +  紧跟其后的一个兄弟节点 dIv+p
      ~  后面的所有的兄弟节点   div~p
   属性选择器 []
      div[attr]     有某个属性的标签
      div[attr="value"/value] 有某个属性名=属性值的标签
      div[attr^=value] 选中属性名，并且属性值以什么开头的 <div> </div>
      div[attr$=value] 选中属性名，并且属性值以什么结尾的
      div[attr*=value] 选中属性名，并且属性值包含什么
      div[attr~=value] 选中属性名，并且有一个值为value 一般针对class
          <div class="one two three"></div>
          div[attr~=two]
    伪类选择器
      子代选择器
        不分类型：
         p:only-child 选择独生子p
         p:first-child 选择p是第一个孩子的
         p:last-child 选择p为最后一个孩子的
         p:nth-child(n) 选择p为第几个孩子的
         p:nth-last-child() 选择p是倒数第几个孩子

        分类型的：
        div *:first-of-type 每种类型中的第一个
        div *:last-of-type 每种类型中的最后一个
        div *:nth-of-type(n) 每种类型中的第几个
        div *:nth-last-of-type(n) 每种类型中的倒数第几个
      状态选择器（一般针对表单和a标签）  
        a标签
           :link 未访问的样式
           :visited 以访问的样式
           :hover 鼠标悬停样式
           :active 激活（点击）样式
        表单
           :focus 聚焦状态
           
           :enabled 可用标签样式
           :disabled 禁用标签样式（所有有disabled属性的标签）

           :readonly 只读样式
           
           :checked 选中radio和checkbox的样式
           :default 默认被选中的样式（有checked属性的标签）

           :required 选中所有必填的样式
           :optional 非必填的样式

           :valid 验证通过的样式
           :invalid 验证不通过的样式
    伪类选择器
        ::before 在某个元素之前追加内容  
                div::before{
                    content:"*";
                    color:red;
                }
        ::after  在某个元素之后追加内容
        ::first-letter 第一个字符 
                <div>hello</div>  选中的是h   div::first-letter{}
        ::first-line 选中第一行
        ::selection 给选中的字符附样式，一般在textarea中（必须用双冒号）

2.css选择器的优先级
    1）!important 修饰的最优先
    2）特性值 权值和最大的优先
         style属性内部样式 1000
         id选择器 100
         class选择器，属性选择器，伪类选择器(子代和状态) 10
         标签选择器，伪元素选择器   1
         > + ~ 空格   0
    3)权值和一样就近原则

3.继承
    可继承属性 color   
    不可继承属性 border
        将可继承变为不可继承，使用initial属性值
        将不可继承变为可继承，使用inherit属性值
        不进行设置 默认继承就继承，不继承就不继承,使用unset属性值
        border:inherit;/*继承*/
        color: initial;/*不继承*/
        color: unset;/*不进行设置 默认继承就继承，不继承就不继承*/

4.文字样式
    font-style 字体倾斜
        normal 正常
        italic 倾斜
        obolique 模拟倾斜

    font-weight 字体粗细
        normal 正常 400
        bold  加粗  700
        bolder lighter 比父元素粗或细
        100-900 数字

    font-size 字体大小，默认为16px
        浏览器默认的换算 16px=1em;
        一般会在页面开始的时候设置body的字体为 font-size:62.5%;
        如此整个页面的大小换算则为 1em=16px*62.5%=10px;

    font-family 字体家族
        serif 有衬线
        sans-serif 无衬线
        monospace 等宽 英文字母的等宽（unicode编码）
        cursive 草书
        fantasy 梦幻
        "黑体" "宋体"...

    font属性连写   font:style weight size/line-height family

5.文本样式
    text-decoration :none;
      属性连写和分开写在谷歌都不支持。
       text-decoration-line:线的位置（连写时不能省略）
              underline(下划线)
              overline 上划线
              line-through 删除线
       text-decoration-style:线的类型（可省略）
              solid 实线
              dotted 点状线
              double 双实线
              dashed 虚线
              wavy 波浪线
       text-decoration-color（可省略）

       text-decoration:line-through solid red;连写属性

    text-align 文本对齐方式
        right
        left
        center
        justify 两端对齐 ？

    text-indent
    text-transform
        none 默认
        uppercase 大写
        lowercase 小写
        capitalize 首字母大写
        full-width:等宽，中文和英文之间等宽
    text-shadow 文字阴影:水平方向偏移 垂直方向偏移 模糊距离 颜色;
        如果想写多个阴影，则用逗号隔开
        水平方向正值向右，负值向左

6.列表
   默认样式 ：ul有一个上下margin 16px;有有一个padding-left为40px；
            dl有一个上下margin 16px;没有padding-left；dd有margin-left 为40px;
            p 有上下margin为16px;
   list-style-type
       none 去掉
       disc 实心圆
       circle 空心圆
       square 方形
       decimal 数字
       decimal-leading-zero 小于10以下的数字前面加0
       lower-roman：小写罗马
       upper-roman:大写罗马
   list-style-image：url();
       注意位置，配合切片
   list-style-position
       inside 主框内
       outside 主框外
7.a标签样式
  cursor
     default: 默认 箭头
     auto:  自动
     pointer:手型
     crosshair 十字
     move :手型 缩的
     help : ?
     wait:等待 转圈
     八个方向
     url(路径),auto;  必须用逗号形式给一个备用的样式，当显示不出的时候就会使用后面的。


#css day05

1.选择器:选中元素给样式
```
   id选择器 #test
   类选择器  .test
   标签选择器 div
   普遍选择器 *     div *
   嵌套选择器 div.test（交集）
   组合选择器 div,.test（并集）
   子代选择器
      空格 后代
      >  直接子代
      +  紧跟其后的一个兄弟节点 dIv+p
      ~  后面的所有的兄弟节点   div~p
   属性选择器 []
      div[attr]     有某个属性的标签
      div[attr="value"/value] 有某个属性名=属性值的标签
      div[attr^=value] 选中属性名，并且属性值以什么开头的 <div> </div>
      div[attr$=value] 选中属性名，并且属性值以什么结尾的
      div[attr*=value] 选中属性名，并且属性值包含什么
      div[attr~=value] 选中属性名，并且有一个值为value 一般针对class
          <div class="one two three"></div>
          div[attr~=two]
    伪类选择器
      子代选择器
        不分类型：
         p:only-child 选择独生子p
         p:first-child 选择p是第一个孩子的
         p:last-child 选择p为最后一个孩子的
         p:nth-child(n) 选择p为第几个孩子的
         p:nth-last-child() 选择p是倒数第几个孩子

        分类型的：
        div *:first-of-type 每种类型中的第一个
        div *:last-of-type 每种类型中的最后一个
        div *:nth-of-type(n) 每种类型中的第几个
        div *:nth-last-of-type(n) 每种类型中的倒数第几个
      状态选择器（一般针对表单和a标签）  
        a标签
           :link 未访问的样式
           :visited 以访问的样式
           :hover 鼠标悬停样式
           :active 激活（点击）样式
        表单
           :focus 聚焦状态
           :enabled 可用标签样式
           :disabled 禁用标签样式（所有有disabled属性的标签）

           :readonly 只读样式
           
           :checked 选中radio和checkbox的样式
           :default 默认被选中的样式（有checked属性的标签）

           :required 选中所有必填的样式
           :optional 非必填的样式

           :valid 验证通过的样式
           :invalid 验证不通过的样式
    伪类选择器
        ::before 在某个元素之前追加内容  
                div::before{
                    content:"*";
                    color:red;
                }
        ::after  在某个元素之后追加内容
        ::first-letter 第一个字符 
                <div>hello</div>  选中的是h   div::first-letter{}
        ::first-line 选中第一行
        ::selection 给选中的字符附样式，一般在textarea中（必须用双冒号）
```

2.css选择器的优先级
```
    1）！important 修饰的最优先
    2）(层叠性)判断是否为直接选中或间接选中
      间接选中 遵循就近原则（看继承的元素离它的远近）
      直接选中 相同的选择器则后来者居上
              不同选择器看权值
                  
                  特性值 权值最大的优先
                      style属性内部样式 1000
                      id选择器 100
                      class选择器，属性选择器，伪类选择器 10
                      标签选择器，伪元素选择器   1
                      > + ~ 空格   0
                  多个选择器叠加 选权值和最大的

    3)权值和大小一样的就遵循 就近原则（ 后来者居上）
```

3.继承
    
  * 可继承属性 color   
  * 不可继承属性 border
  ```
        将可继承变为不可继承，使用initial属性值
        将不可继承变为可继承，使用inherit属性值
        不进行设置 默认继承就继承，不继承就不继承,使用unset属性值
        border:inherit;/*继承*/
        color: initial;/*不继承*/
        color: unset;/*不进行设置 默认继承就继承，不继承就不继承*/
  ```

4.文字样式

  * font-style 字体倾斜
    ```
        normal 正常
        italic 倾斜
        obolique 模拟倾斜
    ```

  * font-weight 字体粗细
    ```
        normal 正常 400
        bold  加粗  700
        bolder lighter 比父元素粗或细
        100-900 数字
    ```

  * font-size 字体大小，默认为16px
    ```
        浏览器默认的换算 16px=1em;
        一般会在页面开始的时候设置body的字体为 font-size:62.5%;
        如此整个页面的大小换算则为 1em=16px*62.5%=10px;
    ```

  * font-family 字体家族
    ```
        serif 有衬线
        sans-serif 无衬线
        monospace 等宽
        cursive 草书
        fantasy 梦幻
        "黑体" "宋体"...
    ```

  * font属性连写   font:style weight size/line-height family

5.文本样式
  * text-decoration 
    ```
       谷歌浏览器不支持这三个属性连写和分开写，但是火狐支持：
       text-decoration-line:线的位置（连写时不能省略）
              underline(下划线)
              overline 上划线
              line-through 删除线
       text-decoration-style:线的类型（可省略）
              solid 实线
              dotted 点状线
              double 双实线
              dashed 虚线
              wavy 波浪线
       text-decoration-color（可省略）

       text-decoration:line-through solid red;连写属性
    ```
  * text-align 文本对齐方式
    ```
        right
        left
        center
        justify 两端对齐 ？
    ```

   * text-indent
   * text-transform
   ```
        none 默认
        uppercase 大写
        lowercase 小写
        capitalize 首字母大写
        full-width 英文与中文之间等宽
    ```

   * text-shadow 文字阴影:水平方向偏移 垂直方向偏移 模糊距离 颜色;
   ```
        如果想写多个阴影，则用逗号隔开
        水平方向正值向右，负值向左
        垂直方向正值向下，负值向上
   ```

6.列表

   默认样式 ：ul有一个上下margin 16px;有一个padding-left为40px；
            dl有一个上下margin 16px;没有padding-left；dd有margin-left 为40px;
            p 有上下margin为16px;
   list-style-type
       none 去掉
       disc 实心圆
       circle 空心圆
       square 方形
       decimal 数字
       decimal-leading-zero 小于10以下的数字前面加0
       lower-roman：小写罗马
       upper-roman:大写罗马
   list-style-image：url();
       注意位置，配合切片
   list-style-position
       inside 主框内
       outside 主框外

7.鼠标的样式

  * cursor
     default: 默认 箭头
     auto:  自动
     pointer:手型
     crosshair 十字
     move :手型 缩的
     help : ?
     wait:等待 转圈
     八个方向
     url(路径),auto;  必须用逗号形式给一个备用的样式，当显示不出的时候就会使用后面的。

  * outline(速记属性) outline:width style color;
    外边框 不占用空间
      outline-width
      outline-style
      outline-color
     outline与border的区别
     border占用空间，会影响盒子的大小
     outline不占用空间，不会影响盒子的大小，一般在border之外的部分展示，不会影响下面的布局
  * display展现形式

    行内元素最好不要直接过渡到块级元素，可以变成行内块级元素。也不要设置margin和padding.

    ```
    inline 行内展示 在一行显示，不可设置宽高
    block 块级展示 独占一行，可以设置宽高，不设置时默认浏览器的宽度
    inline-block 行内块级展示 在一行展示，并且可以设置宽高
    none  元素隐藏，不占据屏幕空间

    ```
  * visibility可见性
    ```
    hidden 不可见 但是占据屏幕宽度，要与display相比较
    visible 可见
    ```
  * overflow超出处理
    ```
      hidden:当子元素有浮动的时候清除浮动；当子元素不浮动，但是元素内容超过父元素的时候，让超出的部分隐藏
      scroll 无论是否有溢出，都有滚动条
      auto 有溢出有滚动条，不溢出没滚动条
    ```

7.盒子模型
  
  
  * w3c标准盒子模型 (box-sizing:content-box)
     ```
     div{
         width:100px;
         height:100px;
         border:10px;
         margin:10px;
         padding:10px;
     }
      内容区宽度 100px 
      盒子宽度（不包括margin）width+border*2+padding*2
      所占空间 width+border*2+padding*2+margin*2
    ```

  * IE模型:width是包括padding border(box-sizing:border-box)
    ```
    div{
         width:100px;
         height:100px;
         border:10px;
         margin:10px;
         padding:10px;
     }
     内容区宽度 width-2*padding-2*border
     盒子宽度 100px
     所占空间 width+margin*2
    ```
  * box-sizing:盒子的大小
    ```
      border-box:设置的width是这个盒子的大小
      content-box:设置的width是盒子内容的大小
      
    ```
  * 盒子的大小和空间大小

      * 盒子的大小不包括margin
      * 所占空间的大小包括margin

8.背景
  1. background-color
  2. background-image:url();
  3. background-position:水平 垂直;
    关键字
      水平方向 left center right
      垂直方向 top center bottom
    px
      可以为负值
      参考原点为元素左上角
      可以制作精灵图
  4. background-size:背景图片的大小
     正常情况下，背景图片的大小为图片的大小

     取值：
        百分比 100% 100% 等比拉伸到这个元素的百分之多少 百分之百占满整个元素(推荐使用)
        px
        cover   等比拉伸，并且拉伸到 宽和高 都占满整个元素
        contain 等比拉伸，并且拉伸到 宽或高 占满整个元素
  5. background-orgin:背景图片的原点
     border-box  背景图片从border开始
     padding-box 背景图片从padding开始 默认
     content-box 背景图片从content开始

  6. background-clip:图片裁剪的范围
     border-box  背景图片从border结束 默认
     padding-box 背景图片从padding结束
     content-box  背景图片从content结束
   
   一般background-origin和background-clip一起使用，并且通常都设置成开始和结束是相同的地方

  7. background-attachment 将图片绑定到什么上
     fixed 绑定到视口上,从body开始。 不随文档流的移动而移动，在视口位置固定不动
     scroll 默认，绑定到某个元素上 ，这个元素的图片不会随着元素内容的移动而移动
     local 绑定到元素内容上，这张背景图会随着元素内容的移动而移动
  
  速记属性
  书写连写 background:image repeat;
          background:url() no-repeat;

9.边框 border（速写属性）
   ```
   1. border-width 设置宽度
   2. border-style 设置线条样式 
       dotted dashed sloid double groove ridge outset inset
   3. border-color 颜色

   4. border-image:边框图片(连写属性)
        
        border-image-source:url();
        
        border-image-slice裁剪成九宫格
           top  right bottom left
     
        border-image-repeat:重复方式
            round 自适应展示，会完整的一块展示（一般用的多）
            repeat 不会自适应展示 不会完整的展示
            stretch 中间拉伸，四个角保留不变。默认
         注意需要设置的是border：10px sloid;
    5. border-radius  圆角边框
       px
       百分比   超过50%就为圆
      
    ``` 

10.表格
```
  border-collapse 边框的合并和展示
    collapse合并
    separate不合并
  background 背景连写
  caption-side 标题的位置
     top
     bottom
  table-layout 布局方式
     auto 自动识别，单元格的宽度由单元格的内容决定
     fixed 固定  单元格的宽度由你自己设置的宽度决定，一般不用，内容多时会溢出
```

#css day6    布局
   
1.默认文档流、
     文档书写顺序就是页面展示顺序
       块级元素独占一行，行内元素与其他共享一行
2.改变默认文档流

   float 浮动 

   display

   position 定位
      static 默认定位（静态定位）,不定位

      fixed 固定定位 固定在浏览器上  脱离文档流 不随文档流的滚动而滚动，后面的盒子往上会被覆盖
      
      relative 相对定位 相对与原来位置 不脱离文档流 
      
      absolute 绝对定位 相对与浏览器或者离它最近的祖先定位元素
                定位元素是使用position属性并且属性值为relative或者fixed,ablusote
               （ 如果没有祖先元素，那么相对于浏览器定位。
                如果有祖先元素但是祖先元素没有定位元素则依然相对于页面定位。
                如果有祖先元素并且祖先元素有定位元素，则相对于最近的祖先元素定位。）
    
      //定位元素有一些特用属性left bottom right top//                                                                                                                             
   display:flex;弹性盒子布局
    盒子默认情况下是分行式布局（块级元素默认的），可以通过下面方法实现分列布局

    方法一：用column属性进行分栏式布局（在一行显示，分列）
      column-count:数字;(分为几列)  分栏
      column-rule:width style color;设置分割线
      column-gap:px;  设置栅栏，即分栏之间的间隔
      用这种方法设置的分栏布局是根据内容来分栏的，不是根据你设置的div来分栏

    方法二：通过给父元素设置display:flex;属性来进行分栏布局，它是根据你设置的div进行内容分栏，而不是通过内容分栏。
      容器 
        父元素 
          1.display:flex;使它的子元素进行分栏布局

          2.flex-diretion:方向
             row 显示在一行，从左开始（默认）
             row-reverse 显示在一行 从右开始 最前面的子元素在最右边
             column 显示在一列 从上开始（与传统文档流中的布局一致）
             column-reverse 显示在一列 从底下开始

          3.flex-wrap（当浏览器窗口缩小到一定程度时）会不会换行
             nowrap 默认 不自动换行，不管缩小到多大，依然是原来的分栏，不会有子元素换行

             wrap 自动换行(最好设置子元素最小宽度配合使用) 当缩小到子元素的最小宽度时，放不下则后面的元素就会换行显示，默认是从后面的元素开始换行，最后面的元素在最下面

             wrap-reverse 自动换行 但是最前面的子元素会先换行，则最后面的子元素反而在最上面
          ##连写属性：
            flex-flow:flex-diretion flex-wrap;
              flex-flow:row wrap;
          4.align-items 垂直对齐方式
            stretch 拉伸使整体对齐 默认
            flex-start 上对齐
            flex-end 下对齐
            center 垂直居中对齐 根据内容的高度来进行垂直居中

          5.justify-content 水平方向对齐

            flex-start 在开始位置对齐 默认是从左开始 左对齐
            flex-end 从结束位置对齐 默认是从右开始 右对齐。但是与右浮动不一样，它是整体的右对齐，盒子的位置不改变

            center 居中 所有子元素整体居中对齐
            space-between 子元素之间有空白
            space-around 子元素周围有空白 左跟右
      
      项目
        子元素
          flex:数字 像素;
            第一个属性值是指这个子元素所占得父元素总比例的比例 1 1 2 
            第二个属性值是最小宽度，用来设置这个子元素的最小的宽度，即指浏览器缩小到这个最小宽度时就不会再缩小了
          
#css day07

浏览器的兼容性
  -moz-  火狐firefox
     -moz-transform
  -o-  opera 欧朋
  -ms- IE浏览器（IE9）
  -webkit-  safari chrome

1.过渡 transition(需要人为触发的)

    transition-property 控制哪个属性
    transition-duration 执行时长
    transition-delay 延迟时间
    transition-timing-function 元素运动速度函数
    通常与hover,active一起使用触发
    
    div{
      property;
    }
    div:hover{
      改变的property以及改变后属性值;
      transition-property:;
      transition-duration:;
      ...
    }


2.动画 animation（不需要人为的触发，自己就能运动）
  速写：animation:name duration timing-function delay count direction;

  animation-name:绑定一个动画名字
  
  div{
      animation-name:动画名字;
      animation-duration
      animation-timing-function
      animation-delay
      animation-iteration-count
      animation-direction
  }

    定义一个动画：
    1. @keyframes 动画名字{
            //动画帧
            from{
                //开始帧的表现形式（css声明块）
            }
            to{
                //结束帧
            }
        }
    2. @keyframes animation-name{
            //动画帧
            0%{
                //开始帧的表现形式（css声明块）
            }
            50%{
                //中间一帧
            }
            ...
            100%{
                //结束帧
            }
        }
    
    animation-duration:动画持续时间（s/ms）
    
    animation-timing-function:动画执行的速度函数
       ease:默认 先慢后快再慢
       ease-in 先慢后快
       ease-out 先快后慢
       ease-in-out 先慢后快再慢
       linear 线性 匀速
    
    animation-delay 动画延迟执行时间
      ms/s 默认立即执行
    animation-iteration-count 动画执行次数
      n
      infinite 无限次
    
    animation-direction 动画执行方向
      normal 从第一帧执行到最后一帧
      reverse 从最后一帧执行到第一帧
      alternate 轮流执行 
           奇数次从第一帧执行到最后一帧
           偶数次从最后一帧执行到第一帧
      alternate-reverse 轮流执行
           奇数次从最后一帧执行到第一帧
           偶数次从第一帧执行到最后一帧
    animaton-play-state 播放状态
       paused 暂停状态
       running 播放  默认
    animation-fill-mode 填充状态
       none 默认状态 等待时间是最初设置的状态
       forwards 在结束的时候是显示最后一帧
       backwards 在延迟等待时间段用第一帧动画填充

3.变形 transform
   transform的属性
      translate(x,y) 移动
      scale(x,y) 放大或者缩小
          取值大于1的放大，属于0-1的缩小
      rotate(deg) 旋转
        rotate()  z轴 旋转盘
        rotateX() x轴 单杠运动
        rotateY() y轴 钢管舞
        rotateZ() z轴 是面向自己的那个轴向（顺时针或逆时针）
        旋转连写：transform:rotateX() rotateY() rotateZ();
      skew(deg) 倾斜
        skewX(deg) 
        skewY(deg)

4.作业
  结合动画和变形实现
    鼠标滑过按钮的时候，下方div，从左到右运动，运动过程旋转   
    鼠标滑过按钮的时候，下方div，从左到右运动，运动过程倾斜   
    鼠标滑过按钮的时候，下方div，从左到右运动，运动过程放大
  结合动画和变形实现，鼠标滑过改div的时候，实现3D效果（x,y轴）
    

5.html中两种无意义的标签：span div

6.布尔值的五种表示方法：
  disabled
  disabled="disabled"
  disabled="true"
  disabled="1"
  disabled=""


#cssday08

1.perspective:视角
  
  * 定义咱们用户的眼睛距离元素的位置。假设视角为1000px;当transform:translateZ(1000px);。我们就看不见了
  * 给每个子元素的视角transform:perspective(500px);
  * 舞台视角：父元素加视角perspective:500px;，子元素变成3d效果transform-style:preserve-3d;


2.媒体查询
    媒体类型
        all 所有设备
        print 打印
        screen 屏幕
        speech 声音合成器
    
    媒体特性
        color
        device-width/device-height 设备的宽高
        width/height 窗口的宽高
        min-
        max-
            min-width :992px;
            max-width:1200px;
        尺寸划分
            超小屏 <768px
            小屏 768-992px 
            中屏 992-1200px
            大屏 >1200px
        
    逻辑运算符
        and并且
        not除了
        only 只有
    
媒体查询模块
    媒体查询类型
    css样式
        超小屏
        @media screen and (max-width:768px){
          div{
                background:blue;
          }
        }
        小屏
        @media screen and (min-width:768px) and (max-width:992px){
          div{
                background:red;
          }
        }
        @media screen and (min-width:992px) and (max-width:1200px){
          div{
                background:red;
          }
        }
        @media screen and (min-width:1200px){
          div{
                background:blue;
          }
        }

3.浏览器兼容

  * img图片底部有空隙 去除img的间距可以设置图片为display:block;或者将父元素的font-size:0;
  * a标签里嵌套一个img，在IE浏览器中会出现一个蓝色边框，去掉边框 a img{border:none;}
  * IE6以下浮动的块级元素又有横向margin，就会出现双倍边距的问题。 用display:inline-block;
