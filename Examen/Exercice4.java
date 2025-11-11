import java.util.concurrent.Semaphore; 
import java.util.Random;

// Créer une classe CarPark qui contient un sémaphore 
class CarPark { 
    private final Semaphore parkingSemaphore = new Semaphore(3); 
    private final Random random = new Random();

    public void enter(int carId) throws InterruptedException {
        // Le thread (voiture) attend jusqu'à ce qu'une autorisation soit disponible 
        System.out.println("Voiture " + carId + " arrive et attend une place...");
        parkingSemaphore.acquire(); 
    
        System.out.println("Voiture " + carId + " ENTRE dans le parking.");
        
        // Simuler le temps passé (1 à 3 secondes) 
        int waitTime = random.nextInt(2000) + 1000; // entre 1000ms et 3000ms
        
        try {
            Thread.sleep(waitTime); 
        } catch (InterruptedException e) {
            System.err.println("Voiture " + carId + " a été interrompue pendant son séjour.");
            Thread.currentThread().interrupt();
        }
        parkingSemaphore.release(); 
        System.out.println("Voiture " + carId + " SORT du parking.");
    }
}
class Car extends Thread {
    private final int carId;
    private final CarPark park;

    public Car(int id, CarPark park) {
        this.carId = id;
        this.park = park;
    }

    @Override
    public void run() {
        try {
            park.enter(carId);
        } catch (InterruptedException e) {
            System.err.println("Voiture " + carId + " a terminé prématurément");
            Thread.currentThread().interrupt();
        }
    }
}
public class Exercice4 {
    public static void main(String[] args) {
        CarPark sharedPark = new CarPark();
        
        // Créez 6 voitures et démarrez-les simultanément. 
        System.out.println("Démarrage de la simulation (Parking de 3 places)");

        for (int i = 1; i <= 6; i++) {
            Car car = new Car(i, sharedPark);
            car.setName("Voiture-" + i);
            car.start();
        }
    }
}