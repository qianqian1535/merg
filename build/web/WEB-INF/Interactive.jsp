<%-- 
    Document   : Interactive
    Created on : 02/08/2018, 1:12:40 PM
    Author     : audrey
--%>

<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interactive Overview</title>
    </head>
    <body>
        <%
            String error = (String) request.getAttribute("errorString");
            String utilserror = (String) request.getAttribute("errorfromUtils");
            Object[] centerNames = (Object[]) request.getAttribute("centerNames");
                        String centerName = (String) request.getAttribute("center_name");

            JSONArray data = (JSONArray) request.getAttribute("data");

        %>
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
            <p><%=centerName%></p>
    </body>
</html>
