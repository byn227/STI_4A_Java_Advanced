import java.io.*;
public class Exercice1 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("prenoms.txt"))) { 
            String line;
            while ((line = br.readLine()) != null) { 
                System.out.println(line); 
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de la lecture du fichier prenoms.txt: " + e.getMessage());
        }
    }
}
