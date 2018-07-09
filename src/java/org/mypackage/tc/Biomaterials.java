package org.mypackage.tc;

/**
 *
 * @author Qianqian
 * Helper class
 */
public enum Biomaterials {
    spot_urine("spot_urine"),
    twenty_four_hr_urine("24h_urine"),
    normal_tissue("normal_tissue"),
    tumor_tissue_paraffin("tumor_tissue_paraffin"),
    tumor_tissue_frozen("tumor_tissue_frozen"),
    whole_blood("whole_blood"),
    plasma("plasma"),
    serum("serum");
    private final String fieldName;
    private boolean valid;
    private Biomaterials(final String fieldName) {
        this.fieldName = fieldName;
        this.valid = false;
    }

    public String getName() {
        return fieldName;
    }
    public boolean isValid(){
        return valid;
    }

}
