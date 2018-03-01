package nmfs.json;
import com.google.gson.Gson;
public class GSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gson g = new Gson();

		Person person = g.fromJson("{\"name\": \"John\"}", Person.class);
		System.out.println(person.name); //John

		System.out.println(g.toJson(person)); // {"name":"John"}
	}

	private class Person {
	    public String name;

	    public Person(String name) {
	        this.name = name;
	    }
	}
}

