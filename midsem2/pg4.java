import java.util.*;;
interface customer {
    void information(); // To get the employee information

    void show(); // To display the employee information

    double tax_rate = 0.05; // To maintain the tax rate as a constant
}

// Define the employee class that implements customer interface
class employee implements customer {
    String name; // To store the name of the employee
    double income; // To store the income of the employee
    double tax; // To store the tax of the employee

    // Implement the information method to get input from user
    public void information() {
        Scanner sc = new Scanner(System.in); // Create a scanner object
        System.out.println("Enter your name: ");
        name = sc.nextLine(); // Read the name from user input
        System.out.println("Enter your income: ");
        income = sc.nextDouble(); // Read the income from user input
        sc.close(); // Close the scanner object
    }

    // Implement the show method to display output to user
    public void show() {
        System.out.println("Name: " + name); // Print the name of the employee
        System.out.println("Income: " + income); // Print the income of the employee
        System.out.println("Tax: " + tax); // Print the tax of the employee
    }

    // Define a method to calculate and return tax based on income slab and tax rate
    public double calculate_tax() {
        if (income <= 300000) {
            return 0;
        } else if (income > 300000 && income <= 600000) {
            return (income - 300000) * tax_rate;
        } else if (income > 600000 && income <= 900000) {
            return (300000 * tax_rate) + (income - 600000) * (tax_rate + 0.05);
        } else if (income > 900000 && income <= 1200000) {
            return (300000 * tax_rate) + (300000 * (tax_rate + 0.05)) + (income - 900000) * (tax_rate + 0.1);
        } else if (income > 1200000 && income <= 1500000) {
            return (300000 * tax_rate) + (300000 * (tax_rate + 0.05)) + (300000 * (tax_rate + 0.1))
                    + (income - 1200000) * (tax_rate + 0.15);
        } else {
            return (300000 * tax_rate) + (300000 * (tax_rate + 0.05)) + (300000 * (tax_rate + 0.1))
                    + (300000 * (tax_rate + 0.15)) + (income - 1500000) * (tax_rate + 0.25);
        }
    }

}

// Define a main class to test and run the program
public class pg4 {

    public static void main(String[] args) {
        employee e = new employee(); // Create an employee object e
        e.information(); // Call information method on e to get input from user
        e.tax = e.calculate_tax(); // Call calculate_tax method on e to compute and assign tax value
        e.show(); // Call show method on e to display output to user
    }
}