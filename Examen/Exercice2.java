import java.io.*;
public class Exercice2 {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("message.txt"))) {
            bw.write("Bonjour !");
            bw.newLine(); 
            bw.write("Bievenue en Java.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de l'écriture dans le fichier message.txt: " + e.getMessage());
        }
    }
}