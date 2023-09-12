package Entity;

public class ClassBean {
	private int id;
	private String name;

	public ClassBean() {
		super();
	}

	public ClassBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "ClassBean [id=" + id + ", name=" + name + "]";
	}
	

}
