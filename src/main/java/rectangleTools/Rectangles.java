package rectangleTools;

import java.util.ArrayList;
import java.util.List;

public class Rectangles {
    private List<Rectangle> rects;

    public Rectangles(){
        rects = new ArrayList<Rectangle>();
    }
    public Rectangles(Rectangle rectangle){
        rects = new ArrayList<Rectangle>();
        rects.add(rectangle);
    }
    public List<Rectangle> getRectangles() {
        return rects;
    }

    public void setRectangles(List<Rectangle> rectangles) {
        this.rects = rectangles;
    }
}
