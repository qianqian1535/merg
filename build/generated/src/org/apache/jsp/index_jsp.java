package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.mypackage.tc.MySQLConn;
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
      out.write("     \n");
      out.write("        <ul>\n");
      out.write("        <li><a href=\"home\">Home</a></li>\n");
      out.write("        <li><a href=\"biocompleteness\">BioCompleteness</a></li>\n");
      out.write("                <li><a href=\"centrecompleteness\">CentreCompleteness</a></li>\n");
      out.write("\n");
      out.write("     </ul>\n");
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
      out.write("                        data: [1, 0.31, 0.635, 0.203, 0.2]\n");
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
      out.write("//           \n");
      out.write("        </script>\n");
      out.write("             <h1>Hello World!</h1>\n");
      out.write("\n");
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
