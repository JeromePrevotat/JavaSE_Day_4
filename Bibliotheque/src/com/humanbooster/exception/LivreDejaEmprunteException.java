package com.humanbooster.exception;

public class LivreDejaEmprunteException extends BibliothequeException{
    public LivreDejaEmprunteException(String msg){
        super((msg == null || msg.equals("")) ? getLivreEmprunteMsg() : msg);            
    }

    public LivreDejaEmprunteException(String msg, Throwable cause){
        super((msg == null || msg.equals("")) ? getLivreEmprunteMsg() : msg, cause);
    }
}
