package org.example;

public abstract class Animal implements Countable {
    protected int count;

    public Animal() {
        count = 1;
    }

    // implement the countable interface
    @Override
    public String getCountString() {
        return count + " animal";
    }

    @Override
    public void incrementCount() {
        count++;
    }

    @Override
    public void resetCount() {
        count = 1;
    }

    @Override
    public int getCount() {
        return count;
    }

}
