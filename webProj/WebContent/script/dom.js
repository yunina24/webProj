<div id="show"></div>

var h1Tag = document.createElement('h1');
h1Tag.innerHTML = "Hello";
console.log(h1Tag);
var aTag = document.createElement('a');
aTag.setAttribute('herf', 'http://www.daum.net');
// aTag.innerHTML = "다음 페이지";
var text = document.createTextNode('다음 사이트'); //텍스트 노드를 만들어서
aTag.appendChild(text); //aTag의 (해당 태그의 appendChild속성을 사용하여)자식으로 만들겠습니다. 선언
console.log(aTag);

// <!-- document.body.appendChild(h1Tag);
// document.body.appendChild(aTag); -->

var show = document.getElementById('show'); //document의 getElementById 속성으로 show ID를 불러와 show라는 이름의 변수(var)로 선언!
show.setAttribute('style', 'background: pink'); //==<div stlye='background: pink'></div>
show.appendChild(h1Tag);
show.appendChild(aTag);