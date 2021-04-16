//obj2.js
var names = []; //=new Array(); 배열 선언
names[0] = 'Hong';
names[1] = 'Hwang';
names[2] = 'Park';
names[3] = 'Yun';

for (var i = 0; i < names.length; i++) {
    document.write('<h2>' + names[i] + '</h2>');
}

console.log('-------------------------');

var tableTag = '<table border="1">';
tableTag += '<tr><td>이름</td><td>나이</td></tr>'; //=tableTag = tableTag + '<tr></tr>';
var persons = [obj, obj2, obj3];
for (var i = 0; i < persons.length; i++) {
    if (persons[i].age < 20) {
        tableTag += '<tr><td style="color: red;">' + persons[i].name + '</td><td style="color: red;">' + persons[i].age + '</td></tr>';
    } else {
        tableTag += '<tr><td>' + persons[i].name + '</td><td>' + persons[i].age + '</td></tr>';
    }
}
tableTag += '</table>';
document.write(tableTag);