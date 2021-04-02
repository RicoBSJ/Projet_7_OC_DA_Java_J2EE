package com.aubrun.eric.projet7.business.service.exception;

public class WrongIdentifier extends RuntimeException {

    public WrongIdentifier() {
        super("Please verify your login details");
    }


}
