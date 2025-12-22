package com.example.rachanadhungana.movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieContainer {
    @SerializedName("page")
    @Expose
    int page;

    @SerializedName("results")
    @Expose
    List<Results> resultslist;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Results> getResultslist() {
        return resultslist;
    }

    public void setResultslist(List<Results> resultslist) {
        this.resultslist = resultslist;
    }
}
