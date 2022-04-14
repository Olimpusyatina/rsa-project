package interfaces;

import rectangleTools.Rectangle;

public interface RectangleInterface {
    void normalizeAxis();
    Rectangle createIntersectRectangle(Rectangle rectangle);
    void makeValid() throws Exception;
}
