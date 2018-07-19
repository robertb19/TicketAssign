public class Coordinates {

    private int x;
    private int y;

    public Coordinates(){

    }

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setEventCoordinates(String[] eventInput){
        this.x = Integer.parseInt(eventInput[1]);
        this.y = Integer.parseInt(eventInput[2]);
    }

    public void setBuyerCoordinates(String[] eventInput){
        this.x = Integer.parseInt(eventInput[0]);
        this.y = Integer.parseInt(eventInput[1]);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static int calculateManhattanDistance(int x1, int y1, int x2, int y2)    {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
