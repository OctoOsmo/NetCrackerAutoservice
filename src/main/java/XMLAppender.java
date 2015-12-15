import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.Date;

/**
 * Created by al on 15.12.2015.
 */
public class XmlAppender {

    static final Logger log = LogManager.getLogger(XmlAppender.class);

    public static void saveCar(Car car) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(Car.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(car, new File("cars/" + car.getName()+".xml"));

    }

    public static void saveCarManually(Car car) throws IOException {
        FileWriter fOut = new FileWriter("cars/" + car.getName()+car.getOwner() + ".xml");
        String header = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n";
        String body = "<" +
                car.getId().toString() +
                ">" +
                "\n\t<name>\n\t\t" +
                car.getName() +
                "\n\t</name>" +
                "\n\t<owner>\n\t\t" +
                car.getOwner() +
                "\n\t</owner>\n" +
                "</" +
                car.getId().toString() +
                ">";
        fOut.write(header);
        fOut.write(body);
        fOut.close();
    }
}
