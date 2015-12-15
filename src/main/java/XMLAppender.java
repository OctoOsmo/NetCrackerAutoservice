import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by al on 15.12.2015.
 */
public class XmlAppender {

    public static void saveCar(Car car){
        Logger log = LogManager.getLogger(XmlAppender.class);
        try {
            JAXBContext context = JAXBContext.newInstance(Car.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(car, new File("cars/" + car.getName()+".xml"));
        } catch (JAXBException e) {
            log.error(e.getMessage());
        }
    }
}
