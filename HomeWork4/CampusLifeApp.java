package HomeWork4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Course {
    private final String name;
    private final String instructor;
    private final int credits;

    public Course(String name, String instructor, int credits) {
        this.name = name;
        this.instructor = instructor;
        this.credits = credits;
    }

    public String getName() { return name; }
    public String getInstructor() { return instructor; }
    public int getCredits() { return credits; }

    @Override
    public String toString() {
        return "Course{name='" + name + "', instructor='" + instructor + "', credits=" + credits + "}";
    }
}

abstract class PlanItem {
    private final String title;
    private final int daysUntil;
    private final int estimatedMinutes;
    private boolean completed;

    protected PlanItem(String title, int daysUntil, int estimatedMinutes) {
        this.title = title;
        this.daysUntil = daysUntil;
        this.estimatedMinutes = Math.max(0, estimatedMinutes);
        this.completed = false;
    }

    public String getTitle() { return title; }
    public int getDaysUntil() { return daysUntil; }
    public int getEstimatedMinutes() { return estimatedMinutes; }
    public boolean isCompleted() { return completed; }

    public void markCompleted() { this.completed = true; }

    public int remainingMinutes() {
        return completed ? 0 : estimatedMinutes;
    }

    public abstract String getCategory();

    public double urgencyScore() {
        if (completed) return 0.0;

        int d = Math.max(0, daysUntil);

        return 100.0 / (d + 1);
    }

    public boolean isUrgent() {
        return !completed && urgencyScore() >= 33.0;
    }

    public String display() {
        String status = completed ? "✅ DONE" : (isUrgent() ? "🔥 URGENT" : "🕒 PENDING");
        return String.format("[%s] %s | in %d day(s) | est %d min | %s",
                getCategory(), title, daysUntil, estimatedMinutes, status);
    }
}


class AssignmentItem extends PlanItem {
    private final Course course;

    public AssignmentItem(String title, Course course, int daysUntilDue, int estimatedHours) {
        super(title, daysUntilDue, estimatedHours * 60);
        this.course = course;
    }

    public Course getCourse() { return course; }

    @Override
    public String getCategory() {
        return "Assignment";
    }

    @Override
    public double urgencyScore() {
        if (isCompleted()) return 0.0;

        int d = Math.max(0, getDaysUntil());

        double timeFactor = Math.min(2.0, getEstimatedMinutes() / 180.0);
        return (120.0 / (d + 1)) + (20.0 * timeFactor);
    }

    @Override
    public String display() {
        String base = super.display();
        return base + " | course: " + course.getName();
    }
}

class ExamPreparationItem extends PlanItem {
    private final Course course;
    private final String examType;

    public ExamPreparationItem(String title, Course course, String examType, int daysUntilExam, int estimatedMinutes) {
        super(title, daysUntilExam, estimatedMinutes);
        this.course = course;
        this.examType = examType;
    }

    @Override
    public String getCategory() {
        return "ExamPrep";
    }

    @Override
    public double urgencyScore() {
        if (isCompleted()) return 0.0;

        int d = Math.max(0, getDaysUntil());

        double spike = (d <= 1) ? 200 : (d <= 3 ? 120 : 60);
        double base = spike / (d + 1);

        double timeBoost = Math.min(60.0, getEstimatedMinutes() / 5.0);
        return base + timeBoost;
    }

    @Override
    public String display() {
        String status = isCompleted() ? "✅ DONE" : (isUrgent() ? "🔥 URGENT" : "🕒 PENDING");
        return String.format("[%s] %s (%s) | %s | in %d day(s) | est %d min",
                getCategory(), getTitle(), examType, course.getName(), getDaysUntil(), getEstimatedMinutes())
                + " | " + status;
    }
}

class ClubEventItem extends PlanItem {
    private final String clubName;
    private final String location;

    public ClubEventItem(String title, String clubName, String location, int daysUntilEvent) {
        super(title, daysUntilEvent, 0);
        this.clubName = clubName;
        this.location = location;
    }

    @Override
    public String getCategory() {
        return "ClubEvent";
    }

    @Override
    public double urgencyScore() {
        if (isCompleted()) return 0.0;

        int d = Math.max(0, getDaysUntil());
        if (d == 0) return 80;
        if (d == 1) return 45;
        return 10.0 / (d + 1);
    }

    @Override
    public String display() {
        String status = isCompleted() ? "✅ DONE" : (isUrgent() ? "🔥 SOON" : "🗓️ SCHEDULED");
        return String.format("[%s] %s | %s @ %s | in %d day(s) | %s",
                getCategory(), getTitle(), clubName, location, getDaysUntil(), status);
    }
}


public class CampusLifeApp {
    public static void main(String[] args) {

        Course oop = new Course("OOP", "Dr. Lee", 6);
        Course discrete = new Course("Discrete Math", "Prof. Kim", 3);
        Course english = new Course("English", "Ms. Brown", 3);

        List<PlanItem> plan = new ArrayList<>();
        plan.add(new AssignmentItem("Lab 2", oop, 1, 3));
        plan.add(new AssignmentItem("Project Part A", oop, 5, 6));
        plan.add(new AssignmentItem("Homework 4", discrete, 0, 2));

        plan.add(new ExamPreparationItem("Quiz Study", discrete, "Quiz", 2, 120));
        plan.add(new ExamPreparationItem("Final Review", english, "Final", 7, 180));

        plan.add(new ClubEventItem("Chess Club Meeting", "Chess Club", "Room B-12", 0));
        plan.add(new ClubEventItem("Volunteer Day", "Community Club", "Campus Gate", 3));

        System.out.println("=== ALL PLAN ITEMS (polymorphism: each displays differently) ===");
        for (PlanItem item : plan) {
            System.out.println(item.display());
        }

        int totalRemainingMinutes = plan.stream()
                .mapToInt(PlanItem::remainingMinutes)
                .sum();

        PlanItem mostUrgent = plan.stream()
                .filter(i -> !i.isCompleted())
                .max(Comparator.comparingDouble(PlanItem::urgencyScore))
                .orElse(null);

        System.out.println("\n=== SUMMARY ===");
        System.out.println("Total remaining time (minutes): " + totalRemainingMinutes);
        if (mostUrgent != null) {
            System.out.printf("Most urgent: %s (score=%.2f)%n", mostUrgent.display(), mostUrgent.urgencyScore());
        }

        System.out.println("\n=== MARK ONE ITEM COMPLETED ===");
        PlanItem completedOne = plan.get(0); // "Lab 2"
        completedOne.markCompleted();
        System.out.println("Completed: " + completedOne.display());

        int newTotalRemainingMinutes = plan.stream()
                .mapToInt(PlanItem::remainingMinutes)
                .sum();

        PlanItem newMostUrgent = plan.stream()
                .filter(i -> !i.isCompleted())
                .max(Comparator.comparingDouble(PlanItem::urgencyScore))
                .orElse(null);

        System.out.println("\n=== UPDATED SUMMARY ===");
        System.out.println("New total remaining time (minutes): " + newTotalRemainingMinutes);
        if (newMostUrgent != null) {
            System.out.printf("New most urgent: %s (score=%.2f)%n", newMostUrgent.display(), newMostUrgent.urgencyScore());
        }
    }
}