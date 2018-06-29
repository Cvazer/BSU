<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <title>WEB Programming</title>
    <script>
        function test(element) {
            for(var key in element){
                var value = element[key];
                alert(key+" "+value);
            }
        }

        $(document).ready(function () {
            filteredCountries("ALL")
        });

        function filteredCountries(s) {
            if (s==="ALL") {
                $("#countries").html("");
                $.ajax({
                    type: 'GET',
                    dataType: 'json',
                    url: "http://localhost:8080/country/getAll",
                    success: function (countries) {
                        countries.forEach(function (country) {
                            $("#countries").append("<div class=\"countryItem\" style=\"padding-left: 20px; font-size: 16pt\" onclick='test(this)'>" + country.name + "</div>");
                        });
                    }
                });
            } else {
                $("#countries").html("");
                data = $("#countriesTF").val();
                if (data===""){filteredCountries('ALL'); return;}
                $.ajax({
                    type: 'POST',
                    dataType: 'json',
                    contentType: "application/json; charset=utf-8",
                    data: data,
                    url: "http://localhost:8080/country/getContains",
                    success: function (countries) {
                        countries.forEach(function (country) {
                            $("#countries").append("<div class='countryItem' style='padding-left: 20px; font-size: 16pt' onclick='test(this)'>" + country.name + "</div>");
                        });
                    },
                    failure: function (msg) {
                        alert(errMsg);
                    }
                });
            }

        }
    </script>
    <style>
        .countryItem:hover{
            cursor: pointer;
            padding: 6px;
            background-color: rgba(255, 0, 0, 0.67);
            color: white;
            border-top-right-radius: 20px;
            border-bottom-right-radius: 20px;
        }
        ::-webkit-scrollbar {
            display: none;
        }
    </style>
</head>
<body style="font-family: Segoe UI,Arial,sans-serif; padding: 0; margin: 0">
    <div id="header" style="font-size: 20pt; padding: 5px; background-color: black; color: white; box-shadow: 2px 4px 6px rgba(0,0,0,0.4);">COUNTRIES AND CITIES</div>
<table style="border: 1px solid black; width: -webkit-fill-available; height: 95%;">
    <tr>
        <td style="width: 15%;">
            <input id="countriesTF" type="text" style="width: -webkit-fill-available; height: 23px" onkeyup="filteredCountries('NOT_ALL')">
            <span style="font-size: 26pt">Countries</span>
            <div id="countries" style="overflow-x: scroll; height: 90%"></div>
        </td>
        <td style="width: 33%; padding-left: 30px">
            <input id="citiesTF" type="text" style="width: -webkit-fill-available; height: 23px" onkeyup="filteredCountries('NOT_ALL')">
            <span style="font-size: 26pt">Cities</span>
            <div id="cities" style="overflow-x: scroll; height: 90%"></div>
        </td>
        <td style="width: 53%"></td>
    </tr>
</table>
</body>
</html>
