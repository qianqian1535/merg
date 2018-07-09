package org.mypackage.tc;

/**
 *
 * @author o7planning modified based on :
 * https://o7planning.org/en/10285/create-a-simple-java-web-application-using-servlet-jsp-and-jdbc#a812142
 *
 */
import static java.lang.System.out;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.*;
import org.mypackage.tc.beans.Patient;
import org.apache.logging.log4j.*;
import org.mypackage.tc.beans.Biomaterial;
import org.mypackage.tc.beans.TumorType;

// 
//import org.o7planning.simplewebapp.beans.Product;
//import org.o7planning.simplewebapp.beans.UserAccount;
public class DBUtils {

    private static boolean initialized = false;
    private static HashMap<String, Patient> patients = new HashMap<>();
    private static Logger logger = LogManager.getLogger(DBUtils.class.getName());
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

        Biomaterial bio = new Biomaterial();
        patient.setBiomaterial(bio);

        //identifier is ensat id + center id
        String key = ensatID + center;
        patients.put(key, patient);
        return patient;
    }

    public static void queryPatient(Connection conn) throws SQLException {

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

    public static void queryBiomaterial(Connection conn) throws SQLException {
                        final String valid = "yes";

        int nTables = 0;
        for (TumorType tumor : TumorType.values()) {
            if(nTables == 4){ // query the first 4 tables
                break;
            
            }
            String table = tumor.name() + "_Biomaterial";
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
                    patient = addPatientToHM(center, ensatID, tumor.name());
//                    return;
                }
//                errormsg += key + " from " + table + "\n\r";
//                System.out.println(key + " from " + table);

                if (patient.getTumorType() == null) {
                    errormsg += key + " from " + table + " tumor type can't be found";
//                    System.out.println(errormsg);

                }
                if (tumor == patient.getTumorType()) {
                    Biomaterial bio = patient.getBiomaterial();
                    String spot_urine = rs.getString("spot_urine").toLowerCase();
                     patients.get(key).getBiomaterial().setSpot_urine(spot_urine.equals(valid));

                        String twenty_four_hr_urine = rs.getString("24h_urine").toLowerCase();
                        patients.get(key).getBiomaterial().setTwenty_four_hr_urine(twenty_four_hr_urine.equals(valid));

                        String normal_tissue = rs.getString("normal_tissue").toLowerCase();
                        bio.setNormal_tissue(normal_tissue.equals(valid));

//                        String tumor_tissue_paraffin = rs.getString("tumor_tissue_paraffin").toLowerCase();
//                        patient.setBiomaterial.setTumor_tissue_paraffin(tumor_tissue_paraffin.equals(valid));
//
//                        String tumor_tissue_frozen = rs.getString("tumor_tissue_frozen").toLowerCase();
//                        bio.setTumor_tissue_frozen(tumor_tissue_frozen.equals(valid));
////
//    private boolean whole_blood;
//    private boolean plasma;
//    private boolean serum;
                }

            }
            nTables++;
        }
    }
//    private void validateBioField(String field, Patient patient){
//                patient.getBiomaterial()
//
//        
//    }

    private static void buildData(Connection conn) throws SQLException {
        queryPatient(conn);
        queryBiomaterial(conn);
        initialized = true;
    }

    public static HashMap<String, Patient> getPatients(Connection conn) throws SQLException {
        if (!initialized) {
            buildData(conn);

        }

        return patients;
    }
}
