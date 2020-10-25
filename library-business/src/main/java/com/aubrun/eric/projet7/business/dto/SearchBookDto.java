package com.aubrun.eric.projet7.business.dto;

public class SearchBookDto {

    private Integer searchBookId;
    private String searchBookTitle;
    private String searchBookAuthorFirstName;
    private String searchBookAuthorLastName;
    private String searchBookPublishingHouse;
    private String searchBookReleaseDate;

    public Integer getSearchBookId() {
        return searchBookId;
    }

    public void setSearchBookId(Integer searchBookId) {
        this.searchBookId = searchBookId;
    }

    public String getSearchBookTitle() {
        return searchBookTitle;
    }

    public void setSearchBookTitle(String searchBookTitle) {
        this.searchBookTitle = searchBookTitle;
    }

    public String getSearchBookAuthorFirstName() {
        return searchBookAuthorFirstName;
    }

    public void setSearchBookAuthorFirstName(String searchBookAuthorFirstName) {
        this.searchBookAuthorFirstName = searchBookAuthorFirstName;
    }

    public String getSearchBookAuthorLastName() {
        return searchBookAuthorLastName;
    }

    public void setSearchBookAuthorLastName(String searchBookAuthorLastName) {
        this.searchBookAuthorLastName = searchBookAuthorLastName;
    }

    public String getSearchBookPublishingHouse() {
        return searchBookPublishingHouse;
    }

    public void setSearchBookPublishingHouse(String searchBookPublishingHouse) {
        this.searchBookPublishingHouse = searchBookPublishingHouse;
    }

    public String getSearchBookReleaseDate() {
        return searchBookReleaseDate;
    }

    public void setSearchBookReleaseDate(String searchBookReleaseDate) {
        this.searchBookReleaseDate = searchBookReleaseDate;
    }

    public String getSearchBookAuthorFirstName(String bookAuthorFirstName) {
        return searchBookAuthorFirstName;
    }

    public String getSearchBookAuthorLastName(String bookAuthorLastName) {
        return searchBookAuthorLastName;
    }

    public String getSearchBookPublishingHouse(String bookPublishingHouse) {
        return searchBookPublishingHouse;
    }

    public String getSearchBookReleaseDate(String bookReleaseDate) {
        return searchBookReleaseDate;
    }
}
