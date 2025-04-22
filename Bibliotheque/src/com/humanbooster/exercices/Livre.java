package com.humanbooster.exercices;

public class Livre {
    // - Attributs :
    public String isbn;
    public String titre;
    public String auteur;
    public int anneePubli;
    public boolean dispo;

    public Livre(String isbn, String titre, String auteur, int anneePubli, boolean dispo){
        errorHandler();
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePubli = anneePubli;
        this.dispo = dispo;
    }

    private void errorHandler(... args[]) throws IllegalArgumentException {
        if (this.isbn.equals("")) throw new IllegalArgumentException("Error: ISBN cannot not be Empty");
        if (this.titre.equals("")) throw new IllegalArgumentException("Error: Titre cannot not be Empty");
        if (this.dispo != true && this.dispo != false) throw new IllegalArgumentException("Error: Dispo must be true or false");
    }

    public void errorHandler(String isbn, <Object> ... auteur){

    }

    // GETTER
    public String getIsbn(){
        return this.isbn;
    }

    public String getTitre(){
        return this.titre;
    }

    public String getAuteur(){
        return this.auteur;
    }

    public int getAnneePubli(){
        return this.anneePubli;
    }

    public boolean getDispo(){
        return this.dispo;
    }

    // SETTER
    public void setIsbn(String isbn){
        errorHandler();
        this.isbn = isbn;
    }
    
    public void setTitre(String titre){
        errorHandler();
        this.titre = titre;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public void setAnneePubli(int anneePubli){
        this.anneePubli = anneePubli;
    }

    public void setIsbn(boolean dispo){
        this.dispo = dispo;
    }

    // - equals() et hashCode() basés sur l'ISBN
    // - toString() pour l'affichage

}
