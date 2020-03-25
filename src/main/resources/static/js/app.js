var api = apiclient;
var Module = (function () {

    function _map(list) {
        return mapList = list.map(function (country) {
            return {countryname: country.countryname,statList: country.statList,confirmed: country.confirmed,
                deaths: country.deaths,
                recovered: country.recovered};
        })
    }


    function _table(cities) {
        countries = _map(cities);
        $("#estadisticas > tbody").empty();
        countries.map(function (country) {
            $("#estadisticas > tbody").append(
                "<tr> <td>" +
                "<form><button class='btn btn-primary' type='button' onclick='Module.getCountryStatistics(\"" +
            country.countryname+ "\""+ ")' >"+country.countryname+"</button></form>"+
                "</td>" +
                "<td>" +
                country.deaths +
                "</td> " +
                "<td>" +
                country.confirmed+
                "</td> " +
                "<td>" +
                country.recovered+"</td>" +
                "</tr>"
            );
        });
    };
    function _tabled(country) {
        document.getElementById("nombrePais").innerHTML = country.countryname;
        $("#pais > tbody").empty();

        $("#pais > tbody").append(
            "<tr> <td> Num Deaths</td> <td>" +
            country.deaths +
            "</td></tr>" +
            "<tr> <td> Num Confirmed</td> <td>" +
            country.confirmed +
            "</td></tr>"+
        "<tr> <td> Num Recovered</td> <td>" +
        country.recovered +
        "</td></tr>"

        );

        $("#porpais > tbody").empty();
        country.statList.map(function (statd) {
            $("#porpais > tbody").append(
                "<tr> <td>" +
                statd.province +
                "</td>" +
                "<td>" +
                statd.deaths +
                "</td> " +
                "<td>" +
                statd.confirmed+
                "</td> " +
                "<td>" +
                statd.recovered+"</td>" +
                "</tr>"
            );
        });
    };



    function plotMarkers(m)
    {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 8
        });
        markers = [];
        bounds = new google.maps.LatLngBounds();

        m.forEach(function (marker) {
            var position = new google.maps.LatLng(marker.location.latitude, marker.location.longitude);

            markers.push(
                new google.maps.Marker({
                    position: position,
                    map: map,
                    animation: google.maps.Animation.DROP
                })
            );

            bounds.extend(position);
        });

        map.fitBounds(bounds);
    }

    function init (){
        apiclient.getStatistics().then(function (data){
            _table(data);});
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 8
        });

    };

    function getCountryStatistics(name) {
        apiclient.getStatisticsByName(name).then(function (data){
            _tabled(data);});
    }


    return {
        init:init,
        getCountryStatistics:getCountryStatistics

    };
}());