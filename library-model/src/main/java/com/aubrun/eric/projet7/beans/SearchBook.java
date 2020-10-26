package com.aubrun.eric.projet7.beans;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "searchBook_id_generator", sequenceName = "searchBook_id_seq", allocationSize = 1)
@Table(name = "SEARCHBOOK")
public class SearchBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "searchBook_id_generator")
    @Column(name = "search_book_id")
    private Integer searchBookId;
    @Column(name = "search_book_title")
    private String searchBookTitle;
    @Column(name = "search_book_author_first_name")
    private String searchBookAuthorFirstName;
    @Column(name = "search_book_author_last_name")
    private String searchBookAuthorLastName;
    @Column(name = "search_book_publishing_house")
    private String searchBookPublishingHouse;
    @Column(name = "search_book_release_date")
    private String searchBookReleaseDate;

    public SearchBook() {
        super();
    }

    public SearchBook(Integer searchBookId, String searchBookTitle, String searchBookAuthorFirstName, String searchBookAuthorLastName, String searchBookPublishingHouse, String searchBookReleaseDate) {
        super();
        this.searchBookId = searchBookId;
        this.searchBookTitle = searchBookTitle;
        this.searchBookAuthorFirstName = searchBookAuthorFirstName;
        this.searchBookAuthorLastName = searchBookAuthorLastName;
        this.searchBookPublishingHouse = searchBookPublishingHouse;
        this.searchBookReleaseDate = searchBookReleaseDate;
    }

    public SearchBook(String searchBookTitle, String searchBookAuthorFirstName, String searchBookAuthorLastName, String searchBookPublishingHouse, String searchBookReleaseDate) {
        super();
        this.searchBookTitle = searchBookTitle;
        this.searchBookAuthorFirstName = searchBookAuthorFirstName;
        this.searchBookAuthorLastName = searchBookAuthorLastName;
        this.searchBookPublishingHouse = searchBookPublishingHouse;
        this.searchBookReleaseDate = searchBookReleaseDate;
    }

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

    @Override
    public String toString() {
        return "SearchBook{" +
                "searchBookId=" + searchBookId +
                ", searchBookTitle='" + searchBookTitle + '\'' +
                ", searchBookAuthorFirstName='" + searchBookAuthorFirstName + '\'' +
                ", searchBookAuthorLastName='" + searchBookAuthorLastName + '\'' +
                ", searchBookPublishingHouse='" + searchBookPublishingHouse + '\'' +
                ", searchBookReleaseDate='" + searchBookReleaseDate + '\'' +
                '}';
    }
}
