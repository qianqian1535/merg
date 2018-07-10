<%-- 
    Document   : BioCompleteness
    Created on : 25/06/2018, 12:29:21 PM
    Author     : Qianqian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.*"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Completeness by Biomaterial</title>
        <script src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src = "https://code.highcharts.com/highcharts.js"></script> 


    </head>
    <body>
        <%
            JSONArray ACC_CompPercentage = (JSONArray) request.getAttribute("ACC_CompPercentage");
            JSONArray APA_CompPercentage = (JSONArray) request.getAttribute("APA_CompPercentage");

            JSONArray fields = (JSONArray) request.getAttribute("categories");
            String error = (String) request.getAttribute("errorString");
        %>
        
        <h1>Biomaterial Completeness by tumour types</h1>
        <p id = "error_msg">Error message: <%= error%></p> <br><br>
        <h4>Completeness ratio is calculated by number of valid entries/total records</h4>
        <div id = "ACCChart" style = "width: 900px; height: 400px; margin: 0 auto"></div>
        <div id = "APAChart" style = "width: 900px; height: 400px; margin: 0 auto"></div>

        <p id="demo"></p>

        <script>

            function chart(bioMaterial, data, name) {

                var dataset = [
                    {
                        name: name,
                        data: data}];
                var chartdata = {
                    chart: {type: 'column'},
                    title: {text: name + ' Biomaterial Completeness'},
                    xAxis: {
                        categories: bioMaterial
                    },
                    yAxis: {
                        min: 0,
                        title: {text: 'Percentage'}
                    },
                    series: dataset
                };
                return chartdata;
            }

            $(document).ready(function () {
                const fields_str = document.getElementById("fields").innerHTML;
                const fields = JSON.parse(fields_str);
                const ACCdata_str = document.getElementById("ACC_CompPercentage").innerHTML;
                const ACCdata = JSON.parse(ACCdata_str);
                const ACCchartdata = chart(fields, ACCdata, 'ACC');
                $('#ACCChart').highcharts(ACCchartdata);
                
                const APAdata_str = document.getElementById("APA_CompPercentage").innerHTML;
                const APAdata = JSON.parse(APAdata_str);
                const APAchartdata = chart(fields, APAdata, 'APA');
                $('#APAChart').highcharts(APAchartdata);
            });
        </script>
        <p id = "ACC_CompPercentage"><%= ACC_CompPercentage%></p> <br><br>
        <p id = "APA_CompPercentage"><%= APA_CompPercentage%></p> <br><br>
        <p id = 'fields'><%= fields%></p> <br><br>


    </body>
</html>