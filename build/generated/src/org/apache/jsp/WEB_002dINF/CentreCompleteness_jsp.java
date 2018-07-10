package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.json.JSONArray;
import org.mypackage.tc.servlet.CentreCompleteness;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;
import org.mypackage.tc.beans.Patient;
import java.util.Map;
import java.util.Iterator;

public final class CentreCompleteness_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Completeness by Center</title>\n");
      out.write("        <script src = \"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n");
      out.write("        <script src = \"https://code.highcharts.com/highcharts.js\"></script> \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            String error = (String) request.getAttribute("errorString");
            String utilserror = (String) request.getAttribute("errorfromUtils");
            JSONArray columnNames = (JSONArray) request.getAttribute("columnnames");
            JSONArray data = (JSONArray) request.getAttribute("data");

        
      out.write("\n");
      out.write("        <h1>Patient Record Completeness by Center</h1>\n");
      out.write("\n");
      out.write("        <div id = \"AllCenters\" style = \"width: 9000px; height: 400px; margin: 0 auto\"></div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            function chart(columnNames, data, name) {\n");
      out.write("\n");
      out.write("                var dataset = [\n");
      out.write("                    {\n");
      out.write("                        name: name,\n");
      out.write("                        data: data}];\n");
      out.write("                var chartdata = {\n");
      out.write("                    chart: {type: 'column'},\n");
      out.write("                    title: {text: ': Completeness by Center'},\n");
      out.write("                    xAxis: {\n");
      out.write("                        categories: columnNames\n");
      out.write("                    },\n");
      out.write("                    yAxis: {\n");
      out.write("                        min: 0,\n");
      out.write("                        title: {text: 'Percentage'}\n");
      out.write("                    },\n");
      out.write("                    series: dataset\n");
      out.write("                };\n");
      out.write("                return chartdata;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                const fields_str = document.getElementById(\"column_names\").innerHTML;\n");
      out.write("\n");
      out.write("                document.getElementById(\"demo\").innerHTML = \"fields_str\";\n");
      out.write("\n");
      out.write("                const fields_str = ");
      out.print(columnNames);
      out.write(";\n");
      out.write("                const fields = JSON.parse(fields_str);\n");
      out.write("                const data_str = document.getElementById(\"data\").innerHTML;\n");
      out.write("                const data = JSON.parse(data_str);\n");
      out.write("                alert(data_str);\n");
      out.write("                const chartdata = chart(fields, data, 'All Centers');\n");
      out.write("\n");
      out.write("\n");
      out.write("                $('#AllCenters').highcharts(chartdata);\n");
      out.write("\n");
      out.write("\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <p id = \"error_msg\">Error message:  ");
      out.print( utilserror);
      out.write("</p> <br><br>\n");
      out.write("        <p id =\" column_names\">");
      out.print(columnNames);
      out.write("</p>\n");
      out.write("        <p id=\"demo\"></p>\n");
      out.write("\n");
      out.write("        <p id =\" data\">");
      out.print(data);
      out.write("</p>\n");
      out.write("        ");


            HashMap<String, Patient> patients = (HashMap) request.getAttribute("PatientsHM");
            Iterator iterator = patients.keySet().iterator();

            // Get an iterator
            int i = 0;
            while (iterator.hasNext()) {
                i++;
                String patientID = (String) iterator.next();
                Patient patient = (Patient) patients.get(patientID);

        
      out.write("\n");
      out.write("        <p>no ");
      out.print( i);
      out.write('.');
      out.write(' ');
      out.print( patientID);
      out.write(" : ");
      out.print( patient.getTumorType());
      out.write("</p>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
     if (patient.getBiomaterial() != null) {
        
      out.write(" \n");
      out.write("        <p>");
      out.print( patient.getTumorType());
      out.write(' ');
      out.print( patient.getBiomaterial().getFieldValidness()[0]);
      out.write("</p>\n");
      out.write("        ");

                }
            }

        
      out.write("\n");
      out.write("\n");
      out.write("        <h1>Completeness by Center</h1>\n");
      out.write("        <h4>Completeness criteria for one patient's record is based on </h4>\n");
      out.write("        <p id = \"error_msg\">Error message: ");
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
