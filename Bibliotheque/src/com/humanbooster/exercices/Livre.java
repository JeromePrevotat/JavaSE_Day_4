package com.humanbooster.exercices;
import java.util.HashMap;
import java.util.Map;

public class Livre {
    // - Attributs :
    public String isbn;
    public String titre;
    public String auteur;
    public int anneePubli;
    public boolean dispo;

    private final Map<String, Object> args = new HashMap<>();

    public Livre(String isbn, String titre, String auteur, int anneePubli, boolean dispo){
        init(isbn, titre, dispo);
        errorHandler(args);
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
        this.anneePubli = anneePubli;
        this.dispo = dispo;
    }

    // Error Handler
    private void init(String isbn, String titre, boolean dispo){
        args.put("isbn", isbn);
        args.put("titre", titre);
        args.put("dispo", dispo);
    }

    private void errorHandler(Map<String, Object> args) throws IllegalArgumentException {
        args.forEach((k,v) -> {
            if (k.equals("isbn") && (v.equals("") || v == null)) throw new IllegalArgumentException("Error: ISBN cannot not be Empty");
            if (k.equals("titre") && (v.equals("") || v == null)) throw new IllegalArgumentException("Error: Titre cannot not be Empty");
            if (k.equals("dispo") && (v == null)) throw new IllegalArgumentException("Error: Dispo must be true or false");
        });
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
        errorHandler(Map.of("isbn", isbn));
        this.isbn = isbn;
    }
    
    public void setTitre(String titre){
        errorHandler(Map.of("titre", titre));
        this.titre = titre;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public void setAnneePubli(int anneePubli){
        this.anneePubli = anneePubli;
    }

    public void setDispo(boolean dispo){
        errorHandler(Map.of("dispo", dispo));
        this.dispo = dispo;
    }

    // METHODS
    @Override
    public boolean equals(Object l){
        if (l instanceof Livre){
            if (this.isbn.hashCode() == ((Livre) l).isbn.hashCode()) return true;
        }
        else throw new IllegalArgumentException("Error: Passer un Livre en parametre.");
        return false;
    }

    @Override
    public String toString(){
        return ("ISBN: " + this.isbn + "\nTitre: " + this.titre + "\nAuteur: " + this.auteur + "\nPublication: " + this.anneePubli + "\nDisponible " + this.dispo + "\n");
    }
    // - toString() pour l'affichage

}
