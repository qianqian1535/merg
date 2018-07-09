package org.mypackage.tc.beans;

import org.mypackage.tc.beans.TumorType;

/**
 *
 * @author Qianqian
 */
public class Patient {

    private int ensatID;
    private String center;
    private TumorType tumorType;
    private Biomaterial biomaterial;

    public int getEnsatID() {
        return ensatID;
    }

    public void setEnsatID(int ensatID) {
        this.ensatID = ensatID;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public TumorType getTumorType() {
        return tumorType;
    }

    public void setTumorType(String tumorType) {
        try {
            this.tumorType = TumorType.valueOf(tumorType);
        } catch (IllegalArgumentException e) {
            this.tumorType = TumorType.NOTVALID;
        }
    }

    public Biomaterial getBiomaterial() {
        return biomaterial;
    }

    public void setBiomaterial(Biomaterial biomaterial) {
        this.biomaterial = biomaterial;
    }

}
