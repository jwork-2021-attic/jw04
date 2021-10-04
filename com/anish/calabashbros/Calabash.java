package com.anish.calabashbros;

import java.awt.Color;

public class Calabash extends Creature implements Comparable<Calabash> {

    private int rank;

    public Calabash(Color color, int rank, World world) {
        super(color, (char) 2, world);
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    @Override 
    public String toString(){
        return String.valueOf(this.rank);
    }

    public static final Calabash C1 = new Calabash(new Color(204, 0, 0), 1, null);
    public static final Calabash C2 = new Calabash(new Color(255, 165, 0), 2, null);
    public static final Calabash C3 = new Calabash(new Color(252, 233, 79), 3, null);
    public static final Calabash C4 = new Calabash(new Color(78, 154, 6), 4, null);
    public static final Calabash C5 = new Calabash(new Color(50, 175, 255), 5, null);
    public static final Calabash C6 = new Calabash(new Color(114, 159, 207), 6, null);
    public static final Calabash C7 = new Calabash(new Color(173, 127, 168), 7, null);

    @Override
    public int compareTo(Calabash o) {
        return Integer.valueOf(this.rank).compareTo(Integer.valueOf(o.rank));
    }

    public void swap(Calabash another) {
        int x=this.getX();
        int y = this.getY();
        this.moveTo(another.getX(), another.getY());
        another.moveTo(x, y);
    }

}
