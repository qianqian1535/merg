package org.mypackage.tc;

/**
 *
 * @author o7planning modified based on :
 * https://o7planning.org/en/10285/create-a-simple-java-web-application-using-servlet-jsp-and-jdbc#a812142
 *
 */
import java.sql.*;
import java.util.HashMap;
import java.util.*;
import org.json.*;
import org.mypackage.tc.beans.Patient;
import org.mypackage.tc.beans.Biomaterial;
import org.mypackage.tc.beans.Imaging;
import org.mypackage.tc.beans.Pathology;
import org.mypackage.tc.beans.TumorType;

// 
//import org.o7planning.simplewebapp.beans.Product;
//import org.o7planning.simplewebapp.beans.UserAccount;
public class DBUtils {

    private static boolean initialized = false;
    private static HashMap<String, Patient> patients = new HashMap<>();
    public static String errormsg = "";

    public DBUtils() {
    }

    public static JSONArray queryAll(Connection conn, String table) throws SQLException, Exception {

        String query = "select * from ";
        query = query.concat(table);

        PreparedStatement pstm = conn.prepareStatement(query);

        ResultSet rs = pstm.executeQuery();

        if (!rs.next()) {
            System.out.println("no qurey ");
            return null;

        }
        return Converter.convertToJSON(rs);
    }

    private static Patient addPatientToHM(String center, int ensatID, String tumorType) {
        Patient patient = new Patient();
        patient.setEnsatID(ensatID);
        patient.setCenter(center);
        patient.setTumorType(tumorType);

        if (patient.getTumorType() == TumorType.NAPACA) {
            Biomaterial bio = new Biomaterial();
            patient.setBiomaterial(bio);
            Imaging imaging = new Imaging();
            patient.setImaging(imaging);
            Pathology pathology = new Pathology();
            patient.setPathology(pathology);
            //identifier is ensat id + center id
            String key = ensatID + center;
            patients.put(key, patient);

        }
        return patient;
    }

