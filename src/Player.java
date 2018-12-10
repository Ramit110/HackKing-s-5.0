import java.util.HashMap;
import javafx.scene.shape.*;

/**
 * The Player class handles everything that the main character does
 */

public class Player {
    private final double SPEED = 5;
    private final double MAX_FALL = 20;
    private final double HEIGHT = 2;
    private final double WIDTH = 1;
    private final double MAX_PHASE = 5;

    private boolean isPhased;
    private boolean isFalling;
    private boolean isAlive;
    private int lives;
    private double v_hori;
    private double v_verti;
    private double coord_x;
    private double coord_y;
    private double jump_time;
    private double phase_time;
    private double jump_height_init;

    private HashMap<String, Controls> keyPresses;

    /**
     * Constructor for class Player to create Player objects
     * @param setKeyPresses Array of controls JUMP, LEFT, RIGHT, ACTIVATE PHASE
     * @param coord_x x-coordinate
     * @param coord_y y-coordinate
     */
    public Player(String setKeyPresses[], double coord_x, double coord_y) {

        // assign player keys to Controls value
        if (setKeyPresses.length != Controls.values().length)
            throw new IllegalArgumentException("Length of array of strings must match controls available to the player.\n");
        else{
            for (int i=0; i<setKeyPresses.length; i++)
                keyPresses.put(setKeyPresses[i], Controls.values()[i]);
        }

        // Players won't start out with ability or they'll fall through the ground lol
        isPhased = false;
        lives = 3;
        v_hori = 0;
        v_verti = 0;
        jump_time = 0;
        phase_time = 0;
        jump_height_init = 0;
        isAlive = true;
        isFalling = false;

        this.coord_x = coord_x;
        this.coord_y = coord_y;

    }

    /**
     * Update the state of the player after background calcs from existing data
     * @param curr_time current time of running system
     */
    public void updateState(double curr_time){

        double time = curr_time - jump_time;
        double gravity = 9.8;

        coord_x = coord_x + v_hori*time;
        if (isFalling)
            coord_y = coord_y + (v_verti*time - (0.5)*gravity*time*time);

        if (phase_time > MAX_PHASE)
            loseLife();
    }

    /**
     * Check state of the player
     * @param input input from the user
     * @param current_time current time
     */
    public void checkInput(String input, double current_time){

        switch (keyPresses.get(input)){
            case ACTIVATE_PHASE:
                if (isPhased) {
                    jump_height_init = coord_x;
                    phase_time = current_time;
                    phaseOn();
                }
                break;
            case GO_LEFT:
                if (v_hori >= -SPEED)
                    v_hori = -SPEED;
                break;
            case GO_RIGHT:
                if (v_hori <= +SPEED)
                    v_hori = +SPEED;
                break;
            case JUMP:
                jump_time = current_time;
                if (v_verti !=0)
                    v_verti = +2*SPEED;
                break;
            default:
                if (v_verti == 0) {
                    if (v_hori > 0)
                        v_hori--;
                    else if (v_hori < 0)
                        v_hori++;
                }
                phaseOff();
        }
    }

    /**
     * Method to check for collision with any set of points
     * @param points array of corner points (rectangle only)
     * @return boolean true if collision is detected
     */
    public boolean isColliding(double points[][]) {
        if (isPhased)
            return false;
        else {
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(new Double[]{
                    points[0][0], points[0][1],
                    points[1][0], points[1][1],
                    points[2][0], points[2][1],
                    points[3][0], points[3][1],
            });

            if (polygon.intersects(coord_x, coord_y, WIDTH, HEIGHT)) {
                loseLife();
                return true;
            } else
                return false;
        }
    }

    /**
     * Method to update the falling variable of the player
     * and ensure that the player has landed safely
     * @param points array of rectangle corner points
     */
    public void updateFalling(double points[][]) {
        // as long as you're phased you keep moving down
        if (isPhased)
            isFalling = true;

        else if ((points[0][0] - (coord_y + HEIGHT)) < 10){

            // player will lose life if jump is too much
            if ((points[0][0] - jump_height_init) >= MAX_FALL)
                loseLife();

            // stop falling
            v_verti = 0;
            isFalling = false;
        }
    }

    public boolean isAlive{
        return isAlive;
    }

    /**
     * What happens if the player has lost a life
     */
    private void loseLife(){
        lives--;
        if (lives<=0)
            isAlive = false;
    }

    /**
     * Switch on the ability to phase
     */
    private void phaseOn(){
        isPhased = true;
    }

    /**
     * Switch off the ability to phase
     */
    private void phaseOff(){
        isPhased = false;
    }

}

