import java.util.List;
import java.util.ArrayList;
public class Exercice3 {
    public static void main(String[] args) {
        List<integer> nombre = new ArrayList<Integer>();
        nombre.add(1);
        nombre.add(2);
        nombre.add(3);
        nombre.add(4);
        nombre.add(5);
        
        System.out.println("Boucle for classique: ");
        for (int i = 0; i < nombre.size(); i++) {
            System.out.println(nombre.get(i));
        }

        System.out.println("Boucle for-each: ");
        for (Integer p : nombre) {
            System.out.println(p);
        }
    }
}