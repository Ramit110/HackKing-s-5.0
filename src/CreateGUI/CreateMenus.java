package CreateGUI;

import org.lwjgl.opengl.GL11;

public class CreateMenus {

    public static void createMainMenu(Screen screenToChange){
        GL11.glColor3d(0.5F, 1.0F, 0.75F);
        GL11.glVertex2d(0, 0);
        GL11.glColor3d(0.5F, 1.0F, 0.75F);
        GL11.glVertex2d(0, 1.0);
        GL11.glColor3d(0.5F, 1.0F, 0.75F);
        GL11.glVertex2d(1.0, 0);
        GL11.glColor3d(0.5F, 1.0F, 0.75F);
        GL11.glVertex2d(1.0, 1.0);
    }
}
