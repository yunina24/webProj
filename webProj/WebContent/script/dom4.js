var ps = document.querySelectorAll('div>p') //div 태그 아래에 있는 자식인 p를 전부 호출
ps.textContent = 'hello';
ps.style.backgroundcolor = 'gold';

// ps.forEach(function(val){
//     console.log(val);
//     // val.innerHTML = '<h1>Hello</h1>'; //Hello의 결과로 출력
//     val.textContent = '<h1>Hello</h1>'; //<h1>Hello</h1>의 결과로 출력
// //     val.style.backgroundcolor = 'pink';
// });

// <!--예제: numbers: 0~10
        //     filter>map>forEach 순서로 짝수만 걸러난 값을 evenVal 변수로 정의
        //     evenVal의 값을 * 3 하는 값을 mapVal 변수로 정의하여 출력--> 
        // var numbers = [];
        // numbers[0] = '1';
        // numbers.push('2');
        // numbers.push('3');
        // numbers.push('4');
        // numbers.push('5');
        // numbers.push('6');
        // numbers.push('7');
        // numbers.push('8');
        // numbers.push('9');
        // numbers.push('10');

      
        // var evenVal = numbers.filter(function(val, idx, ary){
        //     return val % 2 == 0; //짝수만 출력!
        // });

        // var mapVal = evenVal.map(function(val, idx, ary){
        //     return val * 3;
        // });

        // // var i = 0;
        // mapVal.forEach(function(val, idx, ary){
        //     console.log(val);
        // });


            //해당 예제의 교수님 답안
            var numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9 ,10];
            // var evenVal = numbers.filter(function(val){
            //     return val % 2 == 0;
            // });
            // var mapVal = evenVal.map(function(val){
            //     return val * 3;
            // });
            // mapVal.forEach(function(val){
            //     console.log(val);
            // });
    
            //위 문장들을 람다식으로 간략화
            numbers.filter((val) => val % 2 ==0).map((val) => val * 3).forEach((val) => console.log(val));
            
            var sum = (a, b) => { //var sum = (a, b) => a + b; 이것을 arrow function이라고 함
                return a+b;
            }
            sum(10, 20);