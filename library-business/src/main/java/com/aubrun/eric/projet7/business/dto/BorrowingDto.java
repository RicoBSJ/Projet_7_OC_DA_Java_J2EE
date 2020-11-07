package com.aubrun.eric.projet7.business.dto;

import java.util.Date;

public class BorrowingDto {

    private Integer borrowingId;
    private BookDto bookBorrowing;
    private UserAccountDto userAccountBorrowing;
    private Date beginDate;
    private Date endDate;
    private Boolean renewal;

    public Integer getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Integer borrowingId) {
        this.borrowingId = borrowingId;
    }

    public BookDto getBookBorrowing() {
        return bookBorrowing;
    }

    public void setBookBorrowing(BookDto bookBorrowing) {
        this.bookBorrowing = bookBorrowing;
    }

    public UserAccountDto getUserAccountBorrowing() {
        return userAccountBorrowing;
    }

    public void setUserAccountBorrowing(UserAccountDto userAccountBorrowing) {
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
}
