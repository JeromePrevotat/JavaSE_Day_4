import com.humanbooster.exercices.Bibliotheque;
import com.humanbooster.exercices.Livre;

public class App {
    public static void main(String[] args) throws Exception {
        // Creation des Livres
        Livre l1 = new Livre("1", "AAA", "aaa", 2000, true);
        Livre l2 = new Livre("2", "BBB", "bbb", 2000, true);
        Livre l3 = new Livre("3", "CCC", "ccc", 2000, true);
        Livre l4 = new Livre("4", "DDD", "ddd", 2000, true);
        Livre l5 = new Livre("5", "EEE", "eee", 2000, true);
        Livre l6 = new Livre("3", "CCC", "ccc", 2000, true);
        Livre l7 = new Livre("3", "CCC", "ccc", 2000, true);
        Livre l8 = new Livre("6", "H2G2", "Douglas Adams", 2000, true);

        //Aberrants
        // Livre l9 = new Livre("", "H2G2", "Douglas Adams", 2000, true);
        // Livre l10 = new Livre("10", "", "Douglas Adams", 2000, true);
        Livre l11 = new Livre("11", "H2G2", "", 2000, true);
        Livre l12 = new Livre("12", "H2G2", "Douglas Adams", 2000, true);

        // AJout des Livres a la Bibliothèque
        Bibliotheque b = new Bibliotheque();
        b.ajouterLivre(l1);
        b.ajouterLivre(l2);
        b.ajouterLivre(l3);
        b.ajouterLivre(l4);
        b.ajouterLivre(l5);
        b.ajouterLivre(l6);
        b.ajouterLivre(l7);
        b.ajouterLivre(l8);

        // Aberant
        // b.ajouterLivre(l9);
        // b.ajouterLivre(l10);
        b.ajouterLivre(l11);

        // Affichage des infos de l3
        System.out.println(b.rechercherLivre(l3.getIsbn()).toString());

        // b.rechercherLivre(l3.getIsbn()).forEach((livre) -> {
        //     System.out.println(livre.toString());
        // });

        // Ajouter des Emprunts
        b.emprunterLivre(l8.getIsbn());
        b.emprunterLivre(l4.getIsbn());
        b.emprunterLivre(l5.getIsbn());
        b.emprunterLivre(l11.getIsbn());
        // Afficher la Liste des Emprunts
        System.out.println("\nEMPRUNTS: " + b.getLivresEmprunte().toString());
        //Afficher la Liste des Livres Dispo
        System.out.println("\nLIVRE DISPO: " + l8.getDispo());
        // Rendre l8
        b.rendreLivre(l8.getIsbn());
        // Afficher la Liste des Emprunts (l8 doit avoir disparu de la Liste puisque Rendu)
        System.out.println("\nEMPRUNTS: " + b.getLivresEmprunte().toString());
        // Verifie si l8 est Disponible (doit retourner true puisque l8 est de nouveau dispo)
        System.out.println("\nLIVRE DISPO: " + l8.getDispo());
        //Afficher la Liste des Livres Dispo (l8 doit de nouveau apparaitre dans cette liste puisque dispo)
        System.out.println("\nLIVRES DISPO: " + b.getLivresDisponibles());
        // Afficher la Liste des Emprunts (last check)
        System.out.println("\nLIVRES EMPRUNTES: " + b.getLivresEmprunte());
    }
}
