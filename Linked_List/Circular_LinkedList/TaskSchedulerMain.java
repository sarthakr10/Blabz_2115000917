class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task currentTask = null; 


    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head; 
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
        if (currentTask == null) currentTask = head;
    }


    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void addAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (position == 0 || head == null) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task temp = head;
        for (int i = 0; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
            tail.next = head;
        }
    }

    public void removeTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        Task temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) { 
                    head = head.next;
                    tail.next = head;
                    if (temp == tail) { 
                        head = tail = null;
                    }
                } else if (temp == tail) {
                    prev.next = head;
                    tail = prev;
                } else { 
                    prev.next = temp.next;
                }
                System.out.println("Task " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found.");
    }


    public void viewCurrentTask() {
        if (currentTask == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + currentTask.taskId + " | " + currentTask.taskName + " | Priority: " + currentTask.priority + " | Due: " + currentTask.dueDate);
        currentTask = currentTask.next;
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task: " + temp.taskId + " | " + temp.taskName + " | Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks with priority " + priority + " found.");
        }
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        System.out.println("Task List:");
        do {
            System.out.println(temp.taskId + " | " + temp.taskName + " | Priority: " + temp.priority + " | Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskSchedulerMain {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtBeginning(1, "Complete Java Project", 2, "2025-02-15");
        scheduler.addAtEnd(2, "Prepare Presentation", 1, "2025-02-20");
        scheduler.addAtEnd(3, "Submit Assignment", 3, "2025-02-18");
        scheduler.addAtPosition(4, "Team Meeting", 1, "2025-02-16", 1);

        scheduler.displayTasks();

        System.out.println("\nRemoving Task 3...");
        scheduler.removeTask(3);

        scheduler.displayTasks();

        System.out.println("\nCurrent Task Rotation:");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        System.out.println("\nSearching for tasks with priority 1:");
        scheduler.searchByPriority(1);
    }
}
