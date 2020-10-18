package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name="edition_id_generator", sequenceName = "edition_id_seq", allocationSize=1)
@Table(name = "EDITION")
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "edition_id_generator")
    @Column(name = "edition_id")
    private Integer editionId;
    @Column(name = "name_edition")
    private String nameEdition;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_list")
    private List<Book> bookList;

    public Edition() {
        super();
    }

    public Edition(Integer editionId, String nameEdition, List<Book> bookList) {
        super();
        this.editionId = editionId;
        this.nameEdition = nameEdition;
        this.bookList = bookList;
    }

    public Edition(String nameEdition, List<Book> bookList) {
        super();
        this.nameEdition = nameEdition;
        this.bookList = bookList;
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public String getNameEdition() {
        return nameEdition;
    }

    public void setNameEdition(String nameEdition) {
        this.nameEdition = nameEdition;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "editionId=" + editionId +
                ", nameEdition='" + nameEdition + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}