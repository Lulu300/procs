package models;

public class Group {
	
	public int id;
	public String name;
	private int version;
	
	public Group() {}

	public Group(int idgroup) {
		this.id = idgroup;
	}
	
	public Group(int idgroup, String name) {
		this.id = idgroup;
		this.name = name;
	}
	
	public Group(String name) {
		this.id = -1;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int idgroup) {
		this.id = idgroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + "]";
	}
	
}
