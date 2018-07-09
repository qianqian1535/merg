package org.mypackage.tc.beans;

/**
 *
 * @author Qianqian
 */
public class Biomaterial {

    private boolean spot_urine;
    private boolean twenty_four_hr_urine;

    private boolean normal_tissue;
    private boolean tumor_tissue_paraffin;
    private boolean tumor_tissue_frozen;

    private boolean whole_blood;
    private boolean plasma;
    private boolean serum;
    
    private boolean[] fieldValidness;

    public boolean[] getFieldValidness() {
        return fieldValidness;
    }

    public void setFieldValidness(int index, boolean fieldValidness) {
        this.fieldValidness[index] = fieldValidness;
    }
    public boolean isSpot_urine() {
        return spot_urine;
    }

    public void setSpot_urine(boolean spot_urine) {
        this.spot_urine = spot_urine;
    }

    public boolean isTwenty_four_hr_urine() {
        return twenty_four_hr_urine;
    }

    public void setTwenty_four_hr_urine(boolean twenty_four_hr_urine) {
        this.twenty_four_hr_urine = twenty_four_hr_urine;
    }

    public boolean isNormal_tissue() {
        return normal_tissue;
    }

    public void setNormal_tissue(boolean normal_tissue) {
        this.normal_tissue = normal_tissue;
    }

    public boolean isTumor_tissue_paraffin() {
        return tumor_tissue_paraffin;
    }

    public void setTumor_tissue_paraffin(boolean tumor_tissue_paraffin) {
        this.tumor_tissue_paraffin = tumor_tissue_paraffin;
    }

    public boolean isTumor_tissue_frozen() {
        return tumor_tissue_frozen;
    }

    public void setTumor_tissue_frozen(boolean tumor_tissue_frozen) {
        this.tumor_tissue_frozen = tumor_tissue_frozen;
    }

    public boolean isWhole_blood() {
        return whole_blood;
    }

    public void setWhole_blood(boolean whole_blood) {
        this.whole_blood = whole_blood;
    }

    public boolean isPlasma() {
        return plasma;
    }

    public void setPlasma(boolean plasma) {
        this.plasma = plasma;
    }

    public boolean isSerum() {
        return serum;
    }

    public void setSerum(boolean serum) {
        this.serum = serum;
    }


}
