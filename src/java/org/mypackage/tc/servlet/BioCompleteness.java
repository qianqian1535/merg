/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@WebServlet(urlPatterns = {"/biocompleteness"})
public class BioCompleteness extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private enum BioMaterial {
        whole_blood, spot_urine, normal_tissue, tumor_tissue_paraffin, tumor_tissue_frozen, plasma, serum
    }
//    private static String fields[] = {"whole_blood", "spot_urine", "normal_tissue", "tumor_tissue_paraffin", "tumor_tissue_frozen", "plasma", "serum"};

    public BioCompleteness() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Connection conn = MyUtils.getStoredConnection(request);

            String errorString = null;
            JSONArray ACCList = null;
            try {
                ACCList = DBUtils.queryAll(conn, "ACC_Biomaterial");

            } catch (Exception e) {
                e.printStackTrace();
                errorString = e.getMessage();
            }
            JSONArray CompPercentage = calcBioPercentage(ACCList);
            // Store info in request attribute, before forward to views
            request.setAttribute("errorString", errorString);
            request.setAttribute("CompPercentage", CompPercentage);
            request.setAttribute("categories", getFields());

            // Forward to /WEB-INF/views/productListView.jsp
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/BioCompleteness.jsp");
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
        JSONArray completeness = new JSONArray();
        JSONArray figures = new JSONArray();

        for (int i = 0; i < nFields; i++) {
            figures.put(ValidRecords[i] / nRecords * 100);
        }
        JSONObject obj = new JSONObject();

        obj.put("name", "ACddC");
        obj.put("data", figures);

        completeness.put(obj);
        return figures;

    }

    //check the result of this field
    private boolean isValid(JSONObject record, String field) throws JSONException {
        String valid = "yes";
        return (record.getString(field).toLowerCase().equals(valid));
    }

}
