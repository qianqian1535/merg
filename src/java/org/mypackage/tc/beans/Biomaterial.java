package org.mypackage.tc.beans;

/**
 *
 * @author Qianqian
 */
public class Biomaterial {

    public final static int SPOT_URINE = 0;
    public final static int TWENTY_FOUR_HR_URINE = 1;
    public final static int NORMAL_TISSUE = 2;
    public final static int NORMAL_TISSUE_PARAFFIN = 3;
    public final static int NORMAL_TISSUE_FROZEN = 4;
    public final static int WHOLE_BLOOD = 5;
    public final static int PLASMA = 6;
    public final static int HEPARIN_PLASMA = 7;
    public final static int SERUM = 8;
    
    public final static int NUM_FIELDS = 9;
    public final static String COLUMN_NAMES[] = {"spot_urine", "24h_urine", "normal_tissue", "tumor_tissue_paraffin", "tumor_tissue_frozen", "whole_blood", "plasma", "heparin_plasma", "serum"};

    private boolean[] fieldValidness = new boolean[NUM_FIELDS];

    public boolean[] getFieldValidness() {
        return fieldValidness;
    }

    public void setFieldValidness(int index, boolean fieldValidness) {
        this.fieldValidness[index] = fieldValidness;
    }

    public boolean isComplete(TumorType type) {
        boolean complete = false;
        switch (type) {
            case ACC:
                complete = false;
                break;
            case NAPACA:
                
                complete =fieldValidness[TWENTY_FOUR_HR_URINE] && fieldValidness[SPOT_URINE] && fieldValidness[SERUM] && (fieldValidness[HEPARIN_PLASMA] || fieldValidness[PLASMA] ) ;
                break;
            case APA:
                complete = false;
                break;
            case Pheo:
                complete = false;
                break;

            default:
                complete = false;
        }
        return complete;
    }

}
