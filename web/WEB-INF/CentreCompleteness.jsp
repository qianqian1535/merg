
<%@ page import="org.json.*"%>
<%@page import="org.mypackage.tc.servlet.CentreCompleteness"%>
<%@page import="java.util.logging.Level"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.HashMap"%>
<%@page import="org.mypackage.tc.beans.Patient"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Completeness by Center</title>
        <script src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src = "https://code.highcharts.com/highcharts.js"></script> 
    </head>
    <body>

        <%
            String error = (String) request.getAttribute("errorString");
            String utilserror = (String) request.getAttribute("errorfromUtils");
            JSONArray columnNames = (JSONArray) request.getAttribute("columnnames");
            JSONObject data = (JSONObject) request.getAttribute("data");

        %>
        <h1>Patient Record Completeness by Center</h1>

        <h4>Completeness criteria for each NAPACA patient's record is based on EURINE-ACT eligibility criteria.</h4>
        <p> biomaterial : [TWENTY_FOUR_HR_URINE] AND [SPOT_URINE] AND [SERUM] AND ([HEPARIN_PLASMA] OR [PLASMA] )<br>
            Growth difference not considered.<br>
            </p>
        <p id = "error_msg">Error message: <%= error%></p> <br>
        <div id = "AllCenters" style = "width: 1800px; height: 400px; margin: 0 auto"></div>
        <p id = "error_msg">Error message:  <%= utilserror%></p> <br><br>
                <img src="../EURINE-ACTCriteria.png" width="475" height="456" alt="EURINE-ACTCriteria"/>

        <p id ="column_names"><%=columnNames%></p>
        <p id ="data"><%=data%></p>
        <script>

            function chart(columnNames, data, name) {

                var dataset = [
                    {
                        name: name,
                        data: data}];
                var chartdata = {
                    chart: {type: 'column'},
                    title: {text: 'Completeness by Center'},
                    xAxis: {
                        categories: columnNames
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


                const fields_str = $('#column_names').html();
                const fields = JSON.parse(fields_str);


                const data_str = document.getElementById("data").innerHTML;
                const data = JSON.parse(data_str);
                const chartdata = chart(fields, data, 'AllCenters');

                $('#AllCenters').highcharts(chartdata);


            });
        </script>

    </body>
</html>
