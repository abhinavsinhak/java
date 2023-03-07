// Employee.java
class Employee {
    protected int employeeId;
    protected String name;
    protected String address;
    protected String mailId;
    protected String mobileNumber;

    public Employee(int employeeId, String name, String address, String mailId, String mobileNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.mailId = mailId;
        this.mobileNumber = mobileNumber;
    }

    public double getBasicPay() {
        return 0;
    }

    public double getGrossPay() {
        return 0;
    }
}

// Programmer.java
class Programmer extends Employee {
    protected double basicPay;

    public Programmer(int employeeId, String name, String address, String mailId, String mobileNumber,
            double basicPay) {
        super(employeeId, name, address, mailId, mobileNumber);
        this.basicPay = basicPay;
    }

    public double getGrossPay() {
        return basicPay + basicPay * 0.97 + basicPay * 0.1 + basicPay * 0.1;
    }

    public double getBasicPay() {
        return basicPay;
    }
}

// AssistantProfessor.java
class AssistantProfessor extends Employee {
    protected double basicPay;

    public AssistantProfessor(int employeeId, String name, String address, String mailId, String mobileNumber,
            double basicPay) {
        super(employeeId, name, address, mailId, mobileNumber);
        this.basicPay = basicPay;
    }

    public double getGrossPay() {
        return basicPay + basicPay * 0.97 + basicPay * 0.1 + basicPay * 0.1;
    }

    public double getBasicPay() {
        return basicPay;
    }
}

// AssociateProfessor.java
class AssociateProfessor extends Employee {
    protected double basicPay;

    public AssociateProfessor(int employeeId, String name, String address, String mailId, String mobileNumber,
            double basicPay) {
        super(employeeId, name, address, mailId, mobileNumber);
        this.basicPay = basicPay;
    }

    public double getGrossPay() {
        return basicPay + basicPay * 0.97 + basicPay * 0.1 + basicPay * 0.1;
    }

    public double getBasicPay() {
        return basicPay;
    }
}

// Professor.java
class Professor extends Employee {
    protected double basicPay;

    public Professor(int employeeId, String name, String address, String mailId, String mobileNumber, double basicPay) {
        super(employeeId, name, address, mailId, mobileNumber);
        this.basicPay = basicPay;
    }

    public double getGrossPay() {
        return basicPay + basicPay * 0.97 + basicPay * 0.1 + basicPay * 0.1;
    }

    public double getBasicPay() {
        return basicPay;
    }
}

public class payslip {

    public static void main(String[] args) {
            System.out.println("w");
    
        }
}
