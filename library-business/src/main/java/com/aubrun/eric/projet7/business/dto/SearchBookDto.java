package com.aubrun.eric.projet7.business.dto;

import java.util.Date;

public class SearchBookDto {

    private Integer searchDtoId;
    private String titleSearchDto;
    private String nameAuthor;
    private String publishingHouse;
    private Date releaseDate;

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
}
