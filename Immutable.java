package all;

import java.util.Date;

/* 1. Class must be declared as final (So that child classes can’t be created)
 • 2. Data members in the class must be declared as final (So that we can’t change the value of it after object creation)
 • 3. A parameterized constructor
 • 4. Getter method for all the variables in it
 • 5. No setters 
 */
public final class Immutable {  
	private final String id;
	private final String name;
	private final Date dob;
	
	public Immutable(String id, String name, Date birthDate) {
		this.id = id;
		this.name = name;
		this.dob = birthDate;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Date getDob() {
		return (Date)dob.clone();
	}
	
	public static void main(String[] args) {
		Immutable immutable = new Immutable("1", "Joe", new Date());
	}

}
