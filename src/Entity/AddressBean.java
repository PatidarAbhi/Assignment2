package Entity;

public class AddressBean {
	private int id;
	private String pinCode;
	private String city;
	private int studentId;

	public AddressBean() {
	}

	public AddressBean(int id, String pinCode, String city, int studentId) {
		super();
		this.id = id;
		this.pinCode = pinCode;
		this.city = city;
		this.studentId = studentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "AdressBean [id=" + id + ", pinCode=" + pinCode + ", city=" + city + ", studentId=" + studentId + "]";
	}

}
