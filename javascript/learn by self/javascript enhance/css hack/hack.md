#浏览器兼容
  
  * 所谓的浏览器兼容性问题，是指因为不同浏览器对同一段代码有不同的解析，造成页面显示效果不统一的情况。
  
  * 在大多数情况下，我们的需求是，无论用户用什么浏览器来查看我们的网站或者登陆我们的系统，都应该是统一的显示效果。所以浏览器的兼容性问题是前端开发人员经常会碰到和必须要解决的问题。

##常见css浏览器兼容问题及解决方案

1.浏览器兼容问题一：不同浏览器的标签默认的外补丁(margin)和内补丁(padding)不同

  * 内补丁就是border边框内部的空白定义部分，外补丁就是border外部的空白定义部分，主要作用就是在页面中设置空白。
  
  * 问题：随便写几个标签，不加样式控制的情况下，各自的margin 和padding差异较大
  
  * 解决方案：CSS里  **<font color="green">  *{margin:0;padding:0;}</font>**
  
  * 注：这个是最常见的也是最易解决的一个浏览器兼容性问题，几乎所有的CSS文件开头都会用通配符*来设置各个标签的内外补丁是0。

2.浏览器兼容问题二：块属性标签float后，又有横行的(左右)margin情况下，在**<font color="red" size="3">IE6</font>**显示margin是设置的两倍。

  * 问题:常见问题是IE6中后面的一块被顶到下一行
 
  * 解决方案：在设置了float的标签 的样式控制中加入 **<font color="green">display:inline;</font>**将其转化为行内标签
 
  * 注：我们最常用的就是div+CSS布局了，而div就是一个典型的块属性标签，横向布局的时候我们通常都是用div float实现的，横向的间距设置如果用margin实现，这就是一个必然会碰到的兼容性问题

```
<div style="width:200px;height:50px;background:#ccc;">
   <div style="width:100px; height:50px;float:left;margin-left:10px; background:#eee; display:inline"></div>  
</div>  
```

3.浏览器兼容问题三：设置较小高度标签（一般小于10px），在**<font color="red" size="3">IE6，IE7，遨游</font>**中高度超出自己设置高度

  * 问题：IE6、7和遨游里这个标签的高度不受控制，超出自己设置的高度 
 
  * 解决方案：给超出高度的标签 **<font color="green">设置overflow:hidden;或者设置行高line-height 小于你设置的高度</font>**。
 
  * 注:这种情况一般出现在我们设置小圆角背景的标签里。出现这个问题的原因是IE8之前的浏览器都会给标签一个最小默认的行高的高度。即使你的标签是空的，这个标签的高度还是会达到默认的行高。

4.浏览器兼容问题四：行内属性标签，设置display:block后采用float布局，又有横行的margin的情况，会在**<font color="red" size="3">IE6</font>**中有间距bug.

  * 问题：IE6里的间距超过设置的间距
 
  * 解决方案：在display:block;后面加入**<font color="green">display:inline;display:table;</font>**
 
  * 注：行内属性标签，为了设置宽高，我们需要设置display:block;(除了input标签比较特殊)。在用float布局并有横向的margin后，在IE6下，他就具有了块属性float后的横向margin的bug。不过因为它本身就是行内属性标签，所以我们再加上display:inline的话，它的高宽就不可设了。这时候我们还需要在display:inline后面加入display:talbe。

5.浏览器兼容问题五：图片默认有间距

  * 问题：几个img标签放在一起的时候，有些浏览器会有默认的间距，即使用问题一中提到的通配符也不起作用。
  
  * 解决方案：使用float属性为img布局
  
  * 注：因为img标签是行内属性标签，所以只要不超出容器宽度，img标签都会排在一行里，但是部分浏览器的img标签之间会有个间距。应该去掉这个间距使用float。

6.浏览器兼容问题六：标签最低高度设置min-height不兼容

  * 问题：因为min-height本身就是一个不兼容的CSS属性，所以设置min-height时不能很好的被各个浏览器兼容
  
  * 解决方案：如果我们要设置一个标签的最小高度200px，需要进行的设置为：**<font color="green"> {min-height:200px; height:auto !important; height:200px; overflow:visible;} </font>**
  

  * 注：在B/S系统前端开时，有很多情况下我们又这种需求。当内容小于一个值（如300px）时。容器的高度为300px；当内容高度大于这个值时，容器高度被撑高，而不是出现滚动条。这时候我们就会面临这个兼容性问题。

7.浏览器兼容问题七：透明度的兼容css设置

#  CSS hack
 
  * 不同厂商的浏览器或者某浏览器的不同版本对css的支持解析不一样，所以针对不同浏览器或者浏览器的不同版本要写不同css code。

##分类
  
1.条件注释法（IE专有）

2.类内属性前缀
```
     使用hacker我可以把浏览器分为3类：IE6 ；IE7和遨游；其他（IE8 chrome ff safari opera等）
     _  *       IE6认识
     *          IE7和遨游认识
 
     \9         IE6,IE7,IE8,IE9
     \0         IE8,IE9
     \9\0       IE9
     -          IE6专有hack
     !important IE6不认识
```

  * 比如下面一个css设置
```
height:300px;*height:200px;_height:100px; 
```

    * IE6浏览器在读到height:300px的时候会认为高时300px；继续往下读，他也认识*heihgt， 所以当IE6读到*height:200px的时候会覆盖掉前一条的相冲突设置，认为高度是200px。继续往下读，IE6还认识_height,所以他又会覆盖掉200px高的设置，把高度设置为100px；
    
    * IE7和遨游也是一样的从高度300px的设置往下读。当它们读到*height200px的时候就停下了，因为它们不认识_height。所以它们会把高度解析为200px，剩下的浏览器只认识第一个height:300px;所以他们会把高度解析为300px。
     
    * 因为优先级相同且想冲突的属性设置后一个会覆盖掉前一个，所以书写的次序是很重要的。

3.选择器前缀
  
  * (*html) *前缀只对IE6有效
  * (*+html) *+前缀只对IE7有效