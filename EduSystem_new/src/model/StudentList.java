package model;

public class StudentList {
	private String name;
	private String id;
	private String age;
	private String gender;
	private String enrollmentY;
	private String politics;
	private String headTeacher;
	
	public StudentList(String name, String id, String age, String gender, String enrollmentY, String politics,
			String headTeacher) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.enrollmentY = enrollmentY;
		this.politics = politics;
		this.headTeacher = headTeacher;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEnrollmentY() {
		return enrollmentY;
	}

	public void setEnrollmentY(String enrollmentY) {
		this.enrollmentY = enrollmentY;
	}

	public String getPolitics() {
		return politics;
	}

	public void setPolitics(String politics) {
		this.politics = politics;
	}

	public String getHeadTeacher() {
		return headTeacher;
	}

	public void setHeadTeacher(String headTeacher) {
		this.headTeacher = headTeacher;
	}
	
	
	
}
