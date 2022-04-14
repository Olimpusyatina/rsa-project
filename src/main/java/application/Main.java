package application;

import rectangleTools.Rectangle;
import rectangleTools.Rectangles;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Main {

    static final Gson gson = new Gson();
    public static void main(String[] args) throws Exception {
        if (args.length < 2) throw new Exception("There is not 2 arguments!!! Don't make it again!");
        try {
            Rectangles rects = gson.fromJson(new FileReader(args[0]), Rectangles.class);
            Rectangle intersectionRectangle = rects.getRectangles().get(0);
            for (Rectangle current: rects.getRectangles()) {
                current.makeValid();
                intersectionRectangle = current.createIntersectRectangle(intersectionRectangle);
                if (intersectionRectangle == null) break;
            }
            makeAnswer(intersectionRectangle, args[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void makeAnswer(Rectangle rectangle, String path) throws IOException {
        Writer writer = new FileWriter(path);
        if (rectangle == null){
            writer.write("empty");
        }else{
            Rectangles rects = new Rectangles(rectangle);
            gson.toJson(rects, writer);
        }
        writer.close();
    }
}
