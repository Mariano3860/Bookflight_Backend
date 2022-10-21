package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
public class Passenger {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationality", nullable = false)
	private String nationality;

	@Column(name = "age", nullable = false)
	private String age;

	@Column(name = "luggage", nullable = false)
	private int luggage;

	@Column(name = "bookId", nullable = false)
	private long bookId;

	public Passenger() {
	}

	public Passenger(int id, String firstName, String lastName, String nationality, String age, int luggage, long bookId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationality = nationality;
		this.age = age;
		this.luggage = luggage;
		this.bookId = bookId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getLuggage() {
		return luggage;
	}

	public void setLuggage(int luggage) {
		this.luggage = luggage;
	}


}
