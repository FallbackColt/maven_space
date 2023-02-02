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

// 有参函数
function fun2(a, b) {
    alert("有参函数被调用，a=" + a + "，b=" +b);
}

/*
var fun2 = function (a, b) {
    alert("有参函数被调用，a=" + a + "，b=" +b);
}
 */

//有参函数
function fun3(a, b) {
    alert("a+b=" + (a+b) );
}

/*
var fun3 = function (a, b) {
    return a+b;
}
 */

//arguments     在function中不需要定义，但可以直接用来获取所有参数的变量，称为隐形参数
function fun4() {
    alert("arguments[0]=" + arguments[0] + "\narguments[0]=" + arguments[1]);
}

var obj = new Object();
obj.name = "ccr";
obj.age = 23;
obj.fun5 = function () {
    alert("姓名：" + this.name + "\n年龄：" + this.age);
}

/*
    大括号自定义对象
    属性之间使用,分隔
 */

var selfObj = {
    name: "ccr",
    age: 23,
    fun6: function () {
        alert("selfObj\n姓名：" + this.name + "\n年龄：" + this.age);
    },
};

// 动态注册onclick事件
var onclickObj = function () {
    //1. 获取标签对象
    document.getElementById("btn01").onclick = function () {
        alert("动态注册onclick事件");
    }
}

// 动态注册onblur事件
var onblurObj = function () {
    //1. 获取标签对象
    document.getElementById("in01").onblur = function () {
        alert("动态注册onblur事件");
    }
}

// 动态注册onchange事件
var onchangeObj = function () {
    document.getElementById("sel01").onchange = function () {
        alert("动态注册onchange事件");
    }
}

// 动态注册onsubmit事件
var onsubmitObj = function () {
    alert(document.getElementById("sub01"));
}

// 校检内容是否满足要求
var check = function (str, check_symbol) {
    document.getElementById(str).onblur = function () {
        var usernameText =document.getElementById(str).value;
        var patt = /^\w{5,12}$/;
        // test()用于测试字符串是否匹配该规则
        if (patt.test(usernameText)) {
            document.getElementById(check_symbol).innerHTML = "✔";
        } else {
            document.getElementById(check_symbol).innerHTML = "❌";
        }
    }
}

// 兴趣全选
var checkAll = function () {
    var nameList = document.getElementsByName("hobby");
    for (let i = 0; i < nameList.length; i++) {
        nameList[i].checked = 1;
    }
}

// 兴趣全不选
var checkNone = function () {
    var nameList = document.getElementsByName("hobby");
    for (let i = 0; i < nameList.length; i++) {
        nameList[i].checked = 0;
    }
}

// 兴趣反选
var reverseAll = function () {
    var nameList = document.getElementsByName("hobby");
    for (let i = 0; i < nameList.length; i++) {
        nameList[i].checked = !nameList[i].checked;
    }
}