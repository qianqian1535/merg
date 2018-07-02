

<%@page import="org.mypackage.tc.MySQLConn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="org.json.*"%>
<%@ page import="org.mypackage.tc.Converter" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home</title>

        <script src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script src = "https://code.highcharts.com/highcharts.js"></script> 

    </head>
    <body>

     
        <ul>
        <li><a href="home">Home</a></li>
        <li><a href="biocompleteness">BioCompleteness</a></li>
                <li><a href="centrecompleteness">CentreCompleteness</a></li>

     </ul>
        <div id = "container" style = "width: 550px; height: 400px; margin: 0 auto"></div>
        <script language = "JavaScript">
            $(document).ready(function () {
                var chart = {
                    type: 'bar'
                };
                var title = {
                    text: 'Historic World Population by Region'
                };
                var subtitle = {
                    text: 'Source: Wikipedia.org'
                };
                var xAxis = {
                    categories: ['Africa', 'America', 'Asia', 'Europe', 'Oceania'],
                    title: {
                        text: null
                    }
                };
                var yAxis = {
                    min: 0,
                    title: {
                        text: 'Population (millions)',
                        align: 'high'
                    },
                    labels: {
                        overflow: 'justify'
                    }
                };
                var tooltip = {
                    valueSuffix: ' millions'
                };
                var plotOptions = {
                    bar: {
                        dataLabels: {
                            enabled: true
                        }
                    }
                };
                var legend = {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'top',
                    x: -40,
                    y: 100,
                    floating: true,
                    borderWidth: 1,

                    backgroundColor: (
                            (Highcharts.theme && Highcharts.theme.legendBackgroundColor) ||
                            '#FFFFFF'),
                    shadow: true
                };
                var credits = {
                    enabled: false
                };
                var series = [
                    {
                        name: 'Year 1800',
                        data: [1, 0.31, 0.635, 0.203, 0.2]
                    },
                    {
                        name: 'Year 1900',
                        data: [0.133, 0.156, 0.947, 0.408, 0.6]
                    },
                    {
                        name: 'Year 2008',
                        data: [0.973, 0.914, 0.4054, 0.732, 0.34]
                    }
                ];

                var json = {};
                json.chart = chart;
                json.title = title;
                json.subtitle = subtitle;
                json.tooltip = tooltip;
                json.xAxis = xAxis;
                json.yAxis = yAxis;
                json.series = series;
                json.plotOptions = plotOptions;
                json.legend = legend;
                json.credits = credits;
                $('#container').highcharts(json);
            });
//           
        </script>
             <h1>Hello World!</h1>

</body>
</html>
