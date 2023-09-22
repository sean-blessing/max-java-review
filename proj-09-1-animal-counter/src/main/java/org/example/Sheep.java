package org.example;

public class Sheep extends Animal implements Cloneable
{
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String getCountString() {
        return count + " " + name;
    }

    // implement the clonable interface
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}