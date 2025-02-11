class ProcessNode {
    int processId, burstTime, priority;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head, tail;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.head = this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void removeProcess(int processId) {
        if (head == null) return;
        ProcessNode current = head, prev = null;
        do {
            if (current.processId == processId) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    head = head.next;
                    tail.next = head;
                }
                if (current == tail) {
                    tail = prev;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void executeProcesses() {
        if (head == null) return;
        ProcessNode current = head;
        while (true) {
            System.out.println("Executing Process: " + current.processId);
            if (current.burstTime > timeQuantum) {
                current.burstTime -= timeQuantum;
            } else {
                removeProcess(current.processId);
            }
            if (head == null) break;
            current = current.next;
        }
    }

    public void displayProcesses() {
        if (head == null) return;
        ProcessNode current = head;
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.displayProcesses();
        scheduler.executeProcesses();
        scheduler.displayProcesses();
    }
}
