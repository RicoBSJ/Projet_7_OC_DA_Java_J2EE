package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(name="borrowing_id_generator", sequenceName = "borrowing_id_seq", allocationSize=1)
@Table(name = "BORROWING")
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "borrowing_id_generator")
    @Column(name = "id_borrowing")
    private Integer borrowingId;
    @JoinColumn(name = "id_book")
    @ManyToOne
    private Book bookBorrowing;
    @JoinColumn(name = "id_user_account")
    @ManyToOne
    private UserAccount userAccountBorrowing;
    @Column(name = "borrowing_begin_date")
    private Date beginDate;
    @Column(name = "borrowing_end_date")
    private Date endDate;
    @Column(name = "book_renewal")
    private Boolean renewal;

    public Borrowing() {
    }

    public Borrowing(Integer borrowingId, Book bookBorrowing, UserAccount userAccountBorrowing, Date beginDate, Date endDate, Boolean renewal) {
        this.borrowingId = borrowingId;
        this.bookBorrowing = bookBorrowing;
        this.userAccountBorrowing = userAccountBorrowing;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.renewal = renewal;
    }

    public Borrowing(Book bookBorrowing, UserAccount userAccountBorrowing, Date beginDate, Date endDate, Boolean renewal) {
        this.bookBorrowing = bookBorrowing;
        this.userAccountBorrowing = userAccountBorrowing;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.renewal = renewal;
    }

    public Integer getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Integer borrowingId) {
        this.borrowingId = borrowingId;
    }

    public Book getBookBorrowing() {
        return bookBorrowing;
    }

    public void setBookBorrowing(Book bookBorrowing) {
        this.bookBorrowing = bookBorrowing;
    }

    public UserAccount getUserAccountBorrowing() {
        return userAccountBorrowing;
    }

    public void setUserAccountBorrowing(UserAccount userAccountBorrowing) {
        this.userAccountBorrowing = userAccountBorrowing;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getRenewal() {
        return renewal;
    }

    public void setRenewal(Boolean renewal) {
        this.renewal = renewal;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "borrowingId=" + borrowingId +
                ", bookBorrowing=" + bookBorrowing +
                ", userAccountBorrowing=" + userAccountBorrowing +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", renewal=" + renewal +
                '}';
    }
}
