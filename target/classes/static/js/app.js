var api = apiclient;
var Module = (function () {

    function _map(list) {
        return mapList = list.map(function (country) {
            return {countryname: country.countryname,statList: country.statList,confirmed: country.confirmed,
                deaths: country.deaths,
                recovered: country.recovered,
            location:country.location};
        })
    }


    function _table(result) {
        countries = _map(result);
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
        iniciarMapa();
        markers = [];
        bounds = new google.maps.LatLngBounds();
        console.log(m);
        var position = new google.maps.LatLng(m.location.latlng[0], m.location.latlng[1]);
        console.log(position);
        markers.push(
            new google.maps.Marker({
                position: position,
                map: map,
                animation: google.maps.Animation.DROP
            })
        );

        bounds.extend(position);
        map.fitBounds(bounds);
    }

    function iniciarMapa() {
        map = new google.maps.Map(document.getElementById('map'), {
            center: {lat: -34.397, lng: 150.644},
            zoom: 8
        });
    }
    function init (){
        iniciarMapa();
        api.getStatistics().then(function (data){
            _table(data);});

    }

    function getCountryStatistics(name) {
        api.getStatisticsByName(name).then(function (data){
            _tabled(data);
            plotMarkers(data)});
    }


    return {
        init:init,
        getCountryStatistics:getCountryStatistics

    };
}());