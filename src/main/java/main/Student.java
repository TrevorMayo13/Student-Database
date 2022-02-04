package main;

public class Student {

    // Setup All Variables (Can even be public for easier access)
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String country;
    private long postCode;
    private String dob;
    private long age;
    private String gender;
    // ...etc
    
    // -----------------------------------------------------------------

    // Constructor
    public Student(String first, String last, String street, String city, String state, String country,
            long postCode, String dob, long age, String gender) {
        
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
    
    @Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", postCode=" + postCode + ", dob=" + dob + ", age="
				+ age + ", gender=" + gender + "]";
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getPostCode() {
		return postCode;
	}

	public void setPostCode(long postCode) {
		this.postCode = postCode;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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