    private static void queryPatient(Connection conn) throws SQLException {

        String sql = "Select a.ensat_id, a.center_id, a.ensat_database from Identification a ";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int ensatID = rs.getInt("ensat_id");
            String center = rs.getString("center_id");
            String tumorType = rs.getString("ensat_database");
            addPatientToHM(center, ensatID, tumorType);
        }
    }

    private static void queryBiomaterial(Connection conn) throws SQLException {

        String tumorTypes[] = {"NAPACA"}; // tables to query
        for (String tumor : tumorTypes) {
            String table = tumor + "_Biomaterial";
            String sql = "Select * from " + table;

            PreparedStatement pstm = conn.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int ensatID = rs.getInt("ensat_id");
                String center = rs.getString("center_id");
                //identifier is ensat id + center id
                String key = ensatID + center;
                Patient patient = patients.get(key);
                if (patient == null) {
                    patient = addPatientToHM(center, ensatID, tumor);
                }

                if (tumor == patient.getTumorType().name()) {
                    Biomaterial bio = patient.getBiomaterial();
                    validateBioField(bio, rs);
                }

            }
        }
    }

    private static void validateBioField(Biomaterial bio, ResultSet rs) throws SQLException {
        final String valid = "yes";
        int fields = Biomaterial.NUM_FIELDS;
        for (int i = 0; i < fields; i++) {
            if (!bio.getFieldValidness()[i]) { //if the field is not true
                String field = rs.getString(Biomaterial.COLUMN_NAMES[i]);
                bio.setFieldValidness(i, field.toLowerCase().equals(valid));

            }
        }

    }

    private static void queryPathology(Connection conn) throws SQLException {

        String tumorTypes[] = {"NAPACA"};
        for (String tumor : tumorTypes) {

            String table = tumor + "_Pathology";
            String sql = "Select * from " + table;

            PreparedStatement pstm = conn.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int ensatID = rs.getInt("ensat_id");
                String center = rs.getString("center_id");
                //identifier is ensat id + center id
                String key = ensatID + center;
                Patient patient = patients.get(key);
                if (patient == null) {
                    patient = addPatientToHM(center, ensatID, tumor);
                }

                if (tumor == patient.getTumorType().name()) {

                    Pathology patho = patient.getPathology();
                    String kiStr = rs.getString("ki67");
                    if (kiStr.isEmpty()) {
                        patho.setKi67(null);
                    } else {
                        patho.setKi67(kiStr);
//                        not sure what is the valid number range, data entries are not consistent
//                        double ki67;
//                        try {
//                            ki67 = Double.parseDouble(kiStr);
//
//                        } catch (NumberFormatException e) {
//                            ki67 = Double.NaN;
//                        }
//                        patho.setKi67(ki67);

                    }
                    String weissStr = rs.getString("weiss_score");
                    if (weissStr.isEmpty()) {
                        patho.setWeiss_score(null);
                    } else {
                        patho.setWeiss_score(weissStr);
//                        double weiss;
//                        try {
//                            weiss = Double.parseDouble(weissStr);
//
//                        } catch (NumberFormatException e) {
//                            weiss = Double.NaN;
//                        }
//                        patho.setWeiss_score(weiss);

                    }
                }

            }
        }
    }

    private static void queryImaging(Connection conn) throws SQLException {

        String tumorTypes[] = {"NAPACA"};
        for (String tumor : tumorTypes) {

            String table = tumor + "_Imaging";
            String sql = "Select * from " + table;

            PreparedStatement pstm = conn.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int ensatID = rs.getInt("ensat_id");
                String center = rs.getString("center_id");
                //identifier is ensat id + center id
                String key = ensatID + center;
                Patient patient = patients.get(key);
                if (patient == null) {
                    patient = addPatientToHM(center, ensatID, tumor);
                }

                if (tumor == patient.getTumorType().name()) {
                    validateImagingField(patient.getImaging(), rs);
                }

            }
        }
    }

    private static void validateImagingField(Imaging imaging, ResultSet rs) throws SQLException {
        final String valid = "yes";
        String hasImage = rs.getString("imaging_of_tumor");
        imaging.setImaging(hasImage.toLowerCase().equals(valid));
        String tumorSite = rs.getString("tumor_sites");
        imaging.setTumor_sites(tumorSite);
        String rightTumorStr = rs.getString("right_adrenal_max_tumor");
        if (rightTumorStr.isEmpty()) {
            imaging.setRight_adrenal_max_tumor(Double.NaN);
        } else {
            double rightTumor;
            try {
                rightTumor = Double.parseDouble(rightTumorStr);

            } catch (NumberFormatException e) {
                rightTumor = Double.NaN;
            }
            imaging.setRight_adrenal_max_tumor(rightTumor);

        }
        String leftTumorStr = rs.getString("right_adrenal_max_tumor");
        if (leftTumorStr.isEmpty()) {
            imaging.setLeft_adrenal_max_tumor(Double.NaN);
        } else {
            double leftTumor;
            try {
                leftTumor = Double.parseDouble(leftTumorStr);

            } catch (NumberFormatException e) {
                leftTumor = Double.NaN;
            }
            imaging.setLeft_adrenal_max_tumor(leftTumor);

        }
        String CTDensity = rs.getString("ct_tumor_density");
        if (CTDensity.isEmpty() || CTDensity.equals("Not done")) {
            imaging.setCt_tumor_density(null);

        } else {
            imaging.setCt_tumor_density(CTDensity);

        }

    }

    private static void querySurgery(Connection conn) throws SQLException {

        String tumorTypes[] = {"NAPACA"};
        for (String tumor : tumorTypes) {

            String table = tumor + "_Surgery";
            String sql = "Select * from " + table;

            PreparedStatement pstm = conn.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int ensatID = rs.getInt("ensat_id");
                String center = rs.getString("center_id");
                //identifier is ensat id + center id
                String key = ensatID + center;
                Patient patient = patients.get(key);
                if (patient == null) {
                    patient = addPatientToHM(center, ensatID, tumor);
                }

                if (tumor == patient.getTumorType().name()) {
                    patient.setUndergoneSurgery(true);
                }

            }
        }
    }

    private static void buildData(Connection conn) throws SQLException {
        queryPatient(conn);
        queryBiomaterial(conn);
        queryPathology(conn);
        queryImaging(conn);
        querySurgery(conn);

        initialized = true;
    }

    public static HashMap<String, Patient> getPatients(Connection conn) throws SQLException {
        if (!initialized) {
            buildData(conn);

        }

        return patients;
    }
}
