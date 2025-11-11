package TD5;

import java.lang.reflect.*;
import java.util.Date;

public class AnalyseurObjet {
    
    public static void afficherInfos(Object o) {
        if (o == null) {
            System.out.println("Objet null");
            return;
        }
        
        Class<?> classe = o.getClass();
        
        System.out.println("\n=== ANALYSE: " + classe.getSimpleName() + " ===");
        System.out.println("\nClasse: " + classe.getName());
        
        // Superclasse
        System.out.print("Superclasse: ");
        if (classe.getSuperclass() != null) {
            System.out.println(classe.getSuperclass().getName());
        } else {
            System.out.println("aucune");
        }
        
        // Interfaces
        System.out.print("Interfaces: ");
        Class<?>[] interfaces = classe.getInterfaces();
        if (interfaces.length == 0) {
            System.out.println("aucune");
        } else {
            System.out.println();
            for (Class<?> inter : interfaces) {
                System.out.println("  - " + inter.getName());
            }
        }
        
        // Attributs
        System.out.println("\nAttributs:");
        Field[] champs = classe.getDeclaredFields();
        for (Field champ : champs) {
            System.out.println("  " + Modifier.toString(champ.getModifiers()) + " " + champ.getType().getSimpleName() + " " + champ.getName());
        }
        
        // Constructeurs
        System.out.println("\nConstructeurs:");
        Constructor<?>[] constructeurs = classe.getDeclaredConstructors();
        for (Constructor<?> c : constructeurs) {
            System.out.print("  " + Modifier.toString(c.getModifiers()) + " " + classe.getSimpleName() + "(");
            Class<?>[] params = c.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getSimpleName());
                if (i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }
        
        // Méthodes
        System.out.println("\nMéthodes:");
        Method[] methodes = classe.getDeclaredMethods();
        for (Method m : methodes) {
            System.out.print("  " + Modifier.toString(m.getModifiers()) + 
                           " " + m.getReturnType().getSimpleName() + " " + m.getName() + "(");
            Class<?>[] params = m.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getSimpleName());
                if (i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Test avec String
        System.out.println("TEST 1: String");
        afficherInfos("Bonjour");
        
        // Test avec Date
        System.out.println("\nTEST 2: Date");
        afficherInfos(new Date());
        
        // Test avec classe personnalisée
        System.out.println("\nTEST 3: Personne");
        afficherInfos(new Personne("Dupont", 25));
    }
}

class Personne {
    private String nom;
    protected int age;
    
    public Personne(String nom, int age) {
        this.nom = nom;
        this.age = age;
    }
    
    public String getNom() {
        return nom;
    }
    
    public int getAge() {
        return age;
    }
    
    @Override
    public String toString() {
        return nom + " (" + age + " ans)";
    }
}
