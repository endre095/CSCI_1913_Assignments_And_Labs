import java.util.TreeSet;

public class GradeBook {
    private TreeSet<Student> master;
    
    public GradeBook() {
        master = new TreeSet<>();
    }

    public void addStudent(Student s) {
        master.add(s);
    }

    public void printStudentData() {
        Iterator<Double> d = master.iterator<;
    }
    



    public static void main(String[] args) {
        Student alice = new Student("Alice", new double[] { 100, 80, 95, 85, 92 });
        Student peter = new Student("Peter", new double[] { 98, 88, 92, 83, 87 });
        Student joan = new Student("Joan", new double[] { 75, 80, 78, 82, 72 });
        Student alex = new Student("Alex", new double[] { 100, 98, 95, 96, 93 });
        Student julienne = new Student("Julienne", new double[] { 100, 100, 98, 95, 92 });
        Student philip = new Student("Philip", new double[] { 88, 82, 85, 85, 82 });
    }

}   