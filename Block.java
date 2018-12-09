import processing.core.PApplet;
import processing.core.PShape;

import java.awt.*;

//import Java.core.library.*;

public class Block extends PApplet {

    PShape tile;
    double x, y, h, w;
    Color colour;
    public Block(double x, double y, double h, double w, Color colour ){
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.colour = colour;
        setup();
    }

    public Color getColour(){ return colour;}

    public void setup() {
        rectMode(CORNERS);
        tile = createShape(RECT, Math.round(x), Math.round(y), Math.round(h), Math.round(w));
        tile.setStroke();
        tile.setFill(tile);

    }

    public PShape getTile(){

            return tile;}

    public double getXCoord(){ return x;}

    public double getYCoord(){ return y;}

    public double getWid(){ return w;}

    public double getHeight(){ return h;}

}