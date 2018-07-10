
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
            JSONArray data = (JSONArray) request.getAttribute("data");

        %>
        <h1>Patient Record Completeness by Center</h1>

        <h4>Completeness criteria for one patient's record is based on </h4>
        <p id = "error_msg">Error message: <%= error%></p> <br>
        <div id = "AllCenters" style = "width: 900px; height: 400px; margin: 0 auto"></div>

        <p id = "error_msg">Error message:  <%= utilserror%></p> <br><br>
        <p id ="column_names"><%=columnNames%></p>
        <p id="demo">["","HYBU","TRIZ","FRSQ","FRST","ITFL","FRPA1","FRPA2","FRPA3","GYDR","SPOV","GYBN2","ITMI","GBOX","ITMI2","FRRO","FRBE","FRBO","GYMV","JPSE","GYMU","ITNA","FRBR","GYMZ","FRMA","GBBI","NLAM","FRMO","PTCO","IRDU","PLWW2","GBCD","AUME2","FRNA","NLRO","GBIP","GBMA2","FRTO","FRLI","NYBE","FRTR","SWGO","FRDI","GYWU","ROBU","PLKK","SPBA","ITPD","BGSO","GRAT","USTX","ITRO","GBMA","FRGR","SPMA","USMN","ITBR","GRAT2","GBED","USMI","GYBN","ITPD2","PTLI","SPSV","SLLB","BZSP","GYDF2","GBLB","LIKA","GBLD","GBLF","GBLE","GBLG","GBDD","GBTT","GBLK","GBDE","NLEI","RUSP","CRZA","GYLE","ITTU","AUME","IRDU2","GYDF","FRAN","GYLU","NLNI","FRRE","IRGA","ITTU2","ITTU3","SZZH","GBNE","SBBE","GBNH","FRLY1","PLWW","FRLY2","ITBR2"]

        </p>

        <p id ="data"><%=data%></p>
        <script>

            function chart(columnNames, data, name) {

                var dataset = [
                    {
                        name: name,
                        data: data}];
                var chartdata = {
                    chart: {type: 'column'},
                    title: {text: ': Completeness by Center'},
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

                document.getElementById("demo").innerHTML = "fields_str";

                const fields_str = $('#column_names').html();
                const fields = JSON.parse(fields_str);


                const data_str = document.getElementById("data").innerHTML;
                const data = JSON.parse(data_str);
                const chartdata = chart(fields, data, 'AllCenters');
                alert("chartdata");


                $('#AllCenters').highcharts(chartdata);


            });
        </script>

    </body>
</html>
