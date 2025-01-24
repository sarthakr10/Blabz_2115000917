import java.util.Scanner;

public class l2q9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = 5;
        int subjects = 3;
        int[][] marks = new int[students][subjects];
        String[] subjectNames = {"Physics", "Chemistry", "Maths"};
        
        for (int i = 0; i < students; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            for (int j = 0; j < subjects; j++) {
                System.out.print(subjectNames[j] + ": ");
                marks[i][j] = scanner.nextInt();
            }
        }
        
        for (int i = 0; i < students; i++) {
            int total = 0;
            for (int j = 0; j < subjects; j++) {
                total += marks[i][j];
            }
            double percentage = total / (double) subjects;
            char grade;
            
            if (percentage >= 90) {
                grade = 'A';
            } else if (percentage >= 80) {
                grade = 'B';
            } else if (percentage >= 70) {
                grade = 'C';
            } else if (percentage >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            
            System.out.println("Student " + (i + 1) + " - Percentage: " + percentage + "%, Grade: " + grade);
        }
        
        scanner.close();
    }
}
