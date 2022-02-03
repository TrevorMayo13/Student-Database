package main;

import studentObject.ID;
import studentObject.Location;
import studentObject.Login;
import studentObject.Name;
import studentObject.Picture;
import studentObject.Registered;
import studentObject.dateOfBirth;

public class Student {
	private String gender;
	private Name name;
	private Location location;
	private String email;
	private Login login;
	private dateOfBirth dob;
	private Registered registered;
	private String phone;
	private String cell;
	private ID id;
	private String nat;
	private Picture picture;
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getNat() {
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public dateOfBirth getDob() {
		return dob;
	}

	public void setDob(dateOfBirth dob) {
		this.dob = dob;
	}

	public Registered getRegistered() {
		return registered;
	}

	public void setRegistered(Registered registered) {
		this.registered = registered;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public Picture getPicture() {
		return picture;
	}

	public void setPicture(Picture picture) {
		this.picture = picture;
	}


	public Student() {
	}

	@Override
	public String toString() {
		return "Student [gender=" + gender + ", name=" + name + ", location=" + location + ", email=" + email
				+ ", login=" + login + ", dob=" + dob + ", registered=" + registered + ", phone=" + phone + ", cell="
				+ cell + ", id=" + id + ", picture=" + picture + ", nat=" + nat + "]";
	}
}
