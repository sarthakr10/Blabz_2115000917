public class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayDetails() {
        if (this instanceof Patient) {
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
            System.out.println("Hospital: " + hospitalName);
        } else {
            System.out.println("The object is not an instance of Patient.");
        }
    }

    public static void main(String[] args) {
        Patient patient1 = new Patient(1, "John Doe", 30, "Flu");
        Patient patient2 = new Patient(2, "Jane Smith", 25, "Cold");

        patient1.displayDetails();
        System.out.println();
        patient2.displayDetails();

        System.out.println();
        System.out.println("Total Patients: " + Patient.getTotalPatients());
    }
}