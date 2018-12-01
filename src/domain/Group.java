package domain;

import java.io.Serializable;

public class Group implements Serializable {

	private static final long serialVersionUID = -2594594472505624951L;
	public int id;
	public String groupName;
	public long version;
	
	public Group(int id)
	{
		this.id = id;
		this.groupName = "";
	}
	
	public Group(String groupName)
	{
		this.id = -1;
		this.groupName = groupName;
	}
	
	public Group(int id, String groupName)
	{
		this.id = id;
		this.groupName = groupName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
}
