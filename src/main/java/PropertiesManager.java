import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by al on 14.12.2015.
 */
public class PropertiesManager {
    private String fileName;
    private Properties properties = new Properties();
    private Integer X, N, handlig_time;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getX() {
        return X;
    }

    public void setX(Integer x) {
        X = x;
    }

    public Integer getN() {
        return N;
    }

    public void setN(Integer n) {
        N = n;
    }

    public Integer getHandlig_time() {
        return handlig_time;
    }

    public void setHandlig_time(Integer handlig_time) {
        this.handlig_time = handlig_time;
    }

    public PropertiesManager() throws FileNotFoundException {
        fileName = "properties.txt";
    }

    public PropertiesManager(String fileName) {
        this.fileName = fileName;
    }

    public void store(Integer parkinSize, Integer masterCount, Integer handlig_time) throws IOException {
        FileOutputStream f = new FileOutputStream(fileName);
        properties.setProperty("X", parkinSize.toString());
        properties.setProperty("N", masterCount.toString());
        properties.setProperty("handlig_time", handlig_time.toString());
        properties.store(f, "Autoservice properties N is workers count, X is parking size");
        f.close();
    }

    public void read() throws IOException {
        FileInputStream fin = new FileInputStream(fileName);
        properties.load(fin);
        X = Integer.parseInt(properties.getProperty("X"));
        N = Integer.parseInt(properties.getProperty("N"));
        handlig_time = Integer.parseInt(properties.getProperty("handlig_time"));
        fin.close();
    }
}
