import java.util.Random;
import java.util.Scanner;

public class l3q12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[][] scores = generateScores(numStudents);
        double[][] results = calculateResults(scores);

        displayScorecard(scores, results);
    }

    public static int[][] generateScores(int numStudents) {
        Random random = new Random();
        int[][] scores = new int[numStudents][3];

        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = 40 + random.nextInt(61); // Physics
            scores[i][1] = 40 + random.nextInt(61); // Chemistry
            scores[i][2] = 40 + random.nextInt(61); // Math
        }

        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        int numStudents = scores.length;
        double[][] results = new double[numStudents][3];

        for (int i = 0; i < numStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return results;
    }

    public static void displayScorecard(int[][] scores, double[][] results) {
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade\tRemarks");

        for (int i = 0; i < scores.length; i++) {
            String grade = "";
            String remarks = "";

            if (results[i][2] >= 80) {
                grade = "Level 4";
                remarks = "Above agency-normalized standards";
            } else if (results[i][2] >= 70) {
                grade = "Level 3";
                remarks = "At agency-normalized standards";
            } else if (results[i][2] >= 60) {
                grade = "Level 2";
                remarks = "Below, but approaching agency-normalized standards";
            } else if (results[i][2] >= 50) {
                grade = "D";
                remarks = "Well below agency-normalized standards";
            } else if (results[i][2] >= 40) {
                grade = "E";
                remarks = "Too below agency-normalized standards";
            } else {
                grade = "R";
                remarks = "Remedial standards";
            }

            System.out.println((i + 1) + "\t" + scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t" + results[i][0] + "\t" + results[i][1] + "\t" + results[i][2] + "\t" + grade + "\t" + remarks);
        }
    }
}