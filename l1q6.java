public class l1q6 {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide both month and day as command line arguments.");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int day = Integer.parseInt(args[1]);

        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season");
        } else {
            System.out.println("Not a Spring Season");
        }
    }

    public static boolean isSpringSeason(int month, int day) {
        if (month == 3 && day >= 20) {
            return true;
        } else if (month == 4 || month == 5) {
            return true;
        } else if (month == 6 && day <= 20) {
            return true;
        } else {
            return false;
        }
    }
}