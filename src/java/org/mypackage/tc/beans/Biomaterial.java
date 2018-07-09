package org.mypackage.tc.beans;

/**
 *
 * @author Qianqian
 */
public class Biomaterial {

//    private boolean spot_urine;
//    private boolean twenty_four_hr_urine;
//
//    private boolean normal_tissue;
//    private boolean tumor_tissue_paraffin;
//    private boolean tumor_tissue_frozen;
//
//    private boolean whole_blood;
//    private boolean plasma;
//    private boolean serum;
    public final static int SPOT_URINE = 0;
    public final static int TWENTY_FOUR_HR_URINE = 1;
    public final static int NORMAL_TISSUE = 2;
    public final static int NORMAL_TISSUE_PARAFFIN = 3;
    public final static int NORMAL_TISSUE_FROZEN = 4;
    public final static int WHOLE_BLOOD = 5;
    public final static int PLASMA = 6;
    public final static int SERUM = 7;
    public final static int NUM_FIELDS = 8;
    public final static String COLUMN_NAMES[] = { "spot_urine", "24h_urine", "normal_tissue", "tumor_tissue_paraffin", "tumor_tissue_frozen","whole_blood", "plasma", "serum"};

    private boolean[] fieldValidness = new boolean[NUM_FIELDS];

    public boolean[] getFieldValidness() {
        return fieldValidness;
    }

    public void setFieldValidness(int index, boolean fieldValidness) {
        this.fieldValidness[index] = fieldValidness;
    }
    public boolean isComplete(TumorType type){
        boolean complete = false;
        switch (type){
            case ACC :
                break;
                
            default:
                
        }
        return complete;
    }

}
