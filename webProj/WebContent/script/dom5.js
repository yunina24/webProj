var buttons = document.getElementsByTagName('button');
buttons[0].setAttribute('onclick', 'showTable()');
for (var i = 0; i < buttons.length; i++) {
    buttons[i].setAttribute('onclick', 'showTable()'); //==<button onclick="showTable()">클릭</button>
}


var p1 = {
    name: '성진아',
    score: 80
}
var p2 = {
    name: '김수민',
    score: 83
}
var p3 = {
    name: '장재우',
    score: 85
}

// for(var field in p3){
//     console.log(field, p3[field]);
// }

var persons = [p1, p2, p3];

function showTable() {
    var tableTag = document.createElement('table');
    tableTag.setAttribute('border', '1');

    for (var p of persons) { //배열의 개수만큼 반복하여 출력
        var tr1 = document.createElement('tr');
        var td1 = document.createElement('td');
        td1.innerHTML = p.name;
        var td2 = document.createElement('td');
        td2.innerHTML = p.score;

        console.log('name 요소: ' + p.name);
        console.log('score 요소: ' + p.score);

        tableTag.appendChild(tr1);
        tr1.appendChild(td1);
        tr1.appendChild(td2);

        // var tr1 = document.createElement('tr');
        // for(var field in persons) {
        //     var tr1 = document.createElement('tr');
        //     for(var field in persons) {
        //         var td1 = document.createElement('td');
        //         td1.innerHTML = persons[field];
        //         tr1.appendChild();
        //     }

    }

    var show = document.getElementById('show');
    show.appendChild(tableTag);
}