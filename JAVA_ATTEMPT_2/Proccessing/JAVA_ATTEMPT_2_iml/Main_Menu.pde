color rectColor;
color rectHighlight;
color currentColor;
boolean rectOver = false;

int x1 = 1920/2;
int y1 = 1080/2;
int btnWidth = 120;
int btnHeight = 60;
PImage img;

void initItems(){
  rectColor = color(0);
  rectHighlight = color(51);
  currentColor = color(102);
  
  img = loadImage( new File("").getAbsolutePath() + "/Hey.png");
  
  
  background(currentColor);
}

void drawMenu() {
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

void update() {
  if ( overRect() ) {
    rectOver = true;
  } else {
     rectOver = false;
  }
}

boolean overRect()  {
  if (mouseX >= x1 && mouseX <= x1+btnHeight && 
      mouseY >= y1 && mouseY <= y1+btnWidth) {
    return true;
  } else {
    return false;
  }
}
