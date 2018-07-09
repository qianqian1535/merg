
package org.mypackage.tc.servlet;

/**
 *
 * @author qianqian
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mypackage.tc.DBUtils;
import org.mypackage.tc.MyUtils;
import org.json.*;
import org.mypackage.tc.beans.Patient;

@WebServlet(urlPatterns = {"/centercompleteness"})
public class CentreCompleteness extends HttpServlet {


    public CentreCompleteness() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String errorString = null;
         HashMap<String, Patient> patients = null;
        try {
            patients = DBUtils.getPatients(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(CentreCompleteness.class.getName()).log(Level.SEVERE, null, ex);
            errorString = ex.getMessage();
        }
        // Store info in request attribute, before forward to views
        request.setAttribute("errorString", errorString);
        request.setAttribute("PatientsHM", patients);
                request.setAttribute("errorfromUtils", DBUtils.errormsg);

        // Forward to /WEB-INF/views/productListView.jsp
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/CentreCompleteness.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
