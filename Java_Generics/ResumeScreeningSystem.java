import java.util.ArrayList;
import java.util.List;


abstract class JobRole {
    private String candidateName;
    private int experienceYears;
    
    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }
    
    public String getCandidateName() { return candidateName; }
    public int getExperienceYears() { return experienceYears; }

    public abstract void displayRoleInfo();
}

//job roles
class SoftwareEngineer extends JobRole {
    private String programmingLanguages;
    
    public SoftwareEngineer(String candidateName, int experienceYears, String programmingLanguages) {
        super(candidateName, experienceYears);
        this.programmingLanguages = programmingLanguages;
    }
    
    @Override
    public void displayRoleInfo() {
        System.out.println("Software Engineer: " + getCandidateName() + 
                           " | Experience: " + getExperienceYears() + 
                           " years | Skills: " + programmingLanguages);
    }
}

class DataScientist extends JobRole {
    private String machineLearningSkills;
    
    public DataScientist(String candidateName, int experienceYears, String machineLearningSkills) {
        super(candidateName, experienceYears);
        this.machineLearningSkills = machineLearningSkills;
    }
    
    @Override
    public void displayRoleInfo() {
        System.out.println("Data Scientist: " + getCandidateName() + 
                           " | Experience: " + getExperienceYears() + 
                           " years | Skills: " + machineLearningSkills);
    }
}

class ProductManager extends JobRole {
    private String domainExpertise;
    
    public ProductManager(String candidateName, int experienceYears, String domainExpertise) {
        super(candidateName, experienceYears);
        this.domainExpertise = domainExpertise;
    }
    
    @Override
    public void displayRoleInfo() {
        System.out.println("Product Manager: " + getCandidateName() + 
                           " | Experience: " + getExperienceYears() + 
                           " years | Expertise: " + domainExpertise);
    }
}



class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();
    
    public void addResume(T resume) {
        resumes.add(resume);
    }
    
    public void processResumes() {
        for (T resume : resumes) {
            resume.displayRoleInfo();
        }
    }
}


class ResumeScreeningPipeline {
    public static void processAllResumes(List<? extends JobRole> resumes) {
        System.out.println("Processing resumes in the AI Screening System...");
        for (JobRole resume : resumes) {
            resume.displayRoleInfo();
        }
    }
}


public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareEngineerResumes = new Resume<>();
        softwareEngineerResumes.addResume(new SoftwareEngineer("Alice", 5, "Java, Python, React"));
        softwareEngineerResumes.addResume(new SoftwareEngineer("Bob", 3, "C++, Node.js, Angular"));
        
        Resume<DataScientist> dataScientistResumes = new Resume<>();
        dataScientistResumes.addResume(new DataScientist("Charlie", 4, "TensorFlow, Python, SQL"));
        dataScientistResumes.addResume(new DataScientist("David", 2, "R, Deep Learning, Pandas"));
        
        Resume<ProductManager> productManagerResumes = new Resume<>();
        productManagerResumes.addResume(new ProductManager("Eve", 6, "E-commerce, Agile, UX"));
        productManagerResumes.addResume(new ProductManager("Frank", 7, "FinTech, Data-Driven Strategy"));

        System.out.println("Software Engineer Resumes:");
        softwareEngineerResumes.processResumes();

        System.out.println("\nData Scientist Resumes:");
        dataScientistResumes.processResumes();

        System.out.println("\nProduct Manager Resumes:");
        productManagerResumes.processResumes();


        System.out.println("\nProcessing all resumes:");
        List<JobRole> allResumes = new ArrayList<>();
        allResumes.add(new SoftwareEngineer("Alice", 5, "Java, Python, React"));
        allResumes.add(new DataScientist("Charlie", 4, "TensorFlow, Python, SQL"));
        allResumes.add(new ProductManager("Eve", 6, "E-commerce, Agile, UX"));
        
        ResumeScreeningPipeline.processAllResumes(allResumes);
    }
}
