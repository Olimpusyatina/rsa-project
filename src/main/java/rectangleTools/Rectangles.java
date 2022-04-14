package rectangleTools;

import java.util.ArrayList;
import java.util.List;

public class Rectangles {
    private List<Rectangle> rects;

    public Rectangles(){
        rects = new ArrayList<>();
    }
    public Rectangles(Rectangle rectangle){
        rects = new ArrayList<>();
        rects.add(rectangle);
    }
    public List<Rectangle> getRectangles() {
        return rects;
    }

    public void setRectangles(List<Rectangle> rectangles) {
        this.rects = rectangles;
    }
}
