class StudentRecord{
    int rollNumber;
    int age;
    String name;
    String grade;
    StudentRecord next;

    public StudentRecord(int rollNumber , String name , int age , String grade){
        this.age = age;
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        this.next = null;
    }
}

class Singly_LinkedList{
    private StudentRecord head;

    public Singly_LinkedList(){
        this.head = null;
    } 
    public void addAtBeginning(int rollNumber , String name , int age ,String grade){
        StudentRecord newRecord = new StudentRecord(rollNumber, name, age, grade);
        newRecord.next = head;
        head = newRecord;
    }
    public void addAtLast(int rollNumber , String name , int age , String grade){
        StudentRecord newRecord = new StudentRecord(rollNumber, name, age, grade);
        if (head == null) {
            head = newRecord;
        }
        else{
            StudentRecord temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newRecord;
        }
    }
    public void addAtPosition(int rollNumber , String name , int age ,String grade , int position){
        StudentRecord newRecord = new StudentRecord(rollNumber, name, age, grade);
        if (position ==0 ) {
            newRecord.next = head;
            head = newRecord;
        }
        StudentRecord temp = head;
        for(int i = 0 ; i<position-1 && temp != null ; i++){
            temp= temp.next;
        }
        if (temp != null) {
            newRecord.next = temp.next;
            temp.next = newRecord;
        }
        else{
            System.out.println("Position not found");
        }
    }
    
    public void deleteByRollNumber(int rollNumber){
        if (head == null) {
            return;
        }
        if(head.rollNumber == rollNumber){
            head = head.next;
            return;
        }
        StudentRecord temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    public StudentRecord search(int rollNumber){
        StudentRecord temp = head;
        while(temp != null){
            if (temp.rollNumber== rollNumber) {
                return temp;
            }
        }
        return null;
    }
    public void displayAllRecords(){
        StudentRecord temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
    public void updateGrande(int rollNumber , String newGrade){
        StudentRecord record = head;
        while(record != null){
            if (record.rollNumber == rollNumber) {
                record.grade = newGrade;
                return;
            }
            record = record.next;
        }
    }
    public static void main(String[] args){
        Singly_LinkedList list = new Singly_LinkedList();
        list.addAtLast(1, "John Doe", 20, "A");
        list.addAtBeginning(2, "Jane Smith", 21, "B");
        list.addAtPosition(3, "Alice Johnson", 22, "C", 1);
        list.displayAllRecords();
        list.updateGrande(2, "A+");
        list.displayAllRecords();
        list.deleteByRollNumber(1);
        list.displayAllRecords();
        StudentRecord student = list.search(3);
        if (student != null) {
            System.out.println("Found: " + student.name);
        } else {
            System.out.println("Student not found.");
        }

    }
}
