import java.util.ArrayList;
import java.util.List;

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String name;
    private List<Faculty> faculties;

    public Department(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public String getName() {
        return name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }
}

class University {
    private String name;
    private List<Department> departments;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void deleteUniversity() {
        departments.clear();
    }
}

public class UniversityDemo {
    public static void main(String[] args) {
        Faculty faculty1 = new Faculty("Dr. Smith");
        Faculty faculty2 = new Faculty("Dr. Johnson");

        Department csDepartment = new Department("Computer Science");
        csDepartment.addFaculty(faculty1);

        Department mathDepartment = new Department("Mathematics");
        mathDepartment.addFaculty(faculty2);

        University university = new University("Tech University");
        university.addDepartment(csDepartment);
        university.addDepartment(mathDepartment);

        System.out.println("University: " + university.getName());
        for (Department dept : university.getDepartments()) {
            System.out.println("Department: " + dept.getName());
            for (Faculty faculty : dept.getFaculties()) {
                System.out.println("Faculty: " + faculty.getName());
            }
        }

        university.deleteUniversity();
        System.out.println("University deleted. Departments: " + university.getDepartments().size());

        System.out.println("Independent Faculty: " + faculty1.getName());
        System.out.println("Independent Faculty: " + faculty2.getName());
    }
}
