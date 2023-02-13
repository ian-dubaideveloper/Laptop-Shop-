// JavaScript Document
var xmlhttp = new XMLHttpRequest();
var url = "http://localhost:8080/laptopshop/rest/inventory";

xmlhttp.onreadystatechange=function() {
    if (xmlhttp.readyState == 4) {
    if(xmlhttp.status == 200 || xmlhttp.status == 304) {
        parseJson(xmlhttp.responseText);
    }
    }
}
xmlhttp.open("GET", url, true);
xmlhttp.send();

function parseJson(response) {
    var arr = JSON.parse(response);
    var i;
    var out = "<table>";

    for(i = 0; i < arr.length; i++) {
        out += "<tr><td>" +
        arr[i].id +
        "</td><td>" +
        arr[i].name +
        "</td><td>" +
        arr[i].brand +
        "</td><td>" +
        arr[i].display +
        "</td><td>" +
        arr[i].processor +
        "</td><td>" +
        arr[i].memory +
        "</td><td>" +
        arr[i].harddrive +
        "</td><td>" +
        arr[i].graphics +
        "</td><td>" +
        arr[i].numUsbs +
        "</td><td>" +
        arr[i].price +
        "</td></tr>";
    }
    out += "</table>";
    document.getElementById("id01").innerHTML = out;
}
