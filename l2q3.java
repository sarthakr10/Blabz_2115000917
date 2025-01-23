import java.util.Scanner;

public class l2q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter marks for Physics: ");
        int physics = scanner.nextInt();
        System.out.print("Enter marks for Chemistry: ");
        int chemistry = scanner.nextInt();
        System.out.print("Enter marks for Maths: ");
        int maths = scanner.nextInt();

        int totalMarks = physics + chemistry + maths;
        double percentage = (totalMarks / 3.0);

        String grade, levelDescription, remarks;
        if (percentage >= 80) {
            grade = "A";
            levelDescription = "Level 4";
            remarks = "Above agency-normalized standards";
        } else if (percentage >= 70) {
            grade = "B";
            levelDescription = "Level 3";
            remarks = "At agency-normalized standards";
        } else if (percentage >= 60) {
            grade = "C";
            levelDescription = "Level 2";
            remarks = "Below, but approaching agency-normalized standards";
        } else if (percentage >= 50) {
            grade = "D";
            levelDescription = "Level 1";
            remarks = "Well below agency-normalized standards";
        } else if (percentage >= 40) {
            grade = "E";
            levelDescription = "Level 1-";
            remarks = "Too below agency-normalized standards";
        } else {
            grade = "R";
            levelDescription = "Remedial";
            remarks = "Remedial standards";
        }
        System.out.println("Average Mark: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Level Description: " + levelDescription);
        System.out.println("Remarks: " + remarks);
    }
}