import java.awt.*;

public class Tile{

    private double x, y, width,height ;
    private boolean hurt, faze;
    private Color color;

    public Tile(double x, double y, double height, double width, Color color){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        //this.hurt = hurt;
        this.color = color;

    }

    public double getXCoordinate()
    {
        return x;
    }

    public double getYCoordinate()
    {
        return y;
    }

    public double getHeight()
    {
        return height;
    }

    public double getWidth()
    {
        return width;
    }

    public Color getColor() { return color; }

  //  public boolean getHurt()
   // {
    //    return hurt;
  //  }


    public double[][] getCP(){
        double[][] arr = {{x, y},  {x+ width, y},{x, y + height},{x + width, y + height}};;
        return arr;
    }



}