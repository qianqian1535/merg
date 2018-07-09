
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

    </head>
    <body>
        
        <%
            String error = (String) request.getAttribute("errorString");
            String utilserror = (String) request.getAttribute("errorfromUtils");%>
                <p id = "error_msg">Error message:  <%= utilserror%></p> <br><br>

        <%

            HashMap<String, Patient> patients = (HashMap) request.getAttribute("PatientsHM");
                        Iterator iterator = patients.keySet().iterator();

            try{
            // Get an iterator
            int i = 0;
            while (iterator.hasNext()) {
                i++;
                String patientID = (String) iterator.next();
                Patient patient = (Patient) patients.get(patientID);

        %>
        <p>no <%= i%>. <%= patientID%> : <%= patient.getTumorType()%></p>




        <%     if (patient.getBiomaterial() != null) {
        %> 
        <p><%= patient.getTumorType()%> <%= patient.getBiomaterial().isNormal_tissue()%></p>
        <%
                }
            }
}catch (NullPointerException ex) {
            Logger.getLogger(CentreCompleteness.class.getName()).log(Level.SEVERE, null, ex);
        }
        %>

        <h1>Completeness by Center</h1>
        <h4>Completeness criteria for one patient's record is based on </h4>
        <p id = "error_msg">Error message: <%= error%></p> <br><br>

    </body>
</html>
