
let menuFlag = false;
let state = document.title;

$(document).ready(function() {
  $(".navbar-brand").hide();
  state = state.toLocaleLowerCase();
  showInitIcon(state+".png");
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
      "quest",
      "index",
      "mypage",
      "timeline"
    ];
    let index = nameOfImages.indexOf(state);
    if (index !== -1) nameOfImages.splice(index, 1);

    for (let i = 2; i <= 4; i++) {
      $("#link_" + i).attr("href",nameOfImages[i-2]+".jsp")
      $("#img_" + i).attr("src", "static/img/" + nameOfImages[i - 2]+".png");
    }
    await sleep(100);
    for (let i = 2; i <= 4; i++) {
      $("#link_" + i).show();
    }

    menuFlag = true;
  }
  else {
    if(t.id != 'link_1') return;
    document.head.removeChild(document.head.lastChild);
    $(".menu").removeClass("opened");
    $(".navbar-brand").hide();

    let img = $("#img_" + t.id.split("_")[1]);
    state = img.attr("src").split("/")[2]; // index.png
    state = state.substring(0,state.length - 4); // index
    showInitIcon(state+".png");

    $("#header-title").show();
    menuFlag = false;
  }
}

function doDisplay() {
	  var con = document.getElementById("orumlist");
	  if (con.style.display == "block") {
	    con.style.display = "none";
	  } else {
	    con.style.display = "block";
	  }
	}

function logDisplay(){
	var con = document.getElementById("loginpass");
	  if (con.style.display == "block") {
		    con.style.display = "none";
		  } else {
		    con.style.display = "block";
		  }
		}

$('.flat-toggle').on('click', function() {
    $(this).toggleClass('on');
});
