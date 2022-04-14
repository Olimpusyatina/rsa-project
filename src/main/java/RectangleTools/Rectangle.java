package RectangleTools;

import com.google.gson.Gson;

// TODO заменить координаты на точки

public class Rectangle {
    private Double x1, x2, y1, y2;


    public Rectangle(double x1, double y1, double x2, double y2) {
        setX1(x1);
        setY2(y2);
        setX2(x2);
        setY1(y1);
    }

    private void normalizeAxis(){
        Double cordTmp = getX1();
        if (getX1() > getX2()){
            setX1(getX2());
            setX2(cordTmp);
        }
        if (getY1() > getY2()){
            cordTmp = getY1();
            setY1(getY2());
            setY2(cordTmp);
        }
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public Double getY1() {
        return y1;
    }

    public void setY1(Double y1) {
        this.y1 = y1;
    }

    public Double getY2() {
        return y2;
    }

    public void setY2(Double y2) {
        this.y2 = y2;
    }

    public Rectangle createIntersectRectangle(Rectangle rectangle){
        double x1 = Math.max(getX1(), rectangle.getX1());
        double y1 = Math.max(getY1(), rectangle.getY1());
        double x2 = Math.min(getX2(), rectangle.getX2());
        double y2 = Math.min(getY2(), rectangle.getY2());
        if (x2 - x1 < 0 || y2 - y1 < 0) return null;
        return new Rectangle(x1, y1, x2, y2);
    }

    public void makeValid() throws Exception {
        if (getX1() == null || getX2() ==null || getY1() == null || getY2() == null) throw new Exception("There is invalid rectangle with points: " + new Gson().toJson(this));
        normalizeAxis();
    }
}
