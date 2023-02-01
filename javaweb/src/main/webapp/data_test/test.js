// alert("导入js");
// let i;
// i = 12;
//typeof()返回变量的数据类型
// alert(typeof (i));

/*
    等于==            简单的字面数值比较
    全等于===          除了数值比较之外，还会比较两个变量的数据类型
 */

// let a = 12;
// let b = "12";
// alert(a == b); //true
// alert(a === b); //false

// let array_01 = []; //空数组
// alert(array_01.length);
// let array_02 = [1, "2", array_01]; //数组赋值
// alert(array_02.length);

//无参函数
function fun1() {
    alert("无参函数被调用");
}
/*
var fun1 = function () {
    alert("无参函数被调用");
}
 */

fun1();

// 有参函数
function fun2(a, b) {
    alert("有参函数被调用，a=" + a + "，b=" +b);
}
/*
var fun2 = function (a, b) {
    alert("有参函数被调用，a=" + a + "，b=" +b);
}
 */

fun2(1, "qw");

//有参函数
function fun3(a, b) {
    return a+b;
}
/*
var fun3 = function (a, b) {
    return a+b;
}
 */

alert("1+2=" + fun3(1, 2));

//arguments     在function中不需要定义，但可以直接用来获取所有参数的变量，称为隐形参数
function fun4() {
    alert("arguments[0]=" + arguments[0]);
    alert("arguments[0]=" + arguments[1]);
}

fun4(54, "sa21");

var obj = new Object();
obj.name = "ccr";
obj.age = 23;
obj.fun5 = function () {
    alert("姓名：" + this.name + "\n年龄：" + this.age);
}
obj.fun5();

/*
    大括号自定义对象
    属性之间使用,分隔
    最后一个属性不要使用,
 */

var selfObj = {
    name: "ccr",
    age: 23,
    fun6: function () {
        alert("selfObj\n姓名：" + this.name + "\n年龄：" + this.age);
    },
};

selfObj.fun6();