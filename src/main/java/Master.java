import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.util.concurrent.BlockingQueue;

/**
 * Created by al on 14.12.2015.
 */
public class Master implements Runnable{

    Logger log = LogManager.getLogger(Master.class);
    Marker master = MarkerManager.getMarker("master");
    private BlockingQueue<Car> parking;
    private Integer handlig_time;

    public Master(BlockingQueue<Car> parking, Integer handlig_time) {
        this.parking = parking;
        this.handlig_time = handlig_time;
    }

    @Override
    public void run() {
        log.debug(master, "master started");
        while (true){
            log.debug(master, "Queue size is: " + parking.size());
            log.debug(master, "trying to repair car");
            try {
                Car tmpCar = parking.take();
                Thread.sleep(handlig_time);
                log.debug("Car repaired: ");
                tmpCar.logCar();
            } catch (InterruptedException e) {
                log.warn("Interruption here");
            }
        }
    }
}
