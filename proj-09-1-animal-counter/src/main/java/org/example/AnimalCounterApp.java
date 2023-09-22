package org.example;

public class AnimalCounterApp {
    
    public static void main(String args[]) {
        countAlligators();
        countSheep();
    }

    public static void countAlligators() {
        System.out.println("Counting alligators...\n");

        // create an Alligator object
        Alligator gator = new Alligator();

        // use the count method to count the Alligator object
        // a specified number of times
        count(gator, 3);
    }

    public static void countSheep() {
        System.out.println("Counting sheep...\n");

        // create a Sheep object and set some initial values
        Sheep blackie = new Sheep();
        blackie.setName("Blackie");

        // use the count method to count Blackie 2 times
        count(blackie, 2);

        // make a clone of Blackie
        Sheep dolly = null;
        try {
            dolly = (Sheep) blackie.clone();
            
            // change the name of the clone to Dolly
            dolly.setName("Dolly");
            
            // count Dolly 3 times
            count(dolly, 3);
        } catch(CloneNotSupportedException e) {
            System.out.println("Unable to clone: " + e.getMessage());
        }

        // count Blackie again 1 time
        count(blackie, 1);
    }
    
    public static void count(Countable c, int maxCount) {
        c.resetCount();
        while (c.getCount() <= maxCount) {
            System.out.println(c.getCountString());
            c.incrementCount();
        }
        System.out.println();
    }
    
}
