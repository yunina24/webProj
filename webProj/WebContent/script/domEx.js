function createTitle() {
    var trTag = document.createElement('tr');
    for (var i = 0; i < arguments.length; i++) {
        var td1 = document.createElement('th');
        td1.innerHTML = arguments[i];
        trTag.appendChild(td1);
    }
    //for문과 arguments로 코드 길이 줄이기
    // var td2 = document.createElement('th');
    // td2.innerHTML = t2;
    // var td3 = document.createElement('th');
    // td3.innerHTML = t3;
    // var td4 = document.createElement('th');
    // td4.innerHTML = t4;
    // var td5 = document.createElement('th');
    // td5.innerHTML = t5;
    // trTag.appendChild(td2);
    // trTag.appendChild(td3);
    // trTag.appendChild(td4);
    // trTag.appendChild(td5);

    tbl.appendChild(trTag);
}

function createData() {
    for (var ps of persons) {
        var trTag = document.createElement('tr');
        trTag.setAttribute('id', ps.id);
        trTag.onmouseover = mouseOverFnc;
        trTag.onmouseout = mouseOutFnc;

        for (var field in ps) { //4번 반복하는 필드라는 이름의 변수 선언
            if (field == 'id') { //아이디칸을 클릭하면...회원정보 수정 이벤트
                var tdTag = document.createElement('td');
                tdTag.onclick = modifyFnc; //수정버튼 기능 호출
                var text = document.createTextNode(ps[field]);
                trTag.appendChild(tdTag);
                tdTag.appendChild(text);
            } else if (field == 'name') { //이름칸을 클릭하면...해당 링크로 연결
                var tdTag = document.createElement('td');
                var link = document.createElement('a');
                link.setAttribute('href', "dom.jsp?name=" + ps.name + "&id=" + ps.id + "&score=" + ps.score + "&gender=" + ps.gender);
                link.innerHTML = ps.name;
                trTag.appendChild(tdTag);
                tdTag.appendChild(link);
            } else {
                var tdTag = document.createElement('td');
                var text = document.createTextNode(ps[field]);
                trTag.appendChild(tdTag);
                tdTag.appendChild(text);

            }
        }
    
    var bt = document.createElement('button');
    bt.innerHTML = '삭제';
    bt.onclick = deleteRow; //삭제버튼 기능 호출

    var tdTag = document.createElement('td');
    tdTag.appendChild(bt);
    trTag.appendChild(tdTag);
    tbl.appendChild(trTag);
    }
}


function mouseOverFnc() {
    // this.children[1].innerHTML;
    this.style.backgroundColor = 'gold';
}

function mouseOutFnc() {
    this.style.backgroundColor = '';
}

function deleteRow() {
    this.parentNode.parentNode.remove();
}

function modifyFnc() { //수정할 데이타의 아이디를 클릭하면 입력창에 호출
    var idVal = this.innerHTML;
    var nameVal = this.previousSibling.childNodes[0].innerHTML;
    var scoreVal = this.nextSibling.innerHTML;
    var genderVal = this.parentNode.childNodes[3].innerHTML;

    console.log(idVal, nameVal, scoreVal, genderVal);

    document.getElementById('name').value = nameVal;
    document.getElementById('id').value = idVal;
    document.getElementById('score').value = scoreVal;
    var gds = document.querySelectorAll('input[name="gender"]');
    for (var i = 0; i < gds.length; i++) {
        if (gds[i].value == genderVal) {
            gds[i].checked = true;
        }
    }
}

function saveBtFnc() {
    var iName = document.getElementById('name');
    var iId = document.querySelector('input[name="id"]'); //해당 값의 input태그에 아이디가 없을 경우
    var iScore = document.getElementsByTagName('input')[2];
    var iGender = document.querySelector('input[name="gender"]:checked');
    // console.log(iName.value);

    var trTag = document.createElement('tr');
    trTag.onmouseover = mouseOverFnc; //마우스오버 컬러변경 이벤트
    trTag.onmouseout = mouseOutFnc;

    //name
    var tdTag = document.createElement('td');
    tdTag.innerHTML = iName.value;
    trTag.appendChild(tdTag);

    //id
    tdTag = document.createElement('td');
    tdTag.innerHTML = iId.value;
    trTag.appendChild(tdTag);

    //score
    tdTag = document.createElement('td');
    tdTag.innerHTML = iScore.value;
    trTag.appendChild(tdTag);

    //gerder
    tdTag = document.createElement('td');
    tdTag.innerHTML = iGender.value;
    trTag.appendChild(tdTag);

    //button
    var bt = document.createElement('button');
    bt.innerHTML = '삭제';
    bt.onclick = deleteRow;
    tdTag = document.createElement('td');
    tdTag.appendChild(bt);
    trTag.appendChild(tdTag);

    tbl.appendChild(trTag);
}

function modifyBtFnc() { //수정할 데이타를 호출하여 수정한 뒤 등록
    var id = document.getElementById('id').value;
    var name =  document.getElementById('name').value;
    var score = document.getElementById('score').value;
    var gender = document.querySelector('input[name="gender"]:checked').value;
    console.log(targetTr);

    var targetTr = document.getElementById(id); //아이디로 해당 tr의 정보 전부호출
    targetTr.children[0].innerHTML = '<a href = "dom.jsp?name=" + name + "&id=" + id + "&score=" + score + "&gender=" + gender> '+ name +' </a>'
    targetTr.children[2].innerHTML = score;
    targetTr.children[3].innerHTML = gender;
}