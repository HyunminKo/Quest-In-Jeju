// window.onload = function(){
//     var signupform = document.getElementById("signupform");
//     var op = document.getElementById("signup-btn");
//     op.onclick = function(){
    
    
//     if(signupform.content.value ==''){
//         alert('내용을 입력해주세요');
//     }
//     else{
//         signupform.submit();
//     }
//     };
// };
function check(){
    var signupform = document.getElementById("signupform");
    var email = document.getElementById("email");
    var password = document.getElementById("password");
    var passwordcheck = document.getElementById("passwordcheck");
    var name = document.getElementById("name");
    // console.log(email.value);
    // console.log(password.value);
    // console.log(passwordcheck.value);
    // console.log(name.value);
    
    if(email.value == ''){
        alert("이메일을 입력해주세요")
        return false;
    } 
    else if(password.value == '') {
        alert("비밀번호를 입력해주세요")
        return false;
    }
    else if(passwordcheck.value == '') {
        alert("비밀번호를 확인해주세요")
        return false;
    }
    else if(name.value == '') {
        alert("이름을 입력해주세요")
        return false;
    }
    else{
        signupform.submit();
    }
}
// if(signupform.content.value ==''){
    //     alert('빈칸을 모두 입력해주세요');
    // }
    // else{
    //     // signupform.submit();
    // }
