color rectColor;
color rectHighlight;
color currentColor;
boolean rectOver = false;

int x1 = 1280/2-300;
int y1 = 720/2-30;
int btnWidth = 600;
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
