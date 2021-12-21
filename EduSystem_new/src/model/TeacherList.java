package model;

public class TeacherList {
	private String name;
	private String age;
	private String gender;
	private String nation;
	private String politics;
	private String education;
	private String phone;
	
	public TeacherList(String name, String age, String gender, String nation, String politics, String education,
			String phone) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.nation = nation;
		this.politics = politics;
		this.education = education;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPolitics() {
		return politics;
	}

	public void setPolitics(String politics) {
		this.politics = politics;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
}
