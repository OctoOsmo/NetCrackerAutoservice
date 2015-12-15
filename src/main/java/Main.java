import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by al on 14.12.2015.
 */
public class Main {
    public static void main(String[] args) {
        final Logger log = LogManager.getLogger(Main.class);

        Integer parkingSize, masterCount, handlig_time;
        try {
            PropertiesManager pm = new PropertiesManager();
            pm.read();
            parkingSize = pm.getX();
            masterCount = pm.getN();
            handlig_time = pm.getHandlig_time();
            log.debug("parkingSize = " + parkingSize + ", masterCount = " + masterCount + ", handlig time = " + handlig_time);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            parkingSize = 100; masterCount = 5; handlig_time = 100;
        } catch (IOException e) {
            log.error(e.getMessage());
            parkingSize = 100; masterCount = 5; handlig_time = 100;
        }

        Service service = new Service(masterCount, parkingSize, handlig_time);
        service.repairCars();
    }
}
