interface customer {
  // The information method takes the name and income of the employee as parameters
  void information(String name, double income);
  // The show method displays the name and tax of the employee
  void show();
  // The tax_rate method returns the tax rate based on the income slab
  double tax_rate(double income);
}

// Define the employee class that implements the customer interface
class employee implements customer {
  // Declare private variables to store the name, income and tax of the employee
  private String name;
  private double income;
  private double tax;

  // Implement the information method to assign values to name and income variables
  public void information(String name, double income) {
    this.name = name;
    this.income = income;
    // Calculate the tax by calling the tax_rate method and multiplying it with income
    this.tax = this.income * this.tax_rate(this.income);
  }

  // Implement the show method to print the name and tax of the employee
  public void show() {
    System.out.println("Name: " + this.name);
    System.out.println("Tax: " + this.tax);
  }

  // Implement the tax_rate method to return the appropriate tax rate based on income slab
  public double tax_rate(double income) {
    if (income <= 300000) { // Up to Rs.3.0 lakh - NIL
      return 0.0;
    } else if (income <=600000) { // Rs.3.0 lakh - Rs.6 lakh -5%
      return 0.05;
    } else if (income <=900000) { // Rs.6 lakh - Rs.9 lakh -10%
      return 0.1;
    } else if (income <=1200000) { 
      return 0.15;
    } else if (income <=1500000) { 
      return 0.2;
    } else { 
      return 0.3;
    }
    
  
}
}


public class program3{
  
public static void main(String[] args) {
  
  
employee e1 = new employee();
  
e1.information("Alice",500000); 
e1.show(); 
  
employee e2 = new employee(); 
e2.information("Bob",1000000); 
e2.show(); 
  
employee e3 = new employee(); 
e3.information("Charlie",2000000); 
e3.show(); 
  
} 
}