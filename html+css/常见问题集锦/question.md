#子级父级外边距合并问题

1.出现问题:给子元素设置margin-top时，外盒子会被顶下来,

  * 方法一：给父元素设置overflow:hidden;
  * 方法二：给父元素设置border:1px solid #ccc; box-sizing:border-box;
  * 方法三：给子元素设置display:inline-block;

  * 方法四：给父元素设置float:left;
  * 方法五：给子元素设置float:left;
  * 方法六：给子元素和父元素设置float:left;

  * 方法七：给父元素设置绝对定位
  * 方法八：给子元素设置绝对定位
  * 方法九：给父元素和子元素都加绝对定位
  * 方法十：父相子绝

#嵌套盒子水平垂直居中

1.要求：使内盒子垂直水平居中,假设外盒子宽高200px;内盒子宽高100px;

  * 方法一：浮动后设置margin
  ```
        .outer{
            width: 200px;
            height:200px;
            background-color: pink;
            /* float: left; */
        }
        .inner{
            width:100px;
            height:100px;
            background-color: red;
            float: left;    
            /*若是不浮动,设置margin 会把外盒子顶下来(即父子元素的外边距合并问题)  */
            margin:50px;
        }
  ```

  * 方法二：定位(父相子绝最好)后设置left top
  ```
        .outer{
            width: 200px;
            height:200px;
            background-color: pink;
            position: relative;   
             /* position: absolute;  */
        }
        .inner{
            width:100px;
            height:100px;
            background-color: red;
            /* position:relative; */
            position: absolute; 
            /*父相子绝（最好用这个） 或者 父绝子绝 或者 子绝*/
            top:50px;/* (200-100)/2=50px */
            left:50px;
        }
  ```

  * 方法三：弹性盒布局:flex后水平垂直居中
  ```
        .outer{
            width: 200px;
            height:200px;
            background-color: pink;
            display: flex;
            align-items: center; /*垂直方向居中*/
            justify-content: space-around;/*水平方向居中并周围留空*/
        }
        .inner{
            width:100px;
            height:100px;
            background-color: red;    
        }
  ```

  * 方法四：给父盒子设置padding,给子盒子设置margin
  ```
   设置子元素的margin:可以给父元素设置overflow和border
    .outer{
            width: 200px;
            height:200px;
            background-color: pink;
            overflow: hidden; 
            /* border:1px solid #ccc; */
            /* box-sizing:border-box; */
        }
    .inner{
            width:100px;
            height:100px;
            background-color: red; 
            margin:50px auto;   
    }


    设置父元素的padding
        .outer{
            /*增加父元素的padding-top和padding-left:50px;减少width和height*/
            /* width: 200px; */
            width: 150px;
            /* height: 200px; */
            height:150px;
            background-color: pink;
            padding: 50px 0 0 50px;/*(200-100)/2=50px 因为增加padding会改变盒子的大小，所以要减小宽高*/

        }
        .inner{
            width:100px;
            height:100px;
            background-color: red;    
        }
  ```

  * 方法五：定位的加强版
  ```
    1.
        .outer{
            width: 300px;
            height: 300px; 
            background-color: pink;
            position: relative;
        }
        .inner{
            background-color: red;    
            position: absolute;
            left:25%;
            top:25%;
            bottom:25%;
            right:25%;
        }
    2.
        .outer{
            width: 200px;
            height: 200px; 
            background-color: pink;
            position: relative;
        }
        .inner{
            width: 100px;
            height: 100px;
            background-color: red;    
            position: absolute;
            left:0;
            top:0;
            bottom:0;
            right:0;
            margin:auto;
        }
    3.
        .outer{
            width: 200px;
            height: 200px; 
            background-color: pink;
            position: relative;
        }
        .inner{
            width: 100px;
            height: 100px;
            background-color: red;    
            position: absolute;
            left:25%;
            right: 25%; 
            margin:50px auto;/*50px=(200-100)/2*/
        }
  ```

#竖排变横排的方法（行布局变成列布局）

1.浮动：float(30+5+30+5+30=100%)
```
        .container{
            width: 800px;
            height: 200px;
            background-color: pink;
        }
        .container>div{
            width:30%;
            height: 200px;
            background-color: red;
        }
        .one{
            float:left;
        }
        .two{
            float: left;
            margin-left: 5%;
        }
        .three{
            float:right;
        }
```

2.定位：position
```
        .container{
            width: 800px;
            height: 200px;
            background-color: pink;
            position: relative;
        }
        .container>div{
            width:30%;
            height: 200px;
            background-color: red;
            position: absolute;
        }
        .one{
            left:0;
            top:0;
        }
        .two{
            left:35%;
            top:0;
        }
        .three{
            left:70%;
            top:0;
        }
```

3.弹性盒布局:flex
```
        .container{
            width: 800px;
            height: 200px;
            background-color: pink;
            display: flex; 
        }
        .container>div{
            width:30%;
            height: 200px;
            background-color: red;
        }
        .one{
            flex: 1;
        }
        .two{
            flex:1;
            margin-left: 5%; 
        }
        .three{
            flex:1;
            margin-left: 5%; 
        }
```

