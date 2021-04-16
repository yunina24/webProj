//function3.js

var sum = function (a, b) {
    var num1 = 10;
    var num2 = 20;
    console.log(a + (num1 + num2) + b);
}

sum('내 나이는 ', '입니다.');
// console.log(sum);


var factorial = function fac(n) {
    if (n == 1) {
        return 1;
    }
    return fac(n - 1);
}

function sumVal(a, b) {
    return a * b;
}

function mulVal(a, b) {
    return a * b;
}

function executeFunc(callBack, num1, num2) {
    var result =  callBack(num1, num2);
    return result;
}

result = executeFunc(sumVal, 3, 5);
console.log(result);
