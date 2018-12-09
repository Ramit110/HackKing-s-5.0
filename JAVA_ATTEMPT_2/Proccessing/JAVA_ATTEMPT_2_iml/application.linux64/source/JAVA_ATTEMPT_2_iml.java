import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.io.File; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class JAVA_ATTEMPT_2_iml extends PApplet {



int mode = 0;
boolean done;

public void setup() {
  
  noStroke();
  rectMode(CENTER);
  
  done = false;
}
public void draw() {
  switch (mode){
    case 0:
      if(!done){
        initItems();
        done=true;
      }
      drawMenu();
      break;
    case 2:
      initLevels();
      break;
    default:
      break;
  }
}

public void mousePressed() {
  if (rectOver) {
    mode+=1;
  }
}
int[] verteces = new int[]{0, 100, 120, 100};

public void initLevels(){
  
}

int rectColor;
int rectHighlight;
int currentColor;
boolean rectOver = false;

int x1 = width/2;
int y1 = height/2;
int btnWidth = 120;
int btnHeight = 60;
PImage img;

public void initItems(){
  rectColor = color(0);
  rectHighlight = color(51);
  currentColor = color(102);
  
  img = loadImage( new File("").getAbsolutePath() + "/Hey.png");
  
  
  background(currentColor);
}

public void drawMenu() {
  update();
  if (rectOver) {
    fill(rectHighlight);
  } else {
    fill(rectColor);
  }
  stroke(255);
  //rect();
  image(img, x1, y1, btnWidth, btnHeight);
  
}

public void update() {
  if ( overRect() ) {
    rectOver = true;
  } else {
     rectOver = false;
  }
}

public boolean overRect()  {
  if (mouseX >= x1 && mouseX <= x1+btnHeight && 
      mouseY >= y1 && mouseY <= y1+btnWidth) {
    return true;
  } else {
    return false;
  }
}

  public void settings() {  size(1280, 720); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "JAVA_ATTEMPT_2_iml" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
