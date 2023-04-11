import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Scanner;

public class GPACalculator {

    public static void main(String[] args) {
        // Get the number of classes
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many classes would you like to calculate? ");
        int numClasses = scanner.nextInt();

        // Create an array to store the classes and grades
        String[] classes = new String[numClasses];
        double[] grades = new double[numClasses];

        // Prompt the user for the class title and grade for each class
        for (int i = 0; i < numClasses; i++) {
            System.out.println("Enter the title of class " + (i + 1) + ": ");
            classes[i] = scanner.next();
            System.out.println("Enter the grade for class " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();
        }

        // Calculate the GPA
        double gpa = 0.0;
        for (int i = 0; i < numClasses; i++) {
            gpa += grades[i] * 4.0;
        }
        gpa /= gpa / numClasses;

        // Display the GPA to the user
        System.out.println("Your GPA is: " + gpa);

        // Save the data to a file
        try {
            File mygrades = new File("mygrades.txt");
            FileWriter fw = new FileWriter(mygrades);
            for (int i = 0; i < numClasses; i++) {
                fw.write(classes[i] + " " + grades[i] + "\n");
            }
            fw.write("GPA: " + gpa + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}