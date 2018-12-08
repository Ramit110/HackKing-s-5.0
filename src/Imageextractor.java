import javax.imageio.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class Imageextractor {
    ArrayList <Tile> tiles = new ArrayList<>();

    public static void createMap(String filename){
        BufferedImage img = ImageIO.read(new File(filename));

        for (int x=0; x<img.getWidth(); x++)
            for (int y=0; y<img.getHeight(); y++){
                Color color = new Color (img.getRGB(x, y));
                int r1 = color.getRed();

                new Tile ()

            }
    }
}
