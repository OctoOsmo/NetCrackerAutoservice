import java.util.concurrent.*;
/**
 * Created by al on 14.12.2015.
 */
public class Service {
    private Integer masterCount;
    BlockingQueue<Car> parking;
    private Integer handlig_time;

    public Service(Integer masterCount, Integer parkingSize, Integer handlig_time) {
        this.masterCount = masterCount;
        this.handlig_time = handlig_time;
        parking = new LinkedBlockingQueue<>(parkingSize);
    }

    public void repairCars(){
        //starting to evacuate cars
        Thread tEvacuator = new Thread(new Evacuator(parking));
        tEvacuator.start();

        //starting to repair cars
        ExecutorService execService = Executors.newFixedThreadPool(masterCount);
        for (int i = 0; i < masterCount; i++) {
            execService.submit(new Master(parking, handlig_time));
        }
    }
}
