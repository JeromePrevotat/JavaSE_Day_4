package com.humanbooster.exception;

public class DonneesInvalidesException extends BibliothequeException{
    public DonneesInvalidesException(String msg){
        super((msg == null || msg.equals("")) ? getInvalidDataMsg() : msg);            
    }

    public DonneesInvalidesException(String msg, Throwable cause){
        super((msg == null || msg.equals("")) ? getInvalidDataMsg() : msg, cause);
    }
}