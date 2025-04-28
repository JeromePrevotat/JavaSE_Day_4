package com.humanbooster.exercices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bibliotheque {
    private List<Livre> livres = new ArrayList<>();
    private Map<String, LocalDate> emprunts = new HashMap<>();

    // METHODS
    public boolean ajouterLivre(Livre l){
        if (l == null || livres.contains(l)) return false;
        return this.livres.add(l);
    }

    // public void supprimerLivre(Livre l){
        // livres.removeIf((livre) -> livre.equals(l));
    public boolean supprimerLivre(String isbn){
        Livre livre = livres.stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
        if (livre == null) return false;
        return livres.remove(livre);
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
            emprunts.put(l.getIsbn(), LocalDate.now());
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
