// index.html 에서 quest item 옆 '인증' 버튼을 눌렀을 때

// 임시로 1번 아이템을 지정
let item_id = 1;
let user_id = 1;

const status = document.getElementById("user-location-confirm-btn").innerText;

if( status === "인증되었습니다✔️") {
    const result = true;

    const params = {
        "item_id": item_id,
        "user_id": user_id,
        "result": true,
        "method": "queryForObject"
    };

    $.ajax({
        url: "/quest-in-jeju/servlet/UserItemPlayServlet",
        type: "POST",
        data: JSON.stringify(params),
        dataType: 'json',
        contentType: "application/json; charset=UTF-8",
        success: function() {
            alert("인증되었습니다")
        }
    });

} else {
    const result = false;
}