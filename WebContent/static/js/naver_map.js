
var options = {
    enableHighAccuracy: true,
    timeout: 5000,
    maximumAge: 0
};

function success(pos) {
    let questMap = JSON.parse(sessionStorage.getItem("questMap"));
    console.log(questMap);
    let latlngs = [];
    for(i in questMap){
        for(item in questMap[i]){
            let latitude = questMap[i][item]['latitude'];
            let longitude = questMap[i][item]['longitude'];
            latlngs.push(new naver.maps.LatLng(latitude, longitude))
        }
    }
    const jejuLatitued = 33.38715;
    const jejuLongitude = 126.5266283;

    let crd = pos.coords; //현재 위도 경도
    let HOME_PATH = window.HOME_PATH || ".";
    let mapOptions = {
        center: new naver.maps.LatLng(jejuLatitued, jejuLongitude),
        zoom: 4
    };
    let map = new naver.maps.Map("map", mapOptions);
    let position = new naver.maps.LatLng(crd.latitude, crd.longitude);

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
    $(".se-pre-con").fadeOut("slow");
}

function error(err) {
    console.warn("ERROR(" + err.code + "): " + err.message);
}


