package com.humanbooster.exception;

public class BibliothequeException extends Exception{
    private static final String LIVRENONDISPOMSG = "Erreur: Le livre n'est pas disponible";
    private static final String LIVREEMPRUNTEMSG = "Erreur: Le livre est déjà emprunté";
    private static final String INVALIDDATAMSG = "Erreur: Les données sont invalides";

    public BibliothequeException(String msg){
        super(msg);
    }

    public BibliothequeException(String msg, Throwable cause){
        super(msg, cause);
    }

    // GETTER
    public static String getLivreNonDispoMsg(){
        return LIVRENONDISPOMSG;
    }

    public static String getLivreEmprunteMsg(){
        return LIVREEMPRUNTEMSG;
    }

    public static String getInvalidDataMsg(){
        return INVALIDDATAMSG;
    }
}
