

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
        <li><a href="biocompleteness">Biomaterial Completeness</a></li>
                <li><a href="centercompleteness"> Completeness by Center</a></li>
                <li><a href="interactive">Interactive Center Completeness</a></li>

     </ul>

</body>
</html>
