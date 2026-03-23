package csci_assignments_3_20_26;

import java.util.Random;

public class BiasedDice extends Dice{
    private double bias = 0.234765;
    private int sideFavored = 5;
    private Random random;

    public BiasedDice(int sides) {
        super(sides);
        }

    public void setFavored(int favored, double bias) {
        this.bias = bias;
        this.sideFavored = favored;
    }

    public int getFavored() {
        return this.sideFavored;
    }

    public void setFavored(int favored){
        this.sideFavored = favored;
    }

    public double getBias() {
        return this.bias;
    }

    public void setBias(int bias){
        this.bias = bias;
    } 

    public int roll() {
        if (random.nextDouble() < this.bias) {
            return this.sideFavored;
        }
        int currentDie = random.nextInt(getSides()) + 1;
        while (currentDie == this.sideFavored) {
            currentDie = random.nextInt(getSides()) + 1;
        }
        return currentDie;
    }
}

