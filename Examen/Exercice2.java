import java.io.BufferedWriter; // Classe requise par l'exercice [2]
import java.io.FileWriter;     // Classe requise par l'exercice [2]
import java.io.IOException;    // Nécessaire pour gérer les erreurs d'entrée/sortie

public class Exercice2 {
    public static void main(String[] args) {
        // Utilisation de try-with-resources pour fermer le flux automatiquement [2]
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("fruits.txt"))) {
            writer.write("Pomme");
            writer.newLine(); // Ajouter une nouvelle ligne [2]
            writer.write("Banane");
            writer.newLine(); // Ajouter une nouvelle ligne [2]
            writer.write("Orange");
        } catch (IOException e) { // Gérer les exceptions potentielles lors de l'écriture [2]
            System.err.println("Erreur lors de l'écriture dans fruits.txt: " + e.getMessage());
        }
        System.out.println("Le fichier fruits.txt a été créé avec succès.");
    }
}