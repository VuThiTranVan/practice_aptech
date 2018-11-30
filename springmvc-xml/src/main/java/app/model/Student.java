package app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "student_tbl")
public class Student {
	private Integer id;
	private String name;
	private String email;
	private int gender;
	private Address address;

	public Student() {
		super();
	}

	public Student(String name, String email, int gender) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public Student(int id, String name, String email, int gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	@Size(max = 50, min = 2, message = "{student.name.invalid}")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email", length = 150, unique = true)
	@Email(message = "{student.email.invalid}")
	@NotBlank(message = "{student.email.notNull}")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "gender")
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@OneToOne
	@JoinColumn(name = "id_address")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void display() {
		System.out.println("Sudent Infor:");
		System.out.println("\t Id: " + getId());
		System.out.println("\t Name: " + getName());
		System.out.println("\t Email: " + getEmail());
		System.out.println("\t Gender: " + getGender());
		System.out.println("**** =++++= ****");

	}

}
