import java.util.ArrayList;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    protected double baseCharge;

    public Patient(String patientId, String name, int age, double baseCharge) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.baseCharge = baseCharge;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private ArrayList<String> records = new ArrayList<>();

    public InPatient(String patientId, String name, int age, double baseCharge, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age, baseCharge);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return baseCharge + (daysAdmitted * dailyCharge);
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for In-Patient " + getName() + ": " + records);
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private ArrayList<String> records = new ArrayList<>();

    public OutPatient(String patientId, String name, int age, double baseCharge, double consultationFee) {
        super(patientId, name, age, baseCharge);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return baseCharge + consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for Out-Patient " + getName() + ": " + records);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();

        InPatient inPatient = new InPatient("IP001", "John Doe", 45, 500, 5, 200);
        OutPatient outPatient = new OutPatient("OP002", "Jane Smith", 30, 200, 100);

        patients.add(inPatient);
        patients.add(outPatient);

        inPatient.addRecord("Diagnosed with pneumonia.");
        inPatient.addRecord("Received oxygen therapy.");
        outPatient.addRecord("Routine checkup for hypertension.");

        System.out.println("Patient Billing Details:");
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: $" + patient.calculateBill());

            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }
            System.out.println("-------------------------------");
        }
    }
}
