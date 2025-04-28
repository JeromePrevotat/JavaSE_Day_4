package com.humanbooster.exception;

public class LivreNonDisponibleException extends BibliothequeException{
    public LivreNonDisponibleException(String msg){
        super((msg == null || msg.trim().equals("")) ? getLivreNonDispoMsg() : msg);            
    }

    public LivreNonDisponibleException(String msg, Throwable cause){
        super((msg == null || msg.trim().equals("")) ? getLivreNonDispoMsg() : msg, cause);
    }
}