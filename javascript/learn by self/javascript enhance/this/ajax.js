function(url,sucFunc,failFunc){
  if(window.XMLhttpRequest){
    var ajax=new XMLhttpRequest();
}
else{
	var ajax=new ActiveX();
}
}