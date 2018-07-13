
package org.mypackage.tc.beans;

public class Pathology {
    private String ki67 , weiss_score; 
    public boolean isComplete(){
        return (ki67!= null) && (weiss_score!= null);
    }

    public String getKi67() {
        return ki67;
    }

    public void setKi67(String ki67) {
        this.ki67 = ki67;
    }

    public String getWeiss_score() {
        return weiss_score;
    }

    public void setWeiss_score(String weiss_score) {
        this.weiss_score = weiss_score;
    }
   
}
