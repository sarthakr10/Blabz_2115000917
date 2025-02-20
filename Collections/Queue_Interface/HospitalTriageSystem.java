import java.util.PriorityQueue;
import java.util.Comparator;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

class SeverityComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        return Integer.compare(p2.severity, p1.severity);
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(new SeverityComparator());

        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        System.out.println("Order of treatment:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}