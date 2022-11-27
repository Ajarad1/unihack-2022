var destinations_location = [];
var destinations_name = [];
var directionsService = null;
var DirectionsDisplay = null;

function initMap() {
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 8,
        center: {lat: -34.397, lng: 150.644}
    });
    var geocoder = new google.maps.Geocoder();

    directionsService = new google.maps.DirectionsService();
    DirectionsDisplay = new google.maps.DirectionsRenderer();
    DirectionsDisplay.setMap(map);
}


function calcRoute() {
    var request = {
        origin: document.getElementById("from").value,
        destination: document.getElementById("to").value,
        travelMode: google.maps.TravelMode.DRIVING,
        unitSystem: google.maps.UnitSystem.IMPERIAL
    }


   directionsService.route(request, (result,status) => {
        if(status == google.maps.DirectionsStatus.OK) {
            const output = document.querySelector('#output');
            output.innerHTML = "<div class='alert-info'> From: " + document.getElementById("from").value + ".<br />To:" + document.getElementById("to").value + ". <br /> Driving distance <i class='fas fa-road'></i>:"+ result.routes[0].legs[0].distance.text + ".<br />Duration <i class='fas fa-hourglass-start'></i> : " + result.routes[0].legs[0].duration.text + ". </div>";
            DirectionsDisplay.setDirections(result);
        } else {
            DirectionsDisplay.setDirections({ routes: []});
            map.setCenter(myLatLng);
            output.innerHTML = "<div class='alert-danger'><i class='fas fa-exclamation-triangle'></i> Could not retrieve driving distance. </div>";
        }
   });
}

function autocomplete() {
   var options = {
    types: ['(cities)']
   }
    /*
   var input1 = document.getElementById("from");
   var autocomplete1 = new google.maps.places.Autocomplete(input1,options)

   var input2 = document.getElementById("to");
   var autocomplete2 = new google.maps.places.Autocomplete(input2,options)
    */
}

function geocodeAddress(geocoder, resultsMap) {
    var address = document.getElementById('address').value;
    geocoder.geocode({'address': address}, function(results, status) {
        if (status === 'OK') {
            resultsMap.setCenter(results[0].geometry.location);
            destinations_location.push(results[0].geometry.location);
            destinations_name.push(address);

            console.log("Destination location: ");
            console.log(destinations_location);

            console.log("Destination name: ");
            console.log(destinations_name);
            var marker = new google.maps.Marker({
                map: resultsMap,
                position: results[0].geometry.location
            });
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }

    });
    }

