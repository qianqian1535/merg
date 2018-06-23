

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

        <%

            //  String db = request.getParameter("db");
            try {

                Class.forName("com.mysql.jdbc.Driver");
                out.println("before successfully opened.");

                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ensat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "audrey970925");
                out.println("database successfully opened.");
                Statement st = con.createStatement();

                String query = "select * from ACC_Biomaterial "; //recreate  figure 1.1.1 from Ashley's paper

                ResultSet rs = st.executeQuery(query);
//                while (rs.next()) {
//                    int id = rs.getInt("id");
//                    String firstName = rs.getString("first_name");
//                    String lastName = rs.getString("last_name");
//                    Date dateCreated = rs.getDate("date_created");
//                    boolean isAdmin = rs.getBoolean("is_ad
//                    System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
//
//                }
                Converter converter = new Converter();
                JSONArray result = converter.convertToJSON(rs);
                double plasma = 0, serum = 0, spot = 0, urine = 0;
                double nResults = result.length();
                String valid = "Yes";
                for (int i = 0; i < nResults; i++) {
                    JSONObject userInfo = result.getJSONObject(i);
                    if (userInfo.getString("serum").equals(valid)) {
                        serum += 1;
                    }

        %>
        <!--    <tr>
                <td><%=userInfo%><td><br>
        
            </tr> -->
        <%
            }
        %>
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
                        data: ["<%=serum / nResults%>", 0.31, 0.635, 0.203, 0.2]
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
            alert("<%=serum / nResults%>");
        </script>
        <h1><%=serum / nResults%></h1>

        <%

            } catch (Exception e) {
                out.println("SQLException caught: " + e.getMessage());
            }
        %>


    </body>
    <h1>Hello World!</h1>
</body>
</html>
