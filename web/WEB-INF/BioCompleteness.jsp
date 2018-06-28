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
        <script src="BioCompletenessChart.js"></script>
    </head>
    <body>
        <h1>HellWorld!</h1>

        <div id = "ACCChart" style = "width: 550px; height: 400px; margin: 0 auto"></div>
        <p id="demo"></p>

        <div id = "container" style = "width: 550px; height: 400px; margin: 0 auto"></div>

        <%
            JSONArray CompPercentage = (JSONArray) request.getAttribute("CompPercentage");
            JSONArray fields = (JSONArray) request.getAttribute("categories");

            String error = (String) request.getAttribute("errorString");
        %>
   
        <p><%= CompPercentage%></p> <br><br>
        <p><%= fields%></p> <br><br>

        <p>Error message: <%= error%></p> <br><br>

    </body>
</html>
