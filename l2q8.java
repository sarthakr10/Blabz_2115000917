import java.util.Scanner;

public class l2q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + friends[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height of " + friends[i] + " (in cm): ");
            heights[i] = scanner.nextDouble();
        }

        String youngestFriend = findYoungest(friends, ages);
        String tallestFriend = findTallest(friends, heights);

        System.out.println("The youngest friend is: " + youngestFriend);
        System.out.println("The tallest friend is: " + tallestFriend);

        scanner.close();
    }

    public static String findYoungest(String[] friends, int[] ages) {
        int minAgeIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minAgeIndex]) {
                minAgeIndex = i;
            }
        }
        return friends[minAgeIndex];
    }

    public static String findTallest(String[] friends, double[] heights) {
        int maxHeightIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxHeightIndex]) {
                maxHeightIndex = i;
            }
        }
        return friends[maxHeightIndex];
    }
}
