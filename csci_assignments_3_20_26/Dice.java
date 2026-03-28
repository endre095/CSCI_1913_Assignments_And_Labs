package csci_assignments_3_20_26;

import java.util.Random;

public class Dice {
    private int sidesNum = 6;
    private Random random = new Random();

    public Dice(int sidesNum) {
        this.sidesNum = sidesNum;
    }
    public int getSides() {
        return sidesNum;
    }
    public int roll() {
        return random.nextInt(sidesNum) + 1;
    }
}
    

