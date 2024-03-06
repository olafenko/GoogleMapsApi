
package org.example.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class OpeningHours {

    @SerializedName("open_now")
    @Expose
    private Boolean openNow;

    public Boolean getOpenNow() {
        return openNow;
    }

    public void setOpenNow(Boolean openNow) {
        this.openNow = openNow;
    }

    @Override
    public String toString() {
        return "OpeningHours{" +
                "openNow=" + openNow +
                '}';
    }
}
