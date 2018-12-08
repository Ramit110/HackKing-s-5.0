import Enums.State;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL11;


import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * Documantation to  be completed.
 * All static methods should be here for now.
 *
 * @author Ramit110,
 * @version 0.1
 */
public class Main implements Runnable {

    // the thread of the program
    private Thread mainThread;
    private boolean running = true;
    private static Screen screen;

    private State currentState = State.INRO;

    public static void main(String[] args) {
        Main main = new Main();
        screen = new Screen();
        main.init();
        main.start();
    }

    private synchronized void start() {
        mainThread = new Thread("Game");
        run();
    }

    private synchronized void stop() {
        running = false;
        try {
            mainThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void init() {

    }

    public void run() {
        while (running) {
            update();
            render();

            if(screen.shouldClose())
                running = false;
        }
    }

    private void update() {
        glfwPollEvents();
    }

    private double test = 0.0;

    private void render() {
        screen.preRender();


        screen.postRender();
    }
}
