package com.aubrun.eric.projet7.business.dto;

import com.aubrun.eric.projet7.beans.UserAccount;

public class LoanDto {

    private Integer loanId;
    private UserAccount userAccount;

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
}
