package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name="book_id_generator", sequenceName = "book_id_seq",allocationSize=1)
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "book_id_generator")
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "title")
    private String title;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "renewal_loan")
    private Boolean renewalLoan;
    @Column(name = "quantity_loan")
    private Integer quantityLoan;
    @Column(name = "year_book")
    private Date yearBook;
    @JoinColumn(name = "book_author")
    @ManyToOne
    private Author bookAuthor;
    @JoinColumn(name = "book_category")
    @ManyToOne
    private Category bookCategory;

    public Book() {
        super();
    }

    public Book(Integer bookId, String title, Integer quantity, Boolean renewalLoan, Integer quantityLoan, Date yearBook, Author bookAuthor, Category bookCategory) {
        super();
        this.bookId = bookId;
        this.title = title;
        this.quantity = quantity;
        this.renewalLoan = renewalLoan;
        this.quantityLoan = quantityLoan;
        this.yearBook = yearBook;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
    }

    public Book(String title, Integer quantity, Boolean renewalLoan, Integer quantityLoan, Date yearBook, Author bookAuthor, Category bookCategory) {
        super();
        this.title = title;
        this.quantity = quantity;
        this.renewalLoan = renewalLoan;
        this.quantityLoan = quantityLoan;
        this.yearBook = yearBook;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getRenewalLoan() {
        return renewalLoan;
    }

    public void setRenewalLoan(Boolean renewalLoan) {
        this.renewalLoan = renewalLoan;
    }

    public Integer getQuantityLoan() {
        return quantityLoan;
    }

    public void setQuantityLoan(Integer quantityLoan) {
        this.quantityLoan = quantityLoan;
    }

    public Date getYearBook() {
        return yearBook;
    }

    public void setYearBook(Date yearBook) {
        this.yearBook = yearBook;
    }

    public Author getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(Author bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Category getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(Category bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", quantity=" + quantity +
                ", renewalLoan=" + renewalLoan +
                ", quantityLoan=" + quantityLoan +
                ", yearBook=" + yearBook +
                ", bookAuthor=" + bookAuthor +
                ", bookCategory=" + bookCategory +
                '}';
    }
}
