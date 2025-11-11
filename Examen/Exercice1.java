import java.io.BufferedReader; // Classe requise par l'exercice [1]
import java.io.FileReader;    // Classe requise par l'exercice [1]
import java.io.IOException;   // Nécessaire pour gérer les erreurs d'entrée/sortie

public class Exercice1 {
    public static void main(String[] args) {
        // Simulation de la création du fichier (non codée, mais requise) : villes.txt doit exister. [1]
        
        // Utilisation de try-with-resources pour la gestion automatique des ressources [2]
        try (BufferedReader reader = new BufferedReader(new FileReader("villes.txt"))) {
            String line;
            // Utilisation d'une boucle while pour lire chaque ligne [2]
            while ((line = reader.readLine()) != null) { 
                // Affiche chaque ville en majuscules
                System.out.println(line.toUpperCase());
            }
        } catch (IOException e) { // Gestion des exceptions d'entrée/sortie [2]
            // Affichage d'une erreur si la lecture échoue (ex: fichier non trouvé)
            System.err.println("Erreur lors de la lecture du fichier villes.txt: " + e.getMessage());
        }
    }
}