package composite.improved;


import java.util.ArrayList;
import java.util.List;

public class GraphicItemGroup implements Graphic {
    // Here is the composition --> reference to the objects
    private List<Graphic> graphics = new ArrayList<Graphic>();

    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }

    public List<Graphic> getGraphics() {
        return graphics;
    }
}
