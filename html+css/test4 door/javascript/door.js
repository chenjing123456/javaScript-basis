window.onload=function(){
	//获取容器对象
	var box=document.getElementById('contains');
	//获取img对象集合
	var imgs=box.getElementsByTagName('img');
	//单张图片的宽度
	var imgWidth=imgs[0].offsetWidth;
	//隐藏门体露出的宽度
	var exposeWidth=100;
	//设置容器的总宽度
	var boxWidth=imgWidth+exposeWidth*(imgs.length-1);
	box.style.width=boxWidth+'px';
	//设置每道门的初始位置
	function setImgsPos(){
	for(var i=1;i<imgs.length;i++){
        imgs[i].style.left=imgWidth+exposeWidth*(i-1)+'px';
	}
    }
    setImgsPos();
	//计算每道门打开时应该移动的距离
	var translate=imgWidth-exposeWidth;
    //为每道门绑定事件
    for(var i=0;i<imgs.length;i++){
    	(function(i){
    		imgs[i].onmouseover=function(){
    			//将每道门复位
    			setImgsPos();
    			//打开门
    			for(var j=1;j<=i;j++){
    				imgs[j].style.left=parseInt(imgs[j].style.left,10)-translate+'px';
    			}
    		};
    	})(i);
    }
}