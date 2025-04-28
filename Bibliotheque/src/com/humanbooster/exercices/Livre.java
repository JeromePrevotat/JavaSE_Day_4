package com.humanbooster.exercices;
import com.humanbooster.exception.DonneesInvalidesException;
import java.util.Objects;

public class Livre {
    // - Attributs :
    private String isbn;
    private String titre;
    private String auteur = "Anonyme";
    private int anneePubli;
    private boolean dispo;

    public Livre(String isbn, String titre, String auteur, int anneePubli, boolean dispo) throws DonneesInvalidesException{
        if (isbn == null || isbn.trim().equals("")) throw new DonneesInvalidesException("Error: ISBN cannot not be Empty or null");
        if (titre == null || titre.trim().equals("")) throw new DonneesInvalidesException("");
        this.isbn = isbn;
        this.titre = titre;
        if (!(auteur == null) && !auteur.trim().equals("")) this.auteur = auteur;
        this.anneePubli = anneePubli;
        this.dispo = dispo;
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
    public void setIsbn(String isbn) throws DonneesInvalidesException{
        if (isbn == null || isbn.trim().equals("")) throw new DonneesInvalidesException(null);
        this.isbn = isbn;
    }
    
    public void setTitre(String titre) throws DonneesInvalidesException{
        if (titre == null || titre.trim().equals("")) throw new DonneesInvalidesException(null);
        this.titre = titre;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public void setAnneePubli(int anneePubli){
        this.anneePubli = anneePubli;
    }

    public void setDispo(boolean dispo){
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
