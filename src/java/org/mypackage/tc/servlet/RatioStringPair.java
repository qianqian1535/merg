package org.mypackage.tc.servlet;

public class RatioStringPair {

    private int total;
    private int valid;
    private String stringValue;

    public RatioStringPair(String stringValue) {
        this.total = 0;
        this.valid = 0;
        this.stringValue = stringValue;
    }

    public int getTotal() {
        return total;
    }
    public void incrementTotal() {
         total++;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getValid() {
        return valid;
    }
    public void incrementValid() {
         valid++;
    }
    public void setValid(int valid) {
        this.valid = valid;
    }

}
