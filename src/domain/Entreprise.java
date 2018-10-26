package domain;

public class Entreprise 
{
	public int id;
	public String numsiret;
	public String name;
	
	public Entreprise(int id)
	{
		this.id = id;
		this.numsiret = "";
		this.name = "";
	}
	
	public Entreprise(int id, String numsiret, String name)
	{
		this.id = id;
		this.numsiret = numsiret;
		this.name = name;
	}
	
	public Entreprise(String numsiret, String name)
	{
		this.id = -1;
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
	
}
