import java.util.Scanner;

public class l2q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] physicsMarks = new int[numStudents];
        int[] chemistryMarks = new int[numStudents];
        int[] mathsMarks = new int[numStudents];
        double[] percentages = new double[numStudents];
        char[] grades = new char[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");

            physicsMarks[i] = getValidMarks(scanner, "Physics");
            chemistryMarks[i] = getValidMarks(scanner, "Chemistry");
            mathsMarks[i] = getValidMarks(scanner, "Maths");
            percentages[i] = calculatePercentage(physicsMarks[i], chemistryMarks[i], mathsMarks[i]);
            grades[i] = calculateGrade(percentages[i]);
        }

        System.out.println("\nMarks, Percentages, and Grades of Students:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Student " + (i + 1) + ":");
            System.out.println("Physics: " + physicsMarks[i]);
            System.out.println("Chemistry: " + chemistryMarks[i]);
            System.out.println("Maths: " + mathsMarks[i]);
            System.out.println("Percentage: " + percentages[i] + "%");
            System.out.println("Grade: " + grades[i]);
            System.out.println();
        }

        scanner.close();
    }

    private static int getValidMarks(Scanner scanner, String subject) {
        int marks;
        while (true) {
            System.out.print(subject + " marks: ");
            marks = scanner.nextInt();
            if (marks >= 0) {
                break;
            } else {
                System.out.println("Please enter positive values.");
            }
        }
        return marks;
    }

    private static double calculatePercentage(int physics, int chemistry, int maths) {
        return (physics + chemistry + maths) / 3.0;
    }

    private static char calculateGrade(double percentage) {
        if (percentage >= 80) {
            return 'A';
        } else if (percentage >= 70) {
            return 'B';
        } else if (percentage >= 60) {
            return 'C';
        } else if (percentage >= 50) {
            return 'D';
        } else if (percentage >= 40) {
            return 'E';
        } else {
            return 'R';
        }
    }
}