package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Student {
    private long id;
    private String name;
    private String groupName;
    private List<Integer> grades;

    public Student(long id, String name, String groupName, List<Integer> grades) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
        this.grades = grades;
    }

    public Student() {
    }

    public double getAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    void firstRemoveStudent(List<Student> students) {

        System.out.println("══════════════════════════════════════════════");
        System.out.println("1. Удаление студентов со средним баллом ниже 60");
        System.out.println("══════════════════════════════════════════════");

        int before = students.size();

        students.removeIf(student -> {

            int sum = 0;
            for (Integer grade : student.getGrades()) {
                sum += grade;
            }

            double average = (double) sum / student.getGrades().size();

            if (average <= 60) {
                System.out.println("Удалён студент: "
                        + student.getName()
                        + " | Группа: " + student.getGroupName()
                        + " | Средний балл: " + average);
                return true;
            }

            return false;
        });

        System.out.println();
        System.out.println("Удаление завершено.");
        System.out.println("Стало студентов: " + students.size());
        System.out.println();

    }

    void SecondFindGroupWithHighestAverage(List<Student> students) {

        System.out.println("══════════════════════════════════════════════════");
        System.out.println("2. Учебная группа с самым высоким средним баллом");
        System.out.println("══════════════════════════════════════════════════");

        Map<String, List<Student>> grouped = new HashMap<>();

        // группируем студентов
        for (Student s : students) {
            grouped.computeIfAbsent(s.getGroupName(), k -> new ArrayList<>()).add(s);
        }

        String bestGroup = null;
        double bestAverage = 0;

        for (Map.Entry<String, List<Student>> entry : grouped.entrySet()) {

            String groupName = entry.getKey();
            List<Student> groupStudents = entry.getValue();

            double sum = 0;
            for (Student s : groupStudents) {
                sum += s.getAverage();
            }

            double groupAverage = sum / groupStudents.size();

            System.out.println("Группа: " + groupName +
                    " | Средний балл: " + groupAverage);

            if (groupAverage > bestAverage) {
                bestAverage = groupAverage;
                bestGroup = groupName;
            }
        }

        System.out.println();
        System.out.println("ЛУЧШАЯ ГРУППА: " + bestGroup +
                " | Средний балл: " + bestAverage);
        System.out.println();

    }

    void ThirdGroupStudentsByGroup(List<Student> students) {

        System.out.println("══════════════════════════════════════════");
        System.out.println("3. Группировка студентов по группам");
        System.out.println("══════════════════════════════════════════");

        Map<String, List<Student>> grouped = new HashMap<>();

        for (Student s : students) {
            grouped.computeIfAbsent(s.getGroupName(), k -> new ArrayList<>()).add(s);
        }

        for (Map.Entry<String, List<Student>> entry : grouped.entrySet()) {

            System.out.println();
            System.out.println("Группа: " + entry.getKey());
            System.out.println();

            for (Student s : entry.getValue()) {
                System.out.println(s.getName() +
                        " | Средний балл: " + s.getAverage());
                System.out.println();
            }
        }
    }

    void FourthFindOverallAverage(List<Student> students) {

        System.out.println("══════════════════════════════════════════");
        System.out.println("4. Средний балл всех студентов");
        System.out.println("══════════════════════════════════════════");

        double sum = 0;

        for (Student s : students) {
            sum += s.getAverage();
        }

        double overallAverage = sum / students.size();

        System.out.println("Общий средний балл по всем студентам: " + overallAverage);
        System.out.println();
    }

    void FifthSortStudentsByAverageAndName(List<Student> students) {

        System.out.println("══════════════════════════════════════════");
        System.out.println("5. Сортировка студентов");
        System.out.println("   (по среднему баллу ↓, затем по имени)");
        System.out.println("══════════════════════════════════════════");

        students.sort(Comparator
                .comparingDouble(Student::getAverage)
                .reversed()
                .thenComparing(Student::getName)
        );

        for (Student s : students) {
            System.out.println(s.getName() +
                    " | Группа: " + s.getGroupName() +
                    " | Средний балл: " + s.getAverage());
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }
}