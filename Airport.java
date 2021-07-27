
public class Airport {

	private String city;
	private String country;
	private String funFact;
	private String name;
	
	public Airport(String[] info) {
		
		this.name = info[0].trim();
		this.city = info[1].trim();
		this.country = info[2].trim();
		this.funFact = info[3].trim();
		
	}
	
	public String getName() {
		
		return name;
	}
	
	public String getCity() {
		
		return city;
	}
	
	
	public String getLocation() {
		
		return city + ", " + country;
	}
	
	public String getFact() {
		return funFact;
	}
	
	
	
	
	
	
	
}
