
package org.mypackage.tc.beans;

/**
 *
 */
public class Imaging {
        private boolean imaging;

    private String tumor_sites;
    private String ct_tumor_density;
    private double right_adrenal_max_tumor, left_adrenal_max_tumor; //set to Double.NaN if unavaliable
    
    public  boolean isComplete(){
        return imaging;
    }
    public boolean isImaging() {
        return imaging;
    }

    public void setImaging(boolean imaging) {
        this.imaging = imaging;
    }

    public String getTumor_sites() {
        return tumor_sites;
    }

    public void setTumor_sites(String tumor_sites) {
        this.tumor_sites = tumor_sites;
    }

    public String getCt_tumor_density() {
        return ct_tumor_density;
    }

    public void setCt_tumor_density(String ct_tumor_density) {
        this.ct_tumor_density = ct_tumor_density;
    }

    public double getRight_adrenal_max_tumor() {
        return right_adrenal_max_tumor;
    }

    public void setRight_adrenal_max_tumor(double right_adrenal_max_tumor) {
        this.right_adrenal_max_tumor = right_adrenal_max_tumor;
    }

    public double getLeft_adrenal_max_tumor() {
        return left_adrenal_max_tumor;
    }

    public void setLeft_adrenal_max_tumor(double left_adrenal_max_tumor) {
        this.left_adrenal_max_tumor = left_adrenal_max_tumor;
    }
    
}
