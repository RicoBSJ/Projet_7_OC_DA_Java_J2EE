package com.aubrun.eric.projet7.beans;

import javax.persistence.*;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Integer loanId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_book")
    private Book loanBook;

    public Loan() {
        super();
    }

    public Loan(Integer loanId, Book loanBook) {
        super();
        this.loanId = loanId;
        this.loanBook = loanBook;
    }

    public Loan(Book loanBook) {
        super();
        this.loanBook = loanBook;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Book getLoanBook() {
        return loanBook;
    }

    public void setLoanBook(Book loanBook) {
        this.loanBook = loanBook;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + loanId +
                ", book=" + loanBook +
                '}';
    }
}
