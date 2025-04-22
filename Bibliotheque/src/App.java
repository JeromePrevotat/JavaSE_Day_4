import com.humanbooster.exercices.Bibliotheque;
import com.humanbooster.exercices.Livre;

public class App {
    public static void main(String[] args) throws Exception {
        Livre l1 = new Livre("1", "AAA", "aaa", 2000, true);
        Livre l2 = new Livre("2", "BBB", "bbb", 2000, true);
        Livre l3 = new Livre("3", "CCC", "ccc", 2000, true);
        Livre l4 = new Livre("4", "DDD", "ddd", 2000, true);
        Livre l5 = new Livre("5", "EEE", "eee", 2000, true);
        Livre l6 = new Livre("3", "CCC", "ccc", 2000, true);
        Livre l7 = new Livre("3", "CCC", "ccc", 2000, true);

        Livre l8 = new Livre("6", "H2G2", "Douglas Adams", 2000, true);

        Bibliotheque b = new Bibliotheque();
        b.ajouterLivre(l1);
        b.ajouterLivre(l2);
        b.ajouterLivre(l3);
        b.ajouterLivre(l4);
        b.ajouterLivre(l5);
        b.ajouterLivre(l6);
        b.ajouterLivre(l7);

        b.rechercherLivre(l3).forEach((livre) -> {
            System.out.println(livre.toString());
        });

        b.emprunterLivre(l8);
        b.emprunterLivre(l4);
        b.emprunterLivre(l5);
        System.out.println("EMPRUNTS: " + b.emprunts.toString());
        System.out.println("LIVRE DISPO: " + l8.getDispo());
        b.emprunterLivre(l8);
        b.rendreLivre(l8);
        System.out.println("EMPRUNTS: " + b.emprunts.toString());
        System.out.println("LIVRE DISPO: " + l8.getDispo());
        System.out.println("\nLIVRES DISPO: " + b.getLivresDisponibles());
        System.out.println("\nLIVRES EMPRUNTES: " + b.getLivresEmprunte());
    }
}
