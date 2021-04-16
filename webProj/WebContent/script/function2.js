// function2.js

var names = ['구자혁', '유정모', '소국진', ' 전형민'];

function makelist(nameAry) {
    var ulTag = '<ul>';
    for(str of nameAry) { //= String str : nameAry
        ulTag += '<li>' + str + '</li>';
    }
    ulTag += '</ul>'
    return ulTag;
}

var show = makelist(names);
console.log(show);
document.write(show);