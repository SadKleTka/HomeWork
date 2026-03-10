package HomeWork5;

import java.util.*;
import java.util.stream.Collectors;

public class ClassWork {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 2, 10, 7, 8, 4);
        List<String> words = Arrays.asList("apple", "banana", "avocado", "grape", "apricot", "melon");

        List<Student> students = Arrays.asList(
                new Student("Aman", "A1", 3.8),
                new Student("John", "A1", 3.2),
                new Student("Sara", "B1", 3.9),
                new Student("Mike", "B1", 2.8),
                new Student("Anna", "A1", 3.6),
                new Student("Tom", "C1", 3.4)
        );

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("1. Even numbers: " + evenNumbers);

        List<String> upperWords = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("2. Uppercase words: " + upperWords);

        long countStartsWithA = words.stream()
                .filter(word -> word.startsWith("a"))
                .count();
        System.out.println("3. Count starting with 'a': " + countStartsWithA);

        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("4. Sorted descending: " + sortedDesc);

        int max = numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();
        int min = numbers.stream()
                .min(Integer::compareTo)
                .orElseThrow();
        System.out.println("5. Max: " + max + ", Min: " + min);

        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println("6. Unique numbers: " + uniqueNumbers);

        String joinedWords = words.stream()
                .collect(Collectors.joining(", "));
        System.out.println("7. Joined words: " + joinedWords);

        Map<String, List<Student>> groupedStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup));
        System.out.println("8. Grouped students: " + groupedStudents);

        double averageGpa = students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
        System.out.println("9. Average GPA: " + averageGpa);

        List<Student> firstThreeGoodStudents = students.stream()
                .filter(student -> student.getGpa() > 3.5)
                .limit(3)
                .toList();
        System.out.println("10. First 3 students with GPA > 3.5: " + firstThreeGoodStudents);

        long countGoodStudents = students.stream()
                .filter(student -> student.getGpa() > 3.5)
                .count();
        System.out.println("11. Count of students with GPA > 3.5: " + countGoodStudents);
    }
}