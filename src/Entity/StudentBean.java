package Entity;

public class StudentBean {
	private int id;
	private String name;
	private int classId;
	private float marks;
	private char gender;
	private int age;

	public StudentBean() {
		// TODO Auto-generated constructor stub
	}

	public StudentBean(int id, String name, int classId, float marks, char gender, int age) {
		super();
		this.id = id;
		this.name = name;
		this.classId = classId;
		this.marks = marks;
		this.gender = gender;
		this.age = age;
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

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "StudentBean [id=" + id + ", name=" + name + ", classId=" + classId + ", marks=" + marks + ", gender="
				+ gender + ", age=" + age + "]";
	}

}
