package HomeWork4;

import java.util.HashMap;
import java.util.Map;

class Course {
    private final String name;
    private final String instructor;
    private final int credits;

    public Course(String name, String instructor, int credits) {
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "HomeWork4.Course{name='" + name + "', instructor='" + instructor + "', credits=" + credits + "}";
    }
}

record StudySession(Course course, int minutes) {

    public double hours() {
        return minutes / 60.0;
    }

    @Override
    public String toString() {
        return "HomeWork4.StudySession{course='" + course.getName() + "', minutes=" + minutes + "}";
    }
}


class AssignmentTask {
    private final String title;
    private final Course course;
    private final int estimatedHours;
    private final int daysUntilDue;
    private boolean completed;

    public AssignmentTask(String title, Course course, int estimatedHours, int daysUntilDue) {
        this.title = title;
        this.course = course;
        this.estimatedHours = estimatedHours;
        this.daysUntilDue = daysUntilDue;
        this.completed = false;
    }

    public String getTitle() {
        return title;
    }

    public Course getCourse() {
        return course;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public int getDaysUntilDue() {
        return daysUntilDue;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    public boolean isUrgent() {
        return daysUntilDue <= 2 && !completed;
    }

    @Override
    public String toString() {
        return "HomeWork4.AssignmentTask{title='" + title + "', course='" + course.getName()
                + "', estHours=" + estimatedHours
                + ", dueIn=" + daysUntilDue
                + ", completed=" + completed + "}";
    }
}



public class CampusLifeApp {
    public static void main(String[] args) {

        Course oop = new Course("OOP", "Dr. Lee", 6);
        Course discrete = new Course("Discrete Math", "Prof. Kim", 3);
        Course english = new Course("English", "Ms. Brown", 3);

        Course[] courses = { oop, discrete, english };

        AssignmentTask[] tasks = {
                new AssignmentTask("Lab 2", oop, 3, 1),
                new AssignmentTask("Project Part A", oop, 6, 5),
                new AssignmentTask("Homework 4", discrete, 2, 0),
                new AssignmentTask("Quiz Study", discrete, 2, 2),
                new AssignmentTask("Essay Draft", english, 4, 3)
        };

        StudySession[] sessions = {
                new StudySession(oop, 90),
                new StudySession(oop, 60),
                new StudySession(discrete, 45),
                new StudySession(english, 120)
        };

        System.out.println("=== COURSES ===");
        for (Course c : courses) {
            System.out.println(c);
        }

        System.out.println("\n=== ASSIGNMENTS (urgent marked) ===");
        for (AssignmentTask t : tasks) {
            if (t.isUrgent()) {
                System.out.println("!!! URGENT -> " + t);
            } else {
                System.out.println(t);
            }
        }

        int remainingHours = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                remainingHours += t.getEstimatedHours();
            }
        }
        System.out.println("\nTotal estimated hours remaining (incomplete only): " + remainingHours);

        System.out.println("\n=== STUDY TIME PER COURSE (hours) ===");
        Map<String, Double> studyHoursByCourse = new HashMap<>();
        for (StudySession s : sessions) {
            String courseName = s.course().getName();
            studyHoursByCourse.put(courseName,
                    studyHoursByCourse.getOrDefault(courseName, 0.0) + s.hours());
        }

        for (Course c : courses) {
            double hrs = studyHoursByCourse.getOrDefault(c.getName(), 0.0);
            System.out.printf("%s: %.2f hours%n", c.getName(), hrs);
        }

        System.out.println("\n=== MARK ONE ASSIGNMENT COMPLETED ===");
        AssignmentTask updated = tasks[0];
        updated.markCompleted();
        System.out.println("Updated assignment: " + updated);

        int newRemainingHours = 0;
        for (AssignmentTask t : tasks) {
            if (!t.isCompleted()) {
                newRemainingHours += t.getEstimatedHours();
            }
        }
        System.out.println("New remaining estimated hours: " + newRemainingHours);
    }
}