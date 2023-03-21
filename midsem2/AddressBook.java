import java.util.ArrayList;

class Person {
    // Fields for first name, last name and person id
    private String firstName;
    private String lastName;
    private String personId;

    // Constructor with parameters
    public Person(String firstName, String lastName, String personId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personId = personId;
    }

    // Getters and setters for the fields
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    // toString method to display the person information
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personId='" + personId + '\'' +
                '}';
    }
}

public class AddressBook {

    // Field for a list of Person objects
    private ArrayList<Person> list;

    // Constructor that initializes the list field
    public AddressBook() {
        list = new ArrayList<>();
    }

    // Add method that takes a Person object and adds it to the list field
    public void add(Person p) {
        list.add(p);
    }

    // Delete method that takes a Person object and removes it from the list field
    // if it exists
    public void delete(Person p) {
        list.remove(p);
    }

    // Search method that takes either a first name, last name or person id as a
    // parameter
    // and returns a list of Person objects that match the given criteria
    public ArrayList<Person> search(String s) {

        // Create an empty list to store the matching persons
        ArrayList<Person> result = new ArrayList<>();

        // Loop through the list field and compare each Person object with the given
        // parameter
        for (Person p : list) {

            // If the first name, last name or person id matches the parameter, add it to
            // the result list
            if (p.getFirstName().equals(s) || p.getLastName().equals(s) || p.getPersonId().equals(s)) {

                result.add(p);

            }
        }

        // Return the result list
        return result;

    }

    public static void main(String[] args) {
        // Create an AddressBook object called ab
        AddressBook ab = new AddressBook();
        // Create some Person objects with different information and add them to ab
        // using the add method
        Person p1 = new Person("Alice", "Smith", "001");
        Person p2 = new Person("Bob", "Jones", "002");
        Person p3 = new Person("Charlie", "Brown", "003");
        Person p4 = new Person("David", "Green", "004");
        Person p5 = new Person("Eve", "White", "005");

        ab.add(p1);
        ab.add(p2);
        ab.add(p3);
        ab.add(p4);
        ab.add(p5);

        // Print the list of persons in ab using a loop and the toString method
        System.out.println("The list of persons in address book:");
        for (Person p : ab.list) {
            System.out.println(p.toString());
        }

        // Delete some persons from ab using the delete method and print the updated
        // list
        System.out.println("\nDeleting Bob Jones and Eve White from address book:");

        ab.delete(p2);
        ab.delete(p5);

        System.out.println("\nThe updated list of persons in address book:");
        for (Person p : ab.list) {
            System.out.println(p.toString());
        }

        // Search for some persons in ab using the search method with different
        // parameters and print the results
        System.out.println("\nSearching for Alice Smith by first name:");
        ArrayList<Person> result1 = ab.search("Alice");
        for (Person p : result1) {
            System.out.println(p.toString());
        }

        System.out.println("\nSearching for Brown by last name:");
        ArrayList<Person> result2 = ab.search("Brown");
        for (Person p : result2) {
            System.out.println(p.toString());
        }

        System.out.println("\nSearching for 004 by person id:");
        ArrayList<Person> result3 = ab.search("004");
        for (Person p : result3) {
            System.out.println(p.toString());
        }
    }
}
