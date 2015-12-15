import java.util.Random;

/**
 * Created by al on 14.12.2015.
 */
public class CarGenerator {

    private Random rng = new Random();

    private String generateString(String characters, int length)
    {
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        return new String(text);
    }

    public Car getCar(){
        String name = generateString("QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm", 10);
        String owner = generateString("QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm", 15);
        return new Car(rng.nextInt()%3 + 4, name, owner);
    }

}
