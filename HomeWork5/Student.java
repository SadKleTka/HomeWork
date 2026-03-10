package HomeWork5;

public class Student {
    private String name;
    private String group;
    private double gpa;

    public Student(String name, String group, double gpa) {
        this.name = name;
        this.group = group;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return name + " - " + group + " - " + gpa;
    }
}