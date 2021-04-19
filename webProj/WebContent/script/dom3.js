var names = [];
        names[0] = '유정모';
        names.push('구자혁'); //<제일 마지막 위치에 배열값 추가 생성
        names.push('석정원'); 
        names.pop(); //마지막 위치의 배열을 하나 삭제
        delete names[0]; //지정하는 위치의 배열 삭제, 배열 공간은 남아있으나 배열의 값만 삭제
        names.shift(); //처음 위치의 배열을 하나 삭제
        names.unshift('김이담'); //제일 처음 위치에 배열값 추가 생성
        names.push('공도현');
        names.push('소국진');
        names.push('전형민');

        var returnVal = names.map(function(val, idx, ary){ //콜백 배열 오브젝트가 가지고 있는 맵속성
            // if(idx < 3){
            //     return val;
            // }
            // return null;
            var person = {};
            person.name = val;
            person.num = idx;

            return person;
        });

        var returnFil = returnVal.filter(function(val, idx, ary) { //참거짓 
            return idx % 2 == 0; //짝수만 출력!

        });
        // var show = document.getElementById('show');
        // var ulTag = document.createElement('ul');
        // show.appendChild(ulTag);

        // var i = 0;
        // names.forEach(function(val, idx, ary) { //배열이 가지고 있는 매소드
            // console.log('names 요소: ${a}, ${b} ,${c}'); //==('names 요소: ' + i)
            // var liTag = document.createElement('li');
            // liTag.innerHTML = val; //==<li>김이담</li>
            // ulTag.appendChild(liTag);
        // });
        console.log(returnFil);
        console.log('===============');
        console.log(returnVal);