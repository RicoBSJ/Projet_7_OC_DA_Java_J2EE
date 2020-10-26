package com.aubrun.eric.projet7.beans;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="loan_id_generator", sequenceName = "loan_id_seq", allocationSize=1)
@Table(name = "LOAN")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "loan_id_generator")
    @Column(name = "loan_id")
    private Integer loanId;
    @JoinColumn(name = "user_account")
    @ManyToOne
    private UserAccount userAccount;

    public Loan() {
        super();
    }

    public Loan(Integer loanId, UserAccount userAccount) {
        this.loanId = loanId;
        this.userAccount = userAccount;
    }

    public Loan(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", userAccount=" + userAccount +
                '}';
    }
}
