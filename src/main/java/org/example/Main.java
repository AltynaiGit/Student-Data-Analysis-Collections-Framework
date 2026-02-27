package org.example;


import java.util.*;

public class Main {
    static void main() {
        String Pink = "\u001B[95m";
        String reset = "\u001B[0m";
        Student studentClass = new Student();

        List<Student> students = new ArrayList<>();
        students.add(new Student(101, "Ажара", "Группа A", List.of(70, 80, 69)));
        students.add(new Student(102, "Айбек", "Группа A", List.of(55, 60, 56)));
        students.add(new Student(103, "Даниель", "Группа B", List.of(62, 68, 70)));
        students.add(new Student(104, "Алтынай", "Группа C", List.of(90, 90, 90)));
        students.add(new Student(105, "Акылай", "Группа C", List.of(88, 70, 80)));
        students.add(new Student(106, "Санжар", "Группа C", List.of(78, 80, 82)));
        students.add(new Student(107, "Ислан", "Группа B", List.of(45, 50, 50)));
        students.add(new Student(108, "Медина", "Группа C", List.of(83, 81, 82)));
        students.add(new Student(109, "Кутман", "Группа A", List.of(30, 80, 70)));
        students.add(new Student(110, "Эрбол", "Группа B", List.of(70, 70, 70)));
        int count = students.size();

        System.out.println(Pink + "══════════════════════════════════════════════" + reset);
        System.out.println(Pink + "       СИСТЕМА АНАЛИЗА ДАННЫХ СТУДЕНТОВ             " + reset);
        System.out.println(Pink + "══════════════════════════════════════════════" + reset);
        System.out.println("Количество студентов в системе: " + count);
        System.out.println("═════════════════════════════════════════════════");
        System.out.println("1. Удаление студентов со средним баллом ниже 60");
        System.out.println("═════════════════════════════════════════════════");
        Iterator<Student> iterator = students.iterator();
        System.out.println("Удалены следующие студенты: ");

        Student student = null;
        while (iterator.hasNext()) {
            student = iterator.next();
            if (student.calculateAverage() <= 60) {
                System.out.println("ID: " + student.getId());
                System.out.println("Имя: " + student.getName());
                System.out.println("Группа: " + student.getGroupName());
                System.out.println("Средний балл: " + student.calculateAverage());
                System.out.println();
                iterator.remove();
            }
        }
        System.out.println("Количество студентов после удаления: " + students.size());
        System.out.println();

        System.out.println("══════════════════════════════════════════════════");
        System.out.println("2. Учебная группа с самым высоким средним баллом");
        System.out.println("══════════════════════════════════════════════════");

        Map<String, Double> groupTotals = new HashMap<>();
        Map<String, Integer> groupCounts = new HashMap<>();

        for (Student student1 : students) {
            String group = student1.getGroupName();
            double average = student1.calculateAverage();

            groupTotals.put(group, groupTotals.getOrDefault(group, 0.0) + average);
            groupCounts.put(group, groupCounts.getOrDefault(group, 0) + 1);
        }

        String topGroup = "";
        double maxAverage = 0;

        for (String group : groupTotals.keySet()) {
            double groupAverage = groupTotals.get(group) / groupCounts.get(group);

            if (groupAverage > maxAverage) {
                maxAverage = groupAverage;
                topGroup = group;
            }
        }
        System.out.println("Название группы: " + topGroup);
        System.out.println("Средний балл группы: " + maxAverage);

        System.out.println(Pink + "══════════════════════════════════════════════" );
        System.out.println(Pink + " Студент(ы) с наибольшим количеством оценок 5              " );
        System.out.println(Pink + "══════════════════════════════════════════════" );
        System.out.println("Максимальное количество оценок 5: " );

    }
}
