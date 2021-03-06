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

    public static final int MIN_RECORDS = 2;

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
            errorString = ex.getMessage();
        }
        try {
            JSONObject graphData = calcCenterStat(patients);

            JSONArray names = graphData.getJSONArray("name");
            JSONArray data = graphData.getJSONArray("ratio");
            request.setAttribute("columnnames", names);
            request.setAttribute("data", data);

        } catch (JSONException ex) {
            errorString += ex.getMessage();
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

    private JSONObject calcCenterStat(HashMap<String, Patient> patients) throws JSONException {
        HashMap<String, RatioStringPair> centers = new HashMap<>();

        Iterator iterator = patients.keySet().iterator();
        // add centers and its completeness count to a center hashmap
        while (iterator.hasNext()) {
            String patientID = (String) iterator.next();
            Patient patient = (Patient) patients.get(patientID);
            String centerName = patient.getCenter();
            if (centers.get(centerName) == null) {
                centers.put(centerName, new RatioStringPair(centerName));

            }
            RatioStringPair centerRecord = centers.get(centerName);
            if (patient.isComplete()) {
                centerRecord.incrementValid();
            }
            centerRecord.incrementTotal();

        }
        Iterator resultIterator = centers.keySet().iterator();

        JSONArray name = new JSONArray();
        JSONArray ratio = new JSONArray();

        while (resultIterator.hasNext()) {
            String centerName = (String) resultIterator.next();
            RatioStringPair center = (RatioStringPair) centers.get(centerName);

            if (center.getTotal() >= MIN_RECORDS) {
                name.put(center.getStringValue());
                double percentage = ((double) center.getValid()) / center.getTotal() * 100.0;
                ratio.put(percentage);
            }

        }
        JSONObject data = new JSONObject();

        data.put("name", name);

        data.put("ratio", ratio);

        return data;

    }

}
