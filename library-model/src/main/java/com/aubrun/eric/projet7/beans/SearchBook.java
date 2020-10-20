package com.aubrun.eric.projet7.beans;

import java.util.Date;

public class SearchBook {

    private Integer searchDtoId;
    private String titleSearchDto;
    private String nameAuthor;
    private String publishingHouse;
    private Date releaseDate;

    public SearchBook() {
    }

    public SearchBook(Integer searchDtoId, String titleSearchDto, String nameAuthor, String publishingHouse, Date releaseDate) {
        this.searchDtoId = searchDtoId;
        this.titleSearchDto = titleSearchDto;
        this.nameAuthor = nameAuthor;
        this.publishingHouse = publishingHouse;
        this.releaseDate = releaseDate;
    }

    public SearchBook(String titleSearchDto, String nameAuthor, String publishingHouse, Date releaseDate) {
        this.titleSearchDto = titleSearchDto;
        this.nameAuthor = nameAuthor;
        this.publishingHouse = publishingHouse;
        this.releaseDate = releaseDate;
    }

    public Integer getSearchDtoId() {
        return searchDtoId;
    }

    public void setSearchDtoId(Integer searchDtoId) {
        this.searchDtoId = searchDtoId;
    }

    public String getTitleSearchDto() {
        return titleSearchDto;
    }

    public void setTitleSearchDto(String titleSearchDto) {
        this.titleSearchDto = titleSearchDto;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "SearchBook{" +
                "searchDtoId=" + searchDtoId +
                ", titleSearchDto='" + titleSearchDto + '\'' +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
