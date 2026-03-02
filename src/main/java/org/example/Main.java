package org.example;


import java.util.*;

public class Main {
    static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Ажара", "A",List.of(70, 80, 69)));
        students.add(new Student(102, "Айбек", "A", List.of(55, 60, 56)));
        students.add(new Student(103, "Даниель", "B", List.of(62, 68, 70)));
        students.add(new Student(104, "Алтынай", "C", List.of(90, 90, 90)));
        students.add(new Student(105, "Акылай", "C", List.of(88, 70, 80)));
        students.add(new Student(106, "Эрбол", "C", List.of(78, 80, 82)));
        students.add(new Student(107, "Катя", "B", List.of(45, 50, 50)));
        students.add(new Student(108, "Медина", "C", List.of(83, 81, 82)));
        students.add(new Student(109, "Кутман", "A", List.of(30, 80, 70)));
        students.add(new Student(110, "Чопа", "B", List.of(70, 70, 70)));

        Student service = new Student();

        service.firstRemoveStudent(students);
        service.SecondFindGroupWithHighestAverage(students);
        service.ThirdGroupStudentsByGroup(students);
        service.FourthFindOverallAverage(students);
        service.FifthSortStudentsByAverageAndName(students);
    }
}
