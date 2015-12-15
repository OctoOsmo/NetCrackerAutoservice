import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by al on 14.12.2015.
 */
public class Car {
    private Integer id;
    private String name;
    private String owner;
    final private Logger log = LogManager.getLogger(Car.class);

    public Car(Integer id, String name, String owner) {
        this.id = id;
        this.name = name;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void logCar(){
        log.debug("id = " + id);
        log.debug("name = " + name);
        log.debug("owner = " + owner);
    }

}
