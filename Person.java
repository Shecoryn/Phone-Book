//Shecory'n Porter
public class Person implements Comparable<Person> {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	//Makes constructor for the object
	public Person(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	//Following methods are getters and setter methods
	public void setFirst(String first) {
		firstName = first;
	}
	public String getFirst() {
		return firstName;
	}
	public void setLast(String last) {
		lastName = last;
	}
	public String getLast() {
		return lastName;
	}
	public void setNumber(String number) {
		phoneNumber = number;
	}
	public String getNumber() {
		return phoneNumber;
	}
	//Makes a toString method that displays a generic String of a Person object
	public String toString() {
		return firstName + " " + lastName + " " + phoneNumber;
	}
	//Used for sorting the object Person in program. Will always have sorted by last
	//name output when records are displayed
	public int compareTo(Person o) {
		int i;
		if(lastName.compareTo(o.lastName) == 0) {
		    i = firstName.compareTo(o.firstName);
		} else {
			i = lastName.compareTo(o.lastName);
		}
		return i;
	}
}