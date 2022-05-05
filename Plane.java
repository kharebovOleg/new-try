public class Plane {
    static final int FUELMAX = 700;

    private int x, y, z;
    private int dir;
    private int fuel;

    public Plane () {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.fuel = 100;
    }

    public Plane(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.fuel = 100;
    }

    public Plane(int x, int y, int z, int fuel) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.fuel = fuel;
    }

    public void flyStraight(int i) {
        if (fuel - i > 0) {
            direction(i);
            fuel -= i;
        } else {
            i = fuel;
            direction(i);
            fuel = 0;
        }
        String result = String.format("Вы пролетели прямо и сейчас находитесь на координатах: x= %s, y= %s. Топлива осталось= %s", x, y, fuel);
        System.out.println(result);
    }

    public void flyUp(int i, int j) {
        int sum = Math.abs(j) + i;
        if (sum < fuel) {
            direction(i);
            z += j;
        } else {
            System.out.println("не хватает топлива.");
        }
        String result = String.format("Вы пролетели прямо и сейчас находитесь на координатах: x= %s, y= %s, z= %s. Топлива осталось= %s", x, y, z, fuel);
        System.out.println(result);
    }

    public void flyDown(int i, int j) {
        flyUp(i, -j);
        if (z == 0) System.out.println("Самолет приземлился)))");
        else if (z <= 0) System.out.println("Самолет разбился((");
        else System.out.println("Вы опустились ниже и сейчас находитесь на координатах: x= 240, y= 20, z= 80. Топлива осталось= " + fuel);
    }

    private void direction(int i) {
        if (dir == 0) x += i;
        else if (dir == 1) y += i;
        else if (dir == 2) x -= i;
        else y -= i;
    }

    public void dropBomb() {
        System.out.println("The bomb dropped at " + x +", " + y + ", " + z + ".");
    }

    public void turnLeft() {
        dir--;
        if (dir == -1) dir = 3;
        System.out.println("вы повернули налево");
    }

    public void turnRight() {
        dir++;
        if (dir == 4) dir = 0;
        System.out.println("вы повернули направо");
    }

    public void goBackward(int i) {
        flyStraight(-i);
    }

    public void fillFuel() {
        if (z == 0) {
            fuel = FUELMAX;
            System.out.println("Вы заправились. Сейчас топлива= " + fuel);
        }
        else System.out.println("Нельзя заправляться в воздухе");
    }

}
