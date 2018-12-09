int[] verteces = new int[]{1280/2-300, 720/2-30, 600, 60};

void initLevels(){
  
}

void drawLevelMenu(){
  update();
  if (rectOver) {
    fill(rectHighlight);
  } else {
    fill(rectColor);
  }
  stroke(255);
  //rect();
  image(img, x1, y1, btnWidth+100, btnHeight+100);
  
}
