//function.js
// function sum(num3, num4) {
//     var num1 = 10;
//     var num2 = 20;
//     console.log(num1 + num2 + num3 + num4);
//     return num1 + num2 + num3 + num4
// }

// sum(30, 40);
// var result = sum(30, 40 ,50);

// var numAry = [3, 5, 1, 8, 9];

// function arySum(ary) {
//     var sum = 0;
//     for (var i = 0; i < ary.length; i++) {
//         if (ary[i] % 2 == 1) {
//             sum += ary[i];
//         }
//     }
//     return sum;
// }
// arySum(numAry);
// document.write('결과값: ' + result);

function multi(grade) {
    var tableTag = '<table border="1">';
    for (var i = 1; i <= 10; i++) {
        tableTag += '<tr><td>' + grade + '*' + i + '</td><td>' + '=' + '</td><td>' + (grade * i) + '</td></tr>';
    }

    tableTag += '</table>';
    document.write(tableTag);
}
for (var i = 2; i <=9; i++){
    multi(1);
}
// multi(9);