

public class Student implements Comparable<Student> {
    private String name;
    private double[] grades;

    public Student(String name, double[] array) {
        this.name = name;
        this.grades = array;
    }

    public String getName() {
        return name;
    }

    public double[] getGradesArray() {
        return grades;
    }

    public double getAverage() {
        double total = 0;
        for (double d : grades) {
            total += d;
        }
        return total / grades.length;
    }

    public String toString() {
        return this.name + ":" + this.getAverage();
    }

    @Override 
    public int compareTo(Student s) {
        if (this.getAverage() == s.getAverage()) {
            return 0;
        }
        else if (this.getAverage() > s.getAverage()) {
            return 1;
        }
        else if (this.getAverage() < s.getAverage()) {
            return -1;
        }
        return 0;
    }


}