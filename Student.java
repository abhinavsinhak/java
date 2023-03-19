public class Student {
    private String regno;
    private String name;
    private String dept;
    private String[] subjects;
    private double cgpa;

    // Constructor with regno, name, and dept parameters
    public Student(String regno, String name, String dept) {
        this.regno = regno;
        this.name = name;
        this.dept = dept;
        this.subjects = new String[0];
        this.cgpa = 0.0;
    }

    // Constructor with regno, name, dept, and subjects parameters
    public Student(String regno, String name, String dept, String[] subjects) {
        this(regno, name, dept);
        this.subjects = subjects;
    }

    // Constructor with regno, name, dept, subjects, and cgpa parameters
    public Student(String regno, String name, String dept, String[] subjects, double cgpa) {
        this(regno, name, dept, subjects);
        this.cgpa = cgpa;
    }

    // Method to compute cgpa
    public void computeCGPA(double[] grades) {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        this.cgpa = total / grades.length;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Reg No: " + this.regno);
        System.out.println("Name: " + this.name);
        System.out.println("Department: " + this.dept);
        System.out.println("Subjects: " + String.join(", ", this.subjects));
        System.out.println("CGPA: " + this.cgpa);
    }

    public static void main(String[] args) {
        // Create a student object with regno, name, dept, subjects, and cgpa
        Student student = new Student("21CS1123", "Sushant", "Computer Science", new String[]{"Maths", "Computer Networks", "Java Programming"}, 0.0);

        // Compute CGPA and display student details
        double[] grades = {8.5, 7.8, 9.0};
        student.computeCGPA(grades);
        student.displayDetails();
    }
}
