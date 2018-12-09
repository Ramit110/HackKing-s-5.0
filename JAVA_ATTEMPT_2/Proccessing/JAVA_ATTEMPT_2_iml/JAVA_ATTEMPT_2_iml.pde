import java.io.File;

int mode = 0;
boolean done;
color currentColor;

MainMenu mainMenu;

void setup() {
  size(1280, 720);
  noStroke();
  rectMode(CENTER);
  
  done = false;
  background(currentColor);
}
void draw() {
  switch (mode){
    case 0:
      if(mainMenu == null){
        mainMenu = new MainMenu();
      }
      mainMenu.update();
      break;
    case 1:
      break;
    default:
      break;
  }
}

void mousePressed() {
  if (mainMenu.overRect()) {
    mode+=1;
    done = false;
  }
}
