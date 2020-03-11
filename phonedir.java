//Shecory'n Porter
//1. A phone directory that a user can use to manipulate data in.
//2. Sorting algorithms
//3. LinkedList.
//4. You look at the menu that is displayed when you run the program and you select
//the corresponding letter right of the command and type that letter in when the
//program asks you to.
//5.The phonedir class holds all of the methods and code needed to operate the
//program. The Person class just creates an object that stores the first name,
//last name, and phone number so that i can just store all of that data for each
//record in the LinkedList
//(Method explainations by each method respective to their classes below
//and in Person class)
import java.util.*;
public class phonedir {
	private static LinkedList<Person> records = new LinkedList<Person>();
	//This counter is used to manipulate the current record
	private static int counter;
	//This boolean value determines if the program will continue to run or not
	//(Q method)
	private static boolean cont = true;
	public static void main(String []args) {
		Scanner scan = new Scanner(System.in);
		while(cont) {
			menu();
			System.out.println("Enter a command from the list above (q to quit):");
			String option = scan.next();
			switch(option) {
			case "a": A();
				break;
			case "d": D();
				break;
			case "f": F();
				break;
			case "l": L();
				break;
			case "n": N();
				break;
			case "p": P();
				break;
			case "q": Q();
				break;
			case "s": S();
				break;
			default: System.out.println("Illegal command.");
			}
		}
		
	}
	//Displays menu
	public static void menu() {
		System.out.println("\ta\tShow all records");
		System.out.println("\td\tDelete the current record");
		System.out.println("\tf\tChange the first name in the current record");
		System.out.println("\tl\tChange the last name in the current record");
		System.out.println("\tn\tAdd a new record");
		System.out.println("\tp\tChange the phone number in the current record");
		System.out.println("\tq\tQuit");
		System.out.println("\ts\tSelect a record from the record list to become the current record");
	}
	//Show all records
	public static void A() {
		if(records.isEmpty()) {
			System.out.println("Records are empty");
		} else {
			System.out.println("First Name\tLast Name\tPhone Number");
			for(int i = 0; i < records.size(); i++) {
				System.out.println(records.get(i).getFirst() + "\t\t" + records.get(i).getLast() + "\t\t" + records.get(i).getNumber());
			}
		}
	}
	//Delete the current record
	public static void D() {
		if(records.isEmpty()) {
			System.out.println("No current record");
		} else {
			if(counter != -1) {
				System.out.println("Deleted: "+ records.get(counter));
				records.remove(counter);
				counter = -1;
			} else {
				System.out.println("Their is no current directory.");
			}
		}
		Collections.sort(records);
	}
	//Change the first name in the current record
	public static void F() {
		Scanner input = new Scanner(System.in);
		System.out.println("Type in new first name");
		String newFirstName = input.next();
		if(counter != -1) {
			records.get(counter).setFirst(newFirstName);
		} else {
			System.out.println("Their is no current directory.");
		}
	}
	//Change the last name in the current record
	public static void L() {
		Scanner input = new Scanner(System.in);
		System.out.println("Type in new last name");
		String newLastName = input.next();
		if(counter != -1) {
			records.get(counter).setLast(newLastName);
		} else {
			System.out.println("Their is no current directory.");
		}
		Collections.sort(records);
	}
	//Add a new record
	public static void N() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first name: ");
		String first = input.next();
		System.out.println("Enter last name: ");
		String last = input.next();
		System.out.println("Enter phone number with dashes: ");
		String number = input.next();
		Person pers = new Person(first, last, number);
		records.add(pers);
		counter = records.indexOf(pers);
		System.out.println("Current record is: " + pers.toString());
		Collections.sort(records);
	}
	//Change the phone number in the current record
	public static void P() {
		Scanner input = new Scanner(System.in);
		System.out.println("Type in new phone number (add dashes in the number)");
		String newPhoneNumber = input.next();
		records.get(counter).setNumber(newPhoneNumber);
	}
	//Exits the command loop by changing the cont value to false
	public static void Q() {
		cont = false;
	}
	//Changes current record to what ever name the user inputs that is present
	//in the linkedlist
	public static void S() {
		Scanner input = new Scanner(System.in);
		boolean isFound = false;
		A();
		System.out.println("Enter first name: ");
		String first = input.next();
		System.out.println("Enter last name: ");
		String last = input.next();
		for(int i = 0; i < records.size(); i++) {
			if(first.equalsIgnoreCase(records.get(i).getFirst()) && last.equalsIgnoreCase(records.get(i).getLast())) {
				counter = i;
				System.out.println("Current record is: " + records.get(i).toString());
				isFound = true;
			} 
		}
		if(isFound == false) {
			System.out.println("No matching record is found.");
		}
	}
}
