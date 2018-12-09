import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.*;
import java.util.*;
import java.awt.image.BufferedImage;

public class TileMaker {

    private Color wall;
    private ArrayList<Tile> tiles;
    private final double LENGTH = 2;

    public TileMaker(String filename){
        tiles = new ArrayList<>();
        wall = new Color(0, 0, 0); // BLACK
        //portal = new Color(128, 0, 128); // PURPLE
        //spikes = new Color (237, 28, 36); // RED
        //appearing_platform = new Color(185, 122, 87); // BROWN/BAIGE
        //button = new Color (255, 127, 39); // ORANGE
        //vortex = new Color(255, 174, 201); // PINK

        // START OF MAGIC CODE
        File imgLoc = new File(filename);
        BufferedImage img;
        try {
            img = ImageIO.read(imgLoc);
            for (int x=0; x<img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    Color color = new Color(img.getRGB(x, y));
                    tiles.add(new Tile(x+1, y+1, LENGTH, LENGTH, color));
                }
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        // END OF MAGIC CODE
    }

    public ArrayList<Tile> getTiles(){
        return tiles;
    }
}

