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
let isChecked = false;

function signupcheck(){
    var signupform = document.getElementById("signupform");
    var email = document.getElementById("joinEmail");
    var password = document.getElementById("password");
    var passwordcheck = document.getElementById("passwordcheck");
    var name = document.getElementById("name");
    // console.log(email.value);
    // console.log(password.value);
    // console.log(passwordcheck.value);
    // console.log(name.value);
    if(!isChecked) {
    	alert("이메일 중복 체크를 해주세요.");
    	return false;
    }
    if(email.value == ''){
        alert("이메일을 입력해주세요")
        email.focus();
        return false;
    } 
    else if(password.value == '') {
        alert("비밀번호를 입력해주세요")
        password.focus();
        return false;
    }
    else if(passwordcheck.value == '') {
        alert("비밀번호를 입력해주세요")
        passwordcheck.focus();
        return false;
    }else if(password.value != passwordcheck.value){
		alert("비밀번호가 일치하지 않습니다.");
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
function loginCheck() {

}

function checkEmail() {
	if($('#joinEmail').val() == ''){
		alert("Email을 입력해주세요.");
		$('#joinEmail').focus();
		return;
	}
	
	let email = $('#joinEmail').val();

	$.ajax({
        url: "/quest-in-jeju/servlet/EmailCheckServlet",
        type: "POST",
        data: {
            "email":email
	     },
        success: function(data) {
        	console.log(data)
            if(data.trim() == 'true'){ // 가입 가능
            	alert("가입 가능한 이메일입니다.");
            	isChecked = true;
            }else { //가입 불가능
            	alert("존재하는 이메일입니다. 다른 이메일을 입력하세요.");
            	document.getElementById("joinEmail").value = '';
            	isChecked = false;
            }
        },
        error:function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });
}
// if(signupform.content.value ==''){
    //     alert('빈칸을 모두 입력해주세요');
    // }
    // else{
    //     // signupform.submit();
    // }
