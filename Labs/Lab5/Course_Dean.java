import java.util.ArrayList;

public class Course_Dean {

	private ArrayList<Student_Dean> roster; // Collection of Student objects

	public Course_Dean() {
		roster = new ArrayList<Student_Dean>();
	}
   
   // Return an ArrayList of all Students with a GPA of at least 3.5
   // This is like a Getter for an ArrayList
	public ArrayList<Student_Dean> getDeansList() {
	   /* Type your code here */
	   ArrayList<Student_Dean> DeansList = new ArrayList<Student_Dean>();
      for (int i = 0; i < roster.size(); ++i) 
      {
         if (roster.get(i).getGPA() >= 3.5)
         {
            DeansList.add(roster.get(i));
         }
      }
      return DeansList;
	}

	public void addStudent(Student_Dean s) {
		roster.add(s);
	}
	
	// main
   public static void main(String args[]) {
      Course_Dean course = new Course_Dean();
      ArrayList<Student_Dean> deanList = new ArrayList<Student_Dean>();
      String first;  // first name
      String last;   // last name
      double gpa;    // grade point average
      
      first = "Henry";
      last = "Nguyen";
      gpa = 3.5;
      course.addStudent(new Student_Dean(first, last, gpa));  // Add 1st student
      
      first = "Brenda";
      last = "Stern";
      gpa = 2.0;
      course.addStudent(new Student_Dean(first, last, gpa));  // Add 2nd student
      
      first = "Lynda";
      last = "Robison";
      gpa = 3.2;
      course.addStudent(new Student_Dean(first, last, gpa));  // Add 3rd student
      
      first = "Sonya";
      last = "King";
      gpa = 3.9;
      course.addStudent(new Student_Dean(first, last, gpa));  // Add 4th student

      deanList = course.getDeansList();
		System.out.println("Dean's list:");
		for (Student_Dean student: deanList) {
			System.out.println(student);     // Expect: ArrayList with Henry and Sonya
		}
   }    
}