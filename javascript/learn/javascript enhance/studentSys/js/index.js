function Student(id,name,gender,phone){
    Student.prototype.index++;
    this.id = id;
    this.name = name ;
    this.gender = gender;
    this.phone = phone;
}
Student.prototype.index = 1;
var students = [];
// var arr = ["terry","tom"];


$(function(){
    //初始化页面
    $(".content").load("component/studentList.html");

    
   
});