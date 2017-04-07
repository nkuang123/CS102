public class Person {
  String lastName;                    // Declaration/Instantialization of Person fields
  int age;
  char gender;
  int idNumber;
  static int counter = 0;
  
  Person( String str, int n, char x) {             // Person Constructor 
    this.lastName = str;
    this.age = n;
    this.gender = x;
    counter++;
    this.idNumber = counter;
  }
  
  public String getLastName() {            // Getter: lastName
    return lastName;
  }
  
  public int getAge() {                    // Getter: age
    return age;
  }
  
  public char getGender() {                // Getter: gender 
    return gender;
  }
  
  public int getIdNumber() {               // Getter: idNumber
    return idNumber;
  }
  
  public boolean equals( Person prsn) {     // Method that checks if two people are the same
    return ((lastName.equals(prsn.lastName)) && (age == prsn.age) && (gender == prsn.gender));

  }
  
  public String toString() {    // Prints out the information of a person
    return ("Person " + idNumber + ":\t" + lastName + "\t" + age + "\t" + gender);
  }
  
  
  
  
  
  
  
}
  
  
  