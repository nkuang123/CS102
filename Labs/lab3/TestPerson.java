import java.util.*;

public class TestPerson {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner( System.in);
    
    System.out.println( "Please enter the last name of person 1: ");        // User input for first person
    String name1 = keyboard.next();
    System.out.println( "Please enter the age of person 1: ");
    int age1 = keyboard.nextInt();
    System.out.println( "Please enter the gender of person 1 (F/M/T): ");
    char gender1 = (keyboard.next().charAt(0));
    
    System.out.println( "Please enter the last name of person 2: ");        // User input for second person
    String name2 = keyboard.next();
    System.out.println( "Please enter the age of person 2: ");
    int age2 = keyboard.nextInt();
    System.out.println( "Please enter the gender of person 2 (F/M/T): ");
    char gender2 = (keyboard.next().charAt(0));
    
    Person person1 = new Person( name1, age1, gender1);          // Declaration/Instantialization of Person 1
    Person person2 = new Person( name2, age2, gender2);          // Declaration/Instantialization of Person 2
    
    System.out.println(person1.toString());  // Printing information of Person(s) 
    System.out.println(person2.toString());
    
    if ( person1.equals(person2)) {              // Runs the equal() method to check if two people are the same
      System.out.println( "Same person");
      Person.counter--;
    }
    else
      System.out.println( "Not same person");
    
    
    System.out.println( "Total people = " + Person.counter);   // Prints the total amount of people
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}