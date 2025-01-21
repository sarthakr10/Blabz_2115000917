public class q5 {
    public static void main(String[] args) {
        int totalPens = 14;
        int students = 3;

        int pensPerStudent = totalPens / students;
        int remainingPens = totalPens % students;

        System.out.println(
                "Pen Per Student is " + pensPerStudent + " and remaining pen not distributed is " + remainingPens);
    }
}