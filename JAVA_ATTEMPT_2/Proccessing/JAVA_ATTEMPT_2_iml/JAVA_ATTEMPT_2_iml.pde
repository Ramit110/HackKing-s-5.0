import java.io.File;

int mode = 0;
boolean done;

void setup() {
  size(1280, 720);
  noStroke();
  rectMode(CENTER);
  
  done = false;
}
void draw() {
  switch (mode){
    case 0:
      if(!done){
        initItems();
        done=true;
      }
      drawMenu();
      break;
    case 2:
      if(!done){
        initLevels();
        done = true;
      }
      drawLevelMenu();
      break;
    default:
      break;
  }
}

void mousePressed() {
  if (rectOver) {
    mode+=1;
    done = false;
  }
}
