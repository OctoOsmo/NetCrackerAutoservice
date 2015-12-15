import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by al on 14.12.2015.
 */
public class Evacuator implements Runnable{

    Logger log = LogManager.getLogger(Evacuator.class);
    Marker evoc = MarkerManager.getMarker("Evoc"); 
    BlockingQueue<Car> parking;
    CarGenerator carGen = new CarGenerator();

    public Evacuator(BlockingQueue<Car> parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        while (true){
            try {
                Car tmpCar = carGen.getCar();
                parking.put(tmpCar);
                log.debug(evoc, "Queue size is: " + parking.size());
                log.debug(evoc, "Evacuated car: ");
                tmpCar.logCar();
            } catch (InterruptedException e) {
                log.warn("Interruption here");
            }
        }
    }
}
