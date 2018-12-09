public class MainMenu {
  color buttonColour = color(10);
  color rectHighlight = color(51);
  boolean rectOver = false;
  
  int x1 = 1280/2-300;
  int y1 = 720/2-30;
  int btnWidth = 600;
  int btnHeight = 60;
  PImage img;
  
  public MainMenu(){
    img = loadImage( new File("").getAbsolutePath() + "/Hey.png");
  }
  
  void drawMenu() {
    update();
    if (rectOver) {
      fill(rectHighlight);
    } else {
      fill(buttonColour);
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
}
