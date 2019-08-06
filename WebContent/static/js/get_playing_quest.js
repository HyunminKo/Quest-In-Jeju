$(document).ready(function () {
    const params = {
        "method": "findAll"
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

        }
    });
});