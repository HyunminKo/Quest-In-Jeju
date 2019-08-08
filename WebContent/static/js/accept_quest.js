function post_user_quest(quest_id){

    console.log("enter");

    const params = {
        "quest_id": parseInt(quest_id),
        "method" : "insert"
    };

    $.ajax({
        // 참고하세요 여기 남겨도 되나요?
        // https://ddo-o.tistory.com/94
        url: "/quest-in-jeju/servlet/UserQuestPlayServlet",
        type: "POST",
        data: JSON.stringify(params),
        dataType: 'json',
        contentType: "application/json; charset=UTF-8",
        success: function() {
            alert("퀘스트가 시작되었습니다");
            location.href="quest.jsp";
        }
    });
}


function confirm_user_accept(quest_id,user_id) {
    if(user_id == undefined){
        alert("로그인이 필요한 기능입니다.\n로그인 페이지로 이동하겠습니다.");
        location.href="index.jsp";
        return;
    }

    if(confirm('퀘스트를 시작하시겠습니까?')){
        post_user_quest(quest_id);
        return true;
    };
}