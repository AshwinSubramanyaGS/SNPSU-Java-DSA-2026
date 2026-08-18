

public class ToStringDemo {
    public static void main(String[] args) {
        var student = new Student("Prajwal", "3213asd", 8.2);

        System.out.println(student);

    }
    
}

class Student{
    String name;
    String srn;
    double cgpa;
    public Student(String name, String srn, double cgpa) {
        this.name = name;
        this.srn = srn;
        this.cgpa = cgpa;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", srn=" + srn + ", cgpa=" + cgpa + "]";
    }
    
}