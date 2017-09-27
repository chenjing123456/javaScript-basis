$(function(){
	$(".content").load("component/stuList.html");
})
 function Student(id,name,gender,phone){
 	Student.prototype.index++;
 	this.id=id;
 	this.name = name;
 	this.gender = gender;
 	this.phone = phone;
 }
 Student.prototype.index = 1;
 var students = [];