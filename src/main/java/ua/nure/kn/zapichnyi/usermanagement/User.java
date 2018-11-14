package ua.nure.kn.zapichnyi.usermanagement;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6717250521035517564L;
	private long id;
	private String firstName;
    private String lastName;
    private Date dateOfBirth;
	public User() {
		
	}
	public User(long l, String string, String string2, Date parse) {
      id=l;
      firstName=string;
      lastName=string2;
      dateOfBirth=parse;
	}
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getFullName(){
		StringBuilder sb = new StringBuilder();
		sb.append(lastName).append(", ").append(firstName);
		return sb.toString();
		
	}
	public int getAge(){
	SimpleDateFormat sd=new SimpleDateFormat("dd-MM-yyyy");
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	LocalDate now = LocalDate.now();
	LocalDate birth=LocalDate.parse(sd.format(dateOfBirth),formatter);
	Period between = Period.between(birth, now);
		return between.getYears();
	}
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + "]";
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}    
	
	
}
	