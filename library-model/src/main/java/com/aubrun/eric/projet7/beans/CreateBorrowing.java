package com.aubrun.eric.projet7.beans;

import java.util.Date;

public class CreateBorrowing {

    private Integer borrowingId;
    private String bookBorrowing;
    private String userAccountBorrowing;
    private Date beginDate;
    private Date endDate;
    private Boolean renewal;

    public Integer getBorrowingId() {
        return borrowingId;
    }

    public void setBorrowingId(Integer borrowingId) {
        this.borrowingId = borrowingId;
    }

    public String getBookBorrowing() {
        return bookBorrowing;
    }

    public void setBookBorrowing(String bookBorrowing) {
        this.bookBorrowing = bookBorrowing;
    }

    public String getUserAccountBorrowing() {
        return userAccountBorrowing;
    }

    public void setUserAccountBorrowing(String userAccountBorrowing) {
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
