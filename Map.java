//import processing.core.*;
//import processing.data.*;
//import processing.event.*;
//import processing.opengl.*;

import processing.core.PApplet;
import processing.core.PShape;
import java.lang.*;


import java.awt.*;
import java.util.ArrayList;


    public class Map extends PApplet  {

        protected ArrayList <Block> mapMaker;
            private ArrayList <Tile> tiles;
            private TileMaker tileMaker;



            public Map() {
                mapMaker = new ArrayList<>();
                tileMaker = new TileMaker("map1.png");
                tiles = new ArrayList<>();
                loopTiles();
                draw();

            }

            public void loopTiles() {
                tiles = tileMaker.getTiles();
                System.out.println("loop" +tiles.size());
                for(int t = 0; tiles.size() > t; t++){
                    Tile tile = tiles.get(t);
                    Block block = new Block(tile.getXCoordinate(), tile.getYCoordinate(), tile.getHeight(), tile.getWidth(), tile.getColor());
                    mapMaker.add(block);
                }
            }

            public void draw() {
            //    background(255);
                int k=0;
                for (int m = 0; mapMaker.size() > m; m++){
                    Block block = mapMaker.get(m);
                    Color blockColor = block.getColour();
                    int RGBcolor = blockColor.getRGB();
                    PShape tile = block.getTile();
                    if(tile != null){
                        tile.setFill(RGBcolor);
                        shape(block.getTile());
                        k++;
                    }


                }
                System.out.println("draw"+k);
            }

        public void settings() {  fullScreen(); }
        static public void main(String[] passedArgs) {
            String[] appletArgs = new String[] { "Map" };
            if (passedArgs != null) {
                PApplet.main(concat(appletArgs, passedArgs));
            Map map = new Map();
              map.loop();
                map.draw();
            } else {
                PApplet.main(appletArgs);
            }
        }

        }
