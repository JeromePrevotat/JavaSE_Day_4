package com.humanbooster.exception;

public class DonneesInvalidesException extends BibliothequeException{
    public DonneesInvalidesException(String msg){
        super((msg == null || msg.trim().equals("")) ? getInvalidDataMsg() : msg);            
    }

    public DonneesInvalidesException(String msg, Throwable cause){
        super((msg == null || msg.trim().equals("")) ? getInvalidDataMsg() : msg,
                (cause == null) ? null : cause);
    }
}