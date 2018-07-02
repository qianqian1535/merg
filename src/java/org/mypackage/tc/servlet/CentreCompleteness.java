
package org.mypackage.tc.servlet;

/**
 *
 * @author qianqian
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
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

@WebServlet(urlPatterns = {"/centrecompleteness"})
public class CentreCompleteness extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private enum BioMaterial {
        whole_blood, spot_urine, normal_tissue, tumor_tissue_paraffin, tumor_tissue_frozen, plasma, serum
    }
//    private static String fields[] = {"whole_blood", "spot_urine", "normal_tissue", "tumor_tissue_paraffin", "tumor_tissue_frozen", "plasma", "serum"};

    public CentreCompleteness() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection conn = MyUtils.getStoredConnection(request);

            String errorString = null;
            JSONArray ACCList = null;
            JSONArray APAList = null;
            try {
                ACCList = DBUtils.queryAll(conn, "ACC_Biomaterial");
                APAList = DBUtils.queryAll(conn, "APA_Biomaterial");
            } catch (Exception e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
            JSONArray ACC_CompPercentage = calcBioPercentage(ACCList);
            JSONArray APA_CompPercentage = calcBioPercentage(APAList);

            // Store info in request attribute, before forward to views
            request.setAttribute("errorString", errorString);
            request.setAttribute("ACC_CompPercentage", ACC_CompPercentage);
            request.setAttribute("APA_CompPercentage", APA_CompPercentage);

            request.setAttribute("categories", getFields());

            // Forward to /WEB-INF/views/productListView.jsp
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/CentreCompleteness.jsp");
            dispatcher.forward(request, response);
        } catch (JSONException ex) {
            Logger.getLogger(BioCompleteness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private JSONArray getFields() {
        int nFields = BioMaterial.values().length;

        JSONArray fields = new JSONArray();

        for (int i = 0; i < nFields; i++) {
            fields.put(BioMaterial.values()[i].name());

        }
        return fields;
    }

    private JSONArray calcBioPercentage(JSONArray records) throws JSONException {
        double nRecords = records.length();
        int nFields = BioMaterial.values().length;
        int[] ValidRecords = new int[nFields]; //used to record the number of valid data for each field
        //populate array with 0
        for (int j = 0; j < nFields; j++) {
            ValidRecords[j] = 0;
        }
        for (int i = 0; i < nRecords; i++) {
            JSONObject record = records.getJSONObject(i);

            for (int j = 0; j < nFields; j++) {
                if (isValid(record, BioMaterial.values()[j].name())) {
                    ValidRecords[j]++;
                }
            }
        }

        //construct return array with results
        JSONArray figures = new JSONArray();

        for (int i = 0; i < nFields; i++) {
            figures.put(ValidRecords[i] / nRecords * 100);
        }
      
        return figures;

    }

    //check the result of this field
    private boolean isValid(JSONObject record, String field) throws JSONException {
        String valid = "yes";
        return (record.getString(field).toLowerCase().equals(valid));
    }

}
