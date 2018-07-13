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
    private Imaging imaging;
    private Pathology pathology;

    private boolean undergoneSurgery;



    public boolean isComplete() {
        boolean surgeryData = true;
        if (undergoneSurgery){
            surgeryData = pathology.isComplete();
        }
        return biomaterial.isComplete(tumorType) && imaging.isComplete() && surgeryData;
    }
        public boolean isUndergoneSurgery() {
        return undergoneSurgery;
    }

    public void setUndergoneSurgery(boolean undergoneSurgery) {
        this.undergoneSurgery = undergoneSurgery;
    }

    public Pathology getPathology() {
        return pathology;
    }

    public void setPathology(Pathology pathology) {
        this.pathology = pathology;
    }
    
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

    public Imaging getImaging() {
        return imaging;
    }

    public void setImaging(Imaging Imaging) {
        this.imaging = Imaging;
    }

}