#图片后文字居中

1.问题：img后面的文字会默认跟图片的底部对齐，需要让文本居中的方法
    
    图片必须先浮动。
    
  * 给文字span元素包裹，让图片float
  ```
  <img src="13.jpg" alt="" width="100px" height="100px">
  <span>我是her</span>
  ```

    * 方法一：让span元素float;加height和line-height
    ```
        img{
            float:left;
        }
        span{
            float: left;
            height: 100px;
            line-height: 100px;
        }
    ```

    * 方法二：让span元素float；加margin-top
    ```
        img{
            float:left;
        }
        span{
            float: left;
            margin-top:42px;/*默认是16px  （100-16）/2=42px*/
        }
    ```

    * 方法三：让span元素display:inline-block;加height和line-height.
    ```
        img{
            float:left;
        }
        span{
            display: inline-block;
            height: 100px;
            line-height: 100px;
        }
    ```

    * 方法四：让span元素display:inline-block;加margin-top;
    ```
        img{
            float:left;
        }
        span{
            display: inline-block;
            margin-top:42px;/*默认是16px  （100-16）/2=42px*/
        }
    ```

#div中的文本水平垂直居中

1.单行文本水平垂直居中
  * <div><span>你好啊</span></div>
    
  * 方法一：给父元素设置text-align:center;和行高
    ```
    div{
        width: 200px;
        height: 200px;
        background-color: red;
        
        text-align:center;
        line-height:200px;
    }
    ```

  * 方法二：让span设置为display:inline-block;然后设置margin-left和margin-top
  ```
        div{
            width: 200px;
            height: 200px;
            background-color: red;
        }
        div span{
            display: inline-block;
            margin-top:92px;
            margin-left:50px;
        }
  ```

  * 方法三：设置float,并且计算出它的上左margin
  ```
        div{
            width: 200px;
            height: 200px;
            background-color: red;
        }
        div span{
            float:left;
            margin-top:92px; 
            margin-left:60px;
        }
  ```  

2.多行文本水平垂直居中

  * <div><span>你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊你好啊</span></div>

  * 定位：父相子绝
  ```
        div{
            width: 200px;
            height: 200px;
            background-color: red;
            position: relative;
        }
        div span{
            position: absolute;
            top:50px;
        }
  ```

  * 方法二：设置为单元格形式
  ```
        div{
            width: 200px;
            height: 200px;
            background-color: red;
           
            display: table-cell;
            vertical-align: middle;
        }
  ```


#一个div水平居中

1.margin:0 auto;
    ```
    div{
            width: 20%;
            height:100px;
            background-color: red;
            margin:0 auto;
    }
    ```

2.float
    ```
    div{
            width: 20%;
            height:100px;
            background-color: red;
            float:left;
            margin-left:40%;/*(100%-20%)/2=40% */
    }
    ```

3.position:relative;
    ```
    div{
            width: 20%;
            height:100px;
            background-color: red;
            position: relative;
            left:40%;
        }
    ```
4.position:absolute;
    ```
    div{
            width: 20%;
            height:100px;
            background-color: red;
            position: absolute;
            left:40%;
        }
    ```

4.flex
    ```
        body{
            display: flex;
            justify-content: center;
        }
        div{
            width: 20%;
            height:100px;
            background-color: red;
        }
    ```

#ul>li组合布局横排一个列表

1.float布局(ul默认有上下margin 16px和40px的padding-left)
```
        ul{
            padding: 0;
            margin: 0;
        }
        div{
            width: 800px;
            overflow: hidden;
            background-color: pink;
        }
        div ul{
            overflow: hidden;
            float: right;
        }
        div ul li{
            list-style: none;
            float:left;
            line-height: 100px;
            margin-right: 15px;
        }
```

2.flex布局
```
        ul{
            padding: 0;
            margin: 0;
        }
        div{
            width: 800px;
            height: 100px;
            background-color: pink;
        }
        div ul{
            float:right;
            width: 40%;
            
            display:flex;
            justify-content: space-around;
        }
        div ul li{
            list-style: none;
            
            flex:1;
            line-height: 100px;
        }
```

3.column-count方法
```
        ul{
            padding: 0;
            margin: 0;
        }
        div{
            width: 800px;
            height: 100px;
            background-color: pink;
        }
        div ul{
            float:right;
            width: 40%;
            
            column-count: 5;
            column-gap: 10px;
        }
        div ul li{
            list-style: none;
            line-height: 100px;
        }
```

4.display:inline-block;
```
        ul{
            padding: 0;
            margin: 0;
        }
        div{
            width: 800px;
            height: 100px;
            background-color: pink;
        }
        div ul{
            float:right;
            width: 40%;
        }
        div ul li{
            list-style: none;
            line-height: 100px;
            margin-left:15px;
            display: inline-block;
        }
```

#复习第八天css

#网页常见的问题