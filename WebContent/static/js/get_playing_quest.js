let isLogined = false;

function loadingProgressCircleBar() {
    $(function() {
        // Remove svg.radial-progress .complete inline styling
        $("svg.radial-progress").each(function(index, value) {
            $(this)
                .find($("circle.complete"))
                .removeAttr("style");
        });

        $("svg.radial-progress").each(function(index, value) {
            // If svg.radial-progress is approximately 25% vertically into the window when scrolling from the top or the bottom
            // Get percentage of progress
            percent = $(value).data("percentage");
            // Get radius of the svg's circle.complete
            radius = $(this)
                .find($("circle.complete"))
                .attr("r");
            // Get circumference (2πr)
            circumference = 2 * Math.PI * radius;
            // Get stroke-dashoffset value based on the percentage of the circumference
            strokeDashOffset = circumference - (percent * circumference) / 100;
            // Transition progress for 1.25 seconds
            $(this)
                .find($("circle.complete"))
                .animate({ "stroke-dashoffset": strokeDashOffset }, 1250);
        });
    });
}
function getUserQuestAndItemsPlayingByUserId() {
    const params = {
        "method": "getUserQuestAndItemsPlayingByUserId"
    };
    console.log("Start getting user_quest_play list");
    $.ajax({
        // 참고하세요 여기 남겨도 되나요?
        // https://ddo-o.tistory.com/94
        url: "/quest-in-jeju/servlet/UserQuestPlayServlet",
        type: "POST",
        data: JSON.stringify(params),
        dataType: 'json',
        contentType: "application/json; charset=UTF-8",
        success: function(obj) {
            console.log(obj);
            if(obj['code'] == 200){
                sessionStorage.setItem("questMap", JSON.stringify(obj['data']));
            }
            navigator.geolocation.getCurrentPosition(success, error, options);
        },
        error:function(request,status,error){
            $(".se-pre-con").fadeOut("slow");
            console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
    });
}
function isLogin(idValue){
    if(idValue!==undefined){
        isLogined = true;
        getUserQuestAndItemsPlayingByUserId();
    }else {
        navigator.geolocation.getCurrentPosition(success, error, options);
    }
}
