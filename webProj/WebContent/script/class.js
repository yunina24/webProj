class Student {
    constructor(name, age, score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    showAge() {
        return this.age;
    }
    showInfo() {
        return '이름은 ' + this.name + ', 점수는 ' + this.score;
    }
}

var student = [];
student[0] = new Student('정동영', 25, 80);
student[1] = new Student('김이담', 24, 83);
student[2] = new Student('석정원', 22, 75);
student[3] = new Student('공도현', 35, 67);

// student[2].showInfo();

console.log(student);

function creatTr(obj) {
    var tr = '';
    tr += '<tr>';
    tr += '    <td>' + obj.name + '</td>';
    tr += '    <td>' + obj.age + '</td>';
    tr += '    <td>' + obj.score + '</td>';
    tr += '</tr>'
    return tr;
}
var table = '<table border="1" bgcolor="silver">';
for (var i = 0; i < student.length; i++) {
    table += creatTr(student[i]);
}
table += '</table>';

document.write(table);