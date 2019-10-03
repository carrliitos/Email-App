package emailapp;

import java.util.Scanner;

public class Email { // This is our class -- our blueprint/template
	// variable setup
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10; // we need to set the length of the password
	private String alternate_email;
	private String companysuffix = "salazarcompany.com";
	
	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName; // this kwd refers to the class level var
		this.lastName = lastName;
		
		// Call a method asking for the department -- return the department
		this.department = setDepartment();
		
		// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.print("\nYour password is: " + this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companysuffix;
	}
	
	// Ask for the department
	private String setDepartment() {
		System.out.print("New Employee: " + firstName + 
							"\nDepartment Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter Department Code:");
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		if (departmentChoice == 1) { return "Sales"; }
		else if (departmentChoice == 2) { return "Development"; }
		else if (departmentChoice == 3) { return "Accounting"; }
		else { return ""; }
		
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()"; // A set of chars we can choose from
		char[] password = new char[length];
		for (int i = 0; i < length; i++) { // for each value inside length, we're gonna grab a value inside the array, and we iterate that
			int rand = (int) (Math.random() * passwordSet.length()); // Math.random -- used to generate random passwords and is casted as an int and 
			//is multiplied by the length of the passwordSet
			password[i] = passwordSet.charAt(rand); // at the array password, at the position i, we want that to equal the 
			// passwordSet.charAt the random number
		}
		/*
		 *  once everything is generated, we return the password
		 *  and since the password is a set of characters, so we need to 
		 *  say that it is a new String()
		 */
		return new String(password);
	}
	
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) { this.mailboxCapacity = capacity; }
	
	// Set the alternate email
	public void setAlternateEmail(String altEmail) { this.alternate_email = altEmail; }
	
	// Change the password
	public void changePassword(String password) { this.password = password; }
	
	public int getMailboxCapacity() { return mailboxCapacity; }
	public String getAlternateEmail() { return alternate_email; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "\nDisplay Name:" + firstName + " " + lastName +
				"\nCompany Email: " + email +
				"\nMailbox Capacity: " + mailboxCapacity + "mb";
	}

}
