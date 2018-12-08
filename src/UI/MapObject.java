package UI;

/**
 * Credit to JoshuaBradbury from Github
 */

import java.util.Map;
import UI.Vector2f;

public abstract class MapObject {

    private Map map;
    private Vector2f location;

    public abstract void render();

    public abstract void update();

    public abstract void init();

    public Vector2f getLocation() {
        return location;
    }

    public void setLocation(Vector2f location) {
        this.location = location;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Map getMap() {
        return map;
    }

}