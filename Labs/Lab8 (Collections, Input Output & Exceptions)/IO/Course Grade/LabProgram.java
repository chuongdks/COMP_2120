/*

Write a program that reads the student information from a tab separated values (tsv) file. The program then creates a text file that records the course grades of the students. Each row of the tsv file contains the Last Name, First Name, Midterm1 score, Midterm2 score, and the Final score of a student. A sample of the student information is provided in StudentInfo.tsv. Assume the number of students is at least 1 and at most 20. Assume also the last names and first names do not contain whitespaces.

The program performs the following tasks:

    Read the file name of the tsv file from the user.
    Open the tsv file and read the student information.
    Compute the average exam score of each student.
    Assign a letter grade to each student based on the average exam score in the following scale:
        A: 90 =< x
        B: 80 =< x < 90
        C: 70 =< x < 80
        D: 60 =< x < 70
        F: x < 60
    Compute the average of each exam.
    Output the last names, first names, exam scores, and letter grades of the students into a text file named report.txt. Output one student per row and separate the values with a tab character.
    Output the average of each exam, with two digits after the decimal point, at the end of report.txt. Hint: Use the precision sub-specifier to format the output.

Ex: If the input of the program is:

StudentInfo.tsv

and the contents of StudentInfo.tsv are:

Barrett    Edan    70  45  59
Bradshaw    Reagan  96  97  88
Charlton    Caius   73  94  80
Mayo    Tyrese  88  61  36
Stern    Brenda  90  86  45

the file report.txt should contain:

Barrett    Edan    70  45  59  F
Bradshaw    Reagan  96  97  88  A
Charlton    Caius   73  94  80  B
Mayo    Tyrese  88  61  36  D
Stern    Brenda  90  86  45  C

Averages: Midterm1 83.40, Midterm2 76.60, Final 61.60

 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class LabProgram {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        // Declare variables
        String filename;
        String lastName, firstName;
        int midterm1, midterm2, finalExam;
        double midterm1Total = 0, midterm2Total = 0, finalExamTotal = 0;
        int studentCount = 0;         

        // Read the filename from the user
        System.out.print("Enter the filename: ");
        filename = scnr.nextLine();    

        // Open the input file  
        FileInputStream fileByteStream = new FileInputStream(filename);
        Scanner inFS = new Scanner(fileByteStream);

        // Open the output file
        FileOutputStream fileStream = new FileOutputStream("report.txt");
        PrintWriter outFS = new PrintWriter(fileStream);      

        // Process each line in the file
        while (inFS.hasNextLine()) 
        {   
            // Read student information
            lastName = inFS.next();
            firstName = inFS.next();
            midterm1 = inFS.nextInt();
            midterm2 = inFS.nextInt();
            finalExam = inFS.nextInt();
            inFS.nextLine();

            // Compute average exam score
            double averageScore = (midterm1 + midterm2 + finalExam) / 3.0;

            // Compute letter grade
            String letterGrade;
            if (averageScore >= 90) 
            {
                letterGrade = "A";
            } 
            else if (averageScore >= 80) 
            {
                letterGrade = "B";
            } 
            else if (averageScore >= 70) 
            {
                letterGrade = "C";
            } 
            else if (averageScore >= 60) 
            {
                letterGrade = "D";
            } 
            else 
            {
                letterGrade = "F";
            }

            // Output student information and grades to the output file
            outFS.printf("%s\t%s\t%d\t%d\t%d\t%s", lastName, firstName, midterm1, midterm2, finalExam, letterGrade);
            outFS.printf("\n");

            // Update exam totals for calculating averages
            midterm1Total += midterm1;
            midterm2Total += midterm2;
            finalExamTotal += finalExam;
            studentCount++;
        }


        // Compute exam averages
        double midterm1Average = midterm1Total / studentCount;
        double midterm2Average = midterm2Total / studentCount;
        double finalExamAverage = finalExamTotal / studentCount;

        // Output exam averages to the output file
        outFS.printf("\n");
        outFS.printf("Averages: Midterm1 %.2f, Midterm2 %.2f, Final %.2f", midterm1Average, midterm2Average, finalExamAverage);
        outFS.printf("\n");

        // Close files
        fileByteStream.close();
        outFS.close();      
    }
}