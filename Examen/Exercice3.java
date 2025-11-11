import java.util.List;
import java.util.ArrayList; // Utilisée pour pouvoir ajouter un élément [3]

public class Exercice3 {
    public static void main(String[] args) {
        // 1. Créez une List<String> contenant les noms de 5 pays.
        List<String> pays = new ArrayList<>(); 
        pays.add("Canada");
        pays.add("Mexique");
        pays.add("Japon");
        pays.add("Inde");
        pays.add("Australie");

        // 2. Affichez tous les pays :
        
        // Affichage avec une boucle for classique (accès par indice) [3]
        System.out.println("--- Boucle for classique ---");
        for (int i = 0; i < pays.size(); i++) {
            System.out.println("Pays [" + i + "] : " + pays.get(i));
        }

        // Affichage avec une boucle for-each (parcours direct des éléments) [3]
        System.out.println("\n--- Boucle for-each ---");
        for (String paysNom : pays) {
            System.out.println(paysNom);
        }

        // 3. Ajoutez un pays supplémentaire à la liste et affichez la liste mise à jour.
        pays.add("Brésil"); // Ajout d'un pays
        
        System.out.println("\n--- Liste mise à jour (après ajout) ---");
        for (String paysNom : pays) {
            System.out.println(paysNom);
        }
    }
}
