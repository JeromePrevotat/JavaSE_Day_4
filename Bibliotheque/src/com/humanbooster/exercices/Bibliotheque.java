package com.humanbooster.exercices;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bibliotheque {
    public List<Livre> livres = new ArrayList<>();
    public Map<String, Date> emprunts = new HashMap<>();

    // METHODS
    public void ajouterLivre(Livre l){
        this.livres.add(l);
    }

    public void supprimerLivre(Livre l){
        livres.removeIf((livre) -> livre.equals(l));
    }

    public List<Livre> rechercherLivre(Livre l){
        List<Livre> exemplaires = new ArrayList<>();
      
        // if (livres.contains(l)) exemplaires.add(l);
       
        livres.forEach((livre) -> {
             if (livre.isbn.equals(l.isbn)) exemplaires.add(livre);
        });

        return exemplaires;
    }

    public void emprunterLivre(Livre l){
        if (l.getDispo() == true){
            emprunts.put(l.getIsbn(), Date.from(Instant.now()));
            l.setDispo(false);
        }
        else System.out.println("Le Livre n'est pas disponible");
    }

    public void rendreLivre(Livre l){
        emprunts.remove(l.isbn);
        l.setDispo(true);
    }

    public List<Livre> getLivresDisponibles(){
        List<Livre> livresDispo = new ArrayList<>();
        livres.forEach((livre) -> {
            if (livre.getDispo()) livresDispo.add(livre);
        });
        return livresDispo;
    }

    public List<Livre> getLivresEmprunte(){
        List<Livre> livresEmprunte = new ArrayList<>();
        
        emprunts.forEach((livreIsbn,date) -> {
            livres.forEach((l) -> {
                if(livreIsbn.equals(l.isbn)) livresEmprunte.add(l);
            });
        });
        return livresEmprunte;
    }
}
