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
$(document).ready(function () {
    const params = {
        "method": "findAll"
    };
    console.log("test");
    $.ajax({
        // 참고하세요 여기 남겨도 되나요?
        // https://ddo-o.tistory.com/94
        url: "/quest-in-jeju/servlet/UserQuestPlayServlet",
        type: "POST",
        data: JSON.stringify(params),
        dataType: 'json',
        contentType: "application/json; charset=UTF-8",
        success: function(s) {
            console.log(s);
            $(".se-pre-con").fadeOut("slow");
            loadingProgressCircleBar();
        }
    });
});