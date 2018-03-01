package nmfs.spring.beans;

public class Car implements Vehicle {

	private String made;

	public void setMade(String made) {
		this.made = made;
	}
	public String getModel() {
		// TODO Auto-generated method stub
		return "Car - made by "+this.made;
	}

}
