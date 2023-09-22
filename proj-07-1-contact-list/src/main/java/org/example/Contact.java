package org.example;

public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    // empty constructor
    public Contact() {
    }

    public Contact(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void displayContact() {
        System.out.println("--------------------------------------------");
        System.out.println("---- Current Contact -----------------------");
        System.out.println("--------------------------------------------");
        System.out.println("Name:\t\t\t" + firstName + " " + lastName);
        System.out.println("Email Address:\t" + email);
        System.out.println("Phone Number:\t" + phone);
        System.out.println("--------------------------------------------");
    }
}
