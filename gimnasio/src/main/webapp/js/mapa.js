
    cargarMapa();


function cargarMapa() {

    var mapOptions = {
        center:new google.maps.LatLng(-34.6686986,-58.5614947),
        zoom:12,
        panControl: true,
        zoomControl: true,
        scaleControl: false,
        mapTypeControl:false,
        streetViewControl:true,
        overviewMapControl:true,
        rotateControl:true,
        mapTypeId:google.maps.MapTypeId.ROADMAP
    };

    var map = new google.maps.Map(document.getElementById("mapa"),mapOptions);

    //var marker = new google.maps.Marker({
    //    position: new google.maps.LatLng(-34.6686986,-58.5614947),
    //    map: map
    //});
   
}