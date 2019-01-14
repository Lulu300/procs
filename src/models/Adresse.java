package models;

public class Adresse {
	
	public int id;
	public String street;
	public String city;
	public String zip;
	public String country;
	private int version;
	
	public Adresse() {}

	public Adresse(int id) {
		this.id = id;
		this.street = "NULL";
		this.city = "NULL";
		this.zip = "NULL";
		this.country = "NULL";
	}
	
	public Adresse(int id, String street, String city, String zip, String country) {
		this.id = id;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}
	
	public Adresse(String street, String city, String zip, String country) {
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", street=" + street + ", city=" + city + ", zip=" + zip + ", country=" + country
				+ "]";
	}
	
}
