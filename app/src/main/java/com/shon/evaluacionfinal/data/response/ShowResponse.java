package com.shon.evaluacionfinal.data.response;

import com.google.gson.annotations.SerializedName;
import com.shon.evaluacionfinal.model.Shows;

import java.util.List;

public class ShowResponse {
    @SerializedName("Menu")

    public List<Shows> showsList;

    public List<Shows> getShowsList() {
        return showsList;
    }

    public void setShowsList(List<Shows> showsList) {
        this.showsList = showsList;
    }
}
