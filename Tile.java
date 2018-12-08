public class Tile{

    private double x, y, width,height ;
    private boolean hurt, faze;
    private BufferedImage image;
    private Rectangle2D.Double platformBlock;

    public Tile(double x, double y, double height, double width, boolean hurt, boolean solid, Color color){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.hurt = hurt;
        this.solid = solid;
        platformBlock = new Rectangle2D.Double(x, y, width, height);

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

    public boolean getHurt()
    {
        return hurt;
    }

    public boolean getIsSolid()
    {
        return faze;
    }

    public void toggleSolid()
    {
        Solid = !Solid;
    }

    public double[4][2] getCP()
    {
        double arr[4][2] = new double[4][2];
        arr[0] = new double[2]{x, y};
        arr[1] = new double[2]{x+ width, y};
        arr[2] = new double[2]{x, y + height};
        arr[3] = new double[2]{x + width, y + height};

    }




}