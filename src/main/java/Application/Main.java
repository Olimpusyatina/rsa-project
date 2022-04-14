package Application;

import RectangleTools.Rectangle;
import RectangleTools.Rectangles;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static Gson gson = new Gson();
    public static void main(String ... args){
        try {
            Rectangles rects = gson.fromJson(new FileReader(args[0]), Rectangles.class);
            Rectangle intersectionRectangle = rects.getRectangles().get(0);
            for (Rectangle current: rects.getRectangles()) {
                current.makeValid();
                intersectionRectangle = current.createIntersectRectangle(intersectionRectangle);
                if (intersectionRectangle == null) break;
            }
            makeAnswer(intersectionRectangle, args[1]);
            makeAnswer(rects.getRectangles().get(0), args[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void makeAnswer(Rectangle rectangle, String path) throws IOException {
        if (rectangle == null){
            FileWriter fw = new FileWriter(path);
            fw.write("empty");
            fw.close();
        }else{
            gson.toJson(rectangle, new FileWriter(path));
        }
    }
}
