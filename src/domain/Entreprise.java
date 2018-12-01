package domain;

import java.util.Set;

public class Entreprise extends Contact {
	public String numsiret;
	public String name;
	
	
	public Entreprise(int id, String lastName, String firstName, String email, Address address, Set<PhoneNumber> phoneNumbers, Set<Group> groups, String numsiret, String name) {
		super(id, lastName, firstName, email, address, phoneNumbers, groups);
		this.numsiret = numsiret;
		this.name = name;
	}
	
	public Entreprise(String lastName, String firstName, String email, Address address, Set<PhoneNumber> phoneNumbers, Set<Group> groups, String numsiret, String name) {
		super(lastName, firstName, email, address, phoneNumbers, groups);
		this.numsiret = numsiret;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumsiret() {
		return numsiret;
	}

	public void setNumsiret(String numsiret) {
		this.numsiret = numsiret;
	}

	@Override
	public String toString() {
		return "Entreprise [id=" + id + ", numsiret=" + numsiret + ", name=" + name + "]";
	}
	
}
