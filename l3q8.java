import java.util.Scanner;

public class l3q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month (MM): ");
        int month = scanner.nextInt();
        System.out.print("Enter year (YYYY): ");
        int year = scanner.nextInt();
        scanner.close();

        displayCalendar(month, year);
    }

    public static void displayCalendar(int month, int year) {
        String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        int[] daysInMonth = {
            0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        if (isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        System.out.println("   " + months[month] + " " + year);
        System.out.println(" S  M  T  W  T  F  S");

        int firstDayOfMonth = getFirstDayOfMonth(month, year);

        for (int i = 0; i < firstDayOfMonth; i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= daysInMonth[month]; day++) {
            System.out.printf("%3d", day);
            if ((day + firstDayOfMonth) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y / 4 - y / 100 + y / 400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        return (1 + x + (31 * m) / 12) % 7;
    }
}