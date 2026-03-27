package at.daude.Physik;

public class Hitbox {
    private double x, y, width, height;

    public Hitbox(double x, double y,double width,double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean intersects(Hitbox other){
        return  this.x < other.x + other.width &&
                this.x + this.width > other.x &&
                this.y < other.y + other.height &&
                this.y + this.height > other.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void addToX(double a){
        this.x += a;
    }

    public double getY(){
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void addToY(double a){
        this.y += a;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
