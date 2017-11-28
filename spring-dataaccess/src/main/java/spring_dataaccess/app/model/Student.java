package spring_dataaccess.app.model;

public class Student {
	private int id;
	private String name;
	private String email;
	private int gender;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

}
