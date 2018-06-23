package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import org.json.*;
import org.mypackage.tc.Converter;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>home</title>\n");
      out.write("\n");
      out.write("        <script src = \"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("        <script src = \"https://code.highcharts.com/highcharts.js\"></script> \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");


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

        
      out.write("\n");
      out.write("        <!--    <tr>\n");
      out.write("                <td>");
      out.print(userInfo);
      out.write("<td><br>\n");
      out.write("        \n");
      out.write("            </tr> -->\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        <div id = \"container\" style = \"width: 550px; height: 400px; margin: 0 auto\"></div>\n");
      out.write("        <script language = \"JavaScript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                var chart = {\n");
      out.write("                    type: 'bar'\n");
      out.write("                };\n");
      out.write("                var title = {\n");
      out.write("                    text: 'Historic World Population by Region'\n");
      out.write("                };\n");
      out.write("                var subtitle = {\n");
      out.write("                    text: 'Source: Wikipedia.org'\n");
      out.write("                };\n");
      out.write("                var xAxis = {\n");
      out.write("                    categories: ['Africa', 'America', 'Asia', 'Europe', 'Oceania'],\n");
      out.write("                    title: {\n");
      out.write("                        text: null\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                var yAxis = {\n");
      out.write("                    min: 0,\n");
      out.write("                    title: {\n");
      out.write("                        text: 'Population (millions)',\n");
      out.write("                        align: 'high'\n");
      out.write("                    },\n");
      out.write("                    labels: {\n");
      out.write("                        overflow: 'justify'\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                var tooltip = {\n");
      out.write("                    valueSuffix: ' millions'\n");
      out.write("                };\n");
      out.write("                var plotOptions = {\n");
      out.write("                    bar: {\n");
      out.write("                        dataLabels: {\n");
      out.write("                            enabled: true\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                var legend = {\n");
      out.write("                    layout: 'vertical',\n");
      out.write("                    align: 'right',\n");
      out.write("                    verticalAlign: 'top',\n");
      out.write("                    x: -40,\n");
      out.write("                    y: 100,\n");
      out.write("                    floating: true,\n");
      out.write("                    borderWidth: 1,\n");
      out.write("\n");
      out.write("                    backgroundColor: (\n");
      out.write("                            (Highcharts.theme && Highcharts.theme.legendBackgroundColor) ||\n");
      out.write("                            '#FFFFFF'),\n");
      out.write("                    shadow: true\n");
      out.write("                };\n");
      out.write("                var credits = {\n");
      out.write("                    enabled: false\n");
      out.write("                };\n");
      out.write("                var series = [\n");
      out.write("                    {\n");
      out.write("                        name: 'Year 1800',\n");
      out.write("                        data: [\"");
      out.print(serum / nResults);
      out.write("\", 0.31, 0.635, 0.203, 0.2]\n");
      out.write("                    },\n");
      out.write("                    {\n");
      out.write("                        name: 'Year 1900',\n");
      out.write("                        data: [0.133, 0.156, 0.947, 0.408, 0.6]\n");
      out.write("                    },\n");
      out.write("                    {\n");
      out.write("                        name: 'Year 2008',\n");
      out.write("                        data: [0.973, 0.914, 0.4054, 0.732, 0.34]\n");
      out.write("                    }\n");
      out.write("                ];\n");
      out.write("\n");
      out.write("                var json = {};\n");
      out.write("                json.chart = chart;\n");
      out.write("                json.title = title;\n");
      out.write("                json.subtitle = subtitle;\n");
      out.write("                json.tooltip = tooltip;\n");
      out.write("                json.xAxis = xAxis;\n");
      out.write("                json.yAxis = yAxis;\n");
      out.write("                json.series = series;\n");
      out.write("                json.plotOptions = plotOptions;\n");
      out.write("                json.legend = legend;\n");
      out.write("                json.credits = credits;\n");
      out.write("                $('#container').highcharts(json);\n");
      out.write("            });\n");
      out.write("            alert(\"");
      out.print(serum / nResults);
      out.write("\");\n");
      out.write("        </script>\n");
      out.write("        <h1>");
      out.print(serum / nResults);
      out.write("</h1>\n");
      out.write("\n");
      out.write("        ");


            } catch (Exception e) {
                out.println("SQLException caught: " + e.getMessage());
            }
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("    <h1>Hello World!</h1>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
