package CreateGUI;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Screen {

    // stores a long, used throughout
    private long window;

    // window size
    private static final int  width = 1920;
    private static final int  height = 1080;

    public Screen() {
        if(!glfwInit()) {
            /// Handle it
            throw new RuntimeException("GLFW Can't INIT");
        }

        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err));

        window = glfwCreateWindow(width, height, "GameName", NULL, NULL);

        if (window == NULL) {
           throw new RuntimeException("GLFW Can't create window");
        }

        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwSetWindowPos(window,(vidmode.width() - width) / 2,(vidmode.height() - height) / 2);
        glfwMakeContextCurrent(window);
        GL.createCapabilities();
        glfwShowWindow(window);
    }

    public boolean shouldClose() {
        return glfwWindowShouldClose(window);
    }

    public void preRender() {
        GL11.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    }

    public void postRender() {
        glfwSwapBuffers(window);
    }
}
