
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
    state = img.attr("src").split("/")[2];
    showInitIcon(state);

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
/*
  window.onload = function(){
		var is = document.getElementsByTagName("img");
			for(var i=0;i<is.length;i++){
				var fp = function(j){
					is[j].onclick=function(){
						is[j].src="static/img/check.png";
					}
				};
				fp(i);
			}
		};
*/
var options = {
  enableHighAccuracy: true,
  timeout: 5000,
  maximumAge: 0
};

function success(pos) {
  const jejuLatitued = 33.38715;
  const jejuLongitude = 126.5266283;

  var crd = pos.coords;
  $("#app").append("<br>");
  $("#app").append("Your current position is:");
  $("#app").append("<br>");
  $("#app").append("Latitude : " + crd.latitude);
  $("#app").append("<br>");
  $("#app").append("Longitude: " + crd.longitude);
  $("#app").append("<br>");
  $("#app").append("More or less " + crd.accuracy + " meters.");
  $("#app").append("<br>");
  var HOME_PATH = window.HOME_PATH || ".";
  var mapOptions = {
    center: new naver.maps.LatLng(jejuLatitued, jejuLongitude),
    zoom: 4
  };
  var map = new naver.maps.Map("map", mapOptions);
  var position = new naver.maps.LatLng(crd.latitude, crd.longitude);
  var latlngs = [
    new naver.maps.LatLng(33.528486, 126.7692923),
    new naver.maps.LatLng(33.555875, 126.7938253),
    new naver.maps.LatLng(33.5437905, 126.6666554),
    new naver.maps.LatLng(33.366052, 126.3555555)
  ];
  var markerList = [];
  var newMarker = new naver.maps.Marker({
    position: new naver.maps.LatLng(crd.latitude, crd.longitude),
    map: map,
    animation: naver.maps.Animation.BOUNCE,
    icon: {
      url: HOME_PATH + "/static/img/user_red_50_50.png",
      size: new naver.maps.Size(50, 52),
      origin: new naver.maps.Point(0, 0),
      anchor: new naver.maps.Point(25, 26)
    }
  });
  for (var i = 0, size = latlngs.length; i < size; i++) {
    var icon = {
      url: HOME_PATH + "/static/img/current_icon_30_30.png",
      size: new naver.maps.Size(50, 52),
      origin: new naver.maps.Point(0, 0),
      anchor: new naver.maps.Point(25, 26)
    };
    marker = new naver.maps.Marker({
      position: latlngs[i],
      map: map,
      icon: icon
    });

    marker.set("seq", i);

    markerList.push(marker);

    // marker.addListener("mouseover", onMouseOver);
    // marker.addListener("mouseout", onMouseOut);

    icon = null;
    marker = null;
  }
}
