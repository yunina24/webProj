     //<from action="login,jsp" method="get">
     var form = document.createElement('form');
     form.setAttribute('action', 'login.jsp');
     form.setAttribute('method', 'get');

     //아이디와 패스워드 변수 선언
    var id = document.createTextNode('id: ');
    var password = document.createTextNode('password: ');
   
    //id: <input type='text' name="id">
    var inputId =document.createTextNode('input');
    inputId.setAttribute('type', 'text');
    inputId.setAttribute('name', 'id');

    //<input type='password' name="passwd">
    var inputPw =document.createTextNode('input');
    inputId.setAttribute('type', 'password');
    inputId.setAttribute('name', 'passwd');

    //<input type='submit' value="Send">
    var send = document.createElement('input');
    inputId.setAttribute('type', 'submit');
    inputId.setAttribute('name', 'Send');

    //<input type='reset' value="Cencel">
    var cancel = document.createElement('input');
    inputId.setAttribute('type', 'reset');
    inputId.setAttribute('name', 'Cancel');


 //    var show = document.getElementById("show");
    form.appendChild(id);
    form.appendChild(inputId);
    form.appendChild(password);
    form.appendChild(inputPw);
    form.appendChildd(send);
    form.appendChild(cancel);

    document.body.appendChild(form);

 //    document.write('<span>' + 'id: ' + inputId + '</span>');
 //    document.write('<span>' + 'password: ' + inputPw + '</span>');
 //    document.write('<span>' + send + cancel + '</span>');