console.log("enter");

let item_id = 0;
let item_latitude;
let item_longitude;



// 인증 페이지에서 '현재 위치 확인하기' 버튼을 눌렀을 때
function getLocation(id) {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(successCallback, errorCallback);
    item_id = id;
    // item_latitude = parseInt(latitude);
    // item_longitude = parseInt(longitude);
  } else {
    alert("이 브라우저는 Geolocation를 지원하지 않습니다");
  }
}

function successCallback(position) {
  const user_latitude = position.coords.latitude;
  const user_longitude = position.coords.longitude;

  quest_authentication(user_latitude, user_longitude);
  console.log(user_latitude);
  console.log(typeof user_longitude);
  console.log(user_longitude);
}

function errorCallback(error) {
  alert(error.message);
}

function quest_authentication(user_latitude, user_longitude) {
  // 만장굴
  // const manjang_lat = 33.528486;
  // const manjang_lng = 126.7692923;

  // 월정리해변
  // const woljeongli_beach_lat = 33.555875;
  // const woljeongli_beach_lng = 126.7938253;

  // 벤처마루
  // const venturemaru_lat = 33.500459;
  // const venturemaru_lng = 126.529788;

  // 유저 위치
  const startCoords = {
    latitude: user_latitude,
    longitude: user_longitude
  };

  // const destCoords = {
  //   //   latitude: 33.500459,
  //   //   longitude: 126.529788
  //   // };

  // 장소 위치
  const destCoords = {
    latitude: item_latitude,
    longitude: item_longitude
  };

  const dist = computeDistance(startCoords, destCoords);

  if (dist <= 1) {
    console.log("인증되었습니다");
    changeButton(true);
  } else {
    console.log("XXXXX");
    changeButton(false);
  }
}

// 구면 코사인 법칙(Spherical Law of Cosine) 으로 두 위도/경도 지점의 거리를 구함
// 반환 거리 단위 (km)
function computeDistance(startCoords, destCoords) {
  const startLatRads = degreesToRadians(startCoords.latitude);
  const startLongRads = degreesToRadians(startCoords.longitude);
  const destLatRads = degreesToRadians(destCoords.latitude);
  const destLongRads = degreesToRadians(destCoords.longitude);

  const Radius = 6371; //지구의 반경(km)
  const distance =
    Math.acos(
      Math.sin(startLatRads) * Math.sin(destLatRads) +
        Math.cos(startLatRads) *
          Math.cos(destLatRads) *
          Math.cos(startLongRads - destLongRads)
    ) * Radius;

  return distance;
}

function degreesToRadians(degrees) {
  let radians = (degrees * Math.PI) / 180;
  return radians;
}

function changeButton(status) {
  if (status) {
    document.getElementById("user-location-confirm-btn").innerText =
        "인증되었습니다✔ ️";
    document.getElementById("user-location-confirm-btn").style.color = "#27ae60";
    postParams();
  } else {
    document.getElementById("user-location-confirm-btn").innerText =
        "조금 더 이동해주세요️?? 실패일 때 뭘로할까?";
  }

}

function postParams() {
  console.log("enter postParams");
  const status = document.getElementById("user-location-confirm-btn").innerText;

  if (status === "인증되었습니다✔ ️") {
    console.log("status = 인증");
    const params = {
      item_id: item_id,
      // user_id: user_id,
      method: "update"
    };


    $.ajax({
      url: "/quest-in-jeju/servlet/UserItemPlayServlet",
      type: "POST",
      data: JSON.stringify(params),
      dataType: "json",
      contentType: "application/json; charset=UTF-8",
      success: function() {
        console.log("success");
      }
    });
  }
}
