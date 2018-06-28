package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.*;

public final class BioCompleteness_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Completeness by Biomaterial</title>\n");
      out.write("        <script src = \"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("        <script src = \"https://code.highcharts.com/highcharts.js\"></script> \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>HellWorld!</h1>\n");
      out.write("\n");
      out.write("        <div id = \"ACCChart\" style = \"width: 550px; height: 400px; margin: 0 auto\"></div>\n");
      out.write("        <p id=\"demo\"></p>\n");
      out.write("\n");
      out.write("        <div id = \"container\" style = \"width: 550px; height: 400px; margin: 0 auto\"></div>\n");
      out.write("\n");
      out.write("        <script language = \"JavaScript\">\n");
      out.write("            ");

                JSONArray CompPercentage = (JSONArray) request.getAttribute("CompPercentage");
                JSONArray fields = (JSONArray) request.getAttribute("categories");

                String error = (String) request.getAttribute("errorString");
            
      out.write("\n");
      out.write("\n");
      out.write("            var data = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${CompPercentage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\n");
      out.write("            var bioMaterial = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fields}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\n");
      out.write("            var dataset = new Array();\n");
      out.write("            dataset.push({name: \"ACC\", data: data });\n");
      out.write("            document.getElementById(\"demo\").innerHTML = dataset[0].name;\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                var chartdata = {\n");
      out.write("                    chart: {type: 'column'},\n");
      out.write("                    title: {text: 'ACC Biomaterial Completeness'},\n");
      out.write("                    xAxis: {\n");
      out.write("//                         type: 'category'\n");
      out.write("                        categories: [\"whole_blood\", \"spot_urine\", \"normal_tissue\", \"tumor_tissue_paraffin\", \"tumor_tissue_frozen\", \"plasma\", \"serum\"]\n");
      out.write("                    },\n");
      out.write("                    yAxis: {\n");
      out.write("                        min: 0,\n");
      out.write("                        title: {text: 'Percentage'}\n");
      out.write("                    },\n");
      out.write("                    series: [\n");
      out.write("                        {\n");
      out.write("                            name: 'ACC',\n");
      out.write("                            data: [9.667597056584624, 17.153006851053032, 1.4970819588936817, 5.683836589698046, 9.109363105810708, 35.52397868561279, 41.309312357269725]\n");
      out.write("                        }]\n");
      out.write("                };\n");
      out.write("                chartdata.series = dataset;\n");
      out.write("                chartdata.xAxis.categories = bioMaterial;\n");
      out.write("                $('#ACCChart').highcharts(chartdata);\n");
      out.write("            });\n");
      out.write("\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("//                var series = [\n");
      out.write("//                    {\n");
      out.write("//                        name: 'ACC',\n");
      out.write("//                        data: [9.667597056584624, 17.153006851053032, 1.4970819588936817, 5.683836589698046, 9.109363105810708, 35.52397868561279, 41.309312357269725]\n");
      out.write("//                    }];\n");
      out.write("                var dataset = new Array();\n");
      out.write("                dataset.push({\n");
      out.write("                            name: 'ACC',\n");
      out.write("                            data: [9.667597056584624, 17.153006851053032, 1.4970819588936817, 5.683836589698046, 9.109363105810708, 35.52397868561279, 41.309312357269725]\n");
      out.write("                        });\n");
      out.write("                var bioMaterial = [\"whole_blood\", \"spot_urine\", \"normal_tissue\", \"tumor_tissue_paraffin\", \"tumor_tissue_frozen\", \"plasma\", \"serum\"];\n");
      out.write("                var chartdata = {\n");
      out.write("                    chart: {type: 'column'},\n");
      out.write("                    title: {text: 'ACC Biomaterial Completeness'},\n");
      out.write("                    xAxis: {\n");
      out.write("                        categories: []\n");
      out.write("                    },\n");
      out.write("                    yAxis: {\n");
      out.write("                        min: 0,\n");
      out.write("                        title: {text: 'Percentage'}\n");
      out.write("                    },\n");
      out.write("                    series: []\n");
      out.write("                };\n");
      out.write("                chartdata.series = dataset;\n");
      out.write("                chartdata.xAxis.categories = bioMaterial;\n");
      out.write("                $('#container').highcharts(chartdata);\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <p>");
      out.print( CompPercentage);
      out.write("</p> <br><br>\n");
      out.write("        <p>");
      out.print( fields);
      out.write("</p> <br><br>\n");
      out.write("\n");
      out.write("        <p>Error message: ");
      out.print( error);
      out.write("</p> <br><br>\n");
      out.write("\n");
      out.write("    </body>\n");
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
