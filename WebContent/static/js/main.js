let menuFlag = false;
let state = "flag.png";

$(document).ready(function() {
  $(".navbar-brand").hide();
  showInitIcon(state);
});
function showInitIcon(state) {
  $("#img_1").attr("src", "static/img/" + state);
  $("#link_1").show();
}
function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}
async function showStateIcons(t) {
  if (!menuFlag) {
    var styleElem = document.head.appendChild(document.createElement("style"));
    styleElem.innerHTML = "#menu:after {border: 0;}";

    $(".menu").addClass("opened");
    $("#header-title").hide();

    let nameOfImages = [
      "flag.png",
      "placeholder.png",
      "gamer-icon-2.png",
      "timeline-icon2.png"
    ];
    let index = nameOfImages.indexOf(state);
    if (index !== -1) nameOfImages.splice(index, 1);

    for (let i = 2; i <= 4; i++) {
      $("#img_" + i).attr("src", "static/img/" + nameOfImages[i - 2]);
    }
    await sleep(100);
    for (let i = 2; i <= 4; i++) {
      $("#link_" + i).show();
    }

    menuFlag = true;
  } else {
    document.head.removeChild(document.head.lastChild);
    $(".menu").removeClass("opened");
    $(".navbar-brand").hide();

    let img = $("#img_" + t.id.split("_")[1]);
    state = img.attr("src").split("/")[2];
    showInitIcon(state);

    $("#header-title").show();
    menuFlag = false;
  }
}
