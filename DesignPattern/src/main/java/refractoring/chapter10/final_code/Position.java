package refractoring.chapter10.final_code;

public class Position {
    public int x;
    public int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void relativeMove(int dx, int dy) {
        x += dx;
        y += dy;
    }
}