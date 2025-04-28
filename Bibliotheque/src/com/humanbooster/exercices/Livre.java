package com.humanbooster.exercices;
import com.humanbooster.exception.BibliothequeException;
import com.humanbooster.exception.DonneesInvalidesException;
import java.util.Objects;

public class Livre {
    // - Attributs :
    public String isbn;
    public String titre;
    public String auteur = "Anonyme";
    public int anneePubli;
    public boolean dispo;

    public Livre(String isbn, String titre, String auteur, int anneePubli, boolean dispo){
        try {
            if (isbn == null || isbn.equals("")) throw new DonneesInvalidesException("Error: ISBN cannot not be Empty or null");
            if (titre == null || titre.equals("")) throw new DonneesInvalidesException("");
        } catch (BibliothequeException e) {
            System.err.println(e.getMessage());
        }
        this.isbn = isbn;
        this.titre = titre;
        if (!(auteur == null) && !auteur.equals("")) this.auteur = auteur;
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
    public void setIsbn(String isbn){
        try {
            if (isbn == null || isbn.equals("")) throw new DonneesInvalidesException(null);
        } catch (DonneesInvalidesException e) {
            System.err.println(e.getMessage());
        }
        this.isbn = isbn;
    }
    
    public void setTitre(String titre){
        try {
            if (titre == null || titre.equals("")) throw new DonneesInvalidesException(null);
        } catch (DonneesInvalidesException e) {
            System.err.println(e.getMessage());
        }        this.titre = titre;
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
