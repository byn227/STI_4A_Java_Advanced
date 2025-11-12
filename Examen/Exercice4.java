import java.util.concurrent.Semaphore;
import java.util.Random;
public class Exercice4{
    public static void main(String[] args) {
        CarPark parking = new CarPark(4); 
        final int numberOfCars = 8;     
        System.out.println("Simulation d'un parking avec 4 places et 8 voitures.");
        
        for (int i = 1; i <= numberOfCars; i++) {
            Car car = new Car(parking, i);
            car.start(); 
        }
    }
}
class CarPark {
    private final Semaphore semaphore;
    private int carsInside = 0;
    public CarPark(int capacity) {
        this.semaphore = new Semaphore(capacity, true); 
    }
    public Semaphore getSemaphore() {
        return semaphore;
    }
    public synchronized void printEnter(int carNumber) {
        carsInside++;
        System.out.println("-> Voiture " + carNumber + " ENTRE dans le parking.");
    }
    
    public synchronized void printExit(int carNumber) {
        carsInside--;
        System.out.println("<- Voiture " + carNumber + " SORT du parking.");
    }
}

class Car extends Thread {
    private final CarPark park;
    private final int carNumber;
    private static final Random random = new Random();

    public Car(CarPark park, int carNumber) {
        this.park = park;
        this.carNumber = carNumber;
    }
    @Override
    public void run() {
        Semaphore semaphore = park.getSemaphore();
        
        try {
            // acquérir le sémaphore 
            semaphore.acquire();
            // afficher le message d'entrée de manière synchronisée
            park.printEnter(carNumber);
            // attendre 2 à 5 secondes
            long waitTime = random.nextInt(3001) + 2000; 
            Thread.sleep(waitTime); 

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            park.printExit(carNumber);
            semaphore.release();
        }
    }
}