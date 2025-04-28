package com.humanbooster.exercices;

import com.humanbooster.exception.LivreDejaEmprunteException;
import com.humanbooster.exception.LivreNonDisponibleException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        Livre livre = rechercherLivre(isbn);
        if (livre == null) return false;
        return livres.remove(livre);
    }

    // public List<Livre> rechercherLivre(Livre l){
    //     List<Livre> exemplaires = new ArrayList<>();
      
    //     // if (livres.contains(l)) exemplaires.add(l);
       
    //     livres.forEach((livre) -> {
    //          if (livre.isbn.equals(l.isbn)) exemplaires.add(livre);
    //     });

    //     return exemplaires;
    // }

    public Livre rechercherLivre(String isbn){
        return livres.stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    // public void emprunterLivre(Livre l){
    //     if (l.getDispo() == true){
    //         emprunts.put(l.getIsbn(), LocalDate.now());
    //         l.setDispo(false);
    //     }
    //     else System.out.println("Le Livre n'est pas disponible");
    // }

    public boolean emprunterLivre(String isbn){
        Livre livre = rechercherLivre(isbn);
        if (livre == null) return false;
        try {
            if(!livre.dispo) throw new LivreNonDisponibleException(null);
        } catch (LivreNonDisponibleException e) {
            System.err.println(e.getMessage());
        }
        try {
            if(emprunts.containsKey(isbn)) throw new LivreDejaEmprunteException(null);
        } catch (LivreDejaEmprunteException e) {
            System.err.println(e.getMessage());
        }
        emprunts.put(isbn, LocalDate.now());
        livre.setDispo(false);
        return true;
    }

    // public void rendreLivre(Livre l){
    //     emprunts.remove(l.isbn);
    //     l.setDispo(true);
    // }

    public boolean rendreLivre(String isbn){
        if (!emprunts.containsKey(isbn)) return false;
        Livre livre = rechercherLivre(isbn);
        if (livre == null) return false;
        livre.setDispo(true);
        emprunts.remove(isbn);
        return true;
    }

    // public List<Livre> getLivresDisponibles(){
    //     List<Livre> livresDispo = new ArrayList<>();
    //     livres.forEach((livre) -> {
    //         if (livre.getDispo()) livresDispo.add(livre);
    //     });
    //     return livresDispo;
    // }

    public List<Livre> getLivresDisponibles(){
        return livres.stream()
                    .filter(Livre::getDispo)
                    .collect(Collectors.toList());
    }

    // public List<Livre> getLivresEmprunte(){
    //     List<Livre> livresEmprunte = new ArrayList<>();
        
    //     emprunts.forEach((livreIsbn,date) -> {
    //         livres.forEach((l) -> {
    //             if(livreIsbn.equals(l.isbn)) livresEmprunte.add(l);
    //         });
    //     });
    //     return livresEmprunte;
    // }

    public List<Livre> getLivresEmprunte(){
        return livres.stream()
                    .filter(l -> !l.getDispo())
                    .collect(Collectors.toList());
    }
}
