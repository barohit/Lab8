import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InformationArray {

	public static void main(String[] args) {
		
		char ans = 'y'; 
		boolean infoCheck = false; 
		boolean continueCheck = false;
		Student [] studentCatalog = new Student[50]; 
		
		// note, the data is made up and does not reflect the truth about any individual  listed. 
		studentCatalog[0] = new Student("Rohit", 25, "Novi", "Pad Thai"); 
		studentCatalog[1] = new Student("Luke", 24, "Rochester", "Pizza"); 
		studentCatalog[2] = new Student("Finny", 33, "Warren", "Bread");
		studentCatalog[3] = new Student("Adam", 30, "Charlotte", "Cookies");
		studentCatalog[4] = new Student("Victoria", 25, "Detroit", "Chicken Wings"); 
		studentCatalog[5] = new Student("Devosha", 23, "Wayne", "Sushi"); 
		studentCatalog[6] = new Student("Flora", 42, "Gross Pointe", "Sandwiches");
		studentCatalog[7] = new Student("Melanie", 26, "Charlotte", "Tacos");
		studentCatalog[8] = new Student("Lin-Mei", 32, "Chicago", "Wendys"); 
		studentCatalog[9] = new Student("Laura", 45, "Northville", "Lo-Mein"); 
	
		
		
		
		
		System.out.println("Welcome to our Java class. Here we have an array of four students, which contains information about their name, age, hometown and favorite food "); 
		while (ans == 'y')  {
			infoCheck = false; 
			continueCheck = false; 
			
			System.out.println("Which student would you like to learn more about?"); 
			
			Scanner scan = new Scanner(System.in);
			String searchCatalog = scan.next(); 
			int desiredIndex = -1; 
			try {
				for (int i = 0; i < studentCatalog.length; i++) {
					if (studentCatalog[i].name.equalsIgnoreCase(searchCatalog)) {
						desiredIndex = i; 
					}
					
				}
			} catch (NullPointerException e) {  //  keeps the forloop going even if the student
				// is not here, that case will be handled with the outofbounds exception below. 
			}
			scan.nextLine(); //garbage line
			
			try {
			System.out.println("What would you like to know about " + studentCatalog[desiredIndex].name + "?"); 
			} catch (ArrayIndexOutOfBoundsException e) { // if the student's name is not in the
				//array, then  the desiredIndex will be -1,  thus throwing the outofbounds exception
				System.out.println("Sorry, that student does not exist. Please try again: "); 
				continue; 
			}
			System.out.println("enter age, hometown, or favorite food");
			
				
		while (infoCheck == false) {	
				String info = scan.nextLine(); 
				
				try {
					if (Pattern.matches("age*", info)) {
						infoCheck = true; 
						System.out.println("This person is: " + studentCatalog[desiredIndex].age + " years old");   
					} else if (Pattern.matches("hometown*", info)) {
						System.out.println("This person's hometown is : " + studentCatalog[desiredIndex].hometown); 
						infoCheck = true; 
					} else if (Pattern.matches("favorite\\sfood*", info)) {
						infoCheck = true; 
						System.out.println("This person's favorite food is: " + studentCatalog[desiredIndex].favoriteFood); 
					} else {
						IllegalArgumentException e = new IllegalArgumentException(); 
						throw e; 
					}
				} catch (IllegalArgumentException e) {
					System.out.println("Sorry, that data does not exist. Please try again. (enter 'hometown' or 'age' or 'favorite food'");
					continue; 
				}
		}		
		 
	
				System.out.println("Would you like to know more? Enter (y/n) for yes or no respectively"); 
				while (continueCheck == false) {
					try  {
						ans = Character.toLowerCase(scan.next().charAt(0)); 
						Exception e = new Exception(); 
						if (ans != 'y' && ans != 'n') {
							throw e; 
						} else {
							continueCheck = true; 
						}
					} catch (InputMismatchException e) {
						System.out.println("Sorry, wrong answer. Please enter y for yes, or n for no");
						ans = Character.toLowerCase(scan.next().charAt(0)); 
						continue; 
					}
					catch (Exception e) { // just in case they enter a string, but not the right input. 
						System.out.println("Sorry, invalid answer. Please enter y for yes, or n for no");
						ans = Character.toLowerCase(scan.next().charAt(0)); 
						continue; 
					}
					
					if (ans == 'n') {
						System.out.println("Thanks!"); 
						continue; 
					}
				}

		}
	
	}
}