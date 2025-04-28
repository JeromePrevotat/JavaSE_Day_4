package com.humanbooster.exercices;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Livre {
    // - Attributs :
    public String isbn;
    public String titre;
    public String auteur = "Anonyme";
    public int anneePubli;
    public boolean dispo;

    private final Map<String, Object> args = new HashMap<>();

    public Livre(String isbn, String titre, String auteur, int anneePubli, boolean dispo){
        init(isbn, titre, dispo);
        ErrorHandler.handleConstructorArgs(args);
        this.isbn = isbn;
        this.titre = titre;
        if (!auteur.equals("")) this.auteur = auteur;
        this.anneePubli = anneePubli;
        this.dispo = dispo;
    }

    // Error Handler
    private void init(String isbn, String titre, boolean dispo){
        args.put("isbn", isbn);
        args.put("titre", titre);
        args.put("dispo", dispo);
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
        ErrorHandler.handleConstructorArgs(Map.of("isbn", isbn));
        this.isbn = isbn;
    }
    
    public void setTitre(String titre){
        ErrorHandler.handleConstructorArgs(Map.of("titre", titre));
        this.titre = titre;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public void setAnneePubli(int anneePubli){
        this.anneePubli = anneePubli;
    }

    public void setDispo(boolean dispo){
        ErrorHandler.handleConstructorArgs(Map.of("dispo", dispo));
        this.dispo = dispo;
    }

    // METHODS
    @Override
    public boolean equals(Object l){
        if (this == l) return true;
        if (l == null || getClass() != l.getClass()) return false;
        Livre livre = (Livre) l;
        return Objects.equals(this.isbn, livre.isbn);
        // if (l instanceof Livre){
        //     if (this.isbn.hashCode() == ((Livre) l).isbn.hashCode()) return true;
        // }
        // else throw new IllegalArgumentException("Error: Passer un Livre en parametre.");
        // return false;
    }

    @Override
    public String toString(){
        return ("\nISBN: " + this.isbn + "\nTitre: " + this.titre + "\nAuteur: " + this.auteur + "\nPublication: " + this.anneePubli + "\nDisponible " + this.dispo + "\n");
    }
    // - toString() pour l'affichage

}
