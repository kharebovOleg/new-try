public class Tank {

    static final String MODEL = "T34";
    static int nTanks;

    private int x, y;
    private int dir;
    private int fuel;
    private int tankCount;

    public Tank() {
        this(0, 0, 100);
    }

    public Tank(int x, int y) {
        this(x, y, 100);
    }

    public Tank(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        this.fuel = fuel;
        tankCount = ++nTanks;
    }

    public void goForward(int i) {
        if (fuel - i > 0) {
            if (dir == 0) x += i;
            else if (dir == 1) y += i;
            else if (dir == 2) x -= i;
            else y -= i;
            fuel -= i;
        } else {
            i = fuel;
            if (dir == 0) x += i;
            else if (dir == 1) y += i;
            else if (dir == 2) x -= i;
            else y -= i;
            fuel = 0;
        }
    }

    public void printPosition() {
        System.out.println("The Tank " + MODEL + "-" + tankCount + " is at " + x +", " + y + " now.");
    }

    public void turnLeft() {
        dir--;
        if (dir == -1) dir = 3;
    }

    public void turnRight() {
        dir++;
        if (dir == 4) dir = 0;
    }

    public void goBackward(int i) {
        goForward(-i);
    }


}
