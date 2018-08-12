<%-- 
    Document   : Interactive
    Created on : 02/08/2018, 1:12:40 PM
    Author     : audrey
--%>

<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.mypackage.tc.servlet.CentreCompleteness"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interactive Overview</title>
        <script src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src = "https://code.highcharts.com/highcharts.js"></script> 
    </head>
    <body>
        <%
            String error = (String) request.getAttribute("errorString");
            String utilserror = (String) request.getAttribute("errorfromUtils");
            Object[] centerNames = (Object[]) request.getAttribute("centerNames");
            String centerName = (String) request.getAttribute("center_name");

            JSONArray target_data = (JSONArray) request.getAttribute("target_data");
            JSONArray average_data = (JSONArray) request.getAttribute("average_data");

        %>
        <p>Error message: <%=error%></p>
        <form action="${pageContext.request.contextPath}/interactive" method="post">
            <strong>Select a center : </strong>
            <select name="center_name">
                <%
                    for (int i = 0; i < centerNames.length; i++) {
                %>
                <option value="<%=i%>"><%=centerNames[i]%></option>
                <%
                    }
                %>
            </select>
            <input type="submit" value="submit" name="submit" />
        </form>

        <p id="centername"><%=centerName%></p>

        <div id = "AllCenters" style = "width: 400px; height: 400px; margin: 0 auto"></div>

        <p id="target_data"><%=target_data%></p>
        <p id="average_data"><%=average_data%></p>
        <script>
            function chart(columnNames, target, average, centername) {


                var dataset = [
                    {
                        name: "Average",
                        data: average
                    },
                    {
                        name: centername,
                        data: target
                    }];
                var chartdata = {
                    chart: {type: 'column'},
                    title: {text: 'Individual Center vs Average'},
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


                //                const fields_str = $('#column_names').html();
                //                const fields = JSON.parse(fields_str);
                const centername = document.getElementById("centername").innerHTML;

                const target_data_str = document.getElementById("target_data").innerHTML;
                const target_data = JSON.parse(target_data_str);
                const avg_data_str = document.getElementById("average_data").innerHTML;
                const avg_data = JSON.parse(avg_data_str);


                const chartdata = chart(["Overall Completeness"], target_data, avg_data, centername);

                $('#AllCenters').highcharts(chartdata);



            });
        </script>
    </body>
</html>
