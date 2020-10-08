package com.aubrun.eric.projet7.business.dto;

public class LoanDto {

    private Integer loanId;
    private BookDto loanBook;

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public BookDto getLoanBook() {
        return loanBook;
    }

    public void setLoanBook(BookDto loanBook) {
        this.loanBook = loanBook;
    }
}
