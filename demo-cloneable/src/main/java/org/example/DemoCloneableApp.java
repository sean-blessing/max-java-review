package org.example;

public class DemoCloneableApp {
    public static void main(String[] args) {
        System.out.println("Create some contacts!");

        Contact c1 = new Contact("Joe","Smith", "joe@test.com", "111-111-1111");
        System.out.println(c1);

        try {
            Contact copyC1 = (Contact)c1.clone();
            copyC1.setFirstName("Jennifer");
            System.out.println(c1);
            System.out.println(copyC1);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Bye");
    }
}