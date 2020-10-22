package com.aubrun.eric.projet7.business.dto;

import java.util.Date;

public class SearchBookDto {

    private Integer searchId;
    private String searchTitle;
    private String searchAuthor;
    private String searchPublishingHouse;
    private String searchReleaseDate;

    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    public String getSearchTitle() {
        return searchTitle;
    }

    public void setSearchTitle(String searchTitle) {
        this.searchTitle = searchTitle;
    }

    public String getSearchAuthor() {
        return searchAuthor;
    }

    public void setSearchAuthor(String searchAuthor) {
        this.searchAuthor = searchAuthor;
    }

    public String getSearchPublishingHouse() {
        return searchPublishingHouse;
    }

    public void setSearchPublishingHouse(String searchPublishingHouse) {
        this.searchPublishingHouse = searchPublishingHouse;
    }

    public String getSearchReleaseDate() {
        return searchReleaseDate;
    }

    public void setSearchReleaseDate(String searchReleaseDate) {
        this.searchReleaseDate = searchReleaseDate;
    }
}
