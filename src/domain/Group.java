package domain;

import java.io.Serializable;

public class Group implements Serializable {

	public long id;
	public String name;
	public long version;
	
	public Group(long id)
	{
		this.id = id;
		this.name = "";
	}
	
	public Group(String groupName)
	{
		this.id = -1;
		this.name = groupName;
	}
	
	public Group(long id, String groupName)
	{
		this.id = id;
		this.name = groupName;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String groupName) {
		this.name = groupName;
	}
}
