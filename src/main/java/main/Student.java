package main;

public class Student {

    // Setup All Variables (Can even be public for easier access)
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String country;
    private int postCode;
    private String dob;
    private int age;
    private String gender;
    // ...etc
    
    // -----------------------------------------------------------------

    // Constructor
    public Student(String first, String last, String street, String city, String state, String country,
            int postCode, String dob, int age, String gender) {
        
        this.firstName = first;
        this.lastName = last;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postCode = postCode;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
    }
    
    // -----------------------------------------------------------------
    
    // Getters
    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }

    // -----------------------------------------------------------------
    
    // Setters
    public void setFirstName(String name) {
        this.firstName = name;
    }
    
    public void setName(String name) {
        this.lastName = name;
    }
    
}