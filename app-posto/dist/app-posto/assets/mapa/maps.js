
// navigator.geolocation.getCurrentPosition(showPosition);

// function showPosition(position) {
//   var directionsService = new google.maps.DirectionsService();
//   var directionsRenderer = new google.maps.DirectionsRenderer();
//   //  lat = position.coords.latitude;
//   //  lon = position.coords.longitude;
//   //latlon = new google.maps.LatLng(lat, lon)

//   var map = new google.maps.Map(document.getElementById('mapholder'), {
//     zoom: 16,
//     center: { lat: 41.85, lng: -87.65 }
//   });
//   directionsRenderer.setMap(map);


  // mapholder = document.getElementById('mapholder')
  // mapholder.style.height = '250px';
  // mapholder.style.width = '550px';

  // var myOptions = {
  //   center: latlon, zoom: 16,
  //   mapTypeId: google.maps.MapTypeId.ROADMAP,
  //   mapTypeControl: false,
  //   navigationControlOptions: { style: google.maps.NavigationControlStyle.SMALL }
  // };


  // var map = new google.maps.Map(document.getElementById("mapholder"), myOptions);
  // var map = new google.maps.Map(document.getElementById("mapholder"));
  // directionsRenderer.setMap(map);
  // var marker = new google.maps.Marker({ position: latlon, map: map, title: "Você está Aqui!" });


//   var onChangeHandler = function () {
//     calculateAndDisplayRoute(directionsService, directionsRenderer);
//   };

//   document.getElementById('mapholder').addEventListener('change', onChangeHandler);
//   document.getElementById('end').addEventListener('change', onChangeHandler);

// }
// function calculateAndDisplayRoute(directionsService, directionsRenderer) {
//   directionsService.route(
//     {

//       origin: { query: document.getElementById('mapholder').value },
//       destination: { query: document.getElementById('end').value },
//        travelMode: 'DRIVING'
//     },
//     function (response, status) {
//       if (status === 'OK') {
//         directionsRenderer.setDirections(response);
//       } else {
//         window.alert('Directions request failed due to ' + status);
//       }
//     });
// }



function initMap() {
  var directionsService = new google.maps.DirectionsService();
  var directionsRenderer = new google.maps.DirectionsRenderer();
  var map = new google.maps.Map(document.getElementById('map'), {
    zoom: 7,
    center: {lat: 41.85, lng: -87.65}
  });
  directionsRenderer.setMap(map);

  var onChangeHandler = function() {
    calculateAndDisplayRoute(directionsService, directionsRenderer);
  };
  document.getElementById('start').addEventListener('change', onChangeHandler);
  document.getElementById('end').addEventListener('change', onChangeHandler);
}

function calculateAndDisplayRoute(directionsService, directionsRenderer) {
  directionsService.route(
      {
        origin: {query: document.getElementById('start').value},
        destination: {query: document.getElementById('end').value},
        travelMode: 'DRIVING'
      },
      function(response, status) {
        if (status === 'OK') {
          directionsRenderer.setDirections(response);
        } else {
          window.alert('Directions request failed due to ' + status);
        }
      });
}